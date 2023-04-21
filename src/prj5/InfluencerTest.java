// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// - Edison Huang (edisonrhuang)
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
public class InfluencerTest {
    
    // Fields ------------------------------------------------------------------
    
    private Influencer influencer1;
    private Influencer influencer2;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        influencer1 = new Influencer("aafootball", "allaboutfootball", "ES", 
            "Sports", 22876452, 333, 4650272, 518, 170095);
        influencer2 = new Influencer("fashion22", "fitnessandfashion", "US", 
            "Fashion", 43048545, 692, 3566876, 475, 228755);
    }


    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        influencer1 = null;
        influencer2 = null;
    }

    /**
     * Tests the getter methods
     */
    @Test
    public void testGetters() {
        assertEquals("aafootball", influencer1.getUsername());
        assertEquals("allaboutfootball", influencer1.getChannelName());
        assertEquals("ES", influencer1.getCountry());
        assertEquals("Sports", influencer1.getTopics());
        assertEquals(22876452, influencer1.getLikes());
        assertEquals(333, influencer1.getPosts());
        assertEquals(4650272, influencer1.getFollowers());
        assertEquals(518, influencer1.getComments());
        assertEquals(170095, influencer1.getViews());

        influencer1 = new Influencer("aafootball", "allaboutfootball", "ES", 
            "Sports", 22876452, 333, 0, 518, 0);
        
        assertEquals(0.0, influencer1.getTraditionalEngagement(), 0.0);
        assertEquals(0.0, influencer1.getEngagementReach(), 0.0);

        
        influencer1.setEngagementRate(1.0);
        influencer1.setTraditionalRate(1.0);
        
        assertEquals(1.0, influencer1.getTraditionalEngagement(), 0.0);
        assertEquals(1.0 , influencer1.getEngagementReach(), 0.0);
    }

    /**
     * Tests the compare methods
     */
    @Test
    public void testCompares() {
        //System.out.println(influencer1.compareByChannel(influencer2) < 0);
        assertTrue(influencer1.compareByChannel(influencer2) < 0);
        assertEquals(0, influencer1.compareByChannel(influencer1));
        assertTrue(influencer2.compareByChannel(influencer1) > 0);
        
        assertEquals(-1, influencer1.compareByTEngagement(influencer2));
        assertEquals(0, influencer1.compareByTEngagement(influencer1));
        assertEquals(1, influencer2.compareByTEngagement(influencer1));
        
        assertEquals(-1, influencer1.compareByREngagement(influencer2));
        assertEquals(0, influencer1.compareByREngagement(influencer1));
        assertEquals(1, influencer2.compareByREngagement(influencer1));
    }
    
}
