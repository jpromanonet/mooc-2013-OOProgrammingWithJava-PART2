package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MindfulDictionary {
	private Map<String, String> dictionary;
	private File fileDictionary;
	
	
	public MindfulDictionary() {
		dictionary = new HashMap<String, String>();
	}
	
	public MindfulDictionary(String file) {
		this();
		fileDictionary = new File(file);
	}
	
	public void add(String word, String translation) {
		if (!dictionary.containsKey(word)) {
			dictionary.put(word, translation);
		}
	}
	
	public String translate(String word) {
		if (dictionary.containsKey(word)) {
			return dictionary.get(word);
		}
		
		if (dictionary.containsValue(word)) {
			for (String key :
					dictionary.keySet()) {
				if (dictionary.get(key).equals(word)) {
					return key;
				}
			}
			
		}
		return null;
	}
	
	public void remove(String word) {
		String keyToBeRemoved = "";
		dictionary.remove(word);
		
		if (dictionary.containsValue(word)) {
			for (String key :
					dictionary.keySet()) {
				if (dictionary.get(key).equals(word)) {
					keyToBeRemoved = key;
				}
			}
			dictionary.remove(keyToBeRemoved);
		}
	}
	
	public boolean load() {
		if (fileDictionary.canRead()) {
			try {
				readFromFileDictionary();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			return true;
		}
		
		return false;
	}
	
	private void readFromFileDictionary() throws FileNotFoundException {
		Scanner reader = new Scanner(fileDictionary);
		
		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			String word = line.split(":")[0];
			String translation = line.split(":")[1];
			
			dictionary.put(word, translation);
		}
		
		reader.close();
	}
	
	public boolean save() {
		try {
			writeToFileDictionary();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	private void writeToFileDictionary() throws IOException {
		FileWriter fileWriter = new FileWriter(fileDictionary);
		
		for (String key :
				dictionary.keySet()) {
			String value = dictionary.get(key);
			String writtenValue = key + ":" + value;
			
			fileWriter.write(writtenValue + "\n");
		}
		
		fileWriter.close();
	}
}
