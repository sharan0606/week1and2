import java.util.*;

public class week1and2 {

    static HashMap<String, Set<String>> ngramIndex = new HashMap<>();

    public static List<String> generateNGrams(String text, int n) {
        String[] words = text.split("\\s+");
        List<String> ngrams = new ArrayList<>();

        for (int i = 0; i <= words.length - n; i++) {
            StringBuilder gram = new StringBuilder();
            for (int j = 0; j < n; j++) {
                gram.append(words[i + j]).append(" ");
            }
            ngrams.add(gram.toString().trim());
        }

        return ngrams;
    }

    public static void addDocument(String docId, String text) {
        List<String> grams = generateNGrams(text, 3);

        for (String gram : grams) {
            ngramIndex.putIfAbsent(gram, new HashSet<>());
            ngramIndex.get(gram).add(docId);
        }
    }

    public static void checkPlagiarism(String docId, String text) {

        List<String> grams = generateNGrams(text, 3);
        HashMap<String, Integer> matchCount = new HashMap<>();

        for (String gram : grams) {
            if (ngramIndex.containsKey(gram)) {
                for (String doc : ngramIndex.get(gram)) {
                    matchCount.put(doc, matchCount.getOrDefault(doc, 0) + 1);
                }
            }
        }

        System.out.println("Matches Found:");

        for (String doc : matchCount.keySet()) {
            double similarity = (matchCount.get(doc) * 100.0) / grams.size();
            System.out.println(doc + " → Similarity: " + similarity + "%");
        }
    }

    public static void main(String[] args) {

        String doc1 = "data structures and algorithms are important";
        String doc2 = "algorithms and data structures help solve problems";

        addDocument("doc1", doc1);

        checkPlagiarism("doc2", doc2);
    }
}