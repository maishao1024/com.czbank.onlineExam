package com.onlineExam.controller;

import com.onlineExam.dto.DataResult;
import com.onlineExam.dto.SimpleResult;
import com.onlineExam.exception.ERRORCODE;
import com.onlineExam.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private PaperService paperService;

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult submitPaper(HttpServletRequest request){
        try {
            String paperId = request.getParameter("paperId");
            String answer = request.getParameter("answer");
            String questionNo = request.getParameter("questionNo");
            String userId = request.getParameter("id");
            paperService.submitPaper(userId, paperId, answer, questionNo);
        }catch (Exception e){
            return new SimpleResult(ERRORCODE.COMMON);
        }
        return new SimpleResult();
    }

    @RequestMapping(value = "/history",method = RequestMethod.POST)
    @ResponseBody
    public DataResult paperHistory(HttpServletRequest request){
        String title = request.getParameter("title");
        return paperService.paperHistory(title);
    }
}
