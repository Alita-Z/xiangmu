package com.example.hardcoredemo.common.base;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/")
@RestController
public class ParentBaseController {

    @GetMapping(value = "/init")
    public String init(HttpServletRequest request) throws Exception {
        return "0";
    }
}
