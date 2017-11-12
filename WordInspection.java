
package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {
    
    private File file;
    private Scanner reader;

    public WordInspection(File file) {
        this.file = file;   
    }
    
    public int wordCount() throws Exception {
        reader = new Scanner(this.file, "UTF-8");
        int wordCount = 0;
        
        while(reader.hasNextLine()) {
            wordCount++;
            reader.nextLine();
        }
        
        return wordCount;
    }
    
    public List<String> wordsContainingZ() throws Exception {
        reader = new Scanner(this.file, "UTF-8");
        List<String> wordsWithZ = new ArrayList<String>();
        
        
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            if(line.contains("z")) {
                wordsWithZ.add(line);
            }
        }
        
        return wordsWithZ;
        
    }
    
    public List<String> wordsEndingInL() throws Exception{
        reader = new Scanner(this.file, "UTF-8");
        List<String> wordsEndInL = new ArrayList<String>();
        
        while(reader.hasNextLine()) {
            String line = reader.nextLine();
            if(line.endsWith("l")) {
                wordsEndInL.add(line);
            }
        }
        
        return wordsEndInL;
    }
    
    public List<String> palindromes() throws Exception{
        reader = new Scanner(this.file, "UTF-8");
        List<String> palindromes = new ArrayList<String>();
        
        while(reader.hasNextLine()) {
            String line = reader.nextLine();
            if(line.equals(wordReversed(line))) {
                palindromes.add(line);
            }
        }
        
        return palindromes;
    }
    
    public String wordReversed(String word) {
        String newWord = "";
        
        for(int i = word.length() - 1; i >= 0; i--) {
            newWord += word.charAt(i);
        }
        
        return newWord;
    }
    
    public List<String> wordsWhichContainAllVowels() throws Exception{
        reader = new Scanner(this.file, "UTF-8");
        List<String> allVowelWords = new ArrayList<String>();
        List<String> allVowels = new ArrayList<String>();
        allVowels.add("a");
        allVowels.add("e");
        allVowels.add("i");
        allVowels.add("o");
        allVowels.add("u");
        allVowels.add("y");
        allVowels.add("ä");
        allVowels.add("ö");
        
        while(reader.hasNextLine()) {
            boolean containsVowels = true;
            String line = reader.nextLine();
            for(String vowel : allVowels) {
                if(!line.contains(vowel)) {
                    containsVowels = false;
                    break;
                }
            }
            if(containsVowels) {
                allVowelWords.add(line);
            }
        }
        
        return allVowelWords;
    }
}
