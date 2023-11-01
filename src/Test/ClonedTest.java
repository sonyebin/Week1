package Test;

public class ClonedTest implements Cloneable{
    private String name;
    private int age;
    private ClonedTest person;
    public ClonedTest(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void setName(String name){ this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setPerson(ClonedTest person) { this.person = person; }

    public String getName() { return name; }
    public int getAge() { return age; }
    public ClonedTest getPerson() { return person; }

    @Override
    public String toString() { return "이름:"+name+"/나이:"+age; }

    @Override
    protected Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return obj;
    }
    public ClonedTest deepcopy(){   //반환타입 설정해서 타입캐스팅 필요없도록 함
        Object obj = null;
        try {
            obj= super.clone();
        } catch(CloneNotSupportedException e){
        }
        ClonedTest cloned = (ClonedTest) obj;
        cloned.setPerson(new ClonedTest(this.getName(),this.getAge()));
        return cloned;
    }

    public static void main(String[] args) {
        ClonedTest person1 = new ClonedTest("손예빈", 20);
        //얕은 복사 수행
        ClonedTest person2 = (ClonedTest) person1.clone();
        System.out.println("-------얕은 복사 수행-------");
        System.out.println(person1);
        System.out.println(person2);
        System.out.println("동일 주소? " + (person1== person2));

        //복사본 변경 시 원본도 변경...돼야 하는데 왜 안 되지? 영어 마치고 확인
        person2.setName("손수빈");
        System.out.println(person1);
        System.out.println(person2);

        //깊은 복사 수행
        System.out.println("-------깊은 복사 수행-------");
        ClonedTest person3 = person1.deepcopy();
        System.out.println("동일 주소? " + (person1.person == person3.person));
        person3.setName("손수빈");
        System.out.println(person1);
        System.out.println(person3);
    }
}
