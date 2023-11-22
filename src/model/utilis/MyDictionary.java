package model.utilis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDictionary<K,V> implements MyIDictionary<K,V>{

    Map<K,V> dictionary;
    public MyDictionary() {
        dictionary = new HashMap<>();
    }
    @Override
    public boolean isDefined(K key) {
        return dictionary.containsKey(key);
    }

    @Override
    public void put(K key, V value) {
        dictionary.put(key, value);
    }

    @Override
    public V lookUp(K key) {
        try
        {
            return dictionary.get(key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void update(K key, V value) {
        dictionary.put(key, value);
    }

    @Override
    public String toString() {
        return "MyDictionary{" +
                "dictionary=" + dictionary +
                '}';
    }
    @Override
    public List<String> iterateDictionary() {
        List<String> sym_table_content = new ArrayList<>();
        for (Map.Entry<K, V> entry : dictionary.entrySet()) {
            String new_string = "Key: " + entry.getKey() + ", Value: " + entry.getValue();
            sym_table_content.add(new_string);
        }
        return sym_table_content;
    }

    @Override
    public void remove(K key) {
        dictionary.remove(key);
    }
}
