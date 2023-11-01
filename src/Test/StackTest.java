package Test;

interface Stack {
    boolean isEmpty();
    void push(char data);
    char pop();
    char peek();
    void delete();
}

public class StackTest implements Stack {
    private int top;
    private int stackSize;
    private char[] stack;
    public StackTest(int stackSize){
        this.top = -1;
        this.stackSize = stackSize;
        this.stack = new char[this.stackSize];
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull(){
        return (top == this.stackSize -1);
    }
    @Override
    public void push(char data) {
        if (isFull()){
            System.out.println("스택이 포화상태입니다.\n");
        } else stack[++top] = data; //top의 위치를 증가시킨 뒤 삽입
    }

    @Override
    public char pop() {
        if (isEmpty()){
            System.out.println("스택이 공백상태입니다.\n");
            return 0;
        } else return stack[top--]; //데이터를 반환 후 top의 위치 감소
    }

    @Override
    public char peek() {
        if(isEmpty()){
            System.out.println("스택이 공백상태입니다.\n");
            return 0;
        } else return stack[top];
    }

    @Override
    public void delete() {
        if(isEmpty()){
            System.out.println("스택이 공백상태입니다.\n");
        } else top--;
    }
    public int getTop(){
        return this.top;
    }
    public void printStack(){
        if (isEmpty()) System.out.println("스택이 공백상태입니다.\n");
        else{
            System.out.print("Stack : ");
            for(int i=0; i<=this.top; i++) System.out.print(stack[i]+" ");
        }
        System.out.println("(top의 위치 "+getTop()+")");
    }

    public static void main(String[] args) {
        StackTest st = new StackTest(5);
        char data = 0;
        System.out.println("1. 스택에 원소 5개 삽입");
        for(char i = 'A'; i <= 'E'; i++) st.push(i);
        st.printStack();

        System.out.println("2. top이 가리키고 있는 원소 알아내기");
        System.out.println(st.peek());

        System.out.println("3. 스택의 원소 3개 팝");
        for(int i=0; i<3; i++){
            data = st.pop();
            System.out.println("삭제된 원소 : "+data);
            st.printStack();
        }

        System.out.println("4. 스택의 원소 삭제");
        st.delete();
        st.printStack();
    }
}
