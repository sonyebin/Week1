package fifth;
import java.awt.*;
/*
    일반화된 객체들에 대한 list 구현
 */

public class List3 {
    private Object[] items = new Object[10];  // 왼쪽의 두 라인은 생성자에서 처리가 나을듯.
    private int count = 0;

    public void add(Object item) {
        items[count++] = item;
    }
    public Object get(int index) {
        return items[index];
    }

    public static void main(String[] args) {
        List3 lst = new List3();
        lst.add(1);
        lst.add(new Point(2,2));
        lst.add("abc");

        int num = (int) lst.get(0);
        int num2 = (int) lst.get(2); // runtime error 실행시 ClassCastException 발생 --> 컴파일 타임에 확인이 가능하면 ...
    }
}
