package IT.Java.templatemethod;

public abstract class AbstractSetting {

	public final String getSetting(String key) {
		String value = lookupCache(key);
		if (value == null) {
			value = readFromDatabase(key);
			System.out.println("[DEBUG] load from db: " + key + " = " + value);
			putIntoCache(key, value);
		} else {
			System.out.println("[DEBUG] load from cache: " + key + " = " + value);
		}
		return value;
	}

	protected abstract String lookupCache(String key);

	protected abstract void putIntoCache(String key, String value);

	private String readFromDatabase(String key) {
		return Integer.toHexString(0x7fffffff & key.hashCode());
	}
}
