import KI34.Olkhovyk.Lab2.Lab2OlkhovykKI34;
import KI34.Olkhovyk.Lab3.Ship;
import KI34.Olkhovyk.Lab4.*;
import KI34.Olkhovyk.Lab5.*;
import KI34.Olkhovyk.Lab6.CalcWFio;
import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Lab2();
		//Lab3();
		//Lab4();
		//Lab5();
	}

	
	
	
	public static void Lab2() throws FileNotFoundException {
		Lab2OlkhovykKI34.Lab2();
	}

	public static void Lab3() {
		Ship ship = new Ship(15,50,5,75);
		out.println("Поточний об'єм палива - " + ship.GetCurrentFuelVolume());
		out.println("Пройдена відстань - " + ship.GetPassedDistance());
		Scanner in = new Scanner(System.in);
		in.nextLine();
		ship.SetCurrentSpeed(12);
		ship.Run(5);	
		in.close();
		out.println("Поточний об'єм палива - " + ship.GetCurrentFuelVolume());
		out.println("Пройдена відстань - " + ship.GetPassedDistance());
		out.println("Поточна швидкість - " + ship.GetCurrentSpeed());
	}

	public static void Lab4() {
		Fregate fregate = new Fregate("човник", 25, 150, 23, 160);
		fregate.GetAllInfo();
		fregate.SetCurrentSpeed(23);
		out.println("Вирушаєм?");
		Scanner in = new Scanner(System.in);
		Boolean value = in.nextBoolean();
		if(value == true){
			out.println("Скільки годин рухатись?");
			int hours = in.nextInt();
			fregate.Move(hours);
			fregate.GetAllInfo();
			out.println("Пройдена дистанція в метрах/вузлах"+fregate.GetPassedDistance());
		}
		else{
			out.println("Ну ні так ні");
		}
		in.close();
	}

	public static void Lab5() {
		try {
			out.print("Enter file name: ");
			try (Scanner in = new Scanner(System.in)) {
				String fName = in.nextLine();
				PrintWriter fout = new PrintWriter(new File(fName));
				try {
					try {
						Equations eq = new Equations();
						out.print("Enter X: ");
						fout.print(eq.calculate(in.nextInt()));
					} finally {
						// Цей блок виконається за будь-яких обставин
						fout.flush();
						fout.close();
					}
				} catch (CalcException ex) {

					out.print(ex.getMessage());
				}
			}
		} catch (FileNotFoundException ex) {
			out.print("Exception reason: Perhaps wrong file path");
		}
	}

	public static void Lab6() throws IOException {
		CalcWFio obj = new CalcWFio();
		Scanner s = new Scanner(System.in);
		System.out.print("Enter data: ");
		double data = s.nextDouble();
		obj.calculate(data);
		System.out.println("Result is: " + obj.getResult());
		obj.writeResTxt("textRes.txt");
		obj.writeResBin("BinRes.bin");

		obj.readResBin("BinRes.bin");
		System.out.println("Result(Bin) is: " + obj.getResult());
		obj.readResTxt("textRes.txt");
		System.out.println("Result(Txt) is: " + obj.getResult());
		s.close();
	}

}
