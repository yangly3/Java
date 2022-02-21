package IT.Java.node.decorator;

import IT.Java.node.NodeDecorator;
import IT.Java.node.TextNode;

public class BoldDecorator extends NodeDecorator {

	public BoldDecorator(TextNode target) {
		super(target);
	}

	@Override
	public String getText() {
		return "<b>" + target.getText() + "</b>";
	}
}
