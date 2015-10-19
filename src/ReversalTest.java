import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class ReversalTest {
    public static File inputOne;
    public static File inputTwo;
    public static File inputThree;
    public static File inputFour;
    public static File inputFive;
    public static File outputOne;
    public static File outputTwo;
    public static File outputThree;
    public static File outputFour;
    public static File outputFive;
    public static File fake;
    public static Scanner reader;;

    @ClassRule
    public static TemporaryFolder tempFolder = new TemporaryFolder();

    @BeforeClass
    public static void executeOnce() {
        fake = new File("this_file_does_not_exist.txt");
        // Create the input files and output files
        try {

            // empty file
            inputOne = tempFolder.newFile("inp1.txt");
            PrintWriter writing = new PrintWriter(inputOne);
            writing.println("");
            writing.close();

            // One Line, One word
            inputTwo = tempFolder.newFile("inp2.txt");
            writing = new PrintWriter(inputTwo);
            writing.println("Ted");
            writing.close();

            // One Line, Two Words
            inputThree = tempFolder.newFile("inp3.txt");
            writing = new PrintWriter(inputThree);
            writing.println("Ted roses");
            writing.close();

            // Two lines, two words each
            inputFour = tempFolder.newFile("inp4.txt");
            writing = new PrintWriter(inputFour);
            writing.println("Ted roses");
            writing.println("much work.");
            writing.close();

            // Three lines, one empty row
            inputFive = tempFolder.newFile("inp5.txt");
            writing = new PrintWriter(inputFive);
            writing.println("Ted roses");
            writing.println("");
            writing.println("much work.");
            writing.close();

            outputOne = tempFolder.newFile("out1.txt");
            writing = new PrintWriter(outputOne);
            writing.println("");
            writing.close();

            outputTwo = tempFolder.newFile("out2.txt");
            outputThree = tempFolder.newFile("out3.txt");
            outputFour = tempFolder.newFile("out4.txt");
            outputFive = tempFolder.newFile("out5.txt");
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testReversal1() {
        // Send a non-existent input file
        int actual = 1;
        int expected = 2;
        try {
            Reversal.reverseFile(fake, outputOne);
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            actual = 2;
        }
        assertEquals("Exception not thrown", actual, expected);
    }

    @Test
    public void testReversal2() {
        // Send a non-existent output file
        int actual = 1;
        int expected = 2;
        try {
            Reversal.reverseFile(inputOne, fake);
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            actual = 2;
        }
        assertEquals("Exception not thrown", actual, expected);
    }

    @Test
    public void testReversal3() {
        // Send an empty input file
        try {
            Reversal.reverseFile(inputOne, outputOne);
            reader = new Scanner(outputOne);
            String actual = "";
            if (reader.hasNext()) {
                actual = reader.nextLine();
            }
            String expected = "";
            assertEquals("File was not empty", expected, actual);
            assertFalse("File still has data", reader.hasNext());
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testReversal4() {
        // One line, One word
        try {
            Reversal.reverseFile(inputTwo, outputTwo);
            reader = new Scanner(outputTwo);
            String actual = "";
            if (reader.hasNext()) {
                actual = reader.nextLine();
            }
            String expected = "Ted";
            assertEquals("Expected:" + expected + " Received:" + actual,
                    expected, actual);
            assertFalse("File still has data", reader.hasNext());
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testReversal5() {
        // Send a file one line, two words
        try {
            Reversal.reverseFile(inputThree, outputThree);
            reader = new Scanner(outputThree);
            String actual = "";
            if (reader.hasNext()) {
                actual = reader.nextLine();
            }
            String expected = "roses Ted";
            assertEquals("Expected:" + expected + " Received:" + actual,
                    expected, actual);
            assertFalse("File still has data", reader.hasNext());
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testReversal6() {
        // Send a file two line, two words
        try {
            Reversal.reverseFile(inputFour, outputFour);
            reader = new Scanner(outputFour);
            String actual = "";
            if (reader.hasNext()) {
                actual = reader.nextLine();
            }
            String expected = "work. much";
            assertEquals("Expected:" + expected + " Received:" + actual,
                    expected, actual);
            if (reader.hasNext()) {
                actual = reader.nextLine();
            }
            expected = "roses Ted";
            assertEquals("Expected:" + expected + " Received:" + actual,
                    expected, actual);
            assertFalse("File still has data", reader.hasNext());
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testReversal7() {
        // Three lines, middle line blank
        try {
            Reversal.reverseFile(inputFive, outputFive);
            reader = new Scanner(outputFive);
            String actual = "";
            if (reader.hasNext()) {
                actual = reader.nextLine();
            }
            String expected = "work. much";
            assertEquals("Expected:" + expected + " Received:" + actual,
                    expected, actual);
            if (reader.hasNext()) {
                actual = reader.nextLine();
            }
            expected = "";
            assertEquals("Expected:" + expected + " Received:" + actual,
                    expected, actual);
            if (reader.hasNext()) {
                actual = reader.nextLine();
            }
            expected = "roses Ted";
            assertEquals("Expected:" + expected + " Received:" + actual,
                    expected, actual);
            assertFalse("File still has data", reader.hasNext());
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testConstructor(){
     Reversal noNull=new Reversal();
     assertNotNull("Consttructor was null", noNull);
    }
}
