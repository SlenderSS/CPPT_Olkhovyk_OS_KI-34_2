package KI34.Olkhovyk.Lab4;

import static java.lang.System.out;
import java.io.FileWriter;
import java.io.IOException;

public class Fregate extends Ship  {

	private String name;
	
	public Fregate(String name,int maxSpeed, double CurrentFuelVolume, double fuelConsumption, double maxFuelVolume){
		super(maxSpeed, CurrentFuelVolume, fuelConsumption, maxFuelVolume);
		this.name = name;
	}
	
	public String GetName() { return this.name; }
	
	@Override
	protected void BurningFuel() {
		{
			if (this.currentSpeed != this.maxSpeed) {
				double coef = this.maxSpeed / this.currentSpeed;
				this.fuelConsumption /= coef;
			}
			this.CurrentFuelVolume -= this.fuelConsumption;
			if (this.CurrentFuelVolume <= 0)
				this.CurrentFuelVolume = 0;
		}
	}
	public void GetAllInfo(){
		out.println("Назва фрегату: " + GetName());
		out.println("Максимальна швидкість: " + GetMaxSpeed());
		out.println("Максимальний об'єм палива: " + GetMaxFuelVolume());
		out.println("Об'єм палива на даний момент: " + GetCurrentFuelVolume());
	}
	@Override
	public void Move(int cycles) {
		while (cycles != 0) {
			BurningFuel();
			this.passedDistance += this.currentSpeed;
			if (this.CurrentFuelVolume == 0)
				break;
			cycles--;
		}
		SendData();
	}

	@Override
	public void SendData() {

		try (FileWriter writer = new FileWriter("Lab4.txt")) 
		{
			writer.write("Пройдена дистанція: " + GetPassedDistance() + "\n");
			writer.write("Максимальна швидкість човна: " + GetMaxSpeed() + "\n");
			writer.write("Залишилось пального: " + GetCurrentFuelVolume() + "\n");
			writer.flush();
			writer.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
