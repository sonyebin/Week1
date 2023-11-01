package fifth;

import java.awt.*;

/*
    나만의 List 클래스 만들기
    version 1: 정수 리스트
    - 정수 배열
    - count 변수
    - add, getter 메소드 등등 ...

    version 2: Point 리스트
    - Point 배열, count 필요
    - ....
 */
public class List {
    //point로 바꾼다고 하면 int를 Point로 바꾸면 됨
    //Object로 바꿀 수도 잇음. 그러면 문자열, 숫자 등등 다 가능...
    //단점? 어떤 인덱스의 객체를 받아올 때 어떤 타입인지를 알 수 없음. 타입캐스트 오류?
    private int[] items = new int[10];  //왼쪽의 두 라인은 생성자에서 처리가 나을 듯
    private int count;
    public void add(int item) { items[count++] = item; }
    public int get(int index) { return items[index]; }
    /***************************************/
    private Point[] points = new Point[10];
    private int pointcount = 0;
    public void addPoint(Point item) { points[pointcount++] = item; }
    public Point getPoint(int index) { return points[index]; }
    /*************************************/
    Object[] objects = new Object[10];
    private int objectcount = 0;
    public void addObject(Object item) { objects[objectcount++] = item; }
    public Object getObject(int index) { return objects[index]; }

    public static void main(String[] args) {
        List lst = new List();
        lst.add(0);
        lst.add(2);
        System.out.println(lst.get(1));

        List pt = new List();
        pt.addPoint(new Point(3,5));
        pt.addPoint(new Point(-2,-3));
        System.out.println(pt.getPoint(1));

        List obj = new List();
        obj.addObject(1);
        obj.addObject(new Point(2,2));
        obj.addObject("abc");
        int num = (int) lst.get(0);
        int num2 = (int) lst.get(2);
        // runtime error 실행시 ClassCastException 발생--> 컴파일 타임에 확인이 가능하면...

    }
}
