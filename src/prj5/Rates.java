// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// - Edison Huang (edisonrhuang)
package prj5;

/**
 * @author Edison Huang
 * @version 4.21.2023
 *
 */
public class Rates implements Comparable {

    // Fields ------------------------------------------------------------------

    private String name;
    private double rate;

    // Constructors ------------------------------------------------------------

    /**
     * Default constructor for Rates that gets a channel name and the rate
     * associated with the channel.
     * 
     * @param name
     *            Name of the channel
     * @param rate
     *            Calculated Rate
     */
    public Rates(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    // Methods -----------------------------------------------------------------


    /**
     * Default getter for the name field
     * 
     * @return Returns the name field
     */
    public String getName() {
        return this.name;
    }


    /**
     * Default getter for the rate field
     * 
     * @return Returns the rate field
     */
    public double getRate() {
        return this.rate;
    }


    /**
     * Given another Rate, compares the two's rate field and returns -1 if this
     * is smaller, 0 if they are equal, 1 if this is larger.
     * 
     * @param o
     *            the object being compared
     *            Other rate to be compared to
     * @return Returns -1 if this is smaller, 0 if equal, 1 if larger
     */
    @Override
    public int compareTo(Object o) {
        Rates r = (Rates)o;
        if (this.getRate() < r.getRate()) {
            return -1;
        }
        else if (this.getRate() > r.getRate()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
