package third;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex2FileIO {
    public static void tryWithResource() {
        try (FileReader reader = new FileReader("file.txt") ) {
            int n = reader.read();
            System.out.println((char)n);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        FileReader fReader = null;
        try {   //FileNotFoundException에 대한 예외처리 필요!
            fReader = new FileReader("file.txt");
            int n = fReader.read();
            System.out.println((char)n);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {   //exception의 나열 순서는 자세->포괄 FNFE는 IO의 자식클래스?
            e.printStackTrace();
        } finally {
            if (fReader != null) {
                try {
                    fReader.close();    //IOException을 발생시킴... 또 try-catch 필요
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
