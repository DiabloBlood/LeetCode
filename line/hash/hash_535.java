


public class Solution535 {
    /**
     * Notes:
     *     1. Math.random is a static double method, return value 0.0 <= rv < 1.0.
     *     2. HashMap could accept `null` as both key and value. If `null` is key, hashmap `hash` method will return `0` directly,
     *        then table[0] create a new Node<K, V> with key is `null` and any value (value can also be `null`).
     *     3. map.get(key) method, if map not contains `key` will return `null` instead of throw exception.s
     *
     * Problem Analysis:
     *     1. To get a tiny url like `http://tinyurl.com/4e9iAk`, we need use a seed string with all letters and digits,
     *        and user Math.random() method to get a random character.
     *     2. `encode` method is a write method, and longUrl ---> tinyUrl is one ---> many is OK, then we just need use
     *        one hash map. But if some body hack the system, will generate a lot of junk write actions, and one hashmap
     *        cannot detect.
     *
     * General Cases:
     *     encode method:
     *     1. do - while create sub tiny url as key.
     *     decode method:
     *     1. tinyMap.containsKey(key);  ---> return tinyMap.get(key);
     *     2. !tinyMap.containsKey(key); ---> return "";
     *
     * Corner Cases:
     *     encode method:
     *     1. longUrl is not valid; ---> // assume it is valid, but remember to mention it during the interview.
     *     decode method:
     *     1. 2. !tinyMap.containsKey(key); ---> return "";
     *
     * Time:  encode method O(1), decode method O(1)
     * Space: encode method O(1), decode method O(1), please note that hash map space is not extra space of method.
     */
    private static final String SEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String TINY_BASE = "https://tinyurl.com/";
    private final Map<String, String> tinyMap = new HashMap<>();

    public String encode(String longUrl) {
        String key = null;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int idx = (int)Math.random() * SEED.length();
                sb.append(SEED.charAt(idx));
            }
            key = sb.toString();
        } while (tinyMap.containsKey(key));
        tinyMap.put(key, longUrl);
        return TINY_BASE + key;
    }

    public String decode(String tinyUrl) {
        return tinyMap.getOrDefault(tinyUrl.replace(TINY_BASE, ""), "");
    }

    /**
     * Use an extra longMap, then longUrl ---> tinyUrl from one --->= many to one ---> one.
     */ 
    private static final String SEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String TINY_BASE = "https://tinyurl.com/";
    private final Map<String, String> tinyMap = new HashMap<>();
    private final Map<String, String> longMap = new HashMap<>();

    public String encode(String longUrl) {
        if (longMap.containsKey(longUrl)) {
            return TINY_BASE + longMap.get(longUrl);
        }
        String key = null;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int idx = (int)(Math.random() * SEED.length());
                sb.append(SEED.charAt(idx));
            }
            key = sb.toString();
        } while (tinyMap.containsKey(key));
        longMap.put(longUrl, key);
        tinyMap.put(key, longUrl);
        return TINY_BASE + key;
    }

    public String decode(String tinyUrl) {
        return tinyMap.getOrDefault(tinyUrl.replace(TINY_BASE, ""), "");
    }
}
