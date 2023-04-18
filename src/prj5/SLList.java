package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

import java.util.Iterator;
import java.util.NoSuchElementException;
import linkedlist.SinglyLinkedList.Node;

public class SLList implements Iterable<Influencer> {

    private Node<Influencer> head;
    private int size;

    /**
     * DLLlist constructor making new list
     */
    public SLList() {
        head = null;
        size = 0;
    }


    /**
     * Adds the object to the end of the list.
     *
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(Influencer obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<Influencer> current = head;
        // empty stack case
        if (isEmpty()) {
            head = new Node<Influencer>(obj);
        }

        // other cases
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<Influencer>(obj));
        }
        size++;
    }


    /**
     * returns whether the list is empty or not
     * 
     * @return true if empty false if not
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * returns the size
     * 
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * representing a node inside of our doubly linked list. points to the node
     * before and after it in a list
     * 
     * @author Faith Jones (fejones20)
     * @version 2023.04.17
     *
     * @param <T>
     *            the data type
     */
    private static class Node<T> {
        private Node<T> next;
        private T data;

        /**
         * creates a new node with type data
         * 
         * @param newData
         *            the data inside node
         */
        public Node(T newData) {
            data = newData;
        }


        /**
         * gets the data in current node
         * 
         * @return the data in node
         */
        public T getData() {
            return data;
        }


        /**
         * sets the new data in node
         * 
         * @param newData
         *            the new data in node
         */
        public void setData(T newData) {
            data = newData;
        }


        /**
         * sets the next node
         * 
         * @param node
         *            the next node
         */
        public void setNext(Node<T> node) {
            next = node;
        }


        /**
         * returns the next node
         * 
         * @return Node<T> the next node
         */
        public Node<T> getNext() {
            return next;
        }
    }


    /**
     * 
     * @author Faith Jones (fejones20)
     * @version 2023.04.17
     *
     * @param <T>
     *            the object type
     */
    private class DLIterator implements Iterator<Influencer> {
        private Node<Influencer> next;
        private boolean calledNext;

        /**
         * create new iterator
         */
        public DLIterator() {
            next = head;
            calledNext = false;
        }


        /**
         * checks to see if there is a next element in the list
         * 
         * @return boolean true if yes false if not
         */
        public boolean hasNext() {
            return (next.getNext() != tail);
        }


        /**
         * gets the next value in the list
         * 
         * @return T the next data value
         */
        public Influencer next() {
            if (hasNext()) {
                next = next.getNext();
                Influencer data = next.getData();
                calledNext = true;
                return data;
            }
            else {
                throw new NoSuchElementException();
            }
        }
    }

    /**
     * new iterator
     * 
     * @return Iterator<Influencer> iterator to iterate through influencers
     */
    @Override
    public Iterator<Influencer> iterator() {
        return new DLIterator();
    }
}
