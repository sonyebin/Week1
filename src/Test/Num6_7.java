package Test;

import java.util.Scanner;

public class Num6_7{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.print(">>");
            String str = s.nextLine();
            if(str.equals("그만")) {
                System.out.println("종료합니다...");
                break;
            }
            String arr[] = str.split(" ");
            System.out.println("어절 개수는 "+arr.length);
        }
    }
}