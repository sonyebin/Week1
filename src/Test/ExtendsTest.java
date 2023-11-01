package Test;

class Person1{
    String name;
    public Person1(String name) { this.name = name; }
}
class Student extends Person1 {
    String grade;
    public Student(String name) {
        super(name);
    }
}

class SuperObject{
    public void paint(){
        draw();
    }
    public void draw(){
        draw();
        System.out.println("Super Object");
    }
}
class SubObject extends SuperObject {
    @Override
    public void paint(){
        super.draw();
    }
    @Override
    public void draw(){
        System.out.println("Sub Object");
    }
}
public class ExtendsTest{
    public static void main(String[] args) {
        Person1 p = new Student("손예빈"); //업캐스팅
        // p.grade = "A"; -> 불가(슈퍼클래스의 멤버만 접근 가능)
        Student s = (Student)p; //다운캐스팅
        s.grade = "A";

        SuperObject b = new SubObject();
        b.paint();
        SubObject a = (SubObject) b;
        a.paint();


    }
}