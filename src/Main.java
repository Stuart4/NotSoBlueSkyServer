import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * NotSoBlueSkyServer
 *
 * @author Jacob Stuart
 * @lab 806
 * @date October 11, 2014
 */
public class Main {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(8865);
		Socket s;
		while (true) {
			s = ss.accept();
			new Thread(new Worker(s)).start();
		}
	}
}
