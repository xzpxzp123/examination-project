package com.xzp.Mapper;

import com.xzp.Pojo.CourseList;
import com.xzp.Pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface StudentMapper {
    public Student findById(@Param("id") int id);
    public void UpdateStuinfo(@Param("id") int id, @Param("name") String name, @Param("phonenumber") String phonenumber, @Param("college") String college, @Param("sex") String sex);
    public CourseList getCoursesByid(int id);
    public String getNameByid(String id);
}

