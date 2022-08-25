import java.util.Scanner;

import KI34.Olkhovyk.Lab4.Fregate;

public class FreageApp {

	public static void main(String[] args) {
		Fregate fregate = new Fregate("човник", 25, 150, 23, 160);
		fregate.GetAllInfo();
		fregate.SetCurrentSpeed(23);
		System.out.println("Вирушаєм?");
		Scanner in = new Scanner(System.in);
		Boolean value = in.nextBoolean();
		if(value == true){
			System.out.println("Скільки годин рухатись?");
			int hours = in.nextInt();
			fregate.Move(hours);
			fregate.GetAllInfo();
			System.out.println("Пройдена дистанція в метрах/вузлах: "+fregate.GetPassedDistance());
		}
		else{
			System.out.println("Ну ні так ні");
		}
		in.close();

	}

}
