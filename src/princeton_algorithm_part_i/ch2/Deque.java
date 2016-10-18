package princeton_algorithm_part_i.ch2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Item[] a;

    private int front;
    private int end;

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];

        for (int i = front; i < end; i++) {
            if (i < 0) temp[i - front] = a[a.length + i % a.length];
            else temp[i - front] = a[i % a.length];
        }
        end = end - front;
        front = 0;
        a = temp;
    }

    // construct an empty deque
    public Deque() {
        a = (Item[]) new Object[1];
        front = 0;
        end = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return end == front;
    }

    // return the number of items on the deque
    public int size() {
        return end - front;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new NullPointerException();
        if (end - front + 1 == a.length) resize(2 * a.length);

        if (--front < 0) a[a.length + front % a.length] = item;
        else a[front % a.length] = item;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) throw new NullPointerException();
        if (end - front + 1 == a.length) resize(2 * a.length);

        if (end < 0) a[a.length + end++ % a.length] = item;
        else a[end++ % a.length] = item;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        if (end - front + 1 == a.length / 4) resize(a.length / 2);

        if (front < 0) return a[a.length + front++ % a.length];
        else return a[front++ % a.length];
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        if (end - front + 1 == a.length / 4) resize(a.length / 2);
        if (end < 0) return a[a.length + --end % a.length];
        else return a[--end % a.length];
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private int i_front = front;
        private int i_end = end;

        @Override
        public boolean hasNext() {
            return i_end > i_front;
        }

        @Override
        public Item next() {
            if (i_end <= i_front) throw new NoSuchElementException();
            if (i_front < 0) return a[a.length + i_front++ % a.length];
            else return a[i_front++ % a.length];
        }
    }

    // unit testing
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addFirst(6);
        for (Integer item : deque) System.out.println(item);
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        String a = "";
    }
}