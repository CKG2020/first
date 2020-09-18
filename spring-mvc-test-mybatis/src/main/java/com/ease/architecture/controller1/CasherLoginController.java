package com.ease.architecture.controller1;

import com.ease.architecture.entity1.Casher;
import com.ease.architecture.service1.CasherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CasherLoginController {

   @Autowired
   private CasherServiceImpl casherService;



    @RequestMapping(value = "casher_login", method = RequestMethod.GET)
    public String login(){
        return "casherlogin";
    }

    @RequestMapping(value = "cahser_check", method = RequestMethod.POST)
    @ResponseBody
    public String student_login(@RequestParam String name, String pwd) {

        Casher casher = casherService.findUserByNameAndPassword(name,pwd);

        if (null != casher && !"".equals(casher)) {

            return "success";
        }

        return "0";

    }

}
