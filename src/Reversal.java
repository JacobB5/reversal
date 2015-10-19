import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

// author Jacob Bechtel 00890504

public class Reversal {
    
    public static void reverseFile(File input, File output)
            throws FileNotFoundException {
        // Throw exception if either file is missing
        if ((!input.exists()) || (!output.exists())) {
            throw new FileNotFoundException();
        }

        ArrayList<String> lines = new ArrayList<String>();
        String temp = "";
        String feed = "";

        // Read in data
        Scanner inp = new Scanner(input);
        while (inp.hasNext()) {
            temp = inp.nextLine();
            String[] tokens = temp.split("\\s+");
            // Create a string which has the words in reverse order
            for (int i = tokens.length - 1; i > -1; i--) {
                feed = feed + tokens[i] + " ";
            }
            feed = feed.trim();
            lines.add(feed);
            feed = "";
            temp = "";
        }

        // Write stored strings to output
        PrintWriter out = new PrintWriter(output);
        for (int i = (lines.size() - 1); i > -1; i--) {
            out.println(lines.get(i));
        }

        // Done, so close the input and output
        out.close();
        inp.close();
    }

}
