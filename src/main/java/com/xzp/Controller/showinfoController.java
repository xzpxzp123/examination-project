package com.xzp.Controller;

import com.xzp.Mapper.ScoreMapper;
import com.xzp.Mapper.StudentMapper;
import com.xzp.Mapper.TeacherMapper;
import com.xzp.Mapper.testPaperMapper;
import com.xzp.Pojo.*;
import com.xzp.Utils.JWTUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Controller
@ResponseBody
public class showinfoController {
    private static int success_Stauts_Code=300;
    private static int error_Stauts_Code=400;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    testPaperMapper testPaperMapper;
    @Autowired
    ScoreMapper scoreMapper;
    @RequestMapping("/Teacher/contro/show/getByid")
    public ResopnseResult showTeacherInfo (@RequestHeader("token") String token)  {
        ResopnseResult<Teacher> resopnseResult=new ResopnseResult<Teacher>();
        Claims claims= null;
        try {
            claims = JWTUtils.parseJWT(token);
            String id=claims.getSubject();
            Teacher teacher=teacherMapper.getById(Integer.parseInt(id));
            resopnseResult.setCode(300);
            resopnseResult.setData(teacher);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("你未成功登录,无法访问教师端页面");
        }
        return  resopnseResult;
    }
    @RequestMapping("/Student/contro/show/getByid" )
    public ResopnseResult showStudentInfo(@RequestHeader("token") String token){
        ResopnseResult<Student> resopnseResult=new ResopnseResult<Student>();
        try {
            Claims claims= JWTUtils.parseJWT(token);
            String id=claims.getSubject();
            Student student=studentMapper.findById(Integer.parseInt(id));
            resopnseResult.setCode(success_Stauts_Code);
           resopnseResult.setData(student);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("你未成功登录,无法访问学生端页面");
        }
        return  resopnseResult;
    }
@RequestMapping("/Teacher/contro/show/showtestPaperInfo")
    public ResopnseResult showtestPaperInfo(String course){
        ResopnseResult<List<course_question>> resopnseResult=new ResopnseResult<>();
       try{
           List<course_question> list=testPaperMapper.getAll(course);
           resopnseResult.setData(list);
           resopnseResult.setCode(success_Stauts_Code);
       }
       catch (Exception e){
           e.printStackTrace();
           throw new RuntimeException("Error");
       }
       return resopnseResult;
    }
    @RequestMapping("/Student/contro/show/showCourseinfo" )
    public ResopnseResult showCoursesinfo(@RequestHeader("token")String token){
    ResopnseResult<CourseList> resopnseResult=new ResopnseResult<>();
        try {
            Claims claims = JWTUtils.parseJWT(token);
            String id = claims.getSubject();
            CourseList courseList=studentMapper.getCoursesByid(Integer.parseInt(id));
            resopnseResult.setData(courseList);
            resopnseResult.setCode(success_Stauts_Code);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error");
        }
        return resopnseResult;
    }
    @RequestMapping("/Student/contro/show/showQuestions")
    public ResopnseResult showQuestions(@RequestParam String course){
        ResopnseResult<List<course_question>> resopnseResult=new ResopnseResult<>();
        try{
        List<course_question> list=testPaperMapper.getAll(course);
        for(course_question course_question:list){
           course_question.setAnswer(null);
        }
        resopnseResult.setData(list);
        resopnseResult.setCode(success_Stauts_Code);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("考题加载失败");
        }
        return resopnseResult;
    }
    @RequestMapping("/Student/contro/show/reshowQuestions")
    public ResopnseResult reShowQuestions(@RequestParam String course){
        ResopnseResult<List<course_question>> resopnseResult=new ResopnseResult<>();
        try{
            List<course_question> list=testPaperMapper.getAll(course);
            for(course_question course_question:list){
                course_question.setAnswer(null);
            }
            resopnseResult.setData(list);
            resopnseResult.setCode(success_Stauts_Code);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("考题加载失败");
        }
        return resopnseResult;
    }
    @RequestMapping("/Teacher/contro/show/showPoints")
    public ResopnseResult showPoints(@RequestParam String course){
        ResopnseResult<List<exam_record>> resopnseResult=new ResopnseResult<>();
        try{
            List<exam_record> list=scoreMapper.showAll(course);
            resopnseResult.setData(list);
            resopnseResult.setCode(success_Stauts_Code);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("加载失败");
        }
        return  resopnseResult;
    }
    @RequestMapping("/Teacher/contro/show/showBystu")
    public  ResopnseResult showoneBystu(@RequestParam String course,@RequestParam String stu_name){
        ResopnseResult<List<exam_record>> resopnseResult=new ResopnseResult<>();
        try{
            List<exam_record> list=scoreMapper.showOne(course,stu_name);
            resopnseResult.setData(list);
            resopnseResult.setCode(success_Stauts_Code);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error");
        }
        return resopnseResult;
    }
    @RequestMapping("/Student/contro/grade/gradePaper")
    public ResopnseResult gradePaper(@RequestBody ExamSubmmitDTO examSubmmitDTO,@RequestHeader("token")String token){
        ResopnseResult<Integer> resopnseResult=new ResopnseResult<>();
        Integer Score=0;
        try {
            String course=examSubmmitDTO.getCourse();
            List<course_question> list=testPaperMapper.getAll(course);
            for(course_question course_question:list){
                String answer=(String) examSubmmitDTO.getAnswerMap().get(course_question.getId());
                if(course_question.getAnswer().equals(answer)){
                    Score=Score+Integer.parseInt(course_question.getPoint());
                }
            }
            Date date=new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/M/d");
            String time=simpleDateFormat.format(date);
            String stu_name=studentMapper.getNameByid(JWTUtils.parseJWT(token).getSubject());
            String retake_flag=scoreMapper.getMaxRetakeFlagById(course,stu_name);
            if(retake_flag==null){
                scoreMapper.InsertScore(course,stu_name,Integer.toString(Score),time,Integer.toString(0));
            }
            else{
                scoreMapper.InsertScore(course,stu_name,Integer.toString(Score),time,Integer.toString(Integer.parseInt(retake_flag)+1));
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error");
        }
            resopnseResult.setCode(success_Stauts_Code);
            resopnseResult.setData(Score);
            return resopnseResult;
    }
}
