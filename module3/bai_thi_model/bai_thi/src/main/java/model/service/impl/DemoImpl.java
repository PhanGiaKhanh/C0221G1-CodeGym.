package model.service.impl;

import model.bean.StudentDemo;
import model.common.Validate;
import model.repository.StudentDemoRepository;
import model.service.DemoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoImpl implements DemoService{
    StudentDemoRepository studentDemoRepository = new StudentDemoRepository();
    @Override
    public List<StudentDemo> findAll() {
        return studentDemoRepository.findAll();
    }

    @Override
    public Map<String, String> insert(StudentDemo studentDemo) {
        Map<String, String> stringMap = new HashMap<>();
        String name = Validate.checkNameVN(studentDemo.getName());
        if (!name.equals("")){
            stringMap.put("name", name);
        }
        String birthday = Validate.checkBirthday(studentDemo.getBirthday());
        if (!birthday.equals("")){
            stringMap.put("birthday", birthday);
        }
        String email = Validate.checkEmail(studentDemo.getEmail());
        if (!email.equals("")) {
            stringMap.put("email", email);
        }
        String address = Validate.checkNameVN(studentDemo.getAddress());
        if (!address.equals("")) {
            stringMap.put("address", address);
        }
        String point = Validate.checkPoint(studentDemo.getPoint());
        if (!point.equals("")){
            stringMap.put("point", point);
        }
        if (stringMap.isEmpty()) {
            studentDemoRepository.insert(studentDemo);
        }
        return stringMap;
    }

    @Override
    public boolean deleteById(int id) {
        return studentDemoRepository.delete(id);
    }

    @Override
    public List<String> updateById(StudentDemo studentDemo) {
        List<String> errList = new ArrayList<>();

        String name = Validate.checkNameVN(studentDemo.getName());
        errList.add(name);
        String e = Validate.checkBirthday(studentDemo.getBirthday());
        errList.add(e);
        errList.add(Validate.checkEmail(studentDemo.getEmail()));
        errList.add(Validate.checkNameVN(studentDemo.getAddress()));
        errList.add(Validate.checkPoint(studentDemo.getPoint()));
        boolean errCheck = false;
        for (String err : errList) {
            if (!err.matches("")){
                errCheck = true;
                break;
            }
        }
        if (!errCheck){
            studentDemoRepository.update(studentDemo);
            errList = null;
        }
        return errList;
    }

    @Override
    public StudentDemo findById(int id) {
        return studentDemoRepository.findById(id);
    }

    @Override
    public List<StudentDemo> search(String name) {
        return studentDemoRepository.search(name);
    }



}
