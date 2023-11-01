package fifth;
//익명클래스가 더 쉽긴 한데... 시험에 내진 않음
import java.util.Iterator;

public class IntList2 {
    private int[] items = new int[10];
    private int count = 0;
    private int current = 0;
    public void add(int item){
        items[count++] = item;
    }
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }

    class IteratorImpl implements Iterator<Integer> {
        public IteratorImpl() {
            current = 0;
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
    }

    public static void main(String[] args) {
        IntList2 iList = new IntList2();
        iList.add(1);
        iList.add(2);

        Iterator<Integer> it = iList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        it = iList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
