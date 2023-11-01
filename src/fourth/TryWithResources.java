package fourth;

import java.io.Closeable;
import java.io.IOException;

class CustomResources implements Closeable {

    @Override
    public void close() throws IOException {

    }
}
public class TryWithResources {
//    public static void main(String[] args) {
//        try {
//            method1();
//        } catch(IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    method2();
//    try (CustomResource cr = new CustomResources()){
//        cr.doSomething();
//    } catch(Exception e){
//
//    }
}
