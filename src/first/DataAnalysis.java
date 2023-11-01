package first;
import java.util.Random;

/*
    1.Random 클래스 사용 설명
    2.nextInt의 사용법
    3.nextBytes의 사용법
    4.클래스 DataAnalysis에 nextInt 메소드 구현
 */
public class DataAnalysis {
    private Random r;

    public DataAnalysis() {
        r = new Random();
    }

    public void nextInts(int[] intData) {
        for (int i = 0; i < intData.length; i++) {
            intData[i] = r.nextInt(100);
        }
    }

    public static void main(String[] args) {

        //랜덤 클래스 사용 - nextInt(), nextInt(bound)
        Random rnd = new Random(); // 난수 객체는 힙 공간에 생성됨
        System.out.println(rnd.nextInt());
        System.out.println(rnd.nextInt(100)); //bound 설정, 100미만으로 제한
        for (int i = 0; i < 5; i++) {
            System.out.print(rnd.nextInt(100));
        }
        System.out.println("\n==============");

        // 람다식의 사용 예
        rnd.ints(3).forEach(val -> System.out.println(val)); //3개의 Integer stream 반환?
        System.out.println("==============");

        // Random 클래스의 사용 - nextBytes (바이트 배열... 바이트 난수로 채움)
        byte[] bData = new byte[10];
        rnd.nextBytes(bData);
        for (byte b : bData) {
            System.out.print(b + " ");
        }
        System.out.println("\n==============");

        DataAnalysis da = new DataAnalysis();
        int[] iData = new int[5];
        da.nextInts(iData);
        for (int i : iData) {
            System.out.print(i + " ");
        }
    }
}
