
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
/*
 * Copyright (C) 2016 Michael <GrubenM@GMail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * A queue in which the item to be removed is chosen uniformly at random from
 * items in the queue.
 * 
 * Corner cases. The order of two or more iterators to the same randomized queue
 * must be mutually independent; each iterator must maintain its own random
 * order. Throw a java.lang.NullPointerException if the client attempts to add a
 * null item; throw a java.util.NoSuchElementException if the client attempts to
 * sample or dequeue an item from an empty randomized queue; throw a
 * java.lang.UnsupportedOperationException if the client calls the remove()
 * method in the iterator; throw a java.util.NoSuchElementException if the
 * client calls the next() method in the iterator and there are no more items to
 * return.
 * 
 * Performance requirements. Your randomized queue implementation must support
 * each randomized queue operation (besides creating an iterator) in constant
 * amortized time. That is, any sequence of m randomized queue operations
 * (starting from an empty queue) should take at most cm steps in the worst
 * case, for some constant c. A randomized queue containing n items must use at
 * most 48n + 192 bytes of memory. Additionally, your iterator implementation
 * must support operations next() and hasNext() in constant worst-case time; and
 * construction in linear time; you may (and will need to) use a linear amount
 * of extra memory per iterator.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size = 0;
    
    public RandomizedQueue()                 // construct an empty randomized queue
    {
        first = null;
        last = null;
    }
   
    public boolean isEmpty()                 // is the queue empty?
    {
        return (size <= 0);
    }
   
    public int size()                        // return the number of items on the queue
    {
        return size;
    }
    
    public void enqueue(Item item)           // add the item
    {
        if (item == null) throw new java.lang.NullPointerException();
        Node<Item> oldlast = last;
        last = new Node<>(item);
        if (isEmpty()) first = last;
        else {
            oldlast.next = last;
            last.previous = oldlast;
        }
        size++;
    }
   
    public Item dequeue()                    // remove and return a random item
    {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Node<Item> n = first;
        for (int i = 0; i < StdRandom.uniform(size); i++) n = n.next;
        if (n.previous != null) n.previous.next = n.next;
        else first = n.next;
        if (n.next != null) n.next.previous = n.previous;
        else last = n.previous;
        size--;
        n.next = null;
        n.previous = null;
        return n.item;
    }
   
    public Item sample()                     // return (but do not remove) a random item
    {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Node<Item> n = first;
        for (int i = 0; i < StdRandom.uniform(size); i++) n = n.next;
        return n.item;
    }
   
    public Iterator<Item> iterator()         // return an independent iterator over items in random order
    {
       return new RandomizedQueueIterator();
    }
    
    private class RandomizedQueueIterator implements Iterator<Item> {
        private Node<Item> iteratorFirst = first;
        private Node<Item> iteratorLast = last;
        private int subsize = size;
        
        @Override
        public boolean hasNext() { return subsize > 0; }
        
        @Override
        public void remove() { 
            throw new java.lang.UnsupportedOperationException();
        }
        
        public Item next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            Node<Item> n = iteratorFirst;
            for (int i = 0; i < StdRandom.uniform(subsize); i++) n = n.next;
            Item item = n.item;
            if (n.next != null) n.next.previous = n.next;
            else iteratorFirst = n.next;
            if (n.previous != null) n.previous.next = n.previous;
            else iteratorLast = n.previous;
            subsize--;
            n.next = null;
            n.previous = null;
            return item;
        }
    }
    
    /**
     * The Node is the class from which a linked list is built.
     * The RandomizedQueue here relies on a linked list implementation.
     */
    private class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> previous;
        
        private Node(Item item) {
            this.item = item;
            next = null;
            previous = null;
        }
    }
    public static void main(String[] args)   // unit testing
    {
       
    }
}

