import KI34.Olkhovyk.Lab3.*;

import static java.lang.System.out;
public class ShippApp {

	public static void main(String[] args) {
		Ship ship = new Ship(15, 50.0, 75.0, 3.0, 5.0, 150, 30, 100500, "Nuclear");
		out.println(ship.GetData());

		ship.SetCurrentSpeed(12);
		ship.Run(5);

		out.println(ship.GetData());

	}

}
