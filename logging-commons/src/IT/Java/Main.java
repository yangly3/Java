package IT.Java;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class Main {

	static final Log log = LogFactory.getLog(Main.class);

	public static void main(String[] args) {
		log.info("Start process...");
		try {
			"".getBytes("invalidCharsetName");
		} catch (UnsupportedEncodingException e) {
			// TODO: 使用log.error(String, Throwable)打�?�异常
		}
		log.info("Process end.");
	}
}