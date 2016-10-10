package basic.basic_structure;

/**
 * Created by sunbo_000 on 2/10/2016.
 */
public class MyStack {
    Integer max;
    Object[] stack;
    Integer num;

    public MyStack(Integer max) {
        this.stack = new Object[max];
        this.max = max;
        this.num = 0;
    }

    public static void main(String[] args) throws Exception {
        MyStack myStack = new MyStack(3);
        System.out.println(myStack.empty());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
//        myStack.push(4);
        System.out.println(myStack.search(3));
        System.out.println(myStack.peek());
//        System.out.println(myStack.num);
        myStack.output();
    }

    public Boolean empty() {
        return this.num <= 0;
    }

    public void push(Object o) throws Exception {
        if (num >= max) throw new Exception("Stack is Full");
        stack[num] = o;
        num++;
    }

    public Object pop() throws Exception {
        if (num <= 0) throw new Exception("Stack is empty");
        num--;
        return stack[num];
    }

    public Integer search(Object o) throws Exception {
        if (num <= 0) throw new Exception("Stack is empty");
        for (int i = 0; i < num; i++) {
            if (o.equals(stack[i])) {
                return num - i;
            }
        }
        return -1;
    }

    public Object peek() {
        if (num <= 0) return null;
        else {
            return stack[num - 1];
        }
    }

    public void output() {
        for (Object o : this.stack) {
            System.out.println(o);
        }
    }
}
