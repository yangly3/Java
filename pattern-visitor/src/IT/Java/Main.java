package IT.Java;

import java.io.File;
import java.io.IOException;

import IT.Java.visitor.ClassFileCleanerVisitor;
import IT.Java.visitor.FileStructure;
import IT.Java.visitor.JavaFileVisitor;


public class Main {

	public static void main(String[] args) throws IOException {
		FileStructure fs = new FileStructure(new File("."));
		fs.handle(new JavaFileVisitor());
		fs.handle(new ClassFileCleanerVisitor());
	}
}
