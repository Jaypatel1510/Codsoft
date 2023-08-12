import java.io.*;
import java.util.Arrays;

public class WordCounter {

    public static String getInputText() throws IOException {

        System.out.print("Enter 'text' to input text or 'file' to provide a file: ");


        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        String userChoice = reader.readLine();

        if ("text".equalsIgnoreCase(userChoice)) {
            System.out.print("Enter the text: ");
            return reader.readLine();
        } 
        else if ("file".equalsIgnoreCase(userChoice)) {
            System.out.print("Enter the file path: ");
            String filePath = reader.readLine();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = fileReader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                return sb.toString();
            }
        } 
        else {
            System.out.println("Invalid input. Please try again.");
            return null;
        }
    }

    public static String[] splitTextIntoWords(String text) {
        return text.toLowerCase().split("\\P{Alpha}+");
    }

    // Function to check if the word is common
    public static boolean isCommonWord(String word) {
        String[] commonWords = {"the", "and", "of", "in", "to", "is", "it", "a", "that", "for"};
        return Arrays.asList(commonWords).contains(word);
    }

    // Function to count words and ignore common words
    public static void countWords(String[] words) {
        int totalCount = words.length;
        int uniqueCount = 0;
        String[] uniqueWords = new String[totalCount];
        int[] wordFrequency = new int[totalCount];

        for (String word : words) {
            if (isCommonWord(word)) {
                continue;
            }

            boolean isUnique = true;
            for (int i = 0; i < uniqueCount; i++) {
                if (uniqueWords[i].equals(word)) {
                    wordFrequency[i]++;
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                uniqueWords[uniqueCount] = word;
                wordFrequency[uniqueCount] = 1;
                uniqueCount++;
            }
        }

        System.out.println("Total word count: " + totalCount);
        System.out.println("Number of unique words: " + uniqueCount);

        for (int i = 0; i < uniqueCount; i++) {
            System.out.println("'" + uniqueWords[i] + "' appears " + wordFrequency[i] + " time(s).");
        }
    }

    public static void main(String[] args) throws IOException {
        String text = getInputText();
        if (text == null) {
            return;
        }

        String[] words = splitTextIntoWords(text);
        countWords(words);
    }
}
