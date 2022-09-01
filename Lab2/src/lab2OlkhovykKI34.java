import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class lab2OlkhovykKI34 {

	public static void main(String[] args) throws FileNotFoundException {
        int nRows;
        char[][] arr;
        String filler;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Введіть розмір квадратної матриці: ");
        nRows = in.nextInt();
        filler = in.nextLine();
        arr = new char[nRows - 2][nRows - 2];
        
        System.out.print("\nВведіть символ-заповнювач: ");
        filler = in.nextLine();
        exit: for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nRows; j++) {
                if (filler.length() == 1) {
                    if ((i > 0 && i < nRows - 1) && (j > 0 && j < nRows - 1)) {
                        arr[i - 1][j-1] = (char) filler.charAt(0);
                        System.out.print(arr[i - 1][j - 1] + " ");
                        fout.print(arr[i - 1][j - 1] + " ");
                    } else {
                        System.out.print(" ");
                        fout.print(" ");
                    }
                        
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
