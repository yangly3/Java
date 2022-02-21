package IT.Java;

import java.util.Map;

import IT.Java.html.HtmlBuilder;
import IT.Java.url.URLBuilder;


public class Main {

	public static void main(String[] args) {
		String markdown = String.join("\n", // 
				"## Builder Pattern", // 
				"> Seperate the construction of a complex object from its representation",
				"Use builder pattern when the construction process is complex.", "----", "Here is an example.");
		HtmlBuilder builder = new HtmlBuilder();
		String html = builder.toHtml(markdown);
		System.out.println(html);

		String url = URLBuilder.builder() // 
				.setDomain("www.google.com") // 
				.setScheme("https") //
				.setPath("/") // 
				.setQuery(Map.of("a", "123", "q", "K&R")) // 
				.build(); //
		System.out.println(url);
	}
}
