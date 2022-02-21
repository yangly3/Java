package IT.Java;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Template {

	final String template;
	final Pattern pattern = Pattern.compile("\\$\\{(\\w+)\\}");

	public Template(String template) {
		this.template = template;
	}

	public String render(Map<String, Object> data) {
		Matcher m = pattern.matcher(template);
		// TODO:
		while (m.find()) {
		}
		return "??";
	}

}