package prj5;


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
    private void testAddAndSize() 
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
     * Tests that sort by name sorts correctly 
     */
    public void testSortByName()
    {
        Influencer name1 = new Influencer("A", "channel", "usa",
            "robots", 10, 20, 2000, 10, 50); 
        Influencer name2 = new Influencer("B", "channel", "usa",
            "robots", 10, 20, 2000, 10, 50); 
        Influencer name3 = new Influencer("C", "channel", "usa",
            "robots", 10, 20, 2000, 10, 50); 
        Data data1 = new Data("January", name1); 
        Data data2 = new Data("Febuary", name2); 
        Data data3 = new Data("March", name3); 
        
        sl.add(data2);
        sl.add(data1);
        sl.add(data3);
        
        sl.sortByName(); 
        Node<Data> pointer = sl.getHead(); 
        
        
        
        
    }
    
    /***
     * Tests that sort by engagement 
     * sorts by the correct engagement 
     */
    public void testSortByEngagement()
    {
        //TODO
    }
    
    /***
     * Tests that sort by T engagement sorts 
     * the items correctly 
     */
    public void testSortByTEngagement()
    {
        //TODO
    }
    
    /***
     * Tests that sort by R engagement sorts 
     * the items correctly
     */
    public void testSortByREngagement()
    {
        //TODO
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
    
    
    

}
