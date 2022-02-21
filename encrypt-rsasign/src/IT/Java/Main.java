package IT.Java;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class Main {
	public static void main(String[] args) throws GeneralSecurityException {
		// ç”Ÿæˆ?RSAå…¬é’¥/ç§?é’¥:
		KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
		kpGen.initialize(1024);
		KeyPair kp = kpGen.generateKeyPair();
		PrivateKey sk = kp.getPrivate();
		PublicKey pk = kp.getPublic();

		// å¾…ç­¾å??çš„æ¶ˆæ?¯:
		byte[] message = "Hello, I am Bob!".getBytes(StandardCharsets.UTF_8);

		// ç”¨ç§?é’¥ç­¾å??:
		Signature s = Signature.getInstance("SHA1withRSA");
		s.initSign(sk);
		s.update(message);
		byte[] signed = s.sign();
		System.out.println(String.format("signature: %x", new BigInteger(1, signed)));

		// ç”¨å…¬é’¥éªŒè¯?:
		Signature v = Signature.getInstance("SHA1withRSA");
		v.initVerify(pk);
		v.update(message);
		boolean valid = v.verify(signed);
		System.out.println("valid? " + valid);
	}
}
