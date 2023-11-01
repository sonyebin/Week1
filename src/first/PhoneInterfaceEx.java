package first;

import java.util.Scanner;

interface PhoneInterface { // 인터페이스 선언
    final int TIMEOUT = 10000; // 상수 필드 선언
    void sendCall(); // 추상 메소드
    void receiveCall(); // 추상 메소드
    default void printLogo() { // default 메소드
        System.out.println("** Phone **");
    }
}
class SamsungPhone implements PhoneInterface { // 인터페이스 구현
    // PhoneInterface의 모든 추상 메소드 구현
    @Override
    public void sendCall() {
        System.out.println("삼성 -- 띠리리리링");
    }
    @Override
    public void receiveCall() {
        System.out.println("삼성 -- 전화가 왔습니다.");
    }

    // 메소드 추가 작성
    public void flash() { System.out.println("전화기에 불이 켜졌습니다."); }
}
class IPhone implements PhoneInterface { // 인터페이스 구현
    // PhoneInterface의 모든 추상 메소드 구현
    @Override
    public void sendCall() {
        System.out.println("IPhone -- 띠리리리링");
    }
    @Override
    public void receiveCall() {
        System.out.println("IPhone -- 전화가 왔습니다.");
    }
}
class PhoneAppl {
    //    private SamsungPhone phone;
    private PhoneInterface phone;
    private Scanner sc = new Scanner(System.in);
    public PhoneAppl() {
        phone = new SamsungPhone();
    }
    public PhoneAppl(PhoneInterface phoneInt) {
        phone = phoneInt;
    }
    public void usePhone() {
        System.out.print("기능 선택(전화걸기:1, 전화받기:2, 종료:0) -> ");
        int ans = sc.nextInt();
        while(ans != 0) {
            if (ans == 1)
                phone.sendCall();
            if (ans == 2)
                phone.receiveCall();
            // ...
            System.out.print("기능 선택(전화걸기:1, 전화받기:2, 종료:0) -> ");
            ans = sc.nextInt();
        }
        System.out.println("종료합니다.");
    }
}
public class PhoneInterfaceEx {
    public static void main(String[] args) {
//        SamsungPhone phone = new SamsungPhone();
//        phone.printLogo();
//        phone.sendCall();
//        phone.receiveCall();
//        phone.flash();

//        PhoneAppl phoneAppl = new PhoneAppl();
        PhoneAppl phoneAppl = new PhoneAppl(new IPhone());
        phoneAppl.usePhone();
    }
}
