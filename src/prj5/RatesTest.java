/**
 * 
 */
package prj5;

/**
 * @author ayeshakabduwal
 * @version 1.0 
 * As a Hokie, I will conduct myself with honor and integrity at all times.
 // I will not lie, cheat, or steal, nor will I accept the actions of those who
 // do.
 // - Ayesha Kabduwal (ayeshak22)
 *
 */
public class RatesTest extends student.TestCase
{
    /***
     * Fields 
     */
    private Rates rate1; 
    
    /***
     * Setup method creates one rate
     * for testing. 
     */
    public void setUp()
    {
        rate1 = new Rates ("rate1", 2000.0); 
    }
    
    /***
     * Asserts that the name method 
     * returns the correct name stored.  
     */
    public void testGetName()
    {
        assertEquals("rate1", rate1.getName()); 
    }
    
    /***
     * Asserts that the get rate method 
     * returns the correct value stored.  
     */
    public void testGetRate()
    {
        assertEquals(2000.0, rate1.getRate(), 0); 
    }
    
    /***
     * Tests that the compare to method returns 
     * the correct value for compare to; 0 if it is equal, 
     * -1 if this rate is less than the rate passed, and 1
     * if this rate is greater than the rate passed. 
     */
    public void testCompareTo()
    {
        Rates ratesLess = new Rates("hello", 100.0); 
        Rates ratesMore = new Rates("hello", 10000.0); 
        Rates ratesEqual = new Rates("hello", 2000.0); 
        
        assertEquals(rate1.compareTo(ratesLess), 1);
        assertEquals(rate1.compareTo(ratesMore), -1);
        assertEquals(rate1.compareTo(ratesEqual), 0);    
    }

}
