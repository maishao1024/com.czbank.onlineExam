package com.onlineExam.controller;

import com.onlineExam.dto.DataResult;
import com.onlineExam.dto.SimpleResult;
import com.onlineExam.exception.ERRORCODE;
import com.onlineExam.service.SignService;
import com.onlineExam.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * create by zdk on 19/7/23
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static Log LOG = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private SignService signService;

    /**
     * 个人签到
     */
    @RequestMapping(value="/sign", method= RequestMethod.POST)
    @ResponseBody
    public SimpleResult sign(HttpServletRequest request) {
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            return signService.sign(id);
        }catch (Exception e){
            return new SimpleResult(ERRORCODE.COMMON);
        }
    }


    /**
     * 我的成绩
     */
    @RequestMapping(value="/myExam", method= RequestMethod.POST)
    @ResponseBody
    public DataResult myExam(HttpServletRequest request) {
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            String username = request.getParameter("username");
            String title = request.getParameter("title");
            return userService.getMyAchievement(id,username,title);
        }catch (Exception e){
            return DataResult.fixedError(ERRORCODE.COMMON);
        }

    }

    /**
     * 更新密码
     */
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    @ResponseBody
    public DataResult updatePassword(HttpServletRequest request) {
        DataResult dataResult;
        try {
            String oldPassword = request.getParameter("password");
            String newPassword = request.getParameter("newPassword");
            String jobNo = request.getParameter("jobNo");
            dataResult = userService.changePassword(jobNo,oldPassword,newPassword);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return DataResult.fixedError(ERRORCODE.COMMON);
        }
        return dataResult;
    }

    /**
     * 更新个人信息
     */
    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult updateAccount(HttpServletRequest request) {
        SimpleResult simpleResult = new SimpleResult();
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            String jobNo = request.getParameter("jobNo");
            String userName = request.getParameter("userName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String wxNo = request.getParameter("wxNo");
            String department = request.getParameter("department");
            return userService.updateUser(id,jobNo,userName,phone,wxNo,email,department);
        } catch (Exception e) {
            simpleResult.setSuccess(false);
            simpleResult.setResMsg(ERRORCODE.COMMON.errMsg);
        }
        return simpleResult;
    }

    /**
     * 验证登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public DataResult login(HttpServletRequest request) {
            try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            return userService.validateUser(username,password);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return DataResult.fixedError(ERRORCODE.COMMON);
        }
    }

    /**
     * 用户注册
     * @param request
     * @return
     */
    @RequestMapping(value = "/register", method= RequestMethod.POST)
    @ResponseBody
    public SimpleResult register(HttpServletRequest request) {
        try {
            String jobNo = request.getParameter("jobNo");
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("passWord");
            return userService.register(jobNo,userName,passWord);
        }catch (Exception e){
            return new SimpleResult(ERRORCODE.COMMON);
        }
    }

    /**
     * 用户列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/userList", method= RequestMethod.POST)
    @ResponseBody
    public DataResult userList(HttpServletRequest request) {
        try {
            String jobNo = request.getParameter("jobNo");
            String userName = request.getParameter("userName");
            String department = request.getParameter("department");
            return userService.getUserList(jobNo,userName,department);
        }catch (Exception e){
            return DataResult.fixedError(ERRORCODE.COMMON);
        }
    }



    /**
     * API:删除用户
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public DataResult deleteUser(HttpServletRequest request) {
        try {
            String jobNo = request.getParameter("jobNo");
            return userService.deleteUser(jobNo);
        }catch (Exception e){
            return new DataResult().fixedError(ERRORCODE.COMMON);
        }
    }

//    /**
//     * API:禁用账号
//     */
//    @RequestMapping(value="/api/disabledAccount/{id}", method= RequestMethod.POST)
//    @ResponseBody
//    public DataResult disabledAccount(@PathVariable int id) {
//        DataResult pageResult = new DataResult();
//        boolean result = userService.disabledAccount(id);
//        return new DataResult().setData(result);
//    }
//
//    /**
//     * API:解禁账号
//     */
//    @RequestMapping(value="/api/abledAccount/{id}", method= RequestMethod.POST)
//    @ResponseBody
//    public DataResult abledAccount(@PathVariable int id) {
//        DataResult pageResult = new DataResult();
//        boolean result = userService.abledAccount(id);
//        return new DataResult().setData(result);
//    }


}
