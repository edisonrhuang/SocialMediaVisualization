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


    // NEW>??!? DELETE
    public Data get(int index) {
        Node<Data> current = head;
        int currentIndex = 0;
        Data data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        // check if the data was null...
        if (data == null) {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
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
     * 
     * sort by the name placing them alphabetically in the list A-Z. compares
     * curr node to next node and swaps/stays still accordingly traversing
     * through whole list
     * 
     * sort by the name in alphabetical order
     * 
     */
    public void sort() {
        Node<Data> curr = head;
        Node<Data> currNext = head.next;
        while (curr != null) {
            currNext = curr.next;
            while (currNext != null) {
                if (curr.getData().getInfluencer().compareByChannel(currNext
                    .getData().getInfluencer()) > 0) {

                    Data temp = curr.data;
                    curr.data = currNext.data;
                    currNext.data = temp;
                    curr = currNext;
                }
                currNext = currNext.next;
            }
            curr = curr.next;

        }

        /*
         * curr = head;
         * while (curr != null) {
         * System.out.print(curr.getData().getInfluencer().getChannelName());
         * curr = curr.next;
         * }
         * System.out.println("");
         */
    }


    public void sortByName() {
        Node<Data> insert = null;

        if (this.size > 1) {
            Node<Data> unsorted = head.next;
            Node<Data> sorted = head;
            sorted.setNext(null);

            while (unsorted != null) {
                insert = unsorted;
                unsorted = unsorted.getNext();
                
                Data data = insert.getData();
                Node<Data> curr = head;
                Node<Data> prev = null;

                while (curr != null && data.getInfluencer().compareByChannel(
                    curr.getData().getInfluencer()) < 0) {
                    prev = curr;
                    curr = curr.getNext();
                }

                if (prev != null) {
                    prev.setNext(insert);
                    insert.setNext(curr);
                }
                else {
                    insert.setNext(head);
                    head = insert;
                }

            }
        }

    }


    /**
     * sort by traditional engagement rate, placing the highest engagement first
     * and the the lowest last in the list. compares curr node to next node and
     * swaps their data accordingly
     */
    public void sortByTEngagement() {
        Node<Data> curr = head;
        Node<Data> currNext = head.next;
        while (curr != null) {
            currNext = curr.next;
            while (currNext != null) {
                if (curr.getData().getInfluencer().compareByTEngagement(currNext
                    .getData().getInfluencer()) < 0) {

                    Data temp = curr.data;
                    curr.data = currNext.data;
                    currNext.data = temp;
                    curr = currNext;
                }
                currNext = currNext.next;
            }
            curr = curr.next;
        }
    }


    /**
     * sort by engagement rate reach, placing the highest engagement rate at
     * the front of the list and lowest at the end. compares curr node to next
     * node and swaps data accordingly
     */
    public void sortByREngagement() {
        Node<Data> curr = head;
        Node<Data> currNext = head.next;
        while (curr != null) {
            currNext = curr.next;
            while (currNext != null) {
                if (curr.getData().getInfluencer().compareByREngagement(currNext
                    .getData().getInfluencer()) < 0) {

                    Data temp = curr.data;
                    curr.data = currNext.data;
                    currNext.data = temp;
                    curr = currNext;
                }
                currNext = currNext.next;
            }
            curr = curr.next;
        }
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

            return (next != null);
        }


        /**
         * gets the next value in the list
         * 
         * @return T the next data value
         */
        public Data next() {
            if (hasNext()) {
                Data data = next.getData();
                next = next.getNext();
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
