import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * NotSoBlueSkyServer
 *
 * @author Jacob Stuart
 * @lab 806
 * @date October 11, 2014
 */

public class Worker implements Runnable {
	private Socket connection;

	public Worker(Socket connection) {
		this.connection = connection;
	}

	@Override
	public void run() {
	try {
		connection.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(connection.getInputStream());

		int longitude, latitude;
		latitude = ois.readInt();
		longitude = ois.readInt();

		Object obj;
		if ((obj = ois.readObject()) != null) {
			boolean rainStatus = (Boolean) obj;
			RainMap rm = new RainMap(latitude, longitude);
			rm.setRainStatus(rainStatus);
		} else {
			RainMap rm = new RainMap(latitude, longitude);
			boolean rainStatus = rm.getRainStatus();
			ObjectOutputStream oos = new ObjectOutputStream(connection.getOutputStream());
			oos.writeBoolean(rainStatus);
		}
	} catch (IOException e) {

	} catch (ClassNotFoundException e) {

	}
	}

}
