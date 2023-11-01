package Test;

public class StringTest {
    public static void main(String[] args) {
        String data = "고급프로그래밍:90 데이터베이스:100";
        String courseArray[] = new String[2];
        int scoreArray[] = new int[2];
        String arr[] = data.split(" ");
        String arr2[] = arr[0].split(":");
        courseArray[0] = arr2[0];
        scoreArray[0] = Integer.parseInt(arr2[1]);
        arr2 = arr[1].split(":");
        courseArray[1] = arr2[0];
        scoreArray[1] = Integer.parseInt(arr2[1]);
        System.out.print("과목 : ");
        for (String s : courseArray) {
            System.out.print(s + " ");
        }
        System.out.print("\n점수 :     ");
        for (int i : scoreArray) {
            System.out.print(i + "         ");
        }
    }
}
