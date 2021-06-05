package common;

import java.util.List;

public class CommonRepository {
    BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ALL = "select * from nameTable ";
    private static final String SELECT_BY_ID = "select * from nameTable where id_nameTable = ?";
    private static final String SELECT_BY_NAME = "select * from nameTable where name_nameTable like ?";
    private static final String INSERT = "";
    private static final String SET_BY_ID = "";
    private static final String DELETE_BY_ID= "";



//    List<E> findAll();
//    boolean insert(E e);
//    boolean deleteById(int id);
//    boolean updateById(E e);
//    E findById(int id);
//    List<E> findByName(String Name);



//    public static void main(String[] args) {
//        StudentRepository studentRepository = new StudentRepository();
//        Student student = new Student("hai17",30,"hai@gmail.com");
//        studentRepository.save(student);
//        System.out.println(studentRepository.findByAll().size());
//    }
}
