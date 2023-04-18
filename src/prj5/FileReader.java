package prj5;

import java.io.File;
import java.util.Scanner;

public class FileReader {

    private SLList list;

    public FileReader(String influencerFileName) {

        list = readInputFile(influencerFileName);

        Data data = new Data();
    }


    public SLList readInputFile(String influencerFile) {

        SLList sll = new SLList();

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
            
            if (tokenCount == 10)
            {
                int[] arr = new int[5];
                for (int i = 0; i < 5; i++)
                {
                    arr[i] = Integer.valueOf(tokens[i + 5]);
                }
                
                Influencer in = new Influencer(tokens[1], tokens[2], tokens[3], tokens[4], arr[0], arr[1], arr[2], arr[3], arr[4]);
            }
        }
    }

}
