package com.example.springjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatsControlelr {

    @Autowired
    private ChatsRepository repository;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/{id}")
    public String submit(@PathVariable("id") Integer id) {

        List<Chats> list = repository.find(1);
        return "success";
    }

}
