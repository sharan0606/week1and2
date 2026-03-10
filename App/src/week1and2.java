import java.util.*;

public class week1and2 {

    static HashMap<String,Integer> pageViews = new HashMap<>();
    static HashMap<String,Set<String>> visitors = new HashMap<>();
    static HashMap<String,Integer> sources = new HashMap<>();

    static void process(String url,String user,String source){

        pageViews.put(url,pageViews.getOrDefault(url,0)+1);

        visitors.putIfAbsent(url,new HashSet<>());
        visitors.get(url).add(user);

        sources.put(source,sources.getOrDefault(source,0)+1);
    }

    static void dashboard(){

        System.out.println("Pages:");
        for(String url:pageViews.keySet()){
            System.out.println(url+" views:"+pageViews.get(url)+
                    " unique:"+visitors.get(url).size());
        }

        System.out.println("\nSources:");
        for(String s:sources.keySet()){
            System.out.println(s+" : "+sources.get(s));
        }
    }

    public static void main(String[] args) {

        process("/news","u1","google");
        process("/news","u2","facebook");
        process("/sports","u3","direct");
        process("/news","u1","google");

        dashboard();
    }
}