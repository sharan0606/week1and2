import java.util.*;

class Entry {
    String ip;
    long expiry;

    Entry(String ip,int ttl){
        this.ip=ip;
        expiry=System.currentTimeMillis()+ttl*1000;
    }

    boolean expired(){
        return System.currentTimeMillis()>expiry;
    }
}

public class week1and2{

    static HashMap<String,Entry> cache=new HashMap<>();

    static String resolve(String domain){

        if(cache.containsKey(domain) && !cache.get(domain).expired()){
            return "Cache HIT: "+cache.get(domain).ip;
        }

        String ip="192.168.1."+new Random().nextInt(100);
        cache.put(domain,new Entry(ip,5));

        return "Cache MISS: "+ip;
    }

    public static void main(String[] args)throws Exception{

        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));

        Thread.sleep(6000);

        System.out.println(resolve("google.com"));
    }
}