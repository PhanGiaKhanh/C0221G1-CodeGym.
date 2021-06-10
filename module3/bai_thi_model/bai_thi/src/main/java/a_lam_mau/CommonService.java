package a_lam_mau;

import java.util.List;

public interface CommonService<E> {
    List<E> findAll();
    boolean insert(E e);
    boolean deleteById(int id);
    boolean updateById(E e);
    E findById(int id);
    List<E> findByName(String Name);
}
