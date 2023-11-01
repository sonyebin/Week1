package fifth;
import java.util.Iterator;
import java.util.Vector;

public class IteratorEx {
    public static void main(String[] args) {
        Vector<Integer> ivec = new Vector<>();
        for(int i=0; i<5; i++){
            ivec.add(i);
        }
        //Iterator 객체 얻기
        Iterator<Integer> it = ivec.iterator();
        while(it.hasNext()){
            int n = it.next();
            System.out.println(n);
        }

        //Iterator를 이용하여 모든 정수 더하기
        int sum = 0;
        it = ivec.iterator();   //it 다시 설정
        while(it.hasNext()){
            int n = it.next();
            sum += n;
        }
        System.out.println("벡터에 있는 정수 합: "+sum);
    }
}
