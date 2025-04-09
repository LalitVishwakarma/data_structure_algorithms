package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Integer.*;

/**
 * Created by dphillips on 8/6/16.
 */
public class SimpleParallelStreamWordCountList {
    public static void main(String[] args) throws Exception {
        System.out.println("\n\nParallel word count example using Old Testement King James bible");
        textWordCount("resources/input/sample_large_file.txt");
        wordCount("resources/input/sample_large_file.txt");
    }

    public static void wordCount(String fileName) throws FileNotFoundException {
        long start = Instant.now().toEpochMilli();
        System.out.println("\tReading file: " + fileName);
        Path filePath = Paths.get(fileName);
        Scanner scanner = new Scanner(new File(fileName));
        HashMap<String, LongAdder> map = new HashMap<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (map.containsKey(words[i])) {
                    map.get(words[i]).increment();
                } else {
                    map.put(words[i], new LongAdder());
                }
            }
        }

        map
                .keySet()
                .stream()
                .map(key -> String.format("%-10d %s", map.get(key).intValue(), key))
                .sorted((prev, next) -> compare(parseInt(next.split("\\s+")[0]), parseInt(prev.split("\\s+")[0])))
//                .limit(5)
                .forEach(t -> System.out.println("\t" + t));
        long end = Instant.now().toEpochMilli();
        System.out.println(String.format("\tCompleted 2 in %d milliseconds", (end - start)));
    }

    /**
     * Return the top 5 most frequently used words from the sample text.
     *
     * @throws Exception
     */
    private static void textWordCount(String fileName) throws Exception {
        long start = Instant.now().toEpochMilli();
        ConcurrentHashMap<String, LongAdder> wordCounts = new ConcurrentHashMap<>();
        System.out.println("\tReading file: " + fileName);
        Path filePath = Paths.get(fileName);
        Files.readAllLines(filePath)
                .parallelStream()                               // Start streaming the lines
                .map(line -> line.split("\\s+"))                // Split line into individual words
                .flatMap(Arrays::stream)                        // Convert stream of String[] to stream of String
                .parallel()                                     // Convert to parallel stream
                .filter(w -> w.matches("\\w+"))                 // Filter out non-word items
                .map(String::toLowerCase)                       // Convert to lower case
                .forEach(word -> {                              // Use an AtomicAdder to tally word counts
                    if (!wordCounts.containsKey(word))          // If a hashmap entry for the word doesn't exist yet
                        wordCounts.put(word, new LongAdder());  // Create a new LongAdder
                    wordCounts.get(word).increment();           // Increment the LongAdder for each instance of a word
                });
        wordCounts
                .keySet()
                .stream()
                .map(key -> String.format("%-10d %s", wordCounts.get(key).intValue(), key))
                .sorted((prev, next) -> compare(parseInt(next.split("\\s+")[0]), parseInt(prev.split("\\s+")[0])))
//                .limit(5)
                .forEach(t -> System.out.println("\t" + t));
        long end = Instant.now().toEpochMilli();
        System.out.println(String.format("\tCompleted in %d milliseconds", (end - start)));
    }


    public static void ac(String fileName) throws IOException {
        ConcurrentHashMap<String, LongAdder> wordsMap = new ConcurrentHashMap<>();
        Files.readAllLines(Paths.get(fileName))
                .parallelStream()
                .map(line -> line.split("\\s+"))
                .flatMap(Arrays::stream)
                .forEach(word -> {
                    if(wordsMap.containsKey(word))
                        wordsMap.get(word).increment();
                    else
                        wordsMap.put(word, new LongAdder());
                });
    }
}