package com.xzp.Mapper;

import com.xzp.Pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface TeacherMapper {
    public Teacher getById( int id);
}
