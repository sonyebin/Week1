package Test;

import java.util.Iterator;

public class IteratorTest {
    int list[] = new int[10];
    private int current = 0;
    private int count = 0;
    public void add(int i){
        list[count++] = i;
    }
    class IterateEx implements Iterator<Integer>{   //내부클래스 구현
        public IterateEx() { current = 0; }
        @Override
        public boolean hasNext() {
            return current < list.length;
        }

        @Override
        public Integer next() {
            return list[current++];
        }
    }
    public Iterator<Integer> iterator() { return new IterateEx(); }

    public static void main(String[] args) {
        IteratorTest itest1 = new IteratorTest();
        for(int i=0; i<10; i++){
            itest1.add(i);
        }
        Iterator<Integer> it = itest1.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}
