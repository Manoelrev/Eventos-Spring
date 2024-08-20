package com.estudos.hellospring.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexControle {

    @RequestMapping("/")
    public String getMethodName() {
        return "web/index";
    }
    
}
