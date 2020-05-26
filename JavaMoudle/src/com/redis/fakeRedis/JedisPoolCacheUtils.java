//package com.redis.fakeRedis;
//
//
//
//import java.util.Properties;
//
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Component;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.ithzk.common.util.Detect;
//import com.ithzk.common.util.JsonUtil;
//import com.ithzk.common.util.PropertiesUtil;
//
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
///**
// * redis 操作数据库配置类
// * @author huzekun
// * @date:2017年12月27日 下午3:01:04
// */
//@Component("JedisPoolCacheUtils")
//public class JedisPoolCacheUtils {
//
//    private final static Logger log = Logger.getLogger(JedisPoolCacheUtils.class);
//
//    public final static String DATA_REDIS_KEY = "data_";
//
//    /**
//     * redis过期时间,以秒为单位
//     */
//    public final static int EXRP_HOUR = 60 * 60;            //一小时
//    public final static int EXRP_HALF_DAY = 60 * 60 * 12;        //半天
//    public final static int EXRP_DAY = 60 * 60 * 24;        //一天
//    public final static int EXRP_MONTH = 60 * 60 * 24 * 30; //一个月
//
//    private static JedisPool jedisPool = null;
//
//    /**
//     * 初始化Redis连接池
//     */
//    public static void initialPool(String path){
//        Properties prop = new Properties();
//        try {
//            prop.load(JedisPoolCacheUtils.class.getClassLoader().getResourceAsStream(path+"-conf/redis.properties"));
//            JedisPoolConfig config = new JedisPoolConfig();
//            config.setMaxTotal(Detect.asPrimitiveInt(prop.getProperty("redis.pool.maxActive")));
//            config.setMaxIdle(Detect.asPrimitiveInt(prop.getProperty("redis.pool.maxIdle")));
//            config.setMinIdle(Detect.asPrimitiveInt(prop.getProperty("redis.pool.minIdle")));
//            config.setMaxWaitMillis(Detect.asPrimitiveInt(prop.getProperty("redis.pool.maxWait")));
//            config.setTestOnBorrow(true);
//            config.setTestOnReturn(true);
//            config.setTestWhileIdle(true);
//            String host = prop.getProperty("redis.host");
//            String port = prop.getProperty("redis.port");
//            String timeOut = prop.getProperty("redis.timeout");
//            jedisPool = new JedisPool(config, host, Detect.asPrimitiveInt(port), Detect.asPrimitiveInt(timeOut));
//        } catch (Exception e) {
//            log.error("First create JedisPool error : "+e);
//            try{vv
//                //如果第一个IP异常，则访问第二个IP
//                JedisPoolConfig config = new JedisPoolConfig();
//                config.setMaxTotal(Detect.asPrimitiveInt(PropertiesUtil.getValueByBundleFromConf(path+"-conf/redis.properties","redis.pool.maxActive")));
//                config.setMaxIdle(Detect.asPrimitiveInt(PropertiesUtil.getValueByBundleFromConf(path+"-conf/redis.properties","redis.pool.maxIdle")));
//                config.setMinIdle(Detect.asPrimitiveInt(PropertiesUtil.getValueByBundleFromConf(path+"-conf/redis.properties","redis.pool.minIdle")));
//                config.setMaxWaitMillis(Detect.asPrimitiveInt(PropertiesUtil.getValueByBundleFromConf(path+"-redis.properties","redis.pool.maxWait")));
//                config.setTestOnBorrow(true);
//                String host = PropertiesUtil.getValueByBundleFromConf(path+"-conf/redis.properties","redis.host");
//                String port = PropertiesUtil.getValueByBundleFromConf(path+"-conf/redis.properties","redis.port");
//                String timeOut = PropertiesUtil.getValueByBundleFromConf(path+"-conf/redis.properties","redis.timeout");
//                jedisPool = new JedisPool(config, host, Detect.asPrimitiveInt(port), Detect.asPrimitiveInt(timeOut));
//            }catch(Exception e2){
//                log.error("Second create JedisPool error : "+e2);
//            }
//        }
//        //Jedis jedis = jedisPool.getResource();
//        //log.info("=====初始化redis池成功!  状态:"+ jedis.ping());
//        log.info("=====初始化redis池成功!");
//    }
//
//
//    /**
//     *
//     * setVExpire(设置key值，同时设置失效时间 秒)
//     * @Title: setVExpire
//     * @param @param key
//     * @param @param value
//     * @param @param seconds
//     * @param index 具体数据库 默认使用0号库
//     * @return void
//     * @throws
//     */
//    public static <V> void setVExpire(String key, V value,int seconds,int index) {
//        String json = JsonUtil.object2json(value);
//        //String json = JSON.toJSONString(value);
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            jedis.select(index);
//            jedis.set(DATA_REDIS_KEY +key, json);
//            jedis.expire(DATA_REDIS_KEY +key, seconds);
//        } catch (Exception e) {
//            log.error("setV初始化jedis异常：" + e);
//            if (jedis != null) {
//                //jedisPool.returnBrokenResource(jedis);
//                jedis.close();
//            }
//        } finally {
//            closeJedis(jedis);
//        }
//
//    }
//    /**
//     *
//     * (存入redis数据)
//     * @Title: setV
//     * @param @param key
//     * @param @param value
//     * @param index 具体数据库
//     * @return void
//     * @throws
//     */
//    public static <V> void setV(String key, V value,int index) {
//        String json = JSON.toJSONString(value);
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            jedis.select(index);
//            jedis.set(DATA_REDIS_KEY +key, json);
//        } catch (Exception e) {
//            log.error("setV初始化jedis异常：" + e);
//            if (jedis != null) {
//                //jedisPool.returnBrokenResource(jedis);
//                jedis.close();
//            }
//        } finally {
//            closeJedis(jedis);
//        }
//
//    }
//
//    /**
//     *
//     * getV(获取redis数据信息)
//     * @Title: getV
//     * @param @param key
//     * @param index 具体数据库 0:常用数据存储      3：session数据存储
//     * @param @return
//     * @return V
//     * @throws
//     */
//    @SuppressWarnings("unchecked")
//    public static <V> V getV(String key,int index) {
//        String value = "";
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            jedis.select(index);
//            value = jedis.get(DATA_REDIS_KEY +key);
//        } catch (Exception e) {
//            log.error("getV初始化jedis异常：" + e);
//            if (jedis != null) {
//                //jedisPool.returnBrokenResource(jedis);
//                jedis.close();
//            }
//        } finally {
//            closeJedis(jedis);
//        }
//        return (V)JSONObject.parse(value);
//    }
//    /**
//     *
//     * getVString(返回json字符串)
//     * @Title: getVString
//     * @param @param key
//     * @param @param index
//     * @param @return
//     * @return String
//     * @throws
//     */
//    public static String getVStr(String key,int index) {
//        String value = "";
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            jedis.select(index);
//            value = jedis.get(DATA_REDIS_KEY +key);
//        } catch (Exception e) {
//            log.error("getVString初始化jedis异常：" + e);
//            if (jedis != null) {
//                //jedisPool.returnBrokenResource(jedis);
//                jedis.close();
//            }
//        } finally {
//            closeJedis(jedis);
//        }
//        return value;
//    }
//
//    /**
//     *
//     * Push(存入 数据到队列中)
//     *
//     * @Title: Push
//     * @param @param key
//     * @param @param value
//     * @return void
//     * @throws
//     */
//    public static <V> void Push(String key, V value) {
//        String json = JSON.toJSONString(value);
//        Jedis jedis = null;
//        try {
//            log.info("存入 数据到队列中");
//            jedis = jedisPool.getResource();
//            jedis.select(15);
//            jedis.lpush(key, json);
//        } catch (Exception e) {
//            log.error("Push初始化jedis异常：" + e);
//            if (jedis != null) {
//                //jedisPool.returnBrokenResource(jedis);
//                jedis.close();
//            }
//        } finally {
//            closeJedis(jedis);
//        }
//    }
//    /**
//     *
//     * Push(存入 数据到队列中)
//     *
//     * @Title: PushV
//     * @param  key
//     * @param value
//     * @param dBNum
//     * @return void
//     * @throws
//     */
//    public static <V> void PushV(String key, V value,int dBNum) {
//        String json = JSON.toJSONString(value);
//        Jedis jedis = null;
//        try {
//            log.info("存入 数据到队列中");
//            jedis = jedisPool.getResource();
//            jedis.select(dBNum);
//            jedis.lpush(key, json);
//        } catch (Exception e) {
//            log.error("Push初始化jedis异常：" + e);
//            if (jedis != null) {
//                //jedisPool.returnBrokenResource(jedis);
//                jedis.close();
//            }
//        } finally {
//            closeJedis(jedis);
//        }
//    }
//
//    /**
//     *
//     * Push(存入 数据到队列中)
//     *
//     * @Title: Push
//     * @param @param key
//     * @param @param value
//     * @return void
//     * @throws
//     */
//    public static <V> void PushEmail(String key, V value) {
//
//        String json = JsonUtil.object2json(value);
//        Jedis jedis = null;
//        try {
//            log.info("存入 数据到队列中");
//            jedis = jedisPool.getResource();
//            jedis.select(15);
//            jedis.lpush(key, json);
//        } catch (Exception e) {
//            log.error("Push初始化jedis异常：" + e);
//            if (jedis != null) {
//                //jedisPool.returnBrokenResource(jedis);
//                jedis.close();
//            }
//        } finally {
//            closeJedis(jedis);
//        }
//    }
//
//    /**
//     *
//     * Pop(从队列中取值)
//     *
//     * @Title: Pop
//     * @param @param key
//     * @param @return
//     * @return V
//     * @throws
//     */
//    @SuppressWarnings("unchecked")
//    public static <V> V Pop(String key) {
//        String value = "";
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            jedis.select(15);
//            value = jedis.rpop(DATA_REDIS_KEY +key);
//        } catch (Exception e) {
//            log.error("Pop初始化jedis异常：" + e);
//            if (jedis != null) {
//                //jedisPool.returnBrokenResource(jedis);
//                jedis.close();
//            }
//        } finally {
//            closeJedis(jedis);
//        }
//        return (V) value;
//    }
//
//
//    /**
//     *
//     * expireKey(限时存入redis服务器)
//     *
//     * @Title: expireKey
//     * @param @param key
//     * @param @param seconds
//     * @return void
//     * @throws
//     */
//    public static void expireKey(String key, int seconds) {
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            jedis.select(3);
//            jedis.expire(DATA_REDIS_KEY +key, seconds);
//        } catch (Exception e) {
//            log.error("Pop初始化jedis异常：" + e);
//            if (jedis != null) {
//                //jedisPool.returnBrokenResource(jedis);
//                jedis.close();
//            }
//        } finally {
//            closeJedis(jedis);
//        }
//
//    }
//
//    /**
//     *
//     * closeJedis(释放redis资源)
//     *
//     * @Title: closeJedis
//     * @param @param jedis
//     * @return void
//     * @throws
//     */
//    public static void closeJedis(Jedis jedis) {
//        try {
//            if (jedis != null) {
//                /*jedisPool.returnBrokenResource(jedis);
//                jedisPool.returnResource(jedis);
//                jedisPool.returnResourceObject(jedis);*/
//                //高版本jedis close 取代池回收
//                jedis.close();
//            }
//        } catch (Exception e) {
//            log.error("释放资源异常：" + e);
//        }
//    }
//
//    public void setJedisPool(JedisPool jedisPool) {
//        this.jedisPool = jedisPool;
//    }
//
//}
