//package com.onlineExam.controller;
//
//import com.onlineExam.dto.DataResult;
//import com.onlineExam.model.Contest;
//import com.onlineExam.service.ContestService;
//import com.onlineExam.service.QuestionService;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(value = "/contest")
//public class ContestController {
//
//    private static Log LOG = LogFactory.getLog(ContestController.class);
//
//    @Autowired
//    private ContestService contestService;
//    @Autowired
//    private QuestionService questionService;
//
//    //添加考试
//    @RequestMapping(value="/api/addContest", method= RequestMethod.POST)
//    @ResponseBody
//    public DataResult addContest(@RequestBody Contest contest) {
//        DataResult pageResult = new DataResult();
//        int contestId = contestService.addContest(contest);
//        return new DataResult().setData(contestId);
//    }
//
//    //更新考试信息
//    @RequestMapping(value="/api/updateContest", method= RequestMethod.POST)
//    @ResponseBody
//    public DataResult updateContest(@RequestBody Contest contest) {
//        DataResult pageResult = new DataResult();
//        boolean result = contestService.updateContest(contest);
//        return new DataResult().setData(result);
//    }
//
//    //删除考试信息
//    @DeleteMapping("/api/deleteContest/{id}")
//    public DataResult deleteContest(@PathVariable int id) {
//        DataResult pageResult = new DataResult();
//        boolean result = contestService.deleteContest(id);
//        return new DataResult().setData(result);
//    }
//
//    //完成考试批改
//    @RequestMapping(value="/api/finishContest/{id}", method= RequestMethod.POST)
//    @ResponseBody
//    public DataResult finishContest(@PathVariable int id) {
//        DataResult pageResult = new DataResult();
//        Contest contest = contestService.getContestById(id);
//        contest.setState(3);
//        questionService.updateQuestionsStateByContestId(id, 1);
//        boolean result = contestService.updateContest(contest);
//        return new DataResult().setData(result);
//    }
//
//
//
//
//}
