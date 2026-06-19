package com.xzp;

import com.xzp.Mapper.TeacherMapper;
import com.xzp.Pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ApplicationTest {
    @Autowired
    private TeacherMapper teacherMapper;
//    @Test
//    public void testMapper(){
////        List<Teacher> list=teacherMapper.findAll();
////        System.out.println(list);
//    }
}
