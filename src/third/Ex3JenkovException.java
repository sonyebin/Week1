package third;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

    /*
    Jenkov 예제: File Open 예제: 단계별로 직접 진행할 것.
    1. openFile() 예제
       - FileReader의 객체 생성 - 예외처리 과정 진행
       - read에 대한 예외 처리도 요구됨.
    2. openFile2() 예제
       - throws 예외 선언할 경우: 포괄적인 예외 선언이 필요
       - 이 메소드의 호출 시 예외처리 요구됨
    3. openFile3(): Finally 사용 예제
       - openFile()의 구현에서 close() 메소드의 위치가 문제가 됨. 에러 발생 시 close()되지 않을 수 있음.
       - scope 룰에 맞게 재구성해야.
       - close()메소드는 IOException을 발생시킬 수 있음.
    4. openFile4(): try-with-resources 구문
       -

 */

public class Ex3JenkovException {
    public static void openFile(){
        try {
            // constructor may throw FileNotFoundException
            FileReader reader = new FileReader("someFile.txt");
            int i=0;
            while(i != -1){
                //reader.read() may throw IOException
                i = reader.read();
                System.out.println((char) i );
            }
            reader.close();
            System.out.println("--- File End ---");
        } catch (FileNotFoundException e) {
            //do something clever with the exception
        } catch (IOException e) {
            //do something clever with the exception
        }
    }

    // throws FileNotFoudException으로 할 경우, read의 예외처리가 요구됨.
    public static void openFile2() throws IOException{
        FileReader reader = new FileReader("someFile");
        int i=0;
        while(i != -1){
            i = reader.read();
            System.out.println((char) i );
        }
        reader.close();
        System.out.println("--- File End ---");
    }
    public static void openFile3() {
        FileReader reader = null;
        try {
            reader = new FileReader("someFile");
            int i=0;
            while(i != -1){
                i = reader.read();
                System.out.println((char) i );
            }
        } catch (IOException e) {
            //do something clever with the exception
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    //do something clever with the exception
                }
            }
            System.out.println("--- File End ---");
        }
    }

    public static void openFile4() {

        try ( FileReader reader = new FileReader("someFile.txt")){
            int i=0;
            while(i != -1){
                i = reader.read();
                System.out.println((char) i );
            }
        } catch (IOException e) {
            //do something clever with the exception
        }
        System.out.println("--- File End ---");
    }
    public static void main(String[] args)  {
//        openFile();
//        openFile2();  // 예외처리 없이 호출 시 컴파일 에러
        openFile4();
    }
}
