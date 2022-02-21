package IT.Java;

import java.io.IOException;

import IT.Java.node.SpanNode;
import IT.Java.node.TextNode;
import IT.Java.node.decorator.BoldDecorator;
import IT.Java.node.decorator.ItalicDecorator;
import IT.Java.node.decorator.UnderlineDecorator;


public class Main {

	public static void main(String[] args) throws IOException {
		TextNode n1 = new SpanNode();
		TextNode n2 = new BoldDecorator(new UnderlineDecorator(new SpanNode()));
		TextNode n3 = new ItalicDecorator(new BoldDecorator(new SpanNode()));
		n1.setText("Hello");
		n2.setText("Decorated");
		n3.setText("World");
		System.out.println(n1.getText());
		System.out.println(n2.getText());
		System.out.println(n3.getText());
	}
}
