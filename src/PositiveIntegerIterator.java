import java.util.*;
/*
 * Goal: Given an Iterator of type Integer, provide an Iterator<Integer> implementation 
 *       that only provides non-negative values. Only implement next() and hasNext()
 * 
 * Input: Iterator of type Integer
 * Output: next() should only ever return positive integers, hasNext() should only return
 *         true if there is a positive integer ahead in the underlying Iterator
 * 
 * Notes:
 *      remove() does not need to be implemented
 *      testIter() is a test case that should pass
 */




public class PositiveIntegerIterator implements Iterator<Integer> {
	Iterator<Integer> iterator;
	Integer next;
	public PositiveIntegerIterator(Iterator<Integer> i) {
		//todo
		iterator = i;
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			if (next != null && next > 0) {
				this.next = next;
				break;
			}
		}
	}
	
	@Override
	public boolean hasNext() {
		//todo
		return next != null && next > 0;
	}
	
	@Override
	public Integer next() { //throws NoSuchElementException
		//todo
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		Integer res = next;
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			if (next != null && next > 0) {
				this.next = next;
				break;
			}
		}
		if (!iterator.hasNext()) {
			next = null;
		}
		return res;
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
		Iterator<Integer> intIter = Arrays.asList(new Integer[] {null, -1, 2, null, 15, -4, 50, null}).iterator();
		Iterator<Integer> iter = new PositiveIntegerIterator(intIter);


//		//multiple hasNext() calls succeed
//		for (int i = 0; i < 100; i++) {
//			assert iter.hasNext();
//		}

		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		/*//values are correct
		iter.hasNext();
		iter.next() == 2;
		//no hasNext() call...
		assert iter.next() == 15;
		assert iter.hasNext();
		assert iter.next() == 50;
		assert iter.hasNext() == false;*/
	}
}


