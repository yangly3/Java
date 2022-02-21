package IT.Java;

import java.math.BigInteger;
import java.security.*;

import javax.crypto.Cipher;

public class Main {
	public static void main(String[] args) throws Exception {
		// 明文:
		byte[] plain = "Hello，使用RSA�?�对称加密算法对数�?�进行加密�?".getBytes("UTF-8");
		// 创建公钥�?�?钥对:
		Person alice = new Person("Alice");
		// 用Alice的公钥加密:
		byte[] pk = alice.getPublicKey();
		System.out.println(String.format("public key: %x", new BigInteger(1, pk)));
		byte[] encrypted = alice.encrypt(plain);
		System.out.println(String.format("encrypted: %x", new BigInteger(1, encrypted)));
		// 用Alice的�?钥解密:
		byte[] sk = alice.getPrivateKey();
		System.out.println(String.format("private key: %x", new BigInteger(1, sk)));
		byte[] decrypted = alice.decrypt(encrypted);
		System.out.println(new String(decrypted, "UTF-8"));
	}
}

class Person {
	String name;
	// �?钥:
	PrivateKey sk;
	// 公钥:
	PublicKey pk;

	public Person(String name) throws GeneralSecurityException {
		this.name = name;
		// 生�?公钥�?�?钥对:
		KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
		kpGen.initialize(1024);
		KeyPair kp = kpGen.generateKeyPair();
		this.sk = kp.getPrivate();
		this.pk = kp.getPublic();
	}

	// 把�?钥导出为字节
	public byte[] getPrivateKey() {
		return this.sk.getEncoded();
	}

	// 把公钥导出为字节
	public byte[] getPublicKey() {
		return this.pk.getEncoded();
	}

	// 用公钥加密:
	public byte[] encrypt(byte[] message) throws GeneralSecurityException {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, this.pk);
		return cipher.doFinal(message);
	}

	// 用�?钥解密:
	public byte[] decrypt(byte[] input) throws GeneralSecurityException {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, this.sk);
		return cipher.doFinal(input);
	}
}
