import java.net.*;
import java.io.*;
import java.util.logging.*;
import java.util.*;

public class TCPClient {
	public static void main(String... args) {
		Logger logger = Logger.getLogger(TCPClient.class.getName());
		logger.setLevel(Level.INFO);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.INFO);
		logger.addHandler(handler);
		logger.info("Starting application...");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input your IP address: ");
		String host = scanner.nextLine();
		System.out.print("Please input your Port Number: ");
		int port = Integer.valueOf(scanner.nextLine());
		try (Socket sock = new Socket(host, port)) {
			InputStream input = sock.getInputStream();
			byte[] buffer = new byte[1024];
			int length = input.read(buffer);
			String quota = new String(buffer, 0, length);
			System.out.print(quota);
			logger.info("The end of the application...");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
