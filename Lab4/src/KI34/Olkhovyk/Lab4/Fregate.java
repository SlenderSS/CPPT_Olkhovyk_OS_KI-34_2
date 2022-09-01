package KI34.Olkhovyk.Lab4;

import java.io.FileWriter;
import java.io.IOException;

public class Fregate extends Ship {

	private String name;

	public Fregate(String name, int maxSpeed, double CurrentFuelVolume, double maxFuelVolume,
			double X, double Y, int power, int fuelConsumption, int damage, String type) {
		super(maxSpeed, CurrentFuelVolume, maxFuelVolume, X, Y, power, fuelConsumption, damage, type);
		this.name = name;
	}

	public String GetName() {
		return this.name;
	}

	@Override
	protected void BurningFuel() {
		if (this.currentSpeed != this.maxSpeed) {
			this.engine.fuelConsumption *= this.currentSpeed / this.maxSpeed;
		}

		this.CurrentFuelVolume -= this.engine.fuelConsumption;
		if (this.CurrentFuelVolume <= 0)
			this.CurrentFuelVolume = 0;
	}

	@Override
	public void Move(int cycles) {
		double startX = this.position.X;
		double startY = this.position.Y;

		while (cycles != 0) {
			BurningFuel();
			if (cycles % 2 == 0)
				this.position.X += this.currentSpeed;
			else
				this.position.Y += this.currentSpeed;
			if (this.CurrentFuelVolume == 0)
				break;
			cycles--;
		}
		SetPassedDistance(startX, startY);
		SendData();
	}

	@Override
	public String GetData() {
		return "Назва фрегата: " + this.name + "\n" + super.GetData();
	}

	@Override
	public void SendData() {
		try (FileWriter writer = new FileWriter("info.txt")) {
			writer.write(GetData());
			writer.flush();
			writer.close();
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
	}

}
