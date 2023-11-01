package second;
/*
   Object 클래스의 기본 설명
   1. 기본 메소드 활용
      - toString(), hashCode(), getClass, equals(), clone()(추후 설명)
   2. 새로운 클래스 Point 정의
      - Object 메소드들의 상속과 오버라이딩: toString(), equals()
 */
// 2.
class Point {
    private int x, y;
    public Point(int x, int y){
        this.x = x; this.y = y;
    }
    public String toString() {
        return "Point(" + x + "," + y + ")";
    }
    protected String toString2() {
        return "Point(" + x + "," + y + ")";
    }
    public boolean equals(Object other) {
        if (other == null)
            return false;
        else if (other.getClass() != this.getClass())
            return false;
        // if(other==null || other.getClass() != this.getClass()) return false;로 써도 될 듯
        else {
            Point temp = (Point) other;
            if (this.x == temp.x && this.y == temp.y)
                return true;
            else
                return false;
        }
    }
}

public class Ex2Object {
    public static void main(String[] args) {
        // 1.
        Object o = new Object();
        Object o2 = new Object();
        System.out.println(o.toString() + ", " + o2.toString());
        System.out.println(o.hashCode() + ", " + o2.hashCode());
        System.out.println(o.getClass() + ", " + o2.getClass());  // 정확히는 Class를 반환. toString()이 실행됨.
        System.out.println(o.equals(o2));

        Object o3 = o;
        System.out.println(o.equals(o3));

        // 2.
        Point p = new Point(1, 2);
        System.out.println("p.toString():" + p.toString());  // toString() 구현 전, 후에 각각 실행

        Point p2 = new Point(1, 2);
        System.out.println("p.equals(p2):" + p.equals(p2));   // equals() 구현 전, 후에 각각 실행

        System.out.println(p2.toString2());  // Protected의 경우 같은 패키지 내에서는 사용 가능 확인

    }
}
