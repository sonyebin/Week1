package third;
/*
    Jenkov 예제1 - 문맥에 맞게 수정함.
    1. divide
       - static method로 수정
       - BadNumberException: 사용자 정의 가능. 대신 ArithmeticException으로 표현
    2. callDivide
       - 메소드 내부에서 divide(2, 1), divide(2, 0)을 호출해 볼 것.
    3. callDivide2
       - propagating과정을 예시
 */
public class Ex1JenkovException {
    public static int divide(int numberToDivide, int numberToDivideBy)
            throws ArithmeticException{
        if(numberToDivideBy == 0){
            throw new ArithmeticException("Cannot divide by 0");
        }
        return numberToDivide / numberToDivideBy;
    }

    public static void callDivide() {
        try {
            int result = divide(2,0);
            System.out.println(result);
        } catch (ArithmeticException e) {
            //do something clever with the exception
            System.out.println(e.getMessage());
        }
        System.out.println("Division attempt done");
    }

    public static void callDivide2() throws ArithmeticException {

        int result = divide(2,0);
        System.out.println(result);
    }

    public static void main(String[] args) {
        try {
            int n = divide(10, 0);  // 0으로 나누어 볼 것.
            System.out.println(n);
        } catch(ArithmeticException e){
        }
//
        callDivide();  // 메소드의 내부를 2/0으로 수정
//
        try {
            callDivide2(); // try catch로 처리해야
        } catch (ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
        }
    }
}
