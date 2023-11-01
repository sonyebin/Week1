package fifth;
import java.util.Iterator;

public class IntList implements Iterator<Integer> {
    private int[] items = new int[10];
    private int count = 0;
    private int current = 0;
    public void add(int item){
        items[count++] = item;
    }
    public int get(int index) {
        return items[index];
    }

    @Override
    public boolean hasNext() {
        if (current < count)
            return true;
        else
            return false;
    }

    @Override
    public Integer next() {
        return items[current++];
    }

    public static void main(String[] args) {
        IntList iList = new IntList();
        iList.add(1);
        iList.add(2);

        // iterating 관리가 쉽지 않음
        while (iList.hasNext()){
            System.out.println(iList.next());
        }

        // 다시 iterating 하려면??
        iList.current = 0;
        while (iList.hasNext()){
            System.out.println(iList.next());
        }
//

    }
}
