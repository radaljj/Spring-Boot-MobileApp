package com.gpch.login.controller;


import com.gpch.login.model.Telefon;
import com.gpch.login.service.TelefonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Kontroler {

    @Autowired
    TelefonService service;





    @GetMapping("/list")
    public ModelAndView courseList(){
          ModelAndView model =new ModelAndView();
        List<Telefon> courseList = service.getAllTelefon();
          model.addObject("courseLists",courseList);
          model.setViewName("course_list");
        return model;
    }

    @GetMapping("/lista")
    public ModelAndView pretraga(@Param("keyword") String keyword){
        ModelAndView model =new ModelAndView();
        List<Telefon> courseList = service.pretraga(keyword);
        model.addObject("keyword", keyword);
        model.addObject("courseLists",courseList);
        model.setViewName("course_list");
        return model;
    }



    @GetMapping("/admin/addCoursePage")
    public ModelAndView addCoursePage(){

          Telefon telefon = new Telefon();
          ModelAndView modelAndView = new ModelAndView();
          modelAndView.addObject("courseForm",telefon);
          modelAndView.setViewName("admin/form");
        return modelAndView;
    }



    @PostMapping("/admin/addCourse")
    public ModelAndView addCourse(@ModelAttribute("courseForm") Telefon telefon){

          service.saveTelefon(telefon);
        return new ModelAndView("redirect:/admin/home");
    }


    @GetMapping("/deleteCourse/{c_id}")
    public ModelAndView deleteCourse(@PathVariable("c_id") int id){

          service.deleteTelefon(id);
        return new ModelAndView("redirect:/admin/home");
    }


    @GetMapping("/updateCourse/{c_id}")
    public ModelAndView updateCourse(@PathVariable("c_id") int id){
          ModelAndView model =new ModelAndView();
          Telefon telefon = service.getTelefonById(id);
          model.addObject("courseForm", telefon);
          model.setViewName("admin/form");

        return model;
    }







}
