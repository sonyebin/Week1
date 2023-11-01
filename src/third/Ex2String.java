package third;

public class Ex2String {
    public static void main(String[] args) {
        String s = "abc";   //string 컨스턴트 풀에 이미 존재하는 것.
        String s2 = new String("abc");  //위에 것과의 차이 알기.
        System.out.println(s==s2);  //같은 주소인지 비교->false
        System.out.println(s.equals(s2));

        String data = "고급프로그래밍:90";
        int i = data.lastIndexOf(':');    //character 타입이라 ' 한 개
        System.out.println(i);
        String part1 = data.substring(0,i); //0부터 i-1까지 추출
        System.out.println(part1);
        String part2 = data.substring(i+1);  //i+1부터 끝까지
        System.out.println(part2);

        // 다음 내용에서 과목 명
        String data2 = "고급프로그래밍:90 데이터베이스:100";
        // 추출 가능한가?
        String[] courseArray = new String[2];
        int[] scoreArray = new int[2];
        int score1, score2;
        String[] tempArr = data2.split(" ");
        //공백을 기준으로 tempArr) [0]=고급프로그래밍:90/[1]=데이터베이스:100 나눔

        String[] temp = tempArr[0].split(":");  //:을 기준으로 temp) [0]=고급프로그래밍/[1]=90 나눔
        courseArray[0] = temp[0];   //고프 저장
        scoreArray[0] = Integer.parseInt(temp[1]);  //90을 Integer형으로 바꿔서 저장

        temp = tempArr[1].split(":");   //[0]=데이터베이스/[1]=100 나눔
        courseArray[1] = temp[0];   //데베 저장
        scoreArray[1] = Integer.parseInt(temp[1]);  //100 저장

        for(String str:courseArray) //과목명 루프 돌며 출력
            System.out.print(str + " ");
        System.out.println();
        for(int n:scoreArray)   //점수 루프돌며 출력
            System.out.print(n + " ");
        System.out.println();
    }
}
