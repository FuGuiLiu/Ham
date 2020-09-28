package com.sky.ham.controller;


import com.sky.ham.entity.MType;
import com.sky.ham.service.MTypeService;
import com.sky.ham.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/mType")
public class MTypeController {

    @Resource
    private MTypeService mTypeService;

    @RequestMapping(value = "/login")
    public String goAnyWhere() {
        return "/login.jsp";
    }

    @RequestMapping(value = "/mType")
    public String querySchool(@RequestParam(value = "currentNo", required = false) String currentNo, @RequestParam(value = "TName", required = false) String TName, Model model) {
        //设置一个最终的页面量
        final int pageSize = 5;
        //声明默认起始页
        int startNo = 1;

        if (currentNo != null) {
            startNo = Integer.parseInt(currentNo);
        }

        List<MType> mTypes = new ArrayList<>();
        if (currentNo == null && TName == null) {
            mTypes = mTypeService.queryMTypesAndPagination(startNo, pageSize, null);
        } else {
            mTypes = mTypeService.queryMTypesAndPagination(startNo, pageSize, TName);
        }


        Page page = new Page();
        page.setCurrentPage(startNo);
//        设置页面量
        page.setPageSize(pageSize);
        //设置总记录数
        if (TName == null) {
            page.setTotalCount(mTypeService.queryMTypesCount(null));
        } else {
            page.setTotalCount(mTypeService.queryMTypesCount(TName));
        }

        //获取总页数
        int totalPageCount = page.getPageCount();

        model.addAttribute("mTypes", mTypes);
        model.addAttribute("currentNo", startNo);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("TName", TName);
        return "/mtype";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateMType(@ModelAttribute @Validated MType mType, BindingResult bindingResult, HttpSession session) {
        String updateResult = null;
        if (bindingResult.hasErrors()) {
            session.removeAttribute("updateError");
            session.setAttribute("updateError", "更新失败请填入正确的信息,且信息不能为空");
            return "error";
        }
        if (mType.getTID() != null) {
            updateResult = String.valueOf(mTypeService.updateMTypes(mType.getTID(), mType));
        }

        if (updateResult != null) {
            updateResult = "success";
        } else {
            updateResult = "error";
        }
        return updateResult;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addMType(@Validated @ModelAttribute MType mType, BindingResult bindingResult, HttpSession session) {
        String addResult = null;

        if (bindingResult.hasErrors()) {
            session.removeAttribute("addError");
            session.setAttribute("addError", "添加失败,请填入正确的内容且内容不能为空");
            return "error";
        }
        addResult = String.valueOf(mTypeService.insertMType(mType));

        if (addResult != null) {
            addResult = "success";
        } else {
            addResult = "error";
        }
        return addResult;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteMType(@ModelAttribute(value = "tid") String tid) {

        String deleteResult = null;
        if (tid.trim() != null) {
            deleteResult = String.valueOf(mTypeService.deleteMType(Integer.parseInt(tid)));
        }

        if (deleteResult != null) {
            deleteResult = "success";
        } else {
            deleteResult = "error";
        }
        return deleteResult;
    }

}
