package com.sky.ham.controller;

import com.sky.ham.entity.Songer;
import com.sky.ham.service.SingerService;
import com.sky.ham.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/singer")
public class SingerController {
    @Resource
    private SingerService singerService;

    @RequestMapping(value = "/list")
    public String singers(@ModelAttribute Songer songer, @RequestParam(value = "currentNo", required = false) String currentNo, Model model) {

        final Integer pageSize = 6;

        Integer startNo = 1;
        if (currentNo != null) {
            startNo = Integer.parseInt(currentNo.trim());
        }
        List<Songer> songers = singerService.querySingersInfos(songer, startNo, pageSize);
        Page page = new Page();
        page.setCurrentPage(startNo);
        page.setPageSize(pageSize);
        page.setTotalCount(singerService.querySingerCount(songer));
        int pageCount = page.getPageCount();

        model.addAttribute("singers", songers);
        model.addAttribute("currentNo", startNo);
        model.addAttribute("totalPageCount", pageCount);
        return "/singer";
    }
}
