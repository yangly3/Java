package IT.Java;

public class Main {

	public static void main(String[] args) {
		TextEditor editor = new TextEditor();
		editor.add("Hello");
		editor.add(',');
		editor.delete();
		editor.add(' ');
		editor.add("world");
		// 
		String state = editor.getState();
		// 
		editor.add("!!!");
		editor.delete();
		editor.print();
		// 
		editor.setState(state);
		editor.print();
	}
}
