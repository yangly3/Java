package IT.Java.node.decorator;

import IT.Java.node.NodeDecorator;
import IT.Java.node.TextNode;

public class ItalicDecorator extends NodeDecorator {

	public ItalicDecorator(TextNode target) {
		super(target);
	}

	@Override
	public String getText() {
		return "<i>" + target.getText() + "</i>";
	}
}
