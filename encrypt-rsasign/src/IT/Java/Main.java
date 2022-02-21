package IT.Java;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class Main {
	public static void main(String[] args) throws GeneralSecurityException {
		// 生�?RSA公钥/�?钥:
		KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
		kpGen.initialize(1024);
		KeyPair kp = kpGen.generateKeyPair();
		PrivateKey sk = kp.getPrivate();
		PublicKey pk = kp.getPublic();

		// 待签�??的消�?�:
		byte[] message = "Hello, I am Bob!".getBytes(StandardCharsets.UTF_8);

		// 用�?钥签�??:
		Signature s = Signature.getInstance("SHA1withRSA");
		s.initSign(sk);
		s.update(message);
		byte[] signed = s.sign();
		System.out.println(String.format("signature: %x", new BigInteger(1, signed)));

		// 用公钥验�?:
		Signature v = Signature.getInstance("SHA1withRSA");
		v.initVerify(pk);
		v.update(message);
		boolean valid = v.verify(signed);
		System.out.println("valid? " + valid);
	}
}
