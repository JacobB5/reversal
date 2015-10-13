import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Reversal {

    public static void reverseFile(File input, File output)
            throws FileNotFoundException {
        //Throw exception if either file is missing
        if ( (!input.exists()) || (!output.exists()) ){
            throw new FileNotFoundException();
        }
        
        ArrayList<String> lines = new ArrayList<String>();
        String temp = "";
        String feed = "";
        
        //Read in data
        try {
            
            Scanner inp = new Scanner(input);
            while (inp.hasNext()) {
                

            }

            // Write stored strings to output
            PrintWriter out = new PrintWriter(output);
            for (int i = (lines.size() - 1); i > -1; i--) {
                out.println(lines.get(i));
            }
            // Done so close the output
            out.close();
            // Done so close the input
            inp.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
        }

    }   

}
