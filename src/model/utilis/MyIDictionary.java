package model.utilis;

import java.util.List;

public interface MyIDictionary<K, V> {
    boolean isDefined(K key);

    void put(K key, V value);

    V lookUp(K key);

    void update(K key, V value);
    public List<String> iterateDictionary();
    void remove(K key);
}
