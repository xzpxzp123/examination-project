package com.xzp.Controller;

import com.xzp.Aop.InvokeLog;
import com.xzp.Mapper.StudentMapper;
import com.xzp.Pojo.ResopnseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class UpdateStuinfoController {
    private static int success_Stauts_Code=300;
    private static int error_Stauts_Code=400;
    @Autowired
    StudentMapper studentMapper;
    @RequestMapping("/Student/contro/update")
    @Transactional
    @InvokeLog
    public ResopnseResult<String> updateByid(int id, String name, String  phonenumber, String  college , String sex ){
        ResopnseResult resopnseResult=new ResopnseResult();

            studentMapper.UpdateStuinfo(id,name,phonenumber,college,sex);
            resopnseResult.setCode(success_Stauts_Code);
            resopnseResult.setData("修改成功");

//        catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException("修改错误");
//        }
        return  resopnseResult;
    }
}
