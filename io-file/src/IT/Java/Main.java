package IT.Java;

import java.io.File;

import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		File currentDir = new File(".");
		listDir(currentDir.getCanonicalFile());
	}

	static void listDir(File dir) {
		// TODO: 
		File[] fs = dir.listFiles();
		if (fs != null) {
			for (File f : fs) {
				System.out.println(f.getName());
			}
		}
	}
}
