package ss.week5;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {
	
	/**
	 * 
	 * @param map - the map created.
	 * @return true- if every value is only referenced by one key. 
	 */
	//@ ensures \result == true || \result == false;
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        // TODO: implement, see exercise P-5.1
    	int count = 0;
    	V answer;
    	Collection<K> key = map.keySet();
    	for (K k1 : key) {
    		answer = map.get(k1);
    		for (K k2 : key) {
    			if (map.get(k2).equals(answer)) {
    				count++;
    			}
    		}
    		if (count > 1) {
    			return false;
    		}
    		count = 0;
    	}
        return true;
    }
    /**
     * 
     * @param map - the map created
     * @param range - the range that must be examined
     * @return true if all values have keys attached.
     */
    //@ ensures \result == true || \result == false;
    public static <K, V> 
           boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        // TODO: implement, see exercise P-5.2
    	int loose = 0;
       	for (V v : range) {
    		if (!map.containsValue(v)) {
    			loose++;
    		}
    	}
        return loose == 0;
    }
    
    /**
     * 
     * @param map - the created map
     * @return the inverse of the original map.
     */
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        // TODO: implement, see exercise P-5.3
    	Map<V, Set<K>> inverseMap = new HashMap<>();
        Set<K> keys = map.keySet();
        Collection<V> values = map.values();
        for (V v : values) {
        	Set<K> set = new HashSet<>();
        	for (K k : keys) {
        		if (map.get(k).equals(v)) {
        			set.add(k);
        		}
        	}
        	inverseMap.put(v, set);
        }
        
        return inverseMap;
	}
    
    /**
     * 
     * @param map - the created map
     * @return the inverse of the original map.
     */
    //@ requires isOneOnOne(map) == true && isSurjectiveOnRange(Map<K, V> map, Set<V> range) == true;
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        // TODO: implement, see exercise P-5.3
    	Map<V, K> inverseMap = new HashMap<>();
        Set<K> keys = map.keySet();
        Collection<V> values = map.values();
        //To check if it is surjective and injective, the range needs to be added as well.
        //This is done by creating an additional set, containing the values from map.
        Set<V> range = new HashSet<>();
        for (V vv : values) {
        	range.add(vv);
        }
        if (isOneOnOne(map) && isSurjectiveOnRange(map, range)) {
        	for (K k : keys) {
               	inverseMap.put(map.get(k), k);
        	}
        }
        return inverseMap;
	}
	/**
	 * 
	 * @param f - the first map.
	 * @param g - the second map
	 * @return true if the maps can be composed.
	 */
	//@ requires f != null && g != null;
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.4
		int count = 0;
		int notComp = 0;
        Set<V> keys2 = g.keySet();
        Set<K> keys1 = f.keySet();
        for (K k1 : keys1) {
        	for (V v1 : keys2) {
        		if (f.get(k1).equals(v1)) {
        			count++;
        		}
        	}
        	if (count == 0) {
        		notComp++;
        	}
        	count = 0;
        }
        return !(notComp > 0);
	}
	
	/**
	 * 
	 * @param f - the first map.
	 * @param g - the second map.
	 * @return The composed map
	 */
	//@ requires (compatible(f, g)) == true;
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.5
		if (compatible(f, g)) {
	    	Map<K, W> composedMap = new HashMap<>();
	        Set<K> keys1 = f.keySet();
	        Set<V> keys2 = g.keySet();
	    	for (K k1 : keys1) {
	    		for (V v2 : keys2) {
	    			if (f.get(k1).equals(v2)) {
	    				composedMap.put(k1, g.get(v2));
	    			}
	      		}
	    	}
	        return composedMap;
		}
		return null;
	}
}
