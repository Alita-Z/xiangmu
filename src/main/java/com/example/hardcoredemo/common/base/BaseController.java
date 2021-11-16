package com.example.hardcoredemo.common.base;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/base")
@RestController
public class BaseController extends ParentBaseController{

    @GetMapping(value = "/init1")
    public String init(HttpServletRequest request) throws Exception {
        return "1";
    }

    @GetMapping(value = "/init2")
    public String init0(HttpServletRequest request) throws Exception {
        return "2";
    }
}
