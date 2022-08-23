package KI34.Olkhovyk.Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab2OlkhovykKI34 {

	public static void Lab2() throws FileNotFoundException {
		
		int nRows;
        char[][] arr;
        String filler;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("Lab2.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Введіть розмір квадратної матриці: ");
        nRows = in.nextInt();
        filler = in.nextLine();
        arr = new char[nRows][];
        for (int i = 0; i < nRows; i++) {
            arr[i] = new char[nRows];
        }
        System.out.print("\nВведіть символ-заповнювач: ");
        filler = in.nextLine();
        exit: for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nRows; j++) {
                if (filler.length() == 1) {
                    if ((i > 0 && i < nRows - 1) && (j > 0 && j < nRows - 1))
                        arr[i][j] = (char) filler.charAt(0);
                    System.out.print(arr[i][j] + " ");
                    fout.print(arr[i][j] + " ");
                } else if (filler.length() == 0) {
                    System.out.print("\nНе введено символ заповнювач");
                    break exit;
                } else {
                    System.out.print("\nЗабагато символівз аповнювачів");
                    break exit;
                }
            }
            System.out.print("\n");
            fout.print("\n");
        }
        fout.flush();
        fout.close();
	}
}
