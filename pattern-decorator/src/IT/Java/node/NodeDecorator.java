package IT.Java.node;

public abstract class NodeDecorator implements TextNode {

	protected final TextNode target;

	protected NodeDecorator(TextNode target) {
		this.target = target;
	}

	@Override
	public void setText(String text) {
		this.target.setText(text);
	}
}
