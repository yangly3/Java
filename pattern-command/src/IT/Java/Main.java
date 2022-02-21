package IT.Java;

import IT.Java.command.Command;
import IT.Java.command.CopyCommand;
import IT.Java.command.PasteCommand;
import IT.Java.command.TextEditor;

public class Main {

	public static void main(String[] args) {
		TextEditor editor = new TextEditor();
		editor.add("Command pattern in text editor.\n");
		Command copy = new CopyCommand(editor);
		copy.execute();
		editor.add("----\n");
		Command paste = new PasteCommand(editor);
		paste.execute();
		System.out.println(editor.getState());
	}
}
