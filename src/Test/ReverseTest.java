package Test;

import java.util.ArrayList;

public class ReverseTest {
    public static void main(String[] args) {
        int[] list = {1,4,12,5,7,1,0};
        int[] arr = new int[list.length];
        int j=0;
        for(int i=list.length; i>=0; i--){
            arr[j] = list[i];
            j++;
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        for(int i=list2.size(); i>=0; i--){
            list3.add(i);
        }
    }
}
