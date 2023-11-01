package Test;

public class WrapperTest {
    public static void main(String[] args) {
        Integer test = Integer.valueOf(10);
        Integer test2 = Integer.valueOf(10);
        int num = 10;
        System.out.println("래퍼클래스 == 기본타입 : "+(test == num)); //true (오토언박싱)
        System.out.println("래퍼클래스.equals(기본타입) : "+test.equals(num)); //true (오토언박싱)
        System.out.println("래퍼클래스 == 래퍼클래스 : "+(test == test2)); //읭 얘도 true인데
        System.out.println("래퍼클래스.equals(래퍼클래스) : "+test.equals(test2)); //true

        String str = "10";
        String str2 = "10.5";
        String str3 = "true";

        Byte b = Byte.parseByte(str);
        Integer i = Integer.parseInt(str);
        Short s = Short.parseShort(str);
        Long l = Long.parseLong(str);
        Float f = Float.parseFloat(str2);
        Double d = Double.parseDouble(str2);
        Boolean bool = Boolean.parseBoolean(str3);

        String stri = Integer.toString(i);
        String strd = Double.toString(d);

        String binary = Integer.toBinaryString(i);
        String octal = Integer.toOctalString(i);
        String hex = Integer.toHexString(i);

    }
}
