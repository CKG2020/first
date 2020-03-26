import java.util.*;

public class ClientMap<K,V> {
         public Map<K,V> map = Collections.synchronizedMap(new HashMap<K,V>());

             public synchronized void removeByValue(Object value) {
                 for (Object key : map.keySet()) {
                        if(map.get(key) == value) {
                                 map.remove(key);
                                 break;                         }
                     } }
            //获取outputStream对象组成的Set
     public synchronized Set<V> valueSet() {
              Set<V> result = new HashSet<V>();
                //遍历map，将map的value存入Set
               for(K key :  map.keySet()) {
                       result.add(map.get(key));
                    }

                  return result;
             }

             public synchronized K getKeyByValue(V val) {
                 for(K key : map.keySet()) {
                         if (map.get(key) == val || map.get(key).equals(val)) {
                                 return key;                          }
     }
                 return null;
             }

             public synchronized V put(K key, V value) { for (V val : valueSet() ) {
                             if (val.equals(value) && val.hashCode() == value.hashCode()) {
                                     throw new RuntimeException("此输入流已经被使用"); }
                    } return map.put(key, value);
            }

}
