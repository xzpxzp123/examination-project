package com.xzp.Controller;

import com.xzp.Aop.InvokeLog;
import com.xzp.Mapper.testPaperMapper;
import com.xzp.Pojo.ResopnseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//<!--    private Integer id;-->
//<!--    private String Question_type;-->
//<!--    private String Question;-->
//<!--    private String Option_1;-->
//<!--    private String Option_2;-->
//<!--    private String Option_3;-->
//<!--    private String Option_4;-->
//<!--    private String answer;-->
//<!--    private String point;-->
//<!--    private String course;-->
@ResponseBody
@Controller
public class UpdatetestPaperController {
    @Autowired
    testPaperMapper testPaperMapper;
    private static int success_Stauts_Code=300;
    private static int error_Stauts_Code=400;
    @InvokeLog
    @Transactional
    @RequestMapping("/Teacher/contro/updateTestPaper")
    public ResopnseResult<String> update(int id, String Question_type, String Question, List<String> Options, String answer, String point, String course){
        ResopnseResult resopnseResult=new ResopnseResult();

            testPaperMapper.updateTestPaper(id,Question_type,Question,Options.get(0),Options.get(1),Options.get(2),Options.get(3),answer,point,course);
            resopnseResult.setCode(success_Stauts_Code);
            resopnseResult.setData("修改成功");

//        catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException("修改错误");
//        }
        return resopnseResult;
    }
}

