import com.cache.config.SpringConfig;
import com.cache.logic.impl.CacheImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class CacheImplTest {

    private static final Logger testInfoWriter = LoggerFactory.getLogger("infoWriter");
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    CacheImpl cacheImpl;


    @BeforeEach
    void before() {
        cacheImpl = context.getBean("CacheImpl", CacheImpl.class);
        testInfoWriter.info("Test begins");
    }

    @AfterEach
    void after() {
        cacheImpl.clear();
        testInfoWriter.info("Test ended");
        testInfoWriter.info("----------------------------------------------------");
    }

    @Test
    void isCacheExist() {
        Assertions.assertNull(cacheImpl.getLocalCache());
        cacheImpl.createCache();
        Assertions.assertNotNull(cacheImpl.getLocalCache());
        cacheImpl.put("test", "1", new Object());
        cacheImpl.put("test1", "2", new Object());
        Assertions.assertTrue(cacheImpl.isCacheExist("test"));
        Assertions.assertTrue(cacheImpl.isCacheExist("test1"));
    }

    @Test
    void put() {
        Assertions.assertNull(cacheImpl.getLocalCache());
        cacheImpl.put("test", "1", new Object());
        cacheImpl.put("test", "2", new Object());
        Assertions.assertNotNull(cacheImpl.getLocalCache());
        Assertions.assertTrue(cacheImpl.isCacheExist("test"));
    }

    @Test
    void get() {
        Assertions.assertNull(cacheImpl.getLocalCache());
        cacheImpl.put("test", "1", new Object());
        cacheImpl.put("test", "2", new Object());
        Assertions.assertNotNull(cacheImpl.getLocalCache());
        Assertions.assertTrue(cacheImpl.isCacheExist("test"));
        Assertions.assertNotNull(cacheImpl.get("test", "2"));
        Assertions.assertNotNull(cacheImpl.get("test", "1"));
    }

    @Test
    void clearWhole() {
        Assertions.assertNull(cacheImpl.getLocalCache());
        cacheImpl.put("test", "1", new Object());
        cacheImpl.put("test", "2", new Object());
        Assertions.assertNotNull(cacheImpl.getLocalCache());
        cacheImpl.clear();
        Assertions.assertTrue(cacheImpl.getLocalCache().isEmpty());
    }

    @Test
    void clearSpecific() {
        cacheImpl.createCache();
        Assertions.assertFalse(cacheImpl.isCacheExist("test"));
        cacheImpl.put("test", "1", new Object());
        Assertions.assertTrue(cacheImpl.isCacheExist("test"));
        cacheImpl.clear("test");
        Assertions.assertFalse(cacheImpl.isCacheExist("test"));
    }

}
