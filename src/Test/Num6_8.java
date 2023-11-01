package Test;
import java.util.Scanner;
public class Num6_8 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("문자열을 입력하세요. 빈칸이 있어도 되고, 영어 한글 모두 됩니다.");
        String str = s.nextLine();
        for(int i=1; i<=str.length(); i++){
            System.out.print(str.substring(i));
            System.out.println(str.substring(0,i-1));
        }
    }
}
