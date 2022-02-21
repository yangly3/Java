package IT.Java;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class Main {
	public static void main(String[] args) throws Exception {
		// 
		Security.addProvider(new BouncyCastleProvider());
		// 
		MessageDigest md = MessageDigest.getInstance("RipeMD160");
		md.update("HelloWorld".getBytes("UTF-8"));
		byte[] result = md.digest();
		System.out.println(new BigInteger(1, result).toString(16));
	}
}
