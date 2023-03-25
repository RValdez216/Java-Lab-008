import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter file path (or Q to quit): ");
            String filePath = scanner.nextLine();

            if (filePath.equals("Q")) {
                break;
            }
            File file = Paths.get(filePath).toFile();

            System.out.print("Skip whitespace (Y/N)? ");
            String input = scanner.nextLine();
            boolean skipWs = input.equals("Y");
            // Create a scanner object

            // Write a loop that will ask the user to enter a file path to gather stats on,
            // and continue until "Q" is entered.

            // Reference Java-Assignment-003 to see how to use the java.nio libraries to turn a String path into a File

            // Ask the user if they would like to skip whitespace

            // Create a variable called skipWs that stores the user's response as a boolean

            /*
             * Within this try/catch block, which is used to handle possible errors thrown by the code in the try block,
             * write code to get the line, word, and character count of the File object created above!
             */
            try {
                FileStats stats = new FileStats(file, skipWs);
                stats.read();

                String fileName = file.getAbsoluteFile().getName();
                int lines = stats.getNumLines();
                int words = stats.getNumWords();
                int chars = stats.getNumChars();

                System.out.printf("Stats: lines - %d, words - %d, chars - %d %s%n", lines, words, chars, fileName);
                // You will need to create a FileStats object by passing it the File object and your skipWs variable as args

                // You will need to call the fs.read method, which you need to implement!

                /*
                 * You will access the FileStats object's getter methods to get the file's line, word, character count and
                 * the files name. You should use a format specifier to print it all out similar to the following example:
                 *
                 * Stats: lines - 6, words - 46, chars - 237 /path/to/file/fileName.txt
                 */
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }
    }
}
