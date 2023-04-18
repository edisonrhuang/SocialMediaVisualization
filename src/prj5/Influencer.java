package prj5;

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
    public Influencer (String username, String channelName, String country, 
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
    public int getTraditionalEngagement() {        
        return ((this.getComments() + this.getLikes()) / this.getFollowers()) 
            * 100;
    }
    
    /**
     * Calculates the engagement reach and returns the calculated value.
     * @return Returns the engagement reach value
     */
    public int getEngagementReach() {
        return ((this.getComments() + this.getLikes()) / this.getViews()) * 100;
    }
}
