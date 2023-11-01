package fifth;

public class GenericMethod {
    public static <T> void print(T a) { System.out.println(a.toString()); }
    public static <T extends Comparable<T>> boolean isBigger(T a, T b){
        if (a.compareTo(b) > 0)
            return true;
        else return false;
    }

    public static void main(String[] args) {
        Integer n = 10;
        Integer n2 = 12;
        System.out.println(isBigger(n,n2));
        String str = "서울,대구,부산,포항";
        String arr[] = str.split(",");
        String arr2[] = str.split(",",2);
        String str2 = str.split(",")[1];
        for(String s : arr)  System.out.println(s);
        for(String s : arr2) System.out.println(s);
        System.out.println(str2);

        String str3 = "abc@naver.com";
        String arr3[] = str3.split("@|\\.");
        for(String s : arr3) System.out.println(s);
    }
}
