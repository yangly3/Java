package IT.Java.visitor;

import java.io.File;

public class FileStructure {

	private File path;

	public FileStructure(File path) {
		this.path = path;
	}

	public void handle(Visitor visitor) {
		scan(path, visitor);
	}

	private void scan(File file, Visitor visitor) {
		if (file.isDirectory()) {
			visitor.visitDir(file);
			for (File sub : file.listFiles()) {
				scan(sub, visitor);
			}
		} else if (file.isFile()) {
			visitor.visitFile(file);
		}
	}
}
