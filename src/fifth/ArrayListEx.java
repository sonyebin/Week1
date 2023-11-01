package fifth;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");  //요소 삽입
        list.add("안녕");
        list.add("bye");
        System.out.println(list.contains("안녕"));
        System.out.println(list.size());    //요소 개수
        list.remove(1); // =list.remove("안녕");
        System.out.println(list.get(1));
        list.add(1,"글자");   // 요소 중간 삽입
        System.out.println(list);
        list.clear();
        System.out.println(list);

        ArrayList<String> a = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        for(int i=0; i<4; i++){
            System.out.print("이름을 입력하세요>> ");
            String str = s.next();
            a.add(str); //ArrayList에 요소 삽입: add() 메소드
        }
        for(int i=0; i<a.size(); i++){
            String name = a.get(i); //요소 알아내기
            System.out.println(name + " ");
        }
        int longestIndex = 0;
        for(int i=1; i<a.size(); i++){
            if(a.get(longestIndex).length() < a.get(i).length())
                longestIndex = i;
        }
        System.out.println("\n가장 긴 이름은 : "+ a.get(longestIndex));
        s.close();
    }
}
