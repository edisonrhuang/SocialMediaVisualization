package prj5;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

public class SocialMediaWindow {

    private Window window;
    private String month;
    private SLList[] list;
    private String rate;

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

    private TextShape barNameLine;
    private TextShape barNumLine;

    private TextShape barLeftNum;
    private TextShape barMidLeftNum;
    private TextShape barMidRightNum;
    private TextShape barRightNum;

    private DecimalFormat df;

    public SocialMediaWindow(SLList[] monthArr) {

        list = monthArr;
        window = new Window("Social Media Vis");
        df = new DecimalFormat("#.#");

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

        barLeft = new Shape(20, window.getGraphPanelHeight() - 120, 20, 100,
            Color.black);
        window.addShape(barLeft);
        barLeft.
        

        // setting up bar channelName titles
// barLeftName = new TextShape(20, 225, "", Color.black);
// window.addShape(barLeftName);
// barMidLeftName = new TextShape(100, 225, "", Color.black);
// window.addShape(barMidLeftName);
// barMidRightName = new TextShape(200, 225, "", Color.black);
// window.addShape(barMidRightName);
// barRightName = new TextShape(300, 225, "", Color.black);
// window.addShape(barRightName);

        barNameLine = new TextShape(20, 225, "", Color.black);
        window.addShape(barNameLine);

        barNumLine = new TextShape(50, 225, "", Color.black);
        window.addShape(barNumLine);

        // setting up bar numbers for rates
// barLeftNum = new TextShape(20, 250, "", Color.black);
// window.addShape(barLeftNum);
// barMidLeftNum = new TextShape(50, 250, "", Color.black);
// window.addShape(barMidLeftNum);
// barMidRightNum = new TextShape(80, 250, "", Color.black);
// window.addShape(barMidRightNum);
// barRightNum = new TextShape(50, 250, "", Color.black);
// window.addShape(barRightNum);
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
        // list.sortByName();

        ArrayList<String> channels = new ArrayList<String>();
        for (int x = 0; x < list[3].size(); x++) {
            // if the arraylist does not have channelname, add it
            if (!channels.contains(list[3].get(x).getInfluencer()
                .getChannelName())) {
                channels.add(list[3].get(x).getInfluencer().getChannelName());
            }
        }

        // make new list to store
        SLList calculatedTrad = new SLList();

        // loop through arraylist
        for (int x = 0; x < channels.size(); x++) {
            // System.out.println(channels.get(x) + ": ");
            int likes = 0;
            int comments = 0;
            int follow = 0;

            // if the array list contains channelname and the month equals
            // Jan-March add comments and likes to total comments and likes
            for (int y = 0; y < list[3].size(); y++) {
                if ((list[3].get(y).getInfluencer().getChannelName().equals(
                    channels.get(x))) && (list[3].get(y).getMonth().equals(
                        "January") || list[3].get(y).getMonth().equals(
                            "February") || list[3].get(y).getMonth().equals(
                                "March"))) {
                    comments += list[3].get(y).getInfluencer().getComments();
                    likes += list[3].get(y).getInfluencer().getLikes();
                }
                // add the followers for just march for traditional calculation
                if ((list[3].get(y).getInfluencer().getChannelName().equals(
                    channels.get(x))) && (list[3].get(y).getMonth().equals(
                        "March"))) {
                    follow = list[3].get(y).getInfluencer().getFollowers();
                }
            }
            double trad;
            // account for zeros
            if (follow == 0) {
                trad = 0.0;
            }
            // else calculate the traditional rate
            else {
                trad = ((likes + comments) / (double)follow) * 100.0;
            }
            // make new influencer to store data traditional data and calculate
            // the total traditional data
            Influencer curr = new Influencer("", channels.get(x), "", "", 0, 0,
                0, 0, 0);
            curr.setTraditionalRate(trad);
            Data currData = new Data("", curr);
            calculatedTrad.add(currData);
        }

        // sort by name
        calculatedTrad.sortByName();

// barLeftName.setText(calculatedTrad.get(0).getInfluencer()
// .getChannelName());
// barMidLeftName.setText(calculatedTrad.get(1).getInfluencer()
// .getChannelName());
// barMidRightName.setText(calculatedTrad.get(2).getInfluencer()
// .getChannelName());
// barRightName.setText(calculatedTrad.get(3).getInfluencer()
// .getChannelName());

        barNameLine.setText(calculatedTrad.get(0).getInfluencer()
            .getChannelName() + "  " + calculatedTrad.get(1).getInfluencer()
                .getChannelName() + "  " + calculatedTrad.get(2).getInfluencer()
                    .getChannelName() + "  " + calculatedTrad.get(3)
                        .getInfluencer().getChannelName());

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
        rate = "T";
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
        rate = "R";
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
        // list = listArr[0];
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
        // list = listArr[1];
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
        // list = listArr[2];
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
        // list = listArr[3];
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
