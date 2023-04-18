package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    private SLList[] list;

    /**
     * the FileReader Constructor
     * 
     * @param influencerFileName
     *            the file name
     * @throws FileNotFoundException
     */
    public FileReader(String influencerFileName) throws FileNotFoundException {

        list = readInputFile(influencerFileName);
    }

    /**
     * Default getter for the list field
     * @return Returns the list field
     */
    public SLList[] getList() {
        return list;
    }

    /**
     * reading in data from the input file and storing it in Influencer
     * 
     * @param influencerFile
     *            the file name
     * @return SLList contains a list of our data
     * @throws FileNotFoundException
     */
    public SLList[] readInputFile(String influencerFile)
        throws FileNotFoundException {

        SLList sllJan = new SLList();
        SLList sllFeb = new SLList();
        SLList sllMarch = new SLList();
        SLList sllAll = new SLList();

        Scanner file = new Scanner(new File(influencerFile));
        while (file.hasNextLine()) {

            String read = file.nextLine();
            Scanner line = new Scanner(read).useDelimiter(",\\s*");
            String[] tokens = new String[10];
            int tokenCount = 0;

            while (line.hasNext() && tokenCount < 10) {
                tokens[tokenCount++] = line.next();
            }
            line.close();

            if (tokenCount == 10) {
                int[] arr = new int[5];

                for (int i = 0; i < 5; i++) {
                    arr[i] = Integer.valueOf(tokens[i + 5]);
                }

                Influencer in = new Influencer(tokens[1], tokens[2], tokens[3],
                    tokens[4], arr[0], arr[1], arr[2], arr[3], arr[4]);

                for (int i = 0; i < 5; i++) {
                    arr[i] = Integer.valueOf(tokens[i + 5]);
                }

                Influencer influ = new Influencer(tokens[1], tokens[2],
                    tokens[3], tokens[4], arr[0], arr[1], arr[2], arr[3],
                    arr[4]);
                Data data = new Data(tokens[0], influ);
                sllAll.add(data);

                if (tokens[0].equals("January")) {
                    sllJan.add(data);
                }
                if (tokens[0].equals("Feburary")) {
                    sllFeb.add(data);
                }
                if (tokens[0].equals("March")) {
                    sllMarch.add(data);
                }
            }
        }
        SLList[] sl = { sllJan, sllFeb, sllMarch, sllAll };
        return sl;
    }
}
