package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    /*
        localhost:8080/prova?nome=Marco
     */
    @RequestMapping(value = "/prova", method = RequestMethod.GET)
    @ResponseBody
    public String prova(@RequestParam(name= "nome") String nome) {
        return "Il tuo nome è "+nome;
    }

    /*
        localhost:8080/prova/19
    */
    @RequestMapping(value = "/prova/{age}", method = RequestMethod.GET)
    @ResponseBody
    public String prova2(@PathVariable(name= "age") String age) {
        return "Hai "+age+" anni";
    }
}
