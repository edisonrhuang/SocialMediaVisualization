// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// - Edison Huang (edisonrhuang)
package prj5;

/**
 * @author Edison Huang
 * @version 4.18.2023
 *
 */
public class Data {
    
    // Fields ------------------------------------------------------------------
    
    private String month;
    private Influencer influencer;
    
    // Constructors ------------------------------------------------------------
    
    /**
     * Constructor for Data that takes in a month field and influencer field
     * @param month Month of the data
     * @param influencer Influencer field
     */
    public Data(String month, Influencer influencer) {
        this.month = month;
        this.influencer = influencer;
    }
    
    // Methods -----------------------------------------------------------------
    
    /**
     * Default getter for the month field
     * @return Returns the month field
     */
    public String getMonth() {
        return this.month;
    }
    
    /**
     * Default getter for the influencer field
     * @return Returns the influencer
     */
    public Influencer getInfluencer() {
        return this.influencer;
    }
}
