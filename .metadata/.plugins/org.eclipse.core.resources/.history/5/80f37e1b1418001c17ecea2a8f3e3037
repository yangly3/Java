package IT.Java.fastfactory;

import IT.Java.service.AbstractFactory;
import IT.Java.service.HtmlDocument;
import IT.Java.service.WordDocument;

public class FastFactory implements AbstractFactory {

	@Override
	public HtmlDocument createHtml(String md) {
		return new FastHtmlDocument(md);
	}

	@Override
	public WordDocument createWord(String md) {
		return new FastWordDocument(md);
	}
}
