package A1_C04_06_Stack;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    private Item[] s;
    private int N = 0;

    public Stack(int capacity) {
        s = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        s[N++] = item;
    }

    public Item pop() {
        Item item = s[--N];
        s[N] = null;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() {

        }

        public Item next() {
            return s[--i];
        }

    }

}
