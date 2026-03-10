import java.util.*;

class DNSEntry {
    String ip;
    long expiryTime;

    DNSEntry(String ip, long ttlSeconds) {
        this.ip = ip;
        this.expiryTime = System.currentTimeMillis() + (ttlSeconds * 1000);
    }

    boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }
}

public class week1and2 {

    static HashMap<String, DNSEntry> cache = new HashMap<>();
    static int hits = 0;
    static int misses = 0;

    public static String resolve(String domain) {

        if (cache.containsKey(domain)) {
            DNSEntry entry = cache.get(domain);

            if (!entry.isExpired()) {
                hits++;
                return "Cache HIT → " + entry.ip;
            } else {
                cache.remove(domain);
            }
        }

        misses++;

        String ip = queryUpstreamDNS(domain);

        cache.put(domain, new DNSEntry(ip, 10)); // TTL 10 seconds

        return "Cache MISS → " + ip;
    }

    public static String queryUpstreamDNS(String domain) {
        return "192.168.1." + new Random().nextInt(255);
    }

    public static void getStats() {
        int total = hits + misses;
        double hitRate = total == 0 ? 0 : (hits * 100.0) / total;

        System.out.println("Cache Hits: " + hits);
        System.out.println("Cache Misses: " + misses);
        System.out.println("Hit Rate: " + hitRate + "%");
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));

        Thread.sleep(11000); // wait for TTL to expire

        System.out.println(resolve("google.com"));

        getStats();
    }
}