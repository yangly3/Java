package IT.Java;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InterruptedException {
		DatagramSocket ds = new DatagramSocket();
		ds.setSoTimeout(1000);
		ds.connect(InetAddress.getByName("localhost"), 6666); // 
		DatagramPacket packet = null;
		for (int i = 0; i < 5; i++) {
			// 
			String cmd = new String[] { "date", "time", "datetime", "weather", "hello" }[i];
			byte[] data = cmd.getBytes();
			packet = new DatagramPacket(data, data.length);
			ds.send(packet);
			// 
			byte[] buffer = new byte[1024];
			packet = new DatagramPacket(buffer, buffer.length);
			ds.receive(packet);
			String resp = new String(packet.getData(), packet.getOffset(), packet.getLength());
			System.out.println(cmd + " >>> " + resp);
			Thread.sleep(1500);
		}
		ds.disconnect();
		System.out.println("disconnected.");
	}
}
