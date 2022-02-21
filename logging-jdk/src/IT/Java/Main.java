package IT.Java;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;


public class Main {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Main.class.getName());
		logger.info("Start process...");
		try {
			"".getBytes("invalidCharsetName");
		} catch (UnsupportedEncodingException e) {
			// TODO: 
		}

		logger.info("Process end.");
	}
}
