package model.utilis;

import java.util.List;

public interface MyIList<T> {
    void add(T itemToAdd);
    int getSize();

    List<T> iterate_list();
}
