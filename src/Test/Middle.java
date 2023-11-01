package Test;

/*
    학번: 32210240
    이름: 구지원
    주의사항:
        1) 자신 이름의 클래스를 생성하고 이를 기반으로 제시된 내용들을 구현할 것.
        2) main와 오버라이드되는 메소드를 제외하고 새로 구현할 메소드들의 이름과 매개변수들에는 자신의 학번의
          마지막 자리 수를 추가할 것. 예) greatest_9(...)
        3) 오버라이드되는 메소드의 명칭은 변경할 필요 없음.
    시험진행 방법:
        1) 자신 이름의 클래스 생성. java 파일 생성을 의미함.
        2) 제시된 문제의 내용을 복사(단 클래스 명은 제외).
        3) 메소드, 매개변수, 주요 변수들의 명칭 변경
        4) 문제 풀이 진행
        5) 완료 후 자신 이름의 .java 파일 온라인 제출

    시험 문제 파일을 참고하여 다음 내용을 구현하세요.
 */

import java.util.ArrayList;
import java.util.List;

// 1.a). 1.b)
class ComplexNo extends Number implements Comparable<ComplexNo>{
    private int real_0;
    private int image_0;

    public ComplexNo(int r, int i) {
        this.real_0 = r;
        this.image_0 = i;
    }

    @Override
    public String toString() {
        // 허수 앞에 - 일경우 처리
        String parsedimage_0 = image_0 < 0?  String.valueOf(image_0) : "+" + image_0;
        parsedimage_0 += "i";

        String result = real_0 + parsedimage_0;
        // 예외처리
        if(real_0 == 0){
            result = image_0 + "i";
        } else if(image_0 == 0){
            result = String.valueOf(real_0);
        }

        return result;
    }

    // 2.a) 추상 메소드들 구현
    @Override
    public int intValue() {
        return real_0;
    }

    @Override
    public long longValue() {
        return real_0;
        //반환할 때 자동으로 형변환이 되기 때문에 (long)real_0;이라고 하지 않아도 ok
        //자동형변환... 작은 데이터 타입->큰 데이터 타입
    }

    @Override
    public float floatValue() {
        return real_0;
    }

    @Override
    public double doubleValue() {
        return real_0;
    }

    // 3.a)
    @Override
    public int compareTo(ComplexNo o) {
        // 동일 0, 기준 값 < 비교대상 -1, 기준 값 > 비교대상 1
        // 동일한 경우 아무 값이나 출력해도 동일하므로 아래처럼 처리
        return Integer.compare(this.real_0, o.real_0) < 0? o.real_0 : this.real_0;
    }

    // 4.a)
    public ComplexNo(String strNo) {
        // 콤마와 마이너스 숫자를 제외한 문자 빈값처리
        String filteredStr = strNo.replaceAll("[^0-9^,^-]", "");
        String[] complexArray = filteredStr.split(",");

        this.real_0 = Integer.parseInt(complexArray[0]);
        this.image_0 = Integer.parseInt(complexArray[1]);
    }

    public int getReal_0() {
        return real_0;
    }

    public int getImage_0() {
        return image_0;
    }
}

public class Middle {
    // 5.a) 제네릭 메소드 maxValue 구현
    public static <T extends Comparable<? super T>> ComplexNo maxValue(List<ComplexNo> complexNoList){
        int max_0 = complexNoList.get(0).getReal_0();
        ComplexNo maxComplexNo_0 = complexNoList.get(0);
        for(ComplexNo complexNo : complexNoList){
            if(complexNo.getReal_0() > max_0){
                max_0 = complexNo.getReal_0();
                maxComplexNo_0 = complexNo;
            }
        }
        return maxComplexNo_0;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("*** 1.c)의 실행 결과 ***");
        // 1.c)
        ComplexNo complexNo1 = new ComplexNo(4, -7);
        ComplexNo complexNo2 = new ComplexNo(-2, 0);

        System.out.println(complexNo1.toString());
        System.out.println(complexNo2.toString());


        System.out.println("*** 2.b)의 실행 결과 ***");
        // 2.b)
        System.out.println(complexNo1.intValue());
        System.out.println(complexNo1.longValue());


        System.out.println("*** 3.b)의 실행 결과 ***");
        // 3.b)
        System.out.println(complexNo1.compareTo(complexNo2));

        System.out.println("*** 4.b)의 실행 결과 ***");
        // 4.b)
        ComplexNo complexNo3 = new ComplexNo("(-12, -35)");
        System.out.println(complexNo3.toString());


        System.out.println("*** 4.c)의 실행 결과 ***");
        // 4.c)
        String[] complexArray = {"(-1,2)", "(5,7)", "(0,-5)", "(3,-1)", "(2,1)"};
        List<ComplexNo> complexNoList = new ArrayList<>();
        for (int i = 0; i < complexArray.length; i++) {
            ComplexNo tmpComplexNo = new ComplexNo(complexArray[i]);
            complexNoList.add(tmpComplexNo);
        }

        complexNoList.forEach((complexNo) -> {
            System.out.println(complexNo.toString());
        });

        System.out.println("*** 5.b)의 실행 결과 ***");
        // 5.b)
        System.out.println(maxValue(complexNoList).toString());
    }
}
