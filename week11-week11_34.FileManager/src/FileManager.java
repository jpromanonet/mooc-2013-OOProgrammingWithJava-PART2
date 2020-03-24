
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        
        Scanner reader = new Scanner(new File(file));
        List<String> lineList = new ArrayList<String>();
        
        while(reader.hasNextLine()) {
            lineList.add(reader.nextLine());
        }
        return lineList;
    }

    public void save(String file, String text) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(text);
        fileWriter.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
    
        for (String line :
                texts) {
            fileWriter.write(line + "\n");
        }
        
        fileWriter.close();
    }
}
