package third;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex4FileReadWithScanner {
        public static void main(String[] args) {
            File myObj = new File("filename.txt");
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
