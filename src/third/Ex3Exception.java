package third;
/*
    Exception의 기본 개념 소개
    1. Exception Handling 없이 실행할 경우, Exception 발생
       - call stack 개념, 주요 메소드: printStackTrace()
    2. try catch 구문으로 대응. 예외 처리
    3. thorws 구문으로 대응. 메소드에 예외 발생 가능 선언. caller에게 대응 요구
  */
class ExceptionExample {
    public static void test1() {
        try {
            test2(null);
        } catch (NullPointerException e) {
            //혹은 여기서 try-catch... 메인에서도 가능?
        }
    }
    public static void test2(String message) throws NullPointerException {
//        try {
            System.out.println(message.toUpperCase());  //대문자로 바꿔주는 메소드
//        } catch(NullPointerException e){
//            여기서 의미있는 대처 필요
//        }
    }
}
public class Ex3Exception {
    public static void main(String[] args) {
        var ex = new ExceptionExample();
        ex.test1();     // try catch로 대응이 필요
    }
}
