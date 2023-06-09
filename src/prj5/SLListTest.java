package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// - Ayesha Kabduwal (ayeshak22)

import java.util.Iterator;
import java.util.NoSuchElementException;

/***
 * 
 * @author ayeshakabduwal
 * @version 2023.04.21
 */

public class SLListTest extends student.TestCase {
    private SLList sl;
    private SLList sl2;
    private Data data1;
    private Data data2;

    /***
     * setup method creates a new
     * singly linked list with data; data object includes
     * a month and an influencer
     */
    public void setUp() {
        sl = new SLList();
        sl2 = new SLList();
        Influencer influ1 = new Influencer("test", "channel", "usa", "robots",
            10, 20, 2000, 10, 50);
        data1 = new Data("January", influ1);
        data2 = new Data("March", influ1);
    }


    /**
     * test that the getter method gets the proper index and throws correct
     * exception if trying to get a null
     */
    public void testGet() {
        sl.add(data2);
        sl.add(data1);
        assertEquals(data1, sl.get(1));

        Exception exception = null;
        try {
            sl.get(3);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /***
     * Tests that the add method adds new data to the
     * singly linked list and ensures that size
     * updates appropriately
     */

    public void testAdd() {

        // null object
        Exception exception = null;
        try {
            sl.add(null);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);

        // adding to an empty list
        sl.add(data1);
        assertEquals(sl.size(), 1);

        // adding to a list with an object
        Influencer influ2 = new Influencer("test2", "channel", "usa", "robots",
            10, 20, 2000, 10, 50);
        Data data10 = new Data("Febuary", influ2);
        sl.add(data10);
        assertEquals(sl.size(), 2);
    }


    /***
     * asserts that the size variable
     * updates correctly
     */
    public void testSize() {
        assertEquals(sl.size(), 0);
        sl.add(data1);
        assertEquals(sl.size(), 1);
    }


    /***
     * Tests that sort by name sorts correctly
     */
    public void testSortByName() {
        Influencer name1 = new Influencer("A", "A", "usa", "robots", 10, 20,
            2000, 10, 50);
        Influencer name2 = new Influencer("B", "B", "usa", "robots", 10, 20,
            2000, 10, 50);
        Influencer name3 = new Influencer("C", "C", "usa", "robots", 10, 20,
            2000, 10, 50);

        Data data5 = new Data("January", name1);
        Data data6 = new Data("Febuary", name2);
        Data data7 = new Data("March", name3);

        // test list size is greater than 1
        sl2.add(data5);
        sl2.sortByName();

        sl.add(data6);
        sl.add(data5);
        sl.add(data7);

        sl.sortByName();
        Iterator<Data> it = sl.iterator();

        Data list1 = it.next();
        System.out.println(list1.getInfluencer().getChannelName());
        assertEquals("A", list1.getInfluencer().getChannelName());
        Data list2 = it.next();
        System.out.println(list2.getInfluencer().getChannelName());
        assertEquals("B", list2.getInfluencer().getChannelName());
        Data list3 = it.next();
        System.out.println(list3.getInfluencer().getChannelName());
        assertEquals("C", list3.getInfluencer().getChannelName());

        // Node<Data> pointer = sl.getHead();

    }


    /***
     * 
     * Tests that sort by T engagement sorts
     * the items correctly
     * (int)(((this.getComments() + this.getLikes()) /
     * (double)this.getFollowers()) * 100);
     * 
     */
    public void testSortByTEngagement() {

        // username, channelname, country, topic, likes, posts
        // followers , comments, views
        Influencer eng1 = new Influencer("A", "A", "usa", "robots", 10, 20,
            2000, 20, 50);
        Influencer eng2 = new Influencer("B", "B", "usa", "robots", 10, 20,
            3000, 30, 50);
        Influencer eng3 = new Influencer("C", "C", "usa", "robots", 10, 20,
            4000, 30, 50);
        Data data5 = new Data("January", eng1);
        Data data6 = new Data("Febuary", eng2);
        Data data7 = new Data("March", eng3);

        // test that list size is greater than one
        sl2.add(data5);
        sl2.sortByTEngagement();

        sl.add(data6);
        sl.add(data5);
        sl.add(data7);

        sl.sortByTEngagement();

        Iterator<Data> it = sl.iterator();
        Data list1 = it.next();
        assertEquals("A", list1.getInfluencer().getChannelName());
        Data list2 = it.next();
        assertEquals("B", list2.getInfluencer().getChannelName());
        Data list3 = it.next();
        assertEquals("C", list3.getInfluencer().getChannelName());

    }


    /***
     * Tests that sort by R engagement sorts
     * the items correctly
     * (int)(((this.getComments() + this.getLikes()) /
     * (double)this.getViews()) * 100);
     */
    public void testSortByREngagement() {
        // username, channelname, country, topic, likes, posts
        // followers , comments, views
        Influencer eng1 = new Influencer("A", "A", "usa", "robots", 10, 20,
            2000, 20, 100);
        Influencer eng2 = new Influencer("B", "B", "usa", "robots", 10, 20,
            3000, 30, 200);
        Influencer eng3 = new Influencer("C", "C", "usa", "robots", 10, 20,
            4000, 30, 300);

        Data data5 = new Data("January", eng1);
        Data data6 = new Data("Febuary", eng2);
        Data data7 = new Data("March", eng3);

        // test that list size is greater than one
        sl2.add(data5);
        sl2.sortByREngagement();

        sl.add(data6);
        sl.add(data5);
        sl.add(data7);

        sl.sortByREngagement();

        Iterator<Data> it = sl.iterator();
        Data list1 = it.next();
        assertEquals("A", list1.getInfluencer().getChannelName());
        Data list2 = it.next();
        assertEquals("B", list2.getInfluencer().getChannelName());
        Data list3 = it.next();
        assertEquals("C", list3.getInfluencer().getChannelName());
    }


    /***
     * Asserts that is empty only
     * returns true if the list is empty
     */
    public void testIsEmpty() {
        assertTrue(sl.isEmpty());
        sl.add(data1);
        assertFalse(sl.isEmpty());

    }


    /***
     * Tests that the iterator functions
     * correctly
     */
    public void testIterator() {
        sl.add(data1);
        sl.add(data1);
        sl.add(data1);
        Iterator<Data> iter = sl.iterator();
        assertEquals(data1, iter.next());
        assertEquals(data1, iter.next());
        assertEquals(data1, iter.next());

        assertFalse(iter.hasNext());
        Exception nullExcep = null;
        try {
            iter.next();
        }
        catch (NoSuchElementException e) {
            nullExcep = e;
        }
        assertNotNull(nullExcep);

    }

}
