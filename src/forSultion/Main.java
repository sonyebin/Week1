package forSultion;
import java.util.Random;
import java.util.Scanner;

class StrNum {
    private String strData;
    private int base;

    public StrNum(String strData, int base) {
        this.strData = strData;
        this.base = base;
    }

    public String getStrData() {
        return strData;
    }

    public void setStrData(String strData) {
        this.strData = strData;
    }

    public int getValue() {
        return Integer.parseInt(strData, 10);  // Always parse as decimal (base 10)
    }

    public int getBase() {
        return base;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StrNum other = (StrNum) obj;
        return strData.equals(other.strData) && base == other.base;
    }

    @Override
    public String toString() {
        return strData;
    }
}

class SimpleStrNum {
    private StrNum strNum;

    public SimpleStrNum(StrNum strNum) {
        this.strNum = strNum;
    }

    public StrNum getStrNum() {
        return strNum;
    }

    public SimpleStrNum add(SimpleStrNum other) {
        int result = this.strNum.getValue() + other.strNum.getValue();
        return new SimpleStrNum(new StrNum(Integer.toString(result, strNum.getBase()), strNum.getBase()));
    }

    public SimpleStrNum subtract(SimpleStrNum other) {
        int result = this.strNum.getValue() - other.strNum.getValue();
        return new SimpleStrNum(new StrNum(Integer.toString(result, strNum.getBase()), strNum.getBase()));
    }

    public SimpleStrNum multiply(SimpleStrNum other) {
        int result = this.strNum.getValue() * other.strNum.getValue();
        return new SimpleStrNum(new StrNum(Integer.toString(result, strNum.getBase()), strNum.getBase()));
    }

    public SimpleStrNum divide(SimpleStrNum other) {
        int otherValue = other.strNum.getValue();
        if (otherValue == 0) {
            System.out.println("Cannot divide by zero.");
            return null;
        }
        int result = this.strNum.getValue() / otherValue;
        return new SimpleStrNum(new StrNum(Integer.toString(result, strNum.getBase()), strNum.getBase()));
    }
}

class SimpleStrNumArray implements Cloneable {
    private SimpleStrNum[] simpleStrNums;

    public SimpleStrNumArray(int n) {
        simpleStrNums = new SimpleStrNum[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            // Generate a random number between 1 and 100 for each SimpleStrNum
            int randomNumber = random.nextInt(100) + 1;
            StrNum strNum = new StrNum(Integer.toString(randomNumber), 10);
            simpleStrNums[i] = new SimpleStrNum(strNum);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        SimpleStrNumArray that = (SimpleStrNumArray) obj;

        // Check if both arrays have the same length
        if (simpleStrNums.length != that.simpleStrNums.length) return false;

        // Check if the elements in both arrays are equal
        for (int i = 0; i < simpleStrNums.length; i++) {
            if (!simpleStrNums[i].equals(that.simpleStrNums[i])) return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("SimpleStrNumArray: [");
        for (int i = 0; i < simpleStrNums.length; i++) {
            result.append(simpleStrNums[i].getStrNum());
            if (i < simpleStrNums.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");

        return result.toString();
    }

    @Override
    public SimpleStrNumArray clone() {
        try {
            SimpleStrNumArray clone = (SimpleStrNumArray) super.clone();
            clone.simpleStrNums = this.simpleStrNums.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // This should never happen
        }
    }

    public SimpleStrNum[] getSimpleStrNums() {
        return simpleStrNums;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the number of SimpleStrNums to generate (or 'quit' to exit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            int n = Integer.parseInt(input);
            SimpleStrNumArray strNumArray = new SimpleStrNumArray(n);

            // Print the SimpleStrNumArray
            System.out.println("Generated SimpleStrNumArray: " + strNumArray.toString());

            SimpleStrNumArray clonedArray = strNumArray.clone();
            System.out.println("Cloned SimpleStrNumArray: " + clonedArray.toString());

            System.out.println(clonedArray.equals(strNumArray));
        }

        scanner.close();
    }
}
