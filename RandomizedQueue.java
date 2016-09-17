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
 *
 * @author Michael <GrubenM@GMail.com>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    int size = 0;
    
    public RandomizedQueue()                 // construct an empty randomized queue
    {
       
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
       
    }
   
    public Item dequeue()                    // remove and return a random item
    {
       
    }
   
    public Item sample()                     // return (but do not remove) a random item
    {
       
    }
   
    public Iterator<Item> iterator()         // return an independent iterator over items in random order
    {
       
    }
    
    /**
     * The Node is the class from which a linked list is built.
     * The deque here relies on a linked list implementation.
     */
    private class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> previous;
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

