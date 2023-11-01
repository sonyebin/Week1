package fourth;
import java.awt.*;
import java.util.Collections;
import java.util.Vector;

public class VectorEx {
    public static void main(String[] args) {
        // 1. 기본 Vector 사용법: Object
        System.out.println("****** 1. ******");
        Vector vec = new Vector();
        vec.add(1);
        vec.add("abc");
        System.out.println(vec.get(0));
        System.out.println(vec.get(1));

        // 2. Integer Vector 생성. 용량(capacity) 변화 확인. 포함 확인, 인덱스의 요소 확인
        System.out.println("****** 2. ******");
        Vector<Integer> vecInt = new Vector<>();
        System.out.println(vecInt.capacity());
        for(int i = 0; i < 25; i++){
            vecInt.add(i);
            System.out.println("i = " + i + ", " + vecInt.size());
        }
        System.out.println(vecInt.contains(15));    // true
        System.out.println(vecInt.indexOf(15));     // 15의 인덱스는 15
        vecInt.add(15, -1);            // 인덱스 15위치에 -1 추가
        System.out.println(vecInt.indexOf(15));     // 15의 인덱스는 16

        // 3. 오버라이드된 clone 메소드 사용 -- cloneable 인터페이스 구현하고 있음.
        System.out.println("****** 3. ******");
        Vector<Integer> cloneObj = (Vector<Integer>)vecInt.clone();
        System.out.println(vecInt.equals(cloneObj));     // equal의 의미? JDK 확인할 것
        for(var n: cloneObj){
            System.out.println(n);
        }
        System.out.println("인덱스 15의 값은 " + cloneObj.get(15));
        Integer val = cloneObj.remove(15);
        System.out.println(val);
        cloneObj.add(15, -1);   // 추가된 값을 -2로 수정하면??
        System.out.println(vecInt.equals(cloneObj));

        // 4. Collections 클래스 내용 확인: 간단히 읽고 넘어갈 것. 그 중 reverse 메소드 확인
        System.out.println("****** 4. ******");
        Collections.reverse(cloneObj); // 주의
        for(var n: cloneObj){
            System.out.println(n);
        }

        // 5. Point 클래스 사용 및 Vector의 toArray 메소드 확인
        System.out.println("****** 5. ******");
        Vector<Point> vecPt = new Vector<>();
        vecPt.add(new Point(1,2));
        vecPt.add(new Point(-1,-2));
        vecPt.add(new Point(0,100));

        for(var t: vecPt)
            System.out.println(t.toString());

        var vPt = vecPt.toArray();

        for(var t: vPt)
            System.out.println(t.toString());


        //math 클래스를 사용해서 20개의 난수 삽입 후 sort해볼 것. --> 다음에 보일 것

    }
}
