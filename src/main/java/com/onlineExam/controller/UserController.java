package com.onlineExam.controller;

import com.onlineExam.dto.DataResult;
import com.onlineExam.dto.SimpleResult;
import com.onlineExam.exception.ERRORCODE;
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
//    @Autowired
//    private PostService postService;
//    @Autowired
//    private GradeService gradeService;
//    @Autowired
//    private ContestService contestService;
//    @Autowired
//    private SubjectService subjectService;
//
//    /**
//     * 个人信息页面
//     */
//    @RequestMapping(value="/profile", method= RequestMethod.GET)
//    public String profile(HttpServletRequest request, Model model) {
//        User currentUser = (User) request.getSession().getAttribute(QexzConst.CURRENT_ACCOUNT);
//        if (currentUser == null){
//            return "redirect:/";
//        }
//        model.addAttribute(QexzConst.CURRENT_ACCOUNT, currentUser);
//        return "/user/profile";
//    }
//
//
    /**
     * 我的成绩
     */
    @RequestMapping(value="/myExam", method= RequestMethod.POST)
    @ResponseBody
    public DataResult myExam(HttpServletRequest request) {
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            String username = request.getParameter("username");
            return userService.getMyAchievement(id,username);
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

//    /**
//     * 用户退出
//     * @param request
//     * @return
//     */
//    @RequestMapping(value = "/logout", method= RequestMethod.GET)
//    public String logout(HttpServletRequest request) {
//        request.getSession().setAttribute(QexzConst.CURRENT_ACCOUNT,null);
//        String url=request.getHeader("Referer");
//        LOG.info("url = " + url);
//        return "redirect:"+url;
//    }
//
//    /**
//     * API:添加用户
//     */
//    @RequestMapping(value="/api/addAccount", method= RequestMethod.POST)
//    @ResponseBody
//    public DataResult addAccount(@RequestBody User user) {
//        DataResult pageResult = new DataResult();
//        User existUser = userService.getAccountByUsername(user.getUsername());
//        if(existUser == null) {//检测该用户是否已经注册
//            user.setPassword(MD5.md5(QexzConst.MD5_SALT+ user.getPassword()));
//            user.setAvatarImgUrl(QexzConst.DEFAULT_AVATAR_IMG_URL);
//            user.setDescription("");
//            int accountId = userService.addAccount(user);
//            return new DataResult().setData(accountId);
//        }
//        return DataResult.fixedError(ERRORCODE.AREADY_EXIST_USERNAME);
//    }
//
//    /**
//     * API:更新用户
//     */
//    @RequestMapping(value="/api/updateManegeAccount", method= RequestMethod.POST)
//    @ResponseBody
//    public DataResult updateAccount(@RequestBody User user) {
//        DataResult pageResult = new DataResult();
//        user.setPassword(MD5.md5(QexzConst.MD5_SALT+ user.getPassword()));
//        boolean result = userService.updateAccount(user);
//        return new DataResult().setData(result);
//    }
//
//    /**
//     * API:删除用户
//     */
//    @DeleteMapping("/api/deleteAccount/{id}")
//    @ResponseBody
//    public DataResult deleteAccount(@PathVariable int id) {
//        DataResult pageResult = new DataResult();
//        boolean result = userService.deleteAccount(id);
//        return new DataResult().setData(result);
//    }
//
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
