package com.sample.boot.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class SampleController {
    @Autowired
    PlaceDataRepository repository;

    @PostConstruct
    public void init() {
        repository.saveAndFlush(new PlaceData("Shinjuku", "Tokyo", "160-0022"));
        repository.saveAndFlush(new PlaceData("Atami", "Shizuoka", "413-0033"));
        repository.saveAndFlush(new PlaceData("Sakura", "Chiba", "285-0025"));
    }

    @RequestMapping("/")
    public ModelAndView sample(ModelAndView mv) {
        List<PlaceData> list = (List<PlaceData>) repository.findAll();
        mv.addObject("list", list);
        mv.setViewName("sample");
        return mv;
    }
}
