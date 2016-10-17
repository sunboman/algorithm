package princeton_algorithm_part_i.ch2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] a;
    private int N;


    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) temp[i] = a[i];
        a = temp;
    }

    // construct an empty randomized queue
    public RandomizedQueue() {
        a = (Item[]) new Object[1];
        N = 0;
    }

    // is the queue empty?
    public boolean isEmpty() {
        return N <= 0;
    }

    // return the number of items on the queue
    public int size() {
        return N;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        if (N == a.length / 4){
            resize(a.length / 2);
        }
        int random = new Random().nextInt(N);
        Item temp = a[random];
        a[random] = a[--N];
        return temp;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int random = new Random().nextInt(N);
        return a[random];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizeQueueIterator();
    }

    private class RandomizeQueueIterator implements Iterator<Item> {

        private int i = N;
        private Item[] b;

        RandomizeQueueIterator() {
            b = (Item[]) new Object[N];
            for (int i = 0; i < N; i++) b[i] = a[i];
        }

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            if (N == 0) throw new NoSuchElementException();
            int random = new Random().nextInt(i);
            Item temp = b[random];
            b[random] = b[--i];
            return temp;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing
    public static void main(String[] args) {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue(1);
        randomizedQueue.enqueue(2);
        randomizedQueue.enqueue(3);
        randomizedQueue.enqueue(4);

        for (Integer item : randomizedQueue) System.out.println(item);
        System.out.println(randomizedQueue.sample());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        for (Integer item : randomizedQueue) System.out.println(item);
    }
}