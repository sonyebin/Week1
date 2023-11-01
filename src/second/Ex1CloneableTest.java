package second;
import java.awt.Point;
class CloneTest {
    private int n;
    public CloneTest(int n) { this.n = n; }

    public int getN() { return n; }
    public void setN(int n) { this.n = n; }
}
public class Ex1CloneableTest {
    public static void main(String[] args) {
        CloneTest cTest = new CloneTest(5);
        //CloneTest cTest2 = cTest.clone();
        //오류 발생 이유: 클론은 protected 메소드이므로 상속 받아 사용 가능...
        Point p = new Point(1,2);
        Point p2 = (Point) p.clone(); //Cloneable 인터페이스 사용
        // Point extends Point2D... Point2D에 clone 구현되어 있으므로 사용 가능!

        System.out.println(p.equals(p2));
        System.out.println(p == p2);    //주소값이 같은지(같은 참조인지) 비교
    }
}
