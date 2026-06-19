package com.xzp.Service;

import com.xzp.Mapper.StudentMapper;
import com.xzp.Mapper.TeacherMapper;
import com.xzp.Pojo.Student;
import com.xzp.Pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class LoginService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;
    public Teacher Service(int id,String college){
        Teacher teacher=teacherMapper.getById(id);
        if(teacher!=null){
            if(teacher.getCollege().equals(college)){
                return teacher;
            }
        }
        return null;
    }
    public Student Service2(int id,String college){
        Student student=studentMapper.findById(id);
        if(student!=null){
            if(student.getCollege().equals(college)){
                return student;
            }
        }
        return null;
    }
}
