package f.pliki;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WritingToFileSample {
    public static void main(String[] args)
            throws IOException {
        String str = "Hello";
        String fileName = "sample.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(str);
            writer.newLine();
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}
