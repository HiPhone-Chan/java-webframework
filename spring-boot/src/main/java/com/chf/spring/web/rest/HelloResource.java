package com.chf.spring.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chf.core.domain.Resp;

@RestController
@RequestMapping("/hello")
public class HelloResource {

    @RequestMapping(method = RequestMethod.GET)
    public Resp sayHello(@RequestParam(required = false) String name) {
        return new Resp(name);
    }

}
