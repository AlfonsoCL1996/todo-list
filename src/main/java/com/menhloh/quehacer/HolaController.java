package com.menhloh.quehacer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HolaController {
    
    @GetMapping("/Hola")
    public String hola() {
        return "hola mundo!";
    }
    
}
