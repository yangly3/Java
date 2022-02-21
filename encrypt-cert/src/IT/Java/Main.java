package IT.Java;

import java.io.InputStream;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.*;

import javax.crypto.Cipher;

public class Main {
	public static void main(String[] args) throws Exception {
		byte[] message = "Hello, use X.509 cert!".getBytes("UTF-8");
		// è¯»å?–KeyStore:
		KeyStore ks = loadKeyStore("/my.keystore", "123456");
		// è¯»å?–ç§?é’¥:
		PrivateKey privateKey = (PrivateKey) ks.getKey("mycert", "123456".toCharArray());
		// è¯»å?–è¯?ä¹¦:
		X509Certificate certificate = (X509Certificate) ks.getCertificate("mycert");
		// åŠ å¯†:
		byte[] encrypted = encrypt(certificate, message);
		System.out.println(String.format("encrypted: %x", new BigInteger(1, encrypted)));
		// è§£å¯†:
		byte[] decrypted = decrypt(privateKey, encrypted);
		System.out.println("decrypted: " + new String(decrypted, "UTF-8"));
		// ç­¾å??:
		byte[] sign = sign(privateKey, certificate, message);
		System.out.println(String.format("signature: %x", new BigInteger(1, sign)));
		// éªŒè¯?ç­¾å??:
		boolean verified = verify(certificate, message, sign);
		System.out.println("verify: " + verified);
	}

	static KeyStore loadKeyStore(String keyStoreFile, String password) {
		try (InputStream input = Main.class.getResourceAsStream(keyStoreFile)) {
			if (input == null) {
				throw new RuntimeException("file not found in classpath: " + keyStoreFile);
			}
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
			ks.load(input, password.toCharArray());
			return ks;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	static byte[] encrypt(X509Certificate certificate, byte[] message) throws GeneralSecurityException {
		Cipher cipher = Cipher.getInstance(certificate.getPublicKey().getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, certificate.getPublicKey());
		return cipher.doFinal(message);
	}

	static byte[] decrypt(PrivateKey privateKey, byte[] data) throws GeneralSecurityException {
		Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return cipher.doFinal(data);
	}

	static byte[] sign(PrivateKey privateKey, X509Certificate certificate, byte[] message)
			throws GeneralSecurityException {
		Signature signature = Signature.getInstance(certificate.getSigAlgName());
		signature.initSign(privateKey);
		signature.update(message);
		return signature.sign();
	}

	static boolean verify(X509Certificate certificate, byte[] message, byte[] sig) throws GeneralSecurityException {
		Signature signature = Signature.getInstance(certificate.getSigAlgName());
		signature.initVerify(certificate);
		signature.update(message);
		return signature.verify(sig);
	}
}
