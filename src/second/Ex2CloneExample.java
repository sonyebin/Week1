package second;

/*
   1. Book 클래스 구현 후, 메인에서 clone() 메소드 사용
   2. Book이 Cloneable 구현하도록 수정
   3. BookStore 클래스 구현 후, Object의 clone 오버라이딩 후 이의 사용
      - shallow copy 개념의 clone.
      - 위의 내용 확인
   4. deepcopy 메소드 구현 -> clone으로 구현 가능
 */

// 2.

class Book implements Cloneable {
    String name;
    int price;
    public Book(String bookName, int bookPrice) {
        name = bookName;
        price = bookPrice;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int newPrice) {
        price = newPrice;
    }
    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return obj;
    }
    @Override
    public String toString() {
        return "Book{" + name + ", " + price + "}";
    }
}

// 3.
class BookStore implements Cloneable {
    public Book book;   // 동일 참조 여부를 메인에서 확인하려 수정
    private String name;
    public BookStore(Book b, String publisher) {
        book = b;
        name = publisher;
    }

    public Book getBook() {
        return book;
    }
    public void setBook(Book newBook) {
        book = newBook;
    }

    @Override
    public BookStore clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return (BookStore) obj;
    }

    public BookStore deepCopy() {
        Object obj = null;
        try {
            obj =  super.clone();
        } catch (CloneNotSupportedException e) {}
        BookStore bs = (BookStore) obj;
        bs.setBook(new Book(this.book.getName(), this.book.getPrice()));
        return bs;
    }

    public String toString() {
        return "BookStore{" + book.toString() + ", " + name + "}";
    }
}

public class Ex2CloneExample {
    public static void main(String[] args) {
        // 1.
        System.out.println("*** 1단계");
        Book book = new Book("JPA Book", 10000);
        Book bookCopy = (Book) book.clone();   //  compile error

        // 2. Cloneble 구현으로 수정
        System.out.println("*** 2단계");
        System.out.println(book);
        System.out.println(bookCopy);

        // 3.BookStore 생성 및 clone() 실행
        System.out.println("*** 3단계");
        BookStore bs1 = new BookStore(new Book("JPA BOOK", 10000), "교보문고");
        BookStore bs2 = bs1.clone();
        System.out.println("bs1과 bs2 동일 주소? " + (bs1 == bs2));
        //bs1과 bs2는 다른 객체라 false 출력, 하지만 내부 필드가 동일 참조라 밑의 코드는 true 출력
        System.out.println("bs1.book과 bs2.book 동일 주소? " + (bs1.book == bs2.book));
        System.out.println("bs2의 book 객체 수정 - shallow copy");
        bs2.getBook().setName("SPRING BOOK");

        // 원본 BookStore을 조회
        System.out.println("bs1 = " + bs1);
        System.out.println("bs2 = " + bs2);

        // 4. deepcopy의미의 clone 실행 - 실제로는 deepcopy. clone으로 수정 가능
        // clone한 BookStore의 BOOK 이름을 JPA BOOK -> SPRING BOOK 변경
        System.out.println("*** 4단계");
        BookStore bs3 = bs1.deepCopy();
        bs3.getBook().setName("New Book Name");

        // 원본 BookStore을 조회
        System.out.println("bs1 = " + bs1);
        System.out.println("bs3 = " + bs3);
    }
}
