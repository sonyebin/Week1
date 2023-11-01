package first;
/*
    추상 클래스의 특징 확인
    1. Point2D와 Point의 기능 확인
    2. MyPoint의 구현: Point2D의 상속
    3. Point2D, Point, MyPoint의 사용

 */

import java.awt.*;
import java.awt.geom.Point2D;

// 2.
class MyPoint extends Point2D implements Comparable<MyPoint>{
    public int x, y;
    public MyPoint(int x, int y) {
        this.x = x; this.y = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setLocation(double v, double v1) {
        this.x = (int) v;
        this.y = (int) v1;
    }


    @Override
    public int compareTo(MyPoint myPoint) {
        if ((x + y) < (myPoint.x + myPoint.y))
            return -1;
        else if ((x + y) > (myPoint.x + myPoint.y))
            return 1;
        else
            return 0;
    }
}

public class Point2DEx {
    public static void main(String[] args) {
        // 1.
        Point2D p = new Point(3,5);     // 추상클래스 사용, 업캐스팅
        System.out.println(p);              // Point 의 toString() 사용

        Point2D p2 = new Point(1,1);
        System.out.println(p2);
        p.setLocation(-1, 1);                  // Point2D의 메소드 사용

        // 3.
        System.out.println("*************");
        MyPoint p3 = new MyPoint(10, 20);
        Point2D[] pArray = new Point2D[3];
        pArray[0] = p3;
        pArray[1] = p;
        pArray[2] = p2;
        for(Point2D v: pArray)
            System.out.println(v);

        MyPoint p4 = new MyPoint(-1, -1);
        System.out.println(p3.compareTo(p4));

    }
}
