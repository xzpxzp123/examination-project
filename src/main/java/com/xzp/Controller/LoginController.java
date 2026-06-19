package com.xzp.Controller;

import com.xzp.Mapper.TeacherMapper;
import com.xzp.Pojo.ResopnseResult;
import com.xzp.Pojo.Student;
import com.xzp.Pojo.Teacher;
import com.xzp.Service.LoginService;
import com.xzp.Utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.xzp.Pojo.Teacher;
import com.xzp.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@ResponseBody
public class LoginController {

    // 注入业务层，用于校验id+college是否合法
    @Autowired
    private LoginService loginService;

    @RequestMapping("/Teacher/login")
    public ResopnseResult<String> teahcer_login(@RequestParam(value = "id",required = true)Integer id,@RequestParam(value = "college",required = true)String college) {

        // 调用业务层校验参数是否正确（查询教师）
        Teacher teacher = loginService.Service(id, college);

        ResopnseResult<String> resopnseResult=new ResopnseResult<>();
        if(teacher==null){
            resopnseResult.setCode(400);
            resopnseResult.setMsg("你的输入有误");
        }
        else{
            resopnseResult.setCode(300);
            resopnseResult.setUserType("teacher");
            String token= JWTUtils.createJWT(UUID.randomUUID().toString(),Integer.toString(id),null);
            resopnseResult.setData(token);
        }
        return resopnseResult;
    }
    @RequestMapping("/Student/login")
    public ResopnseResult<String> student_login(@RequestParam(value = "id",required = true)int id,@RequestParam(value = "college",required = true)String college){
        Student student=loginService.Service2(id,college);
        ResopnseResult<String> resopnseResult=new ResopnseResult<>();
        if(student==null){
            resopnseResult.setCode(400);
            resopnseResult.setMsg("你的输入有误");
        }
        else{
            resopnseResult.setCode(300);
            resopnseResult.setUserType("student");
            String token= JWTUtils.createJWT(UUID.randomUUID().toString(),Integer.toString(id),null);
            resopnseResult.setData(token);
        }
        return resopnseResult;
    }
}

