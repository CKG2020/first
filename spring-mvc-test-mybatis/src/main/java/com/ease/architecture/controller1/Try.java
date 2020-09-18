package com.ease.architecture.controller1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Try {
    @RequestMapping(value = "first", method = RequestMethod.GET)
    public String registryPage() {

        return "bindexcash";
    }
}
