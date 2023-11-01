package fifth;

/*
   교재의 예들 중 핵심 부분만 추출 + 확인
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEx {


    public static void main(String[] args) {
        // P30
        // 영어 단어와 한글 단어의 쌍을 저장하는 HashMap 컬렉션 생성
        HashMap<String, String> dic = new HashMap<>();

        // 3 개의 (key, value) 쌍을 dic에 저장
        dic.put("baby", "아기"); // "baby"는 key, "아기"은 value
        dic.put("love", "사랑");
        dic.put("apple", "사과");
        dic.remove("apple"); // 요소 삭제

        // 해시맵에서 '키' eng의 '값' kor 검색
        String eng = "love";
        String kor = dic.get(eng);   // 값을 변경하면서 테스트
        if(kor == null)
            System.out.println(eng +
                    "는 없는 단어 입니다.");
        else
            System.out.println(kor);

        // P31
        // 사용자 이름과 점수를 기록하는 HashMap 컬렉션 생성
        HashMap<String, Integer> scoreMap = new HashMap<>();
        // (key, value) 쌍 저장
        scoreMap.put("김성동", 97); // 요소 추가
        scoreMap.put("황기태", 88);
        scoreMap.put("김남윤", 98);
        scoreMap.remove("김남윤"); // 요소 삭제

        System.out.println("HashMap의 요소 개수 :" + scoreMap.size());

        Set<String> keys = scoreMap.keySet(); // 해시맵에 있는 모든 키를 Set 컬렉션으로 리턴
        Iterator<String> it = keys.iterator();
        while(it.hasNext()) {
            String name = it.next();
            int score = scoreMap.get(name);
            System.out.println(name + " : " + score);
        }
        //entrySet() 활용
        for (Entry<String, Integer> entry : scoreMap.entrySet()){
            System.out.println("[Key]:" + entry.getKey() +
                    " [Value]:" + entry.getValue()); }

        //KeySet() 활용
        for(String i : scoreMap.keySet()){ //저장된 key값 확인
            System.out.println("[Key]:" + i +
                    " [Value]:" + scoreMap.get(i)); }

        // P32
        HashMap<String, Student> map = new HashMap<String, Student>();

        // 3 명의 학생 저장
        map.put("황기태", new Student(1, "010-111-1111"));
        map.put("이재문", new Student(2, "010-222-2222"));
        map.put("김남윤", new Student(3, "010-333-3333"));
    }
}

// 다음 정의는 위의 클래스 내부에 정의하고 main에서 사용은 곤란. 이유 생각해볼 것.
class Student { // 학생을 표현하는 클래스
    int id;
    String tel;
    public Student(int id, String tel) {
        this.id = id; this.tel = tel;
    }
}
