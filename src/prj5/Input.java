package prj5;

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
     */
    public void main(String[] args) {
        if (args.length > 1) {
            FileReader fr = new FileReader(args[0]);
        }
        else {
            FileReader fr = new FileReader("SampleInput1_2022.csv");
        }
    }

}
