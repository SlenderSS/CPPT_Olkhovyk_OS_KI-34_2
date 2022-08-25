import KI34.Olkhovyk.Lab3.*;

import static java.lang.System.out;
public class ShipApp {

	public static void main(String[] args) {
		Ship ship = new Ship(15,50,5,75);
		out.println("Поточний об'єм палива - " + ship.GetCurrentFuelVolume());
		out.println("Пройдена відстань - " + ship.GetPassedDistance());
		
		ship.SetCurrentSpeed(12);
		ship.Run(5);	
		
		out.println("Поточний об'єм палива - " + ship.GetCurrentFuelVolume());
		out.println("Пройдена відстань - " + ship.GetPassedDistance());
		out.println("Поточна швидкість - " + ship.GetCurrentSpeed());
	}

}
