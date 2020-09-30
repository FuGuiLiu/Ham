package com.sky.ham.controller;

import com.alibaba.fastjson.JSON;
import com.sky.ham.entity.MType;
import com.sky.ham.entity.Songer;
import com.sky.ham.service.MTypeService;
import com.sky.ham.service.SingerService;
import com.sky.ham.util.FileDeletion;
import com.sky.ham.util.Page;
import com.sky.ham.util.PropUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.*;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/singer")
public class SingerController {
    @Resource
    private SingerService singerService;

    @Resource
    private MTypeService mTypeService;

    @RequestMapping("/list")
    public String singerLists(@ModelAttribute(value = "songer") Songer songer, BindingResult result, String currentNo, Model model) {
        if (result.hasErrors()) {
            return "/songer";
        }
//        定义页面显示量
        final Integer pageSize = 5;
//        设置页面起始页
        Integer startNo = 1;

//        如果传入的当前页数不为空的话,就设置当前的页数
        if (currentNo != null) {
            startNo = Integer.parseInt(currentNo);
        }

//        根据条件获取歌手信息
        List<Songer> songers = singerService.querySingersInfos(songer, startNo, pageSize);
        if (songer.getSRNAME() != null) {
            model.addAttribute("SRNAME", songer.getSRNAME());
        }
        if (songer.getAREA() != null) {
            model.addAttribute("AREA", songer.getAREA());
        }
        if (songer.getTID() != null) {
            model.addAttribute("TID", songer.getTID());
        }

//        分页信息
        Page page = new Page();
        page.setCurrentPage(startNo);
        page.setPageSize(pageSize);
        page.setTotalCount(singerService.querySingerCount(songer));
        Integer totalPageCount = page.getPageCount();
//        获取歌手唱歌风格
        List<MType> mTypes = mTypeService.queryMTypeInfos();

//        controller to view 传输数据
        model.addAttribute("songers", songers);
        model.addAttribute("currentNo", startNo);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("mtypes", mTypes);
        return "/songer";
    }

    @RequestMapping(value = "/addSinger", method = RequestMethod.GET)
    public String addSinger(Model model) {
        List<MType> mTypes = mTypeService.queryMTypeInfos();
        model.addAttribute("mtypes", mTypes);
        return "/addSonger";
    }

    @RequestMapping(value = "/addSinger", method = RequestMethod.POST)
    public String addSinger(@Validated @ModelAttribute("Songer") Songer songer, BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "/mistake";
        } else {
            Integer integer = singerService.addSingerInfo(songer);
            if (integer == 1) {
                return "redirect:/singer/list.go";
            } else {
                model.addAttribute("error", "添加失败");
                return "/mistake";
            }
        }
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadFile(MultipartFile picfile, HttpServletRequest request, String lastImg, Model model) {
        if (picfile != null) {
            HttpSession session = request.getSession();
//            获取文件后缀
            String fileExtension = FilenameUtils.getExtension(picfile.getOriginalFilename());
//            获取根路径
            String rootPath = PropUtil.read("localPicturesPath");
            //获取相对路径
            String relativePath = UUID.randomUUID().toString().replace("-", "") + "." + fileExtension;

//            获取全路径
            String fullPath = rootPath + relativePath;

            Client client = Client.create();

            if (lastImg != null && !"".equals(lastImg)) {
                WebResource webResource = client.resource(lastImg);
                webResource.delete();
            }

            WebResource resource = client.resource(fullPath);
            try {
                byte[] bytes = picfile.getBytes();
                resource.put(bytes);
            } catch (Exception e) {
                e.printStackTrace();
                return "error";
            }

            Map<String, String> pathMap = new HashMap<>();
            pathMap.put("realPath", fullPath);
            pathMap.put("relativePath", relativePath);
            return JSON.toJSONString(pathMap);
        } else {
            return "";
        }
    }

    @RequestMapping(value = "/change", method = RequestMethod.GET)
    public String change(@RequestParam(value = "SRID") String srid, Model model) {
        if (srid != null) {
            Songer songer = singerService.selectSingerInfo(Integer.parseInt(srid));
            model.addAttribute("SRID", Integer.parseInt(srid));
            model.addAttribute("songer", songer);
            model.addAttribute("mtypes", mTypeService.queryMTypeInfos());
            model.addAttribute("isUpdate", "update");
        }
        return "/addSonger";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateSonger(@Validated @ModelAttribute("Songer") Songer songer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "/mistake";
        } else {
            Integer integer = singerService.updateSingerInfo(songer, songer.getSRID());

            if (integer == 1) {
                return "/redirect:/singer/list.go";
            }
            return "/songer";
        }
    }

    @RequestMapping(value = "/delete")
    public String deleteSonger(@RequestParam(value = "SRID") String SRID, Model model, HttpServletRequest request) {
        if (SRID != null) {
            FileDeletion.FileHelper.removeFile(request.getSession().getServletContext().getRealPath("/") + singerService.querySingerInfoBySID(Integer.parseInt(SRID)).getPIC());
            Integer integer = singerService.deleteSingerInfo(Integer.parseInt(SRID));
            if (integer == 1) {

                return "redirect:/singer/list.go";
            } else {
                model.addAttribute("error", "删除失败");
                return "/mistake";
            }
        }
        return "redirect:/singer/list.go";
    }
}
