package basic.basic_structure;

/**
 * Created by sunbo_000 on 2/11/2016.
 */
public class MyQueue {
    Object[] queue;
    Integer max;
    Integer head;
    Integer tail;

    public MyQueue(Integer size) {
        this.queue = new Object[size];
        this.max = size;
        this.head = 0;
        this.tail = 0;
    }

    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue(3);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        System.out.println(myQueue.dequeue());
        myQueue.enqueue(4);
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());

        String a = null;
    }

    public void enqueue(Object o) throws Exception {
        if (head - tail >= max) throw new Exception("the Queue is full");
        queue[head % max] = o;
        head++;
    }

    public Object dequeue() throws Exception {
        if (head - tail <= 0) throw new Exception("the Queue is empty");
        Object ele = queue[tail % max];
        tail++;
        return ele;
    }

}
