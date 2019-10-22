package com.kingda.cloudplatform.controller;

import com.kingda.cloudplatform.pojo.BasCustomQuestionDO;
import com.kingda.cloudplatform.service.BasCustomQuestionService;
import com.kingda.cloudplatform.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Constanline
 * @description
 * @date 2019/10/18
 */
@Controller
@RequestMapping("/customQuestion")
public class BasCustomQuestionController {
    @Autowired
    private BasCustomQuestionService basCustomQuestionService;

    @RequestMapping("/getCustomQuestion")
    @ResponseBody
    public BasCustomQuestionDO getCustomQuestion(String id){
        return basCustomQuestionService.queryById(id);
    }

    @RequestMapping("/listCustomQuestion")
    @ResponseBody
    public List<BasCustomQuestionDO> listCustomQuestion(){
        return basCustomQuestionService.queryAll();
    }

    @RequestMapping("/addCustomQuestion")
    public void addCustomQuestion(
            BasCustomQuestionDO modal, HttpServletRequest request, HttpServletResponse response){
        String id = basCustomQuestionService.addBasCustomQuestion(modal);
        WebUtil.renderJson(response, "{\"status\":\"success\",\"msg\":\"添加成功\",\"id\":\"" + id + "\"}");
    }

    @RequestMapping("/deleteBasCustomQuestion")
    public void deleteBasCustomQuestion(
            String id, HttpServletRequest request, HttpServletResponse response){
        BasCustomQuestionDO oModal = basCustomQuestionService.queryById(id);
        if(oModal == null){
            WebUtil.renderJson(response, "{\"status\":\"failed\",\"msg\":\"问题未找到\"}");
        }
        else{
            basCustomQuestionService.deleteBasCustomQuestion(id);
            WebUtil.renderJson(response, "{\"status\":\"success\",\"msg\":\"删除成功\"}");
        }
    }

    @RequestMapping("/updateCustomQuestion")
    public void updateCustomQuestion(
            BasCustomQuestionDO modal, HttpServletRequest request, HttpServletResponse response){
        BasCustomQuestionDO oModal = basCustomQuestionService.queryById(modal.getId());
        if(oModal == null){
            WebUtil.renderJson(response, "{\"status\":\"failed\",\"msg\":\"问题未找到\"}");
        }
        else{
            basCustomQuestionService.updateBasCustomQuestion(modal);
            WebUtil.renderJson(response, "{\"status\":\"success\",\"msg\":\"更新成功\"}");
        }
    }

//    @RequestMapping("/getCustomQuestion")
//    public String getCustomQuestion(Model model, String id){
//        BasCustomQuestionDO modal = basCustomQuestionService.queryById(id);
//        model.addAttribute("customQuestion", modal);
//        return "getCustomQuestion";
//    }
//
//    @RequestMapping("/listCustomQuestion")
//    public String listCustomQuestion(Model model){
//        List<BasCustomQuestionDO> list = basCustomQuestionService.queryAll();
//        model.addAttribute("list", list);
//        return "listCustomQuestion";
//    }
//
//    @RequestMapping("/addCustomQuestion")
//    public String addCustomQuestion(BasCustomQuestionDO modal){
//        basCustomQuestionService.addBasCustomQuestion(modal);
//        return "addCustomQuestion";
//    }
//
//    @RequestMapping("/deleteBasCustomQuestion")
//    public String deleteBasCustomQuestion(String id){
//        BasCustomQuestionDO oModal = basCustomQuestionService.queryById(id);
//        if(oModal == null){
//            basCustomQuestionService.deleteBasCustomQuestion(id);
//        }
//        return "deleteBasCustomQuestion";
//    }
//
//    @RequestMapping("/updateCustomQuestion")
//    public String updateCustomQuestion(BasCustomQuestionDO modal){
//        BasCustomQuestionDO oModal = basCustomQuestionService.queryById(modal.getId());
//        if(oModal == null){
//            basCustomQuestionService.updateBasCustomQuestion(modal);
//        }
//        return "updateCustomQuestion";
//    }
}
