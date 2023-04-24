package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

public class SocialMediaWindow {

    private int rate;
    private Window window;
    private String month;
    private SLList[] listArr;
    private SLList list;

    private Button channelName;
    private Button engagementRate;
    private Button traditionalEngagement;
    private Button reachEngagement;
    private Button janButton;
    private Button febButton;
    private Button marchButton;
    private Button firstQuarter;
    private Button quit;

    private Shape barLeft;
    private Shape barMidLeft;
    private Shape barMidRight;
    private Shape barRight;

    private TextShape timeFrame;
    private TextShape rateType;
    private TextShape sortBy;

    private TextShape barLeftName;
    private TextShape barMidLeftName;
    private TextShape barMidRightName;
    private TextShape barRightName;

    public SocialMediaWindow(SLList[] monthArr) {

        listArr = monthArr;
        window = new Window("Social Media Vis");

        // click channel name
        channelName = new Button("Sort by Channel Name");
        window.addButton(channelName, WindowSide.NORTH);
        channelName.onClick(this, "clickedChannel");

        // click Engagement Rate
        engagementRate = new Button("Sort by Engagement Rate");
        window.addButton(engagementRate, WindowSide.NORTH);
        engagementRate.onClick(this, "clickedEngagementRate");

        // click Traditional Rate
        traditionalEngagement = new Button("Traditional Engagement Rate");
        window.addButton(traditionalEngagement, WindowSide.WEST);
        traditionalEngagement.onClick(this, "clickedTraditionalRate");

        // click Engagement Reach
        reachEngagement = new Button("Reach Engagement Rate");
        window.addButton(reachEngagement, WindowSide.WEST);
        reachEngagement.onClick(this, "clickedReachEngagement");

        // click january
        janButton = new Button("January");
        window.addButton(janButton, WindowSide.SOUTH);
        janButton.onClick(this, "clickedJan");

        // click february
        febButton = new Button("February");
        window.addButton(febButton, WindowSide.SOUTH);
        febButton.onClick(this, "clickedFeb");

        // click march
        marchButton = new Button("March");
        window.addButton(marchButton, WindowSide.SOUTH);
        marchButton.onClick(this, "clickedMarch");

        // click first quarter
        firstQuarter = new Button("First Quarter (Jan-March)");
        window.addButton(firstQuarter, WindowSide.SOUTH);
        firstQuarter.onClick(this, "clickedFirstQuarter");

        // click quit
        quit = new Button("Quit");
        window.addButton(quit, WindowSide.NORTH);
        quit.onClick(this, "clickedQuit");

        // setting up upper left hand corner text values
        sortBy = new TextShape(10, 50, "", Color.black);
        window.addShape(sortBy);
        rateType = new TextShape(10, 30, "", Color.black);
        window.addShape(rateType);
        timeFrame = new TextShape(10, 10, "", Color.black);
        window.addShape(timeFrame);

        // setting up bar channelName titles
        barLeftName = new TextShape(20, 225, "", Color.black);
        window.addShape(barLeftName);
        barMidLeftName = new TextShape(50, 225, "", Color.black);
        window.addShape(barMidLeftName);
        barMidRightName = new TextShape(80, 225, "", Color.black);
        window.addShape(barMidRightName);
        barRightName = new TextShape(50, 225, "", Color.black);
        window.addShape(barRightName);
    }


    /**
     * sorts by the channel name and adjusts bars and order respectively
     * 
     * @param button
     *            the sort by channel button
     */
    public void clickedChannel(Button button) {
        // change to appropriate sort in top left corner
        sortBy.setText("Sorting by Channel Name");

        // use list[3] ????
        list.sortByName();
        barLeftName.setText(list.get(0).getInfluencer().getChannelName());

    }


    /**
     * sorts by the engagement rate from greatest to smallest and adjusts bars
     * and order respectively
     * 
     * @param button
     *            the sort by engagement button
     */
    public void clickedEngagementRate(Button button) {
        // change to appropriate sort in top left corner
        sortBy.setText("Sorting by Engagement Rate");
    }


    /**
     * uses the traditional rate calculation for sorting
     * 
     * @param button
     *            the traditional rate button
     */
    public void clickedTraditionalRate(Button button) {
        // change to appropriate rate in top left corner
        rateType.setText("Traditional Engagement Rate");
    }


    /**
     * uses the reach engagement calculation for sorting
     * 
     * @param button
     *            the engagement reach button
     */
    public void clickedReachEngagement(Button button) {
        // change to appropriate rate in top left corner
        rateType.setText("Reach Engagement Rate");
    }


    /**
     * uses the january data for sort
     * 
     * @param button
     *            the jan button
     */
    public void clickedJan(Button button) {
        // change to appropriate time frame in top left corner
        timeFrame.setText("January");
        // set list to month appropriate data passed in from reader

        // we may need to change this
        list = listArr[0];
    }


    /**
     * uses the february data for sort
     * 
     * @param button
     *            the feb button
     */
    public void clickedFeb(Button button) {
        // change to appropriate time frame in top left corner
        timeFrame.setText("February");
        // set list to month appropriate data passed in from reader
        list = listArr[1];
    }


    /**
     * uses the march data for sort
     * 
     * @param button
     *            the march button
     */
    public void clickedMarch(Button button) {
        // change to appropriate time frame in top left corner
        timeFrame.setText("March");
        // set list to month appropriate data passed in from reader
        list = listArr[2];
    }


    /**
     * uses the entire first quarters data for sorting
     * 
     * @param button
     *            the first quarter button
     */
    public void clickedFirstQuarter(Button button) {
        // change to appropriate time frame in top left corner
        timeFrame.setText("First Quarter (Jan-March)");
        // set list to month appropriate data passed in from reader
        list = listArr[3];
    }


    /**
     * exit the window if quit is clicked
     * 
     * @param button
     *            the button clicked
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * updates the bars and their heights to accurately depict sort
     */
    public void updateBars() {

    }
}
