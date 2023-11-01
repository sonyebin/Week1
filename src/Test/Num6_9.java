package Test;

import java.util.Scanner;

public class Num6_9 {
    public static void main(String[] args) {
        String rsp[] = {"가위","바위","보"};
        Scanner s = new Scanner(System.in);
        int ans=0;
        int computer;
        while(true){
            System.out.print("철수[가위(1), 바위(2), 보(3), 끝내기(4)]>>");
            ans = s.nextInt();
            computer = (int)(Math.random()*3)+1;
            if(ans==4)
                break;
            else{
                System.out.println("철수("+rsp[ans-1]+") : 컴퓨터("+rsp[computer-1]+")");
                if(ans==computer)
                    System.out.println("비겼습니다.");
                else if((ans==1&&computer==2)||(ans==2&&computer==3)&&(ans==3&&computer==1))
                    System.out.println("컴퓨터가 이겼습니다.");
                else System.out.println("철수가 이겼습니다.");
            }
        }
    }
}
