import java.util.Random;

/**
 * NotSoBlueSkyServer
 *
 * @author Jacob Stuart
 * @lab 806
 * @date October 11, 2014
 */
public class RainMap {
	int latitude, longitude;

	public RainMap (int latitude, int longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	//TODO makes something real
	public boolean getRainStatus() {
		Random rnd = new Random();
		if (rnd.nextInt(2) == 1) {
			return true;
		}
		return false;
	}

	public void setRainStatus(boolean rainStatus) {

	}
}
