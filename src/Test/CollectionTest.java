package Test;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {

//        for(i=0; i<SIZE=1;i++){
//            least=i;
//            for(j=i+1; j<SIZE;j++){
//                if(list[j]<list[least]){
//                    least = j;
//                }
//            }
//            temp = list[i];
//            list[i] = list[least];
//            list[least] = temp;
//        }
        //Vector!!!
        Vector<Integer> vecInt = new Vector<>();
        for(int i=0; i<10; i++){
            vecInt.add(i);
        }
        Vector<Integer> cloned = (Vector<Integer>) vecInt.clone();
        for(int i=0; i<vecInt.size(); i++){ //일반 for문...
            System.out.print(vecInt.get(i)+" ");
        }
        System.out.println();
        for(var v : cloned) {   //강화for문... var로 타입추론
            System.out.print(v + " ");
        }
        System.out.println();

        //ArrayList!!!
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");
        Collections.reverse(list);
        Iterator<String> it = list.iterator();  //iterator...
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println(Collections.binarySearch(list,"abc"));
        Collections.sort(list);
        it = list.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println(Collections.binarySearch(list,"abc"));


        //HashMap!!!
        HashMap<String,Integer> familyMap = new HashMap<>(4);
        familyMap.put("손예빈",20);
        familyMap.put("손수빈",29);
        familyMap.put("손의곤",48);
        familyMap.put("김지인",48);
        for(String s : familyMap.keySet()){ //keySet()...
            System.out.println("이름:"+s+"/나이:"+familyMap.get(s));
        }
    }
}
