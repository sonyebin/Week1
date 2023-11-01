package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {
        int n;
        int[] numArray = new int[5];
        Scanner s = new Scanner(System.in);
        System.out.print("배열 인덱스 입력: ");
        n = s.nextInt();

        // ArrayIndexOutOfBoundsException
        try {
            numArray[n] = n;
            System.out.println(numArray[n]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        // ArithmeticException (0으로 나누는 경우)
        try {
            System.out.println(10 / n);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        // NullPointerException
        Integer m = null;
        try {
            System.out.println(m.intValue());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // try-with-resources
        //-> try(...)에 선언된 객체(AutoCloseable 구현)들에 대해 try가 종료될 때 자동으로 close() 호출
        try(FileReader reader = new FileReader("file.txt")){
            int i=0;
            while(i!=-1){
                i = reader.read();
                System.out.println((char)i);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("--- File End ---");

        File myObj = new File("file.txt");
        try (Scanner myReader = new Scanner(myObj)){
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
