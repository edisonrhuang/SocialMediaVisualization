package prj5;

import java.io.FileNotFoundException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// - Faith Jones (fejones20)

/**
 * 
 * @author Faith Jones (fejones20)
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
        if (args.length > 1) {
            fr = new FileReader(args[0]);
            list = fr.getList();
        }
        else {
            fr = new FileReader("SampleInput1_2022.csv");
            list = fr.getList();
        }

        list[0].sortByName();
        list[1].sortByName();
        list[2].sortByName();
        
        System.out.println(list[1].get(0).getInfluencer().getChannelName());
        System.out.println(list[1].get(1).getInfluencer().getChannelName());
        System.out.println(list[1].get(2).getInfluencer().getChannelName());
        System.out.println(list[1].get(3).getInfluencer().getChannelName());

    }


    public void totalTEngagement() {

    }

}
