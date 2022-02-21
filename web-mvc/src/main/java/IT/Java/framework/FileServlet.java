package IT.Java.framework;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/favicon.ico", "/static/*" })
public class FileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext ctx = req.getServletContext();
		// RequestURI包�?�ContextPath,需�?去掉:
		String urlPath = req.getRequestURI().substring(ctx.getContextPath().length());
		// 获�?�真实文件路径:
		String filepath = ctx.getRealPath(urlPath);
		if (filepath == null) {
			// 无法获�?�到路径:
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		Path path = Paths.get(filepath);
		if (!path.toFile().isFile()) {
			// 文件�?存在:
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		// 根�?�文件�??猜测Content-Type:
		String mime = Files.probeContentType(path);
		if (mime == null) {
			mime = "application/octet-stream";
		}
		resp.setContentType(mime);
		// 读�?�文件并写入Response:
		OutputStream output = resp.getOutputStream();
		try (InputStream input = new BufferedInputStream(new FileInputStream(filepath))) {
			input.transferTo(output);
		}
		output.flush();
	}
}