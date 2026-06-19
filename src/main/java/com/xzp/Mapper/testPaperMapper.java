package com.xzp.Mapper;

import com.xzp.Pojo.course_question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
//private Integer id;
//private String Question_type;
//private String Question;
//private String Option_1;
//private String Option_2;
//private String Option_3;
//private String Option_4;
//private String answer;
//private String point;
//private String course;

@Component
@Mapper
public interface testPaperMapper {
    public List<course_question> getAll(String course);
    public void updateTestPaper(@Param("id") int id, @Param("Question_type") String Question_type, @Param("Question") String Question, @Param("Option_1") String Option_1, @Param("Option_2") String Option_2, @Param("Option_3") String Option_3, @Param("Option_4") String Option_4, @Param("answer") String answer, @Param("point") String point, @Param("course") String course);
}
