package prj5;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Arrays;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// - Ayesha Kabduwal (ayeshak22)

/**
 * 
 * @author Ayesha Kabduwal (ayeshak22)
 * @version 2023.04.18
 *
 */
public class Input {

    /**
     * input class constructor intentionally left empty
     */
    public Input() {
        // intentionally left empty
    }


    /**
     * main method executing our program
     * 
     * @param args
     *            the String of arguements passed in
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        SLList[] list = null;
        FileReader fr = null;
        if (args.length > 0) {
            fr = new FileReader(args[0]);
            list = fr.getList();
        }
        else {
            fr = new FileReader("SampleInput1_2022.csv");
            list = fr.getList();
        }

        DecimalFormat df = new DecimalFormat("#.#");
        // printing out traditional engagement rate in the
        // first quarter for each one
        list[0].sortByName();
        list[1].sortByName();
        list[2].sortByName();

        for (int x = 0; x < list[2].size(); x++) {
            System.out.println(list[2].get(x).getInfluencer().getChannelName());
            int janLikes = list[0].get(x).getInfluencer().getLikes();  
            int febLikes = list[1].get(x).getInfluencer().getLikes();
            int marLikes = list[2].get(x).getInfluencer().getLikes();
            int likes = janLikes + febLikes + marLikes;

            int janCom = list[0].get(x).getInfluencer().getComments();
            int febCom = list[1].get(x).getInfluencer().getComments();
            int marCom = list[2].get(x).getInfluencer().getComments();
            int comments = janCom + febCom + marCom;

            int follow = list[2].get(x).getInfluencer().getFollowers();
            double traditional;
            
            if (follow == 0) {
                traditional = 0;
            } 
            else {
                traditional = ((likes + comments) / (double)follow) * 100;
            }
            
            System.out.print("traditional: ");
            if (traditional == 0) {
                System.out.println("N/A");
            }
            else {
                System.out.println(df.format(traditional));
            }
            System.out.print("\n");

            // System.out.println("==========\n"+ "");

        }

        //System.out.println(list[1].get(0).getInfluencer().getChannelName());
        // System.out.println("traditional: ",
        // list[2].get(0).getInfluencer().getTraditionalEngagement());
        //System.out.println(list[1].get(1).getInfluencer().getChannelName());
        //System.out.println(list[1].get(2).getInfluencer().getChannelName());
        //System.out.println(list[1].get(3).getInfluencer().getChannelName());

        // Second, your code must output the influencer summaries
        // for the first quarter, sorted in descending order
        // by reach engagement rate.
        //list[0].sortByREngagement();
        //list[1].sortByREngagement();
        //list[2].sortByREngagement();

        
        System.out.print("\n");
        System.out.print("\n");

        Rates[] engagementRates = new Rates[list[2].size()];
        for (int x = 0; x < list[2].size(); x++) {
            int janLikes = list[0].get(x).getInfluencer().getLikes();
            int febLikes = list[1].get(x).getInfluencer().getLikes();
            int marLikes = list[2].get(x).getInfluencer().getLikes();
            int likes = janLikes + febLikes + marLikes;
            
            int janCom = list[0].get(x).getInfluencer().getComments();
            int febCom = list[1].get(x).getInfluencer().getComments();
            int marCom = list[2].get(x).getInfluencer().getComments();
            int comments = janCom + febCom + marCom;
            
            int janView = list[0].get(x).getInfluencer().getViews();
            int febView = list[1].get(x).getInfluencer().getViews();
            int marView = list[2].get(x).getInfluencer().getViews();
            
            int views = janView + febView + marView;
            double reach;
            
            if (views == 0) {
                reach = 0;
            } 
            else {
                reach = ((likes + comments) / (double)views) * 100;
            }
            
            engagementRates[x] = new Rates(list[2].get(x).getInfluencer()
                .getChannelName(), reach);
            
            /*
            System.out.print("reach: ");
            if (reach == 0) {
                System.out.println("N/A");
            } 
            else {
                System.out.println(df.format(reach));
            }
            //System.out.println("==========\n" + "");
            System.out.print("\n");
            */
        }
        
        Arrays.sort(engagementRates);
        for (int i = engagementRates.length - 1; i >= 0; i--) {
            System.out.println(engagementRates[i].getName());
            System.out.print("reach: ");
            if (engagementRates[i].getRate() == 0) {
                System.out.println("N/A");
            } 
            else {
                System.out.println(df.format(engagementRates[i].getRate()));
            }
            //System.out.println("==========\n" + "");
            System.out.print("\n");
        }

    }
}
