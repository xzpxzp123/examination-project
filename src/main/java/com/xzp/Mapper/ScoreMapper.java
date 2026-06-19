package com.xzp.Mapper;

import com.xzp.Pojo.exam_record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface ScoreMapper {
    public List<exam_record> showAll(String course);
    public List<exam_record> showOne(String course,String name);
    public void InsertScore(@Param("course") String course, @Param("stu_name") String stu_name, @Param("point") String point, @Param("time") String time, @Param("retake_flag") String retake_flag);
    public String getMaxRetakeFlagById(@Param("course") String course, @Param("stu_name") String stu_name);
}
