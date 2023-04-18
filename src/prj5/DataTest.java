// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
package prj5;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Edison Huang
 * @version 4.18.2023
 *
 */
public class DataTest {

    // Fields ------------------------------------------------------------------
    
    private Data data;
    private Influencer influencer;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        influencer = new Influencer("aafootball", "allaboutfootball",
            "ES", "Sports", 22876452, 333, 4650272, 518, 170095);
        data = new Data("January", influencer);
    }


    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        data = null;
    }

    /**
     * Tests getters
     */
    @Test
    public void testGetters() {
        assertEquals("January", data.getMonth());
        assertEquals(influencer, data.getInfluencer());
    }

}
