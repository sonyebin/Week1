package third;
/*
   간단한 runtime exception 예제들
   - 다음 예제는 부적절한 구현 예제 - 가능하면 발생하지 않도록 구현해야 함.
 */
import java.io.FileReader;
import java.util.Scanner;

public class Ex4Exception {
    public static void main(String[] args) {
        int n;
        int[] numArray = new int[5];
        Scanner s = new Scanner(System.in);
        System.out.print("배열 인덱스 입력: ");
        n = s.nextInt();

        // ArrayIndexOutOfBoundsException
        numArray[n] = n;
        System.out.println(numArray[n]);

        // ArithmeticException (0으로 나누는 경우)
        System.out.println(10 / n);


        // NullPointerException
        Integer m = null;
        System.out.println(m.intValue());


//        FileReader reader = new FileReader("file.txt");
    }
}
