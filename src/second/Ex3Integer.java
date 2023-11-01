package second;

public class Ex3Integer {
    public static void main(String[] args) {
        //Integer n = new Integer(10); 이제 지원 안 하기 땜에 사용x
        Integer n2 = Integer.valueOf(10);
        Integer n3 = 10; //auto boxing

        int m = n2.intValue();
        int m2 = n2; //auto unboxing

        m = Integer.parseInt("100");
        m = Integer.parseInt("100",16);
        System.out.println(m);

    }
}
