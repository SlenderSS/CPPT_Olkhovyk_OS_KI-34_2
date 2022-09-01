package KI34.Olkhovyk.Lab4;

public abstract class Ship implements Movable {
	protected Position position;
	protected Weapon weapon;
	protected Engine engine;
	protected int maxSpeed;
	protected int currentSpeed;
	protected double maxFuelVolume;
	protected double CurrentFuelVolume;

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

	public Ship(int maxSpeed, double CurrentFuelVolume, double maxFuelVolume,
			double X, double Y, int power, int fuelConsumption, int damage, String type) {
		this(maxSpeed, CurrentFuelVolume);
		this.maxFuelVolume = maxFuelVolume;

		this.position = new Position(X, Y);
		this.engine = new Engine(power, fuelConsumption);
		this.weapon = new Weapon(damage, type);
	}

	public String GetWeapon() {
		return "Тип зброї " + this.weapon.type + "; Шкода від зброї" + this.weapon.damage;
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
		return this.engine.fuelConsumption;
	}

	public double GetPassedDistance() {
		return this.passedDistance;
	}

	public void SetCurrentSpeed(int speed) {
		if (speed > this.maxSpeed)
			this.currentSpeed = this.maxSpeed;
		this.currentSpeed = speed;
	}

	protected void SetPassedDistance(double startX, double startY) {
		double x = this.position.X - startX;
		double y = this.position.Y - startY;
		this.passedDistance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) * 1852;

	}

	protected abstract void BurningFuel();

	public void Run(int run) {
		double startX = this.position.X;
		double startY = this.position.Y;

		while (run != 0) {
			BurningFuel();
			if (run % 2 == 0)
				this.position.X += this.currentSpeed;
			else
				this.position.Y += this.currentSpeed;
			if (this.CurrentFuelVolume == 0)
				break;
			run--;
		}
		SetPassedDistance(startX, startY);
		SendData();
	}

	public String GetData() {
		String data = "Потужність двигуна: " + this.engine.power + "\n"
				+ "Зброя/шкода: " + this.weapon.type + "/" + this.weapon.damage + "\n"
				+ "Поточні координати корабля: " + this.position.GetPosition() + "\n"
				+ "Пройдена дистанція: " + this.passedDistance + "\n"
				+ "Максимальна швидкість човна: " + this.maxSpeed + "\n"
				+ "Залишилось пального: " + this.CurrentFuelVolume + "\n";
		return data;
	}

	protected abstract void SendData();
}

class Weapon {
	public String type;
	public int damage;

	public Weapon(int damage, String type) {
		this.damage = damage;
		this.type = type;
	}
}

class Position {
	public double X;
	public double Y;

	public Position(double X, double Y) {
		this.X = X;
		this.Y = Y;
	}

	public String GetPosition() {
		return this.X + "," + this.Y;
	}
}

class Engine {
	public int power;
	public int fuelConsumption;

	public Engine(int power, int fuelConsumption) {
		this.power = power;
		this.fuelConsumption = fuelConsumption;
	}

}
