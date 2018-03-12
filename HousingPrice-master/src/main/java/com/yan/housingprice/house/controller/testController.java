package com.yan.housingprice.house.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yan.housingprice.house.interservice.intertest;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping(value = "/test")
public class testController {

    @Autowired
    private intertest intertest;

    @GetMapping("/house")
    public ModelAndView getHouseInfo(){
        try {
            Map<String,Integer> data=intertest.returnhouseprice();
            ModelAndView modelAndView=new ModelAndView("test/test");
            modelAndView.addObject("data",data);
            return modelAndView;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
