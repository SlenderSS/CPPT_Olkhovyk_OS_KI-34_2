import java.util.Scanner;

import KI34.Olkhovyk.Lab4.Fregate;

public class FreageApp {

	public static void main(String[] args) {
		Fregate fregate = new Fregate("човник", 15, 50.0, 75.0, 3.0, 5.0, 150, 30, 100500, "Nuclear");
		fregate.GetData();
		fregate.SetCurrentSpeed(23);
		System.out.println("Вирушаєм?");
		Scanner in = new Scanner(System.in);
		Boolean value = in.nextBoolean();
		if(value == true){
			System.out.println("Скільки годин рухатись?");
			int hours = in.nextInt();
			fregate.Move(hours);
			fregate.GetData();
			System.out.println("Пройдена дистанція в метрах/вузлах: " + fregate.GetPassedDistance());
		}
		else{
			System.out.println("Ну ні так ні");
		}
		in.close();

	}

}
