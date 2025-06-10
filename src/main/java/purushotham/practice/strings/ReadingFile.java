package purushotham.practice.strings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFile {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(System.getProperty("user.dir") + "/src/main/java/purushotham/practice/file.txt");
        BufferedReader br = new BufferedReader(fr);
        br.lines().forEach(System.out::println);
        br.close();

        br.readLine();
    }
}
