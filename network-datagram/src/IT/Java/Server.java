package IT.Java;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Server {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(6666); // ç›‘å?¬æŒ‡å®šç«¯å?£
		System.out.println("server is running...");
		for (;;) {
			// 
			byte[] buffer = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			ds.receive(packet);
			String cmd = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
			// 
			String resp = "bad command";
			switch (cmd) {
			case "date":
				resp = LocalDate.now().toString();
				break;
			case "time":
				resp = LocalTime.now().withNano(0).toString();
				break;
			case "datetime":
				resp = LocalDateTime.now().withNano(0).toString();
				break;
			case "weather":
				resp = "sunny, 10~15 C.";
				break;
			}
			System.out.println(cmd + " >>> " + resp);
			packet.setData(resp.getBytes(StandardCharsets.UTF_8));
			ds.send(packet);
		}
	}
}
