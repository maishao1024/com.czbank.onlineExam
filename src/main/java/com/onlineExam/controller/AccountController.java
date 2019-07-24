package com.onlineExam.controller;

import com.onlineExam.common.QexzConst;
import com.onlineExam.dto.PageResult;
import com.onlineExam.exception.QexzWebError;
import com.onlineExam.model.Account;
import com.onlineExam.model.Contest;
import com.onlineExam.model.Grade;
import com.onlineExam.model.Subject;
import com.onlineExam.service.*;
import com.onlineExam.util.MD5;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    private static Log LOG = LogFactory.getLog(AccountController.class);

    @Autowired
    private AccountService accountService;
    @Autowired
    private PostService postService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private ContestService contestService;
    @Autowired
    private SubjectService subjectService;

    /**
     * 个人信息页面
     */
    @RequestMapping(value="/profile", method= RequestMethod.GET)
    public String profile(HttpServletRequest request, Model model) {
        Account currentAccount = (Account) request.getSession().getAttribute(QexzConst.CURRENT_ACCOUNT);
        if (currentAccount == null){
            return "redirect:/";
        }
        model.addAttribute(QexzConst.CURRENT_ACCOUNT, currentAccount);
        return "/user/profile";
    }

    /**
     * 更改密码页面
     */
    @RequestMapping(value="/password", method= RequestMethod.GET)
    public String password(HttpServletRequest request, Model model) {
        Account currentAccount = (Account) request.getSession().getAttribute(QexzConst.CURRENT_ACCOUNT);
        if (currentAccount == null) {
            //用户未登录直接返回首页面
            return "redirect:/";
        }
        model.addAttribute(QexzConst.CURRENT_ACCOUNT, currentAccount);
        return "/user/password";
    }

    /**
     * 考试记录页面
     */
    @RequestMapping(value="/myExam", method= RequestMethod.GET)
    public String myExam(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        Account currentAccount = (Account) request.getSession().getAttribute(QexzConst.CURRENT_ACCOUNT);
        if (currentAccount == null) {
            return "redirect:/";
        }
        Map<String, Object> data = gradeService.getGradesByStudentId(page, QexzConst.gradePageSize, currentAccount.getId());
        List<Grade> grades = (List<Grade>) data.get("grades");
        Set<Integer> contestIds = grades.stream().map(Grade::getContestId).collect(Collectors.toCollection(HashSet::new));
        List<Contest> contests = contestService.getContestsByContestIds(contestIds);
        List<Subject> subjects = subjectService.getSubjects();
        Map<Integer, String> subjectId2name = subjects.stream().
                collect(Collectors.toMap(Subject::getId, Subject::getName));
        for (Contest contest : contests) {
            contest.setSubjectName(subjectId2name.
                    getOrDefault(contest.getSubjectId(), "未知科目"));
        }
        Map<Integer, Contest> id2contest = contests.stream().
                collect(Collectors.toMap(Contest::getId, contest -> contest));
        for (Grade grade : grades) {
            grade.setContest(id2contest.get(grade.getContestId()));
        }
        model.addAttribute(QexzConst.DATA, data);
        model.addAttribute(QexzConst.CURRENT_ACCOUNT, currentAccount);
        return "/user/myExam";
    }

    /**
     * 更新密码
     */
    @RequestMapping(value = "/api/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public PageResult updatePassword(HttpServletRequest request, HttpServletResponse response) {
        PageResult pageResult = new PageResult();
        try {
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");
            String confirmNewPassword = request.getParameter("confirmNewPassword");
            String md5OldPassword = MD5.md5(QexzConst.MD5_SALT+oldPassword);
            String md5NewPassword = MD5.md5(QexzConst.MD5_SALT+newPassword);
            if (StringUtils.isNotEmpty(newPassword) && StringUtils.isNotEmpty(confirmNewPassword)
                    && !newPassword.equals(confirmNewPassword)) {
                return PageResult.fixedError(QexzWebError.NOT_EQUALS_CONFIRM_PASSWORD);
            }
            Account currentAccount = (Account) request.getSession().getAttribute(QexzConst.CURRENT_ACCOUNT);
            if (!currentAccount.getPassword().equals(md5OldPassword)) {
                return PageResult.fixedError(QexzWebError.WRONG_PASSWORD);
            }
            currentAccount.setPassword(md5NewPassword);
            boolean result = accountService.updateAccount(currentAccount);
            pageResult.setSuccess(result);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return PageResult.fixedError(QexzWebError.COMMON);
        }
        return pageResult;
    }

    /**
     * 更新个人信息
     */
    @RequestMapping(value = "/api/updateAccount", method = RequestMethod.POST)
    @ResponseBody
    public PageResult updateAccount(HttpServletRequest request, HttpServletResponse response) {
        PageResult pageResult = new PageResult();
        try {
            String phone = request.getParameter("phone");
            String qq = request.getParameter("qq");
            String email = request.getParameter("email");
            String description = request.getParameter("description");
            String avatarImgUrl = request.getParameter("avatarImgUrl");
            Account currentAccount = (Account) request.getSession().getAttribute(QexzConst.CURRENT_ACCOUNT);
            currentAccount.setPhone(phone);
            currentAccount.setQq(qq);
            currentAccount.setEmail(email);
            currentAccount.setDescription(description);
            currentAccount.setAvatarImgUrl(avatarImgUrl);
            boolean result = accountService.updateAccount(currentAccount);
            pageResult.setSuccess(result);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return PageResult.fixedError(QexzWebError.COMMON);
        }
        return pageResult;
    }

    /**
     * 验证登录
     */
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    @ResponseBody
    public PageResult login(HttpServletRequest request, HttpServletResponse response) {
        PageResult pageResult = new PageResult();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Account current_account = accountService.getAccountByUsername(username);
            if(current_account != null) {
                String pwd = MD5.md5(QexzConst.MD5_SALT+password);
                if(pwd.equals(current_account.getPassword())) {
                    request.getSession().setAttribute(QexzConst.CURRENT_ACCOUNT,current_account);
                    pageResult.setData(current_account);
                } else {
                    return PageResult.fixedError(QexzWebError.WRONG_PASSWORD);
                }
            } else {
                return PageResult.fixedError(QexzWebError.WRONG_USERNAME);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return PageResult.fixedError(QexzWebError.COMMON);
        }
        return pageResult;
    }

    /**
     * 用户退出
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout", method= RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().setAttribute(QexzConst.CURRENT_ACCOUNT,null);
        String url=request.getHeader("Referer");
        LOG.info("url = " + url);
        return "redirect:"+url;
    }

    /**
     * API:添加用户
     */
    @RequestMapping(value="/api/addAccount", method= RequestMethod.POST)
    @ResponseBody
    public PageResult addAccount(@RequestBody Account account) {
        PageResult pageResult = new PageResult();
        Account existAccount = accountService.getAccountByUsername(account.getUsername());
        if(existAccount == null) {//检测该用户是否已经注册
            account.setPassword(MD5.md5(QexzConst.MD5_SALT+account.getPassword()));
            account.setAvatarImgUrl(QexzConst.DEFAULT_AVATAR_IMG_URL);
            account.setDescription("");
            int accountId = accountService.addAccount(account);
            return new PageResult().setData(accountId);
        }
        return PageResult.fixedError(QexzWebError.AREADY_EXIST_USERNAME);
    }

    /**
     * API:更新用户
     */
    @RequestMapping(value="/api/updateManegeAccount", method= RequestMethod.POST)
    @ResponseBody
    public PageResult updateAccount(@RequestBody Account account) {
        PageResult pageResult = new PageResult();
        account.setPassword(MD5.md5(QexzConst.MD5_SALT+account.getPassword()));
        boolean result = accountService.updateAccount(account);
        return new PageResult().setData(result);
    }

    /**
     * API:删除用户
     */
    @DeleteMapping("/api/deleteAccount/{id}")
    @ResponseBody
    public PageResult deleteAccount(@PathVariable int id) {
        PageResult pageResult = new PageResult();
        boolean result = accountService.deleteAccount(id);
        return new PageResult().setData(result);
    }

    /**
     * API:禁用账号
     */
    @RequestMapping(value="/api/disabledAccount/{id}", method= RequestMethod.POST)
    @ResponseBody
    public PageResult disabledAccount(@PathVariable int id) {
        PageResult pageResult = new PageResult();
        boolean result = accountService.disabledAccount(id);
        return new PageResult().setData(result);
    }

    /**
     * API:解禁账号
     */
    @RequestMapping(value="/api/abledAccount/{id}", method= RequestMethod.POST)
    @ResponseBody
    public PageResult abledAccount(@PathVariable int id) {
        PageResult pageResult = new PageResult();
        boolean result = accountService.abledAccount(id);
        return new PageResult().setData(result);
    }


}
