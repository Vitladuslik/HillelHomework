import java.util.HashMap;
import java.util.Map;

public class CacheImpl implements Cache{

    Map <String, Map<String, Object>> localCache;

    @Override
    public void createCache() {
        localCache = new HashMap<>();
    }

    @Override
    public boolean put(String cache, String key, Object o) {

        localCache.get(cache).put(key,o);
        return true;

    }

    @Override
    public Object get(String cache, String key) {
        return localCache.get(cache).get(key);
    }

    @Override
    public void clear() {
        localCache.clear();
    }

    @Override
    public void clear(String cache) {
        localCache.remove(cache);
    }

    @Override
    public boolean isCacheExist(String cache) {

        return localCache.containsKey(cache);

    }
}
