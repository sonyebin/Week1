package Test;
import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        //nextInt(), nextInt(bound)... 범위:(0~bound-1)
        Random r = new Random();
        System.out.println(r.nextInt(100));
        //람다식의 사용 예... 밑의 코드는 3개의 정수를 stream 반환
        r.ints(3).forEach(val -> System.out.println(val));

        //nextBytes(바이트 배열)... 바이트 난수로 채움
        byte[] bData = new byte[10];
        r.nextBytes(bData);
        for (byte b : bData)
            System.out.print(b + " ");
    }

}
