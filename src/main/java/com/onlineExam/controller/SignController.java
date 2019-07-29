package com.onlineExam.controller;

import com.onlineExam.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SignController {

    @Autowired
    private SignService signService;

}
