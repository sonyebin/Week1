package Test;

class MyPoint2 {
    private int x, y;

    public MyPoint2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) return false;
        MyPoint2 p = (MyPoint2) obj;
        return this.x == p.x && this.y == p.y;
    }
    @Override
    public String toString(){
        return "Point("+x+","+y+")";
    }

    public static void main(String[] args) {
        MyPoint2 p = new MyPoint2(3, 50);
        MyPoint2 q = new MyPoint2(4,50);
        System.out.println(p);
        if(p.equals(q))
            System.out.println("같은 점");
        else
            System.out.println("다른 점");
    }
}