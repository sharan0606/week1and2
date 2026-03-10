import java.util.*;

public class week1and2 {

    static LinkedHashMap<String,String> L1 = new LinkedHashMap<>(5,0.75f,true){
        protected boolean removeEldestEntry(Map.Entry<String,String> e){
            return size()>5;
        }
    };

    static HashMap<String,String> L2 = new HashMap<>();

    static String getVideo(String id){

        if(L1.containsKey(id)){
            return "L1 HIT: "+L1.get(id);
        }

        if(L2.containsKey(id)){
            String v=L2.get(id);
            L1.put(id,v);
            return "L2 HIT → moved to L1";
        }

        String data="VideoData_"+id;
        L2.put(id,data);
        return "DB HIT → added to L2";
    }

    public static void main(String[] args){

        System.out.println(getVideo("video1"));
        System.out.println(getVideo("video1"));
        System.out.println(getVideo("video2"));
    }
}