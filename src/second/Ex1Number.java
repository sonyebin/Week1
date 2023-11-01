package second;

class StrInt extends Number implements Comparable<StrInt>{
    private int num;
    public StrInt(String sInt){
        num = Integer.parseInt(sInt);
    }

    @Override
    public int intValue() {
        return num;
    }

    @Override
    public long longValue() {
        return (long)num;   //타입캐스트?
    }

    @Override
    public float floatValue() {
        return (float)num;
    }

    @Override
    public double doubleValue() {
        return (double)num;
    }

    @Override
    public int compareTo(StrInt strInt) {
        return this.num - strInt.num;
    }
}
public class Ex1Number {
    public static void print(Number n){
        System.out.println(n.getClass().getName() + ":" +n.doubleValue());
    }
//    public static int isSmaller(Number n1, Number n2){
//        return n1.compareTo(n2);   오류나는 이유? int 비교인데 구현된 compareTo는 StrInt 타입이라??
//    }
    public static void main(String[] args) {
        StrInt strI = new StrInt("123");
        Number[] nArrays = { 1.0, 5, 2, (byte)23, 123456L };    //각각 double, int 등으로 박싱되어 대입...

        for(Number n : nArrays)
            System.out.println(n.getClass());

        for(Number n : nArrays)
            System.out.println(n.doubleValue());

        for(Number n : nArrays)
            print(n);
    }
}
