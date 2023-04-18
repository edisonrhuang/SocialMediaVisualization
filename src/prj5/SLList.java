package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// - Faith Jones (fejones20)

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Faith Jones (fejones20)
 * @version 2023.04.18
 *
 */
public class SLList implements Iterable<Data> {

    private Node<Data> head;
    private int size;

    /**
     * DLLlist constructor making new list
     */
    public SLList() {
        head = null;
        size = 0;
    }


    /**
     * returns the head
     * 
     * @return Node<Data> the front node
     */
    public Node<Data> getHead() {
        return head;
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
    public void add(Data obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<Data> current = head;
        // empty stack case
        if (isEmpty()) {
            head = new Node<Data>(obj);
        }

        // other cases
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<Data>(obj));
        }
        size++;
    }


    /**
     * sort by the name
     */
    public void sortByName() {
        Node<Data> curr = head;
        Node<Data> temp = head;
        Node<Data> currNext = head.next;
        while (curr != null) {
            while (currNext != null) {
                if (curr.getData().getInfluencer().compareByChannel(currNext
                    .getData().getInfluencer()) < 0) {
                    temp = curr;
                    curr = currNext;
                    currNext = temp;
                }
                currNext = currNext.next;
            }
            curr = curr.next;
        }
    }


    public void sortByTEngagement() {

    }


    public void sortByREngagement() {

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
    private class SLIterator implements Iterator<Data> {
        private Node<Data> next;
        private boolean calledNext;

        /**
         * create new iterator
         */
        public SLIterator() {
            next = head;
            calledNext = false;
        }


        /**
         * checks to see if there is a next element in the list
         * 
         * @return boolean true if yes false if not
         */
        public boolean hasNext() {
            return (next.getNext() != null);
        }


        /**
         * gets the next value in the list
         * 
         * @return T the next data value
         */
        public Data next() {
            if (hasNext()) {
                next = next.getNext();
                Data data = next.getData();
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
     * @return Iterator<Data> iterator to iterate through Datas
     */
    @Override
    public Iterator<Data> iterator() {
        return new SLIterator();
    }
}
