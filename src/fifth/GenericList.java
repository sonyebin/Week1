package fifth;

import java.awt.*;
import java.util.Iterator;

public class GenericList<T> {    // T(type) or E(element)가 많이 사용됨
    //T a = new T(); 와 같은 제네릭 타입의 객체 생성 불가

    private T[] items = (T[]) new Object[10]; //object를 T타입으로 타입캐스트 해야 함
    private int count = 0;
    private int current = 0;

    public void add(T item){
        items[count++] = item;
    }
    public void myArray(T a){
        System.out.println(a);
    }

    public T get(int index) {
        return items[index];
    }

    public Iterator<T> iterator() {
        current = 0;
        return new GListIteratorImpl();
    }

    class GListIteratorImpl implements Iterator<T> {
        @Override
        public boolean hasNext() {
            if (current < count)
                return true;
            else
                return false;
        }

        @Override
        public T next() {
            return items[current++];
        }
    }

        public static void main(String[] args) {
            // new GenericList<Integer>().add() 의 입력 시 타입이 Integer로 제한됨
            GenericList<Integer> iList = new GenericList<>();
            iList.add(10);
            int num = iList.get(0);

            var pList = new GenericList<Point>();
            pList.add(new Point(1,2));
            System.out.println(pList.get(0));  // 컴파일에 타입 오류를 찾을 수 있는 장점.
            GenericList A = new GenericList();
            A.myArray(5);

        }
    }
