package prj5;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import student.TestableRandom;

public class SocialMediaWindow {

    private Window window;
    private String month;
    private SLList[] listArr;
    private String rate;
    private SLList currData;
    private SLList calculatedData;

    private static final int LEFTALIGN = 20;
    private static final int LEFTMIDALIGN = 100;
    private static final int RIGHTMIDALIGN = 180;
    private static final int RIGHTALIGN = 260;

    private Button channelName;
    private Button engagementRate;
    private Button traditionalEngagement;
    private Button reachEngagement;
    private Button janButton;
    private Button febButton;
    private Button marchButton;
    private Button firstQuarter;
    private Button quit;

    private TextShape timeFrame;
    private TextShape rateType;
    private TextShape sortBy;

    private Shape[] bars;
    private TextShape[] channelNames;
    private TextShape[] rateNums;

    private DecimalFormat df;

    private Influencer curr;
    private int index;
    private Color color;

    public SocialMediaWindow(SLList[] monthArr) {

        listArr = monthArr;
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

        bars = new Shape[4];
        channelNames = new TextShape[4];
        rateNums = new TextShape[4];

        // bars[0] = new Shape
        channelNames[0] = new TextShape(LEFTALIGN, 250, "", Color.black);
        channelNames[1] = new TextShape(LEFTMIDALIGN, 250, "", Color.black);
        channelNames[2] = new TextShape(RIGHTMIDALIGN, 250, "", Color.black);
        channelNames[3] = new TextShape(RIGHTALIGN, 250, "", Color.black);

        rateNums[0] = new TextShape(LEFTALIGN, 270, "", Color.black);
        rateNums[1] = new TextShape(LEFTMIDALIGN, 270, "", Color.black);
        rateNums[2] = new TextShape(RIGHTMIDALIGN, 270, "", Color.black);
        rateNums[3] = new TextShape(RIGHTALIGN, 270, "", Color.black);

        rate = "T";
        clickedJan(janButton);
        clickedChannel(channelName);
        clickedTraditionalRate(traditionalEngagement);

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
        currData.sortByName();
        display();

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

        // sort by appropriate rate type
        if (rate.equals("T")) {
            currData.sortByTEngagement();
        }
        else if (rate.equals("R")) {
            currData.sortByREngagement();
        }
        else {
            return;
        }
        display();

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

        Iterator<Data> pointer = currData.iterator();
        while (pointer.hasNext()) {
            Influencer currInflu = pointer.next().getInfluencer();
            double rate = currInflu.getTraditionalEngagement();
            currInflu.setTraditionalRate(rate);
        }
        display();

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

        Iterator<Data> pointer = currData.iterator();
        while (pointer.hasNext()) {
            Influencer currInflu = pointer.next().getInfluencer();
            double rate = currInflu.getEngagementReach();
            currInflu.setEngagementRate(rate);
        }
        display();
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
        currData = listArr[0];
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
        currData = listArr[1];
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
        currData = listArr[2];
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
        currData = listArr[3];
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
     * update the display
     */
    private void display() {

        // bars[0].remove();
        // display information to gui
        Iterator<Data> pointer = currData.iterator();
        index = 0;

        if (currData.size() > 4) {
            ArrayList<String> channels = new ArrayList<String>();
            for (int x = 0; x < currData.size(); x++) {
                // if the arraylist does not have channelname, add it
                if (!channels.contains(currData.get(x).getInfluencer()
                    .getChannelName())) {
                    channels.add(currData.get(x).getInfluencer()
                        .getChannelName());
                }
            }

            if (rate.equals("T")) {
                // make new list to store
                SLList calculatedTrad = new SLList();

                // loop through arraylist
                for (int x = 0; x < channels.size(); x++) {
                    // System.out.println(channels.get(x) + ": ");
                    int likes = 0;
                    int comments = 0;
                    int views = 0;
                    int follow = 0;

                    // if the array list contains channelname and the month
                    // equals
                    // Jan-March add comments and likes to total comments
                    // and likes
                    for (int y = 0; y < currData.size(); y++) {
                        if ((currData.get(y).getInfluencer().getChannelName()
                            .equals(channels.get(x))) && (currData.get(y)
                                .getMonth().equals("January") || currData.get(y)
                                    .getMonth().equals("February") || currData
                                        .get(y).getMonth().equals("March"))) {
                            comments += currData.get(y).getInfluencer()
                                .getComments();
                            likes += currData.get(y).getInfluencer().getLikes();
                            views += currData.get(y).getInfluencer().getViews();
                        }
                        // add the followers for just march for traditional
                        // calculation
                        if ((currData.get(y).getInfluencer().getChannelName()
                            .equals(channels.get(x))) && (currData.get(y)
                                .getMonth().equals("March"))) {
                            follow = currData.get(y).getInfluencer()
                                .getFollowers();
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
                    // make new influencer to store data traditional data
                    // and calculate
                    // the total traditional data
                    Influencer currInf = new Influencer("", channels.get(x), "",
                        "", 0, 0, 0, 0, 0);
                    currInf.setTraditionalRate(trad);
                    Data data = new Data("", currInf);

                    if (calculatedData == null) {
                        calculatedTrad.add(data);
                    }
                    else {
                        calculatedData.get(x).getInfluencer()
                            .setTraditionalRate(trad);
                    }

                    double reach;
                    // account for zeros
                    if (views == 0) {
                        reach = 0.0;
                    }
                    // else calculate the reach
                    else {
                        reach = ((likes + comments) / (double)views) * 100.0;
                    }

                    if (calculatedData == null) {
                        calculatedTrad.get(x).getInfluencer().setEngagementRate(
                            reach);
                    }
                    else {
                        calculatedData.get(x).getInfluencer().setEngagementRate(
                            reach);
                    }
                }

                if (calculatedData == null) {
                    calculatedData = calculatedTrad;
                }

                // calculatedData.sortByName();

                for (int x = 0; x < calculatedData.size(); x++) {
                    if (bars[x] != null) {
                        window.removeShape(bars[x]);
                    }

                    // get random color for bars
                    TestableRandom generator = new TestableRandom();
                    color = new Color(generator.nextInt(255), generator.nextInt(
                        255), generator.nextInt(255));

                    curr = pointer.next().getInfluencer();

                    // update to appropriate name
                    // channelNames[x].setText(curr.getChannelName());
                    channelNames[x].setText(channels.get(x));
                    window.addShape(channelNames[x]);

                    bars[x] = new Shape(rateNums[x].getX(), 250
                        - (int)calculatedData.get(x).getInfluencer()
                            .getTraditionalEngagement(), 30, (int)calculatedData
                                .get(x).getInfluencer()
                                .getTraditionalEngagement(), color);
                    window.addShape(bars[x]);

                    if (calculatedData.get(x).getInfluencer()
                        .getTraditionalEngagement() == 0.0) {
                        rateNums[x].setText("N/A");
                        window.addShape(rateNums[x]);
                    }
                    else {
                        // update the rates
                        rateNums[x].setText(String.valueOf(df.format(
                            calculatedData.get(x).getInfluencer()
                                .getTraditionalEngagement())));
                        window.addShape(rateNums[x]);
                    }
                }
                currData = calculatedData;
            }
            else {
                SLList calculatedEng = new SLList();
                for (int x = 0; x < channels.size(); x++) {
                    // System.out.println(channels.get(x) + ": ");
                    int likes = 0;
                    int comments = 0;
                    int views = 0;
                    int follow = 0;

                    // get the channel names and their corresponding data for
                    // views,
                    // comments, and likes
                    for (int y = 0; y < currData.size(); y++) {
                        if ((currData.get(y).getInfluencer().getChannelName()
                            .equals(channels.get(x))) && (currData.get(y)
                                .getMonth().equals("January") || currData.get(y)
                                    .getMonth().equals("February") || currData
                                        .get(y).getMonth().equals("March"))) {
                            views += currData.get(y).getInfluencer().getViews();
                            // System.out.println("Views:" +
                            // list[3].get(y).getInfluencer().getViews());
                            // System.out.println("Total Views: " + views);
                            comments += currData.get(y).getInfluencer()
                                .getComments();
                            likes += currData.get(y).getInfluencer().getLikes();
                        }

                        if ((currData.get(y).getInfluencer().getChannelName()
                            .equals(channels.get(x))) && (currData.get(y)
                                .getMonth().equals("March"))) {
                            follow = currData.get(y).getInfluencer()
                                .getFollowers();
                        }
                    }
                    double reach;
                    // account for zeros
                    if (views == 0) {
                        reach = 0.0;
                    }
                    // else calculate the reach
                    else {
                        reach = ((likes + comments) / (double)views) * 100.0;
                    }
                    // make influencer to store total reach data for each month
                    Influencer currInf = new Influencer("", channels.get(x), "",
                        "", 0, 0, 0, 0, 0);
                    currInf.setEngagementRate(reach);
                    Data data = new Data("", currInf);
                    if (calculatedData == null) {
                        calculatedEng.add(data);
                    }
                    else {
                        calculatedData.get(x).getInfluencer().setEngagementRate(
                            reach);
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
                    // make new influencer to store data traditional data
                    // and calculate
                    // the total traditional data
                    currInf.setTraditionalRate(trad);

                    if (calculatedData == null) {
                        calculatedEng.get(x).getInfluencer().setTraditionalRate(
                            trad);
                    }
                    else {
                        calculatedData.get(x).getInfluencer()
                            .setTraditionalRate(trad);
                    }
                }

                if (calculatedData == null) {
                    calculatedData = calculatedEng;
                }

                // sort list by engagement
                calculatedData.sortByName();

                for (int x = 0; x < calculatedData.size(); x++) {

                    if (bars[x] != null) {
                        window.removeShape(bars[x]);
                    }

                    // get random color for bars
                    TestableRandom generator = new TestableRandom();
                    color = new Color(generator.nextInt(255), generator.nextInt(
                        255), generator.nextInt(255));

                    curr = pointer.next().getInfluencer();

                    // update to appropriate name
                    // channelNames[x].setText(curr.getChannelName());
                    channelNames[x].setText(channels.get(x));
                    window.addShape(channelNames[x]);

                    bars[x] = new Shape(rateNums[x].getX(), 250
                        - (int)calculatedData.get(x).getInfluencer()
                            .getEngagementReach(), 30, (int)calculatedData.get(
                                x).getInfluencer().getEngagementReach(), color);
                    window.addShape(bars[x]);

                    if (calculatedData.get(x).getInfluencer()
                        .getEngagementReach() == 0.0) {
                        rateNums[x].setText("N/A");
                        window.addShape(rateNums[x]);
                    }
                    else {
                        // update the rates
                        rateNums[x].setText(String.valueOf(df.format(
                            calculatedData.get(x).getInfluencer()
                                .getEngagementReach())));
                        window.addShape(rateNums[x]);
                    }
                }
                currData = calculatedData;
            }
        }
        else {
            while (pointer.hasNext()) {
                if (bars[index] != null) {
                    window.removeShape(bars[index]);
                }

                // get random color for bars
                TestableRandom generator = new TestableRandom();
                color = new Color(generator.nextInt(255), generator.nextInt(
                    255), generator.nextInt(255));

                curr = pointer.next().getInfluencer();

                // update to appropriate name
                channelNames[index].setText(curr.getChannelName());
                window.addShape(channelNames[index]);

                // how to do the bars without a set height?
                if (rate.equals("T")) {
                    // update bars
                    bars[index] = new Shape(rateNums[index].getX(), 250
                        - (int)curr.getTraditionalEngagement(), 30, (int)curr
                            .getTraditionalEngagement(), color);
                    window.addShape(bars[index]);

                    if (curr.getTraditionalEngagement() == 0.0) {
                        rateNums[index].setText("N/A");
                        window.addShape(rateNums[index]);
                    }
                    else {
                        // update the rates
                        rateNums[index].setText(String.valueOf(df.format(curr
                            .getTraditionalEngagement())));
                        window.addShape(rateNums[index]);
                    }

                }
                else {
                    // update bars
                    bars[index] = new Shape(rateNums[index].getX(), 250
                        - (int)curr.getEngagementReach(), 30, (int)curr
                            .getEngagementReach(), color);
                    window.addShape(bars[index]);

                    if (curr.getEngagementReach() == 0.0) {
                        rateNums[index].setText("N/A");
                        window.addShape(rateNums[index]);
                    }
                    else {
                        // update the rates
                        rateNums[index].setText(String.valueOf(df.format(curr
                            .getEngagementReach())));
                        window.addShape(rateNums[index]);
                    }
                }
                index++;
            }
        }
    }


    public void displayBars(Shape[] shape) {

    }
}
