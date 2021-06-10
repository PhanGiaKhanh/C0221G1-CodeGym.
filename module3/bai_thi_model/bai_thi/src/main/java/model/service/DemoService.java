package model.service;

import model.bean.StudentDemo;

import java.util.List;
import java.util.Map;

public interface DemoService {
    List<StudentDemo> findAll();
    Map<String, String> insert(StudentDemo studentDemo);
    boolean deleteById(int id);
    List<String> updateById(StudentDemo studentDemo);
    StudentDemo findById(int id);
    List<StudentDemo> search(String name);
}
