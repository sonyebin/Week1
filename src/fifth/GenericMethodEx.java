package fifth;

class GStack<T>{
    int tos;
    Object [] stck;
    public GStack(){
        tos = 0;
        stck = new Object[10];
    }
    public void push(T item){
        if(tos==10) return;
        stck[tos] = item;
        tos++;
    }
    public T pop(){
        if(tos==0) return null;
        tos--;
        return (T)stck[tos];
    }
    public static <T> void printStack(GStack<T> a){
        while(true){
            T tmp;
            tmp = a.pop();
            if(a==null) break;
            System.out.print(tmp+" ");
        }
    }

    public static void main(String[] args) {
        GStack<Integer> items = new GStack<>();
        for(int i=0; i<10; i++)
            items.push(i);
        printStack(items);
    }
}
public class GenericMethodEx {

}
