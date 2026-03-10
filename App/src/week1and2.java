import java.util.*;

class TokenBucket{
    int tokens;
    long lastTime;

    TokenBucket(int limit){
        tokens = limit;
        lastTime = System.currentTimeMillis();
    }
}

public class week1and2 {

    static HashMap<String,TokenBucket> clients = new HashMap<>();
    static int LIMIT = 5;

    static boolean check(String id){

        clients.putIfAbsent(id,new TokenBucket(LIMIT));
        TokenBucket b = clients.get(id);

        if(System.currentTimeMillis()-b.lastTime > 3600000){
            b.tokens = LIMIT;
            b.lastTime = System.currentTimeMillis();
        }

        if(b.tokens>0){
            b.tokens--;
            return true;
        }

        return false;
    }

    public static void main(String[] args){

        String client="abc123";

        for(int i=1;i<=7;i++){
            if(check(client))
                System.out.println("Allowed");
            else
                System.out.println("Rate limit exceeded");
        }
    }
}