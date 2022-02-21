package IT.Java.goodfactory;

import IT.Java.service.AbstractFactory;
import IT.Java.service.HtmlDocument;
import IT.Java.service.WordDocument;

public class GoodFactory implements AbstractFactory {

	@Override
	public HtmlDocument createHtml(String md) {
		return new GoodHtmlDocument(md);
	}

	@Override
	public WordDocument createWord(String md) {
		return new GoodWordDocument(md);
	}
}
