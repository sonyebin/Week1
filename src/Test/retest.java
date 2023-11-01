package Test;
//기본형 타입이 아닌 객체와 같은 참조형 타입 변수를 복제(clone)하면 값이 복사되는 게 아닌
//주소값을 복사하는 게 되어 얕은 복사가 됨
class Car implements Cloneable{
    private String name;
    private int price;
    public Car(String name, int price){
        this.name = name;
        this.price = price;
    }

    @Override
    public Car clone(){
        Object obj = null;
        try {
            obj = super.clone();
        } catch(CloneNotSupportedException e){}
        return (Car)obj;
    }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public String toString(){
        return "차 기종: "+name+"/가격: "+price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
class CarStore implements Cloneable{
    Car car;
    private int year;
    public CarStore(Car car, int year){
        this.car = car;
        this.year = year;
    }
    public void setCar(Car car){
        this.car = car;
    }
    @Override
    public String toString(){
        return car.toString()+"/연도:"+year;
    }
    @Override
    public CarStore clone(){
        Object obj = null;
        try {
            obj = super.clone();
        } catch(CloneNotSupportedException e){}
        return (CarStore)obj;
    }

    public CarStore deepCopy(){
        Object obj = null;
        try {
            obj = super.clone();
        } catch(CloneNotSupportedException e){}
        CarStore cloned = (CarStore)obj;
        cloned.setCar(new Car(this.car.getName(),this.car.getPrice()));
        return cloned;
    }
}
public class retest {
    public static void main(String[] args) {
        Car c1 = new Car("모닝",1000);
        Car c2 = c1; //얕은 복사
        Car c3 = c1.clone(); //깊은 복사
        System.out.println("c1:"+c1);
        System.out.println("c2:"+c2);
        System.out.println("c3:"+c3);
        System.out.println("(얕은 복사) c1=c2? "+(c1==c2));
        System.out.println("(깊은 복사) c1=c3? "+(c1==c3));
        System.out.println("------c1 name->마티즈------");
        c1.setName("마티즈");
        System.out.println("c1:"+c1);
        System.out.println("c2:"+c2);
        System.out.println("c3:"+c3);

        System.out.println("---------------------------");

        CarStore cs1 = new CarStore(new Car("아반떼",2000),2023);
        CarStore cs2 = cs1.clone(); //얕은 복사
        CarStore cs3 = cs1.deepCopy();  //깊은 복사
        System.out.println("cs1:"+cs1);
        System.out.println("cs2:"+cs2);
        System.out.println("cs3:"+cs3);
        System.out.println("(얕은 복사) cs1.car=cs2.car? "+(cs1.car==cs2.car));
        System.out.println("(깊은 복사) cs1.car=cs3.car? "+(cs1.car==cs3.car));
        System.out.println("------cs1 name->벤츠------");
        cs1.car.setName("벤츠");
        System.out.println("cs1:"+cs1);
        System.out.println("cs2:"+cs2);
        System.out.println("cs3:"+cs3);
    }
}
