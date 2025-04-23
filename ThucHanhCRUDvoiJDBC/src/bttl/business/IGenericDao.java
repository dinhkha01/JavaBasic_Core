package bttl.business;

import java.util.List;

public interface IGenericDao<T,E>{
    List<T> findAll();
    T findById(E id);
    void save(T t);
    boolean deleteById(E id);
}