import java.util.*;

public class week1and2 {

    static HashMap<String,Integer> queries = new HashMap<>();

    static void addQuery(String q){
        queries.put(q, queries.getOrDefault(q,0)+1);
    }

    static void search(String prefix){

        System.out.println("Suggestions:");

        queries.entrySet()
                .stream()
                .filter(e -> e.getKey().startsWith(prefix))
                .sorted((a,b)->b.getValue()-a.getValue())
                .limit(5)
                .forEach(e -> System.out.println(e.getKey()+" ("+e.getValue()+")"));
    }

    public static void main(String[] args) {

        addQuery("java tutorial");
        addQuery("javascript guide");
        addQuery("java tutorial");
        addQuery("java download");
        addQuery("java tutorial");

        search("jav");
    }
}