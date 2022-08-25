import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.System.out;
import KI34.Olkhovyk.Lab5.*;

public class EquantionsApp {

	public static void main(String[] args) {
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
}
