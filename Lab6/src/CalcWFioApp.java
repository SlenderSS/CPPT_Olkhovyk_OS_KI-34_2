import java.io.IOException;
import java.util.Scanner;

import KI34.Olkhovyk.Lab6.CalcWFio;

public class CalcWFioApp {

	public static void main(String[] args) throws IOException {
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
