package Test;

public class CompareTest implements Comparable<Integer> {
    private int value;

    public CompareTest(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Integer o) {
        return this.value - o;
    }

    public boolean isBigger(int value) {
        return this.compareTo(value) > 0;
    }

    public static void main(String[] args) {
        CompareTest num1 = new CompareTest(4);
        System.out.println(num1.isBigger(5));
        System.out.println(num1.isBigger(4));
        System.out.println(num1.isBigger(2));
    }
}
