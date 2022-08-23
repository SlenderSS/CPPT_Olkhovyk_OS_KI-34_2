package KI34.Olkhovyk.Lab3;

import static java.lang.System.out;
import java.io.FileWriter;
import java.io.IOException;

public class Ship {
	private int maxSpeed;
	private int currentSpeed;
	private double maxFuelVolume;
	private double CurrentFuelVolume;
	private double fuelConsumption;
	private double passedDistance;
	public Ship() {
		this.currentSpeed = 0;
	}
	public Ship(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public Ship(int maxSpeed, double CurrentFuelVolume) {
		this(maxSpeed);
		this.CurrentFuelVolume = CurrentFuelVolume;		
	}

	public Ship(int maxSpeed, double CurrentFuelVolume, double fuelConsumption) {
		this(maxSpeed, CurrentFuelVolume);
		this.fuelConsumption = fuelConsumption;
	}

	public Ship(int maxSpeed, double CurrentFuelVolume, double fuelConsumption, double maxFuelVolume) {
		this(maxSpeed, CurrentFuelVolume, fuelConsumption);
		this.maxFuelVolume = maxFuelVolume;
	}
	
	public int GetMaxSpeed() {
		return this.maxSpeed;
	}
	public int GetCurrentSpeed() {
		return this.currentSpeed;
	}
	public double GetMaxFuelVolume() {
		return this.maxFuelVolume;
	}
	public double GetCurrentFuelVolume() {
		return this.CurrentFuelVolume;
	}
	public double GetFuelConsumption() {
		return this.fuelConsumption;
	}
	public void SetCurrentSpeed(int speed) {
		if(speed > this.maxSpeed)
			this.currentSpeed = this.maxSpeed;
		this.currentSpeed = speed;
	}
	
	private void BurningFuel() {
		if(this.currentSpeed != this.maxSpeed)
		{
			double coef = this.maxSpeed / this.currentSpeed;
			this.fuelConsumption /= coef;
		}
		this.CurrentFuelVolume-= this.fuelConsumption;
		if(this.CurrentFuelVolume <= 0) 
			this.CurrentFuelVolume = 0;
	}
	public void Run(int run) {
		while(run != 0) {
			BurningFuel();
			this.passedDistance += this.currentSpeed;
			if(this.CurrentFuelVolume == 0)
				break;
				run--;
		}
		SendData();
	}
	
	public String GetPassedDistance() {
		return String.valueOf(this.passedDistance*1852);
	}
	
	private void SendData()  {
		
		try(FileWriter writer = new FileWriter("Lab3.txt")){
			writer.write("Пройдена дистанція: " + GetPassedDistance() + "\n");
			writer.write("Максимальна швидкість човна: " + GetMaxSpeed() + "\n");
			writer.write("Залишилось пального: " + GetCurrentFuelVolume() + "\n");
			writer.flush();
			writer.close();
		}catch(IOException ex){
            
           System.out.println(ex.getMessage());
       } 
	}
	
	public static void Lab3() {
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
