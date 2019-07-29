package com.onlineExam.controller;

import com.onlineExam.dto.DataResult;
import com.onlineExam.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/achievement")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @RequestMapping(value = "/getAchievements",method = RequestMethod.POST)
    @ResponseBody
    public DataResult getAchievements(HttpServletRequest request){
        try {
            String jobNo = request.getParameter("jobNo");
            String userName = request.getParameter("userName");
            String achievement = request.getParameter("achievement");
            return achievementService.getAchievements(jobNo,userName,achievement);
        }catch (Exception e){

        }
        return new DataResult();
    }

}
