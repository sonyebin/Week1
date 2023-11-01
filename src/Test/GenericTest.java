package Test;

public class GenericTest<T> {
    private T[] list = (T[]) new Object[5];
    private int count = 0;
    public void add(T a){
        list[count++] = a;
    }
    public void printList(){
        for(int i=0; i<list.length; i++){
            System.out.print(list[i]+" ");
        }
    }

    public static void main(String[] args) {
        GenericTest<Integer> iList = new GenericTest<>();
        System.out.println("-----int 리스트-----");
        for(int i=0; i<5; i++) iList.add(i);
        iList.printList();
        System.out.println("\n-----char 리스트-----");
        GenericTest<Character> strList = new GenericTest<>();
        for(char i='a'; i<='e'; i++) strList.add(i);
        strList.printList();
    }
}
