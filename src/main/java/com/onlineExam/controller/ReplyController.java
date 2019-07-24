package com.qexz.controller;

import com.qexz.dto.PageResult;
import com.qexz.model.Reply;
import com.qexz.service.ReplyService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/reply")
public class ReplyController {

    private static Log LOG = LogFactory.getLog(ReplyController.class);

    @Autowired
    private ReplyService replyService;

    //添加回复
    @RequestMapping(value="/api/addReply", method= RequestMethod.POST)
    @ResponseBody
    public PageResult addReply(@RequestBody Reply reply) {
        PageResult pageResult = new PageResult();
        int replyId = replyService.addReply(reply);
        return new PageResult().setData(replyId);
    }
}
