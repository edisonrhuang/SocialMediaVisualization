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
public class Influencer {

    // Fields ------------------------------------------------------------------
    
    private String username;
    private String channelName;
    private String country;
    private String topics;
    private int likes;
    private int posts;
    private int followers;
    private int comments;
    private int views;
    private double traditionalRate;
    private double engagementRate;
    
    // Constructors ------------------------------------------------------------
    
    /**
     * Default constructor for Influencer that takes in all the fields of an
     * influencer.
     * @param username Username of the influencer
     * @param channelName Channel name of the influencer
     * @param country Country of the influencer
     * @param topics Topic covered by the influencer
     * @param likes Number of likes
     * @param posts Number of posts
     * @param followers Number of followers
     * @param comments Number of comments
     * @param views Number of views
     */
    public Influencer(String username, String channelName, String country, 
        String topics, int likes, int posts, int followers, int comments, 
        int views) {
        
        this.username = username;
        this.channelName = channelName;
        this.country = country;
        this.topics = topics;
        this.likes = likes;
        this.posts = posts;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
        traditionalRate = 0;
        engagementRate = 0;
    }
    
    // Methods -----------------------------------------------------------------
    
    /**
     * Default getter for the username field
     * @return Returns the username field
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     * Default getter for the channel name field
     * @return Returns the channelName field
     */
    public String getChannelName() {
        return this.channelName;
    }
    
    /**
     * Default getter for the country field
     * @return Returns the country field
     */
    public String getCountry() {
        return this.country;
    }
    
    /**
     * Default getter for the topics field
     * @return Returns the topics field
     */
    public String getTopics() {
        return this.topics;
    }
    
    /**
     * Default getter for the likes field
     * @return Returns the likes field
     */
    public int getLikes() {
        return this.likes;
    }
    
    /**
     * Default getter for the posts field
     * @return Returns the posts field
     */
    public int getPosts() {
        return this.posts;
    }
    
    /**
     * Default getter for the followers field
     * @return Returns the followers field
     */
    public int getFollowers() {
        return this.followers;
    }
    
    /**
     * Default getter for the comments field
     * @return Returns the comments field
     */
    public int getComments() {
        return this.comments;
    }
    
    /**
     * Default getter for the views field
     * @return Returns the views field
     */
    public int getViews() {
        return this.views;
    }
    
    /**
     * Calculates the traditional engagement and returns the calculated value
     * @return Returns the traditional engagement value.
     */
    public double getTraditionalEngagement() 
    {
        if (traditionalRate != 0) {
            return traditionalRate;
        }
        if (this.getFollowers() == 0) {
            return 0.0;
        }
        return ((this.getComments() + this.getLikes()) / (double)this
            .getFollowers()) * 100;
    }
    
    /**
     * Calculates the engagement reach and returns the calculated value.
     * @return Returns the engagement reach value
     */
    public double getEngagementReach() {
        if (engagementRate != 0) {
            return engagementRate;
        }
        if (this.getViews() == 0) {
            return 0.0;
        }
        return ((this.getComments() + this.getLikes()) / (double)this
            .getViews()) * 100;
    }
    
    /**
     * Sets the traditional rate to an already calculated value
     * @param rate The calculated rate
     */
    public void setTraditionalRate(double rate) {
        this.traditionalRate = rate;
    }
    
    /**
     * Sets the engagement rate to an already calculated value
     * @param rate The calculated
     */
    public void setEngagementRate(double rate) {
        this.engagementRate = rate;
    }
    
    /**
     * Given another influencer object, compares the two by channel name and if
     * this influencer is smaller, returns -1, if they are equal, returns 0, and
     * if the this influencer is larger, returns 1
     * @param o Other influencer object to be compared to
     * @return Returns -1 if this is smaller, 0 if equal, 1 if larger
     */
    public int compareByChannel(Influencer o) {
        String s = o.getChannelName().toLowerCase(); 
        String currName = channelName.toLowerCase(); 
        return currName.compareTo(s);  
    }
    
    /**
     * Given another influencer object, compares the two by their
     * TraditionalEngagement formula. If this influencer is smaller, returns -1,
     * if they are equal, returns 0, and if this influencer is larger, returns 1
     * @param o Other influencer object to be compared to
     * @return Returns -1 if this is smaller, 0 if equal, 1 if larger
     */
    public int compareByTEngagement(Influencer o) {
        double thisEngagement = this.getTraditionalEngagement();
        double otherEngagement = o.getTraditionalEngagement();
        if (thisEngagement < otherEngagement) {
            return -1;
        }
        else if (thisEngagement == otherEngagement) {
            return 0;
        }
        else {
            return 1;
        }
    }
    
    /**
     * Given another influencer object, compares the two by their 
     * EngagementReach formula. If this influencer is smaller, returns -1, if
     * they are equal, returns 0, and if this influencer is larger, returns 1
     * @param o Other influencer object to be compared to
     * @return Returns -1 if this is smaller, 0 if equal, 1 if larger
     */
    public int compareByREngagement(Influencer o) {
        double thisEngagement = this.getEngagementReach();
        double otherEngagement = o.getEngagementReach();
        if (thisEngagement < otherEngagement) {
            return -1;
        }
        if (thisEngagement == otherEngagement) {
            return 0;
        }
        else {
            return 1;
        }
    }
    
    /*
    public String toString() {
        return "Channel Name: " + this.getChannelName() + "\nLikes: " + 
        this.getLikes() + "\nPosts: " + this.getPosts() + "\nFollowers" + 
        this.getFollowers() + "\nComments:" + this.getComments() + "\nViews:" + 
        this.getViews();
    }
    */

}
