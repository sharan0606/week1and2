import java.util.*;

public class week1and2 {

    static HashMap<String, Integer> users = new HashMap<>();
    static HashMap<String, Integer> attempts = new HashMap<>();

    public static boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public static List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();

        for(int i=1;i<=3;i++){
            suggestions.add(username + i);
        }

        suggestions.add(username.replace("_","."));
        return suggestions;
    }

    public static void main(String[] args) {

        users.put("john_doe",101);
        users.put("admin",102);

        System.out.println("john_doe available: " + checkAvailability("john_doe"));
        System.out.println("jane_smith available: " + checkAvailability("jane_smith"));

        System.out.println("Suggestions for john_doe: " + suggestAlternatives("john_doe"));
    }
}