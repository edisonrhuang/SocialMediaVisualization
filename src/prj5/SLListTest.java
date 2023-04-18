package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/***
 * 
 * @author ayeshakabduwal
 * @version 1.0 
 */
public class SLListTest extends student.TestCase 
{
    private SLList sl;
    private Data data1;
    private Influencer influ1;

    /***
     * setup method creates a new 
     * singly linked list with data; data object includes 
     * a month and an influencer 
     */
    public void setUp() 
    {
        sl = new SLList(); 
        influ1 = new Influencer("test", "channel", "usa",
            "robots", 10, 20, 2000, 10, 50);
        data1 = new Data("January", influ1); 
    }


    /***
     * Tests that the add method adds new data to the 
     * singly linked list and ensures that size 
     * updates appropriately 
     */
    private void testAdd() 
    {
        //null object 
        Exception exception = null;
        try
        {
            sl.add(null);
        }
        catch (IllegalArgumentException e)
        {
            exception = e; 
        }
        assertNotNull(exception); 
        
        //adding to an empty list  
        sl.add(data1);
        assertEquals(sl.size(), 1); 
        
        //adding to a list with an object 
        Influencer influ2 = new Influencer("test2", "channel", "usa",
            "robots", 10, 20, 2000, 10, 50);
        Data data2 = new Data("Febuary", influ2); 
        sl.add(data2);
        assertEquals(sl.size(), 2); 
    }
    
    /***
     * asserts that the size variable 
     * updates correctly 
     */
    public void testSize()
    {
        assertEquals(sl.size(), 0); 
        sl.add(data1);
        assertEquals(sl.size(), 1); 
    }
    
    /***
     * Tests that sort by name sorts correctly 
     */
    public void testSortByName()
    {
        Influencer name1 = new Influencer("A", "A", "usa",
            "robots", 10, 20, 2000, 10, 50); 
        Influencer name2 = new Influencer("B", "B", "usa",
            "robots", 10, 20, 2000, 10, 50); 
        Influencer name3 = new Influencer("C", "C", "usa",
            "robots", 10, 20, 2000, 10, 50); 
        Data data1 = new Data("January", name1); 
        Data data2 = new Data("Febuary", name2); 
        Data data3 = new Data("March", name3); 
        
        sl.add(data2);
        sl.add(data1);
        sl.add(data3);
        
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
    }
    
   
    /***
     * Tests that sort by T engagement sorts 
     * the items correctly 
     * (int)(((this.getComments() + this.getLikes()) / 
            (double)this.getFollowers()) * 100);
     * 
     */
    public void testSortByTEngagement()
    {
        //username, channelname, country, topic, likes, posts
        //followers , comments, views 
        Influencer eng1 = new Influencer("A", "A", "usa",
            "robots", 10, 20, 2000, 20, 50); 
        Influencer eng2 = new Influencer("B", "B", "usa",
            "robots", 10, 20, 3000, 30, 50); 
        Influencer eng3 = new Influencer("C", "C", "usa",
            "robots", 10, 20, 4000, 30, 50); 
        Data data1 = new Data("January", eng1); 
        Data data2 = new Data("Febuary", eng2); 
        Data data3 = new Data("March", eng3); 
        
        sl.add(data2);
        sl.add(data1);
        sl.add(data3);
        
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
            (double)this.getViews()) * 100);
     */
    public void testSortByREngagement()
    {
        //username, channelname, country, topic, likes, posts
        //followers , comments, views 
        Influencer eng1 = new Influencer("A", "A", "usa",
            "robots", 10, 20, 2000, 20, 100); 
        Influencer eng2 = new Influencer("B", "B", "usa",
            "robots", 10, 20, 3000, 30, 200); 
        Influencer eng3 = new Influencer("C", "C", "usa",
            "robots", 10, 20, 4000, 30, 300); 
        
        Data data1 = new Data("January", eng1); 
        Data data2 = new Data("Febuary", eng2); 
        Data data3 = new Data("March", eng3); 
        
        sl.add(data2);
        sl.add(data1);
        sl.add(data3);
        
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
     * Asserts that is empty only 
     * returns true if the list is empty
     */
    public void testIsEmpty()
    {
        assertTrue(sl.isEmpty());
        sl.add(data1);
        assertFalse(sl.isEmpty()); 
    }
    
    /***
     * Tests that the iterator functions 
     * correctly 
     */
    public void testIterator()
    {
        sl.add(data1);
        sl.add(data1);
        sl.add(data1);
        Iterator<Data> iter = sl.iterator(); 
        assertEquals(data1, iter.next()); 
        assertEquals(data1, iter.next()); 
        assertEquals(data1, iter.next()); 
        
        assertFalse(iter.hasNext()); 
        Exception nullExcep = null;
        try 
        {
            iter.next(); 
        }
        catch (NoSuchElementException e)
        {
            nullExcep = e; 
        }
        assertNotNull(nullExcep);   
    }
      

}
