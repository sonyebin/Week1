package first;

public class ComparableEx {
    public static void main(String[] args) {
        Integer i = 10;    //boxing 발생. Wrapper?
        Integer j = -10;
        System.out.println(i.compareTo(j));     //i>j이면 1, i=j이면 0, i<j이면 -1 반환
    }
}
