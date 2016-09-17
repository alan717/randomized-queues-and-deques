
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
 * A generalization of a stack and a queue that supports adding and removing
 * items from either the front or the back of the data structure.
 * 
 * Corner cases. Throw a java.lang.NullPointerException if the client attempts
 * to add a null item; throw a java.util.NoSuchElementException if the client
 * attempts to remove an item from an empty deque; throw a
 * java.lang.UnsupportedOperationException if the client calls the remove()
 * method in the iterator; throw a java.util.NoSuchElementException if the
 * client calls the next() method in the iterator and there are no more items
 * to return.
 * 
 * Performance requirements.   Your deque implementation must support each
 * deque operation in constant worst-case time. A deque containing n items must
 * use at most 48n + 192 bytes of memory. and use space proportional to the
 * number of items currently in the deque. Additionally, your iterator
 * implementation must support each operation (including construction) in
 * constant worst-case time.
 * 
 */
public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size = 0;
    
    public Deque()                           // construct an empty deque
    {
        first = null;
        last = null;
    }
   
    public boolean isEmpty()                 // is the deque empty?
    {
        return (first == null || last == null);
    }
    
    public int size()                        // return the number of items on the deque
    {
        return size;
    }
    
    public void addFirst(Item item)          // add the item to the front
    {
        if (item == null) throw new java.lang.NullPointerException();
        Node<Item> oldfirst = first;
        first = new Node<>(item);
        if (isEmpty()) last = first;
        else first.next = oldfirst;
        size++;
    }
    
    public void addLast(Item item)           // add the item to the end
    {
        if (item == null) throw new java.lang.NullPointerException();
        Node<Item> oldlast = last;
        last = new Node<>(item);
        if (isEmpty()) first = last;
        else oldlast.next = last;
        size++;
    }
    
    public Item removeFirst()                // remove and return the item from the front
    {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        size--;
    }
    
    public Item removeLast()                 // remove and return the item from the end
    {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        size--;
        return item;
    }
    
    public Iterator<Item> iterator()         // return an iterator over items in order from front to end
    {
        return new DequeIterator();
    }
    
    private class DequeIterator implements Iterator<Item> {
        private Node<Item> current = first;
        
        @Override
        public boolean hasNext() { return current != null; }
        
        @Override
        public void remove() { 
            throw new java.lang.UnsupportedOperationException();
        }
        
        public Item next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
    /**
     * The Node is the class from which a linked list is built.
     * The deque here relies on a linked list implementation.
     */
    private class Node<Item> {
        Item item;
        Node<Item> next;
        private Node(Item item) {
            this.item = item;
            next = null;
        }
    }
   
    public static void main(String[] args)   // unit testing
    {
        
    }
}
