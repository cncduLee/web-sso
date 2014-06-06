package com.bitium10.sso.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class SystemErrorController {
    private static final Logger logger = LoggerFactory.getLogger(SystemErrorController.class);

    public static final String SYSTEM_ERROR = "redirect:/";
}
