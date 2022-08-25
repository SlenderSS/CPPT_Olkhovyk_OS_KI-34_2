package KI34.Olkhovyk.Lab4;


public abstract class Ship implements Movable{
	protected int maxSpeed;
	protected int currentSpeed;
	protected double maxFuelVolume;
	protected double CurrentFuelVolume;
	protected double fuelConsumption;
	protected double passedDistance;

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

	public String GetPassedDistance() {
		return String.valueOf(this.passedDistance * 1852) + "/" + String.valueOf(this.passedDistance);
	}

	public void SetCurrentSpeed(int speed) {
		if (speed > this.maxSpeed)
			this.currentSpeed = this.maxSpeed;
		this.currentSpeed = speed;
	}

	protected abstract void BurningFuel();

	protected abstract void SendData();
}
