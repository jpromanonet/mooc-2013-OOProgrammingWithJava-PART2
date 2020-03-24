
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileManager t = new FileManager();
        
        for (String line : t.read("src/testinput1.txt")) {
            System.out.println(line);
        }
    }
}
