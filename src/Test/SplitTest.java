package Test;
// 기본형 타입을 복사하면 값 복사?
// 객체와 같은 참조형 타입의 변수를 clone 복제하면 주소값이 복사되어 얕은 복사
public class SplitTest {

    public static void main(String[] args) {
        String str = "Hello, my name is yebin.";
//        System.out.println(str.split(" "));
        String arr[] = str.split(" ");
        for(String s : arr)
            System.out.println(s);
        int num = 0;
        String str2 = "My name is Tom.";
        for(int i=0; i<str2.length(); i++){
            char a= str2.charAt(i);
            if(a==' ') num++;
        }
        System.out.println(num);

    }
}
