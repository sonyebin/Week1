package first;

/*
   상속 개념 예제 설명 - Random 상속을 통해
   1. 부모 클래스의 필드와 메소드 상속: 메인에서 상속된 메소드의 사용
   2. 생성자에서 부모 클래스의 생성자 호출: super()
   3. 메소드 오버라이딩 예제
   4. 추가 메소드 구현
   5. upcasting, downcasting 예제 제시
   6. 실제 타입의 확인
 */

import java.util.Random;

// 상속 예제
public class DataAnalysis2 extends Random {
    // 2. 부모 클래스의 생성자 호출
    public DataAnalysis2() {
        super(); // super(1);
    }
    // 3. nextInt의 오버라이드 메소드 구현: 메뉴 -> Code -> Override Methods
    @Override
    public int nextInt() {
        return super.nextInt(100);
    }
    // 구현 후 메인에서 확인

    // 4. 본 클래스에서 난수 정수 배열 기능 제공 -- 구현 시켜볼 것.
    public void nextInts(int[] data){
        for(int i = 0; i < data.length; i++){
            data[i] = nextInt();
            //  data[i] = super.nextInt();// 실행결과와 다른 이유?
        }
    }

    public static void main(String[] args) {
        // **** 상속의 의미를 설명 ****
        Random r = new Random();    //랜덤클래스의 참조변수
        System.out.println(r.nextInt());
        // 1. DataAnalysis2는 Random의 method들을 상속
        DataAnalysis2 da = new DataAnalysis2();
        System.out.println(da.nextInt());
        // 1.a 상속된 nextInt() 사용
        System.out.println("========= nextBytes() =========");
        // 1.b Random의 nextBytes로 데이터 생성 가능.
        byte[] bData = new byte[5];
        r.nextBytes(bData);
        for(int i = 0; i < 5; i++){
            System.out.println(bData[i]);
        }
        // 1.c 상속 메소드 nextBytes로 데이터 생성 가능. 실행 결과가 다른 이유?
        da.nextBytes(bData);
        for(int i = 0; i < 5; i++){
            System.out.println(bData[i]);
        }

        System.out.println("========== nextInt ==========");
        // 3. Random nextInt()와 오버라이드된 nextInt의 사용
        for(int i = 0; i < 5; i++){
            System.out.println(r.nextInt());
        }
        for(int i = 0; i < 5; i++){
            System.out.println(da.nextInt());
        }

        System.out.println("========== nextInts(int[] ) ==========");
        // 4. nextInts()의 사용
        int [] iData = new int[5];
        da.nextInts(iData);
        for(int i = 0; i < 5; i++){
            System.out.println(iData[i]);
        }

        System.out.println("========== upcasting, downcasting ==========");
        // 5. upcasting, downcasting 예제
        Random r2 = new DataAnalysis2();      // upcasting
        // r2.nextInts()  ;        // nextInts 메소드 사용 불가능. 이유?
        DataAnalysis2 da2 = (DataAnalysis2) r2;  // downcasting. r2 대신 r로 수정하면 어떤 문제?
        // r2.nextInts() 사용 가능. r.nextInts(); 는 어떤가?

        // instanceof의 기능 및 동적 바인딩
        System.out.println("========== method overriding + dynamic binding ==========");
        System.out.println(da2.nextInt());
        System.out.println(r2.nextInt()); // 어느 메소드가 호출되는지 확인
        System.out.println(r.nextInt());


        System.out.println("========== instanceof ==========");
        System.out.println(r instanceof Random);
        System.out.println(r2 instanceof Random);
        System.out.println(da instanceof Random);

        System.out.println();
        System.out.println(r instanceof DataAnalysis2);
        System.out.println(r2 instanceof DataAnalysis2);
        System.out.println(da instanceof DataAnalysis2);

        System.out.println("========== getClass ==========");
        System.out.println(r.getClass());
        System.out.println(r2.getClass());   // 실제 타입 반환
        System.out.println(da.getClass());
    }
}
