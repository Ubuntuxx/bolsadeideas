package com.example.demo.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class RequestParams {

    @GetMapping("/requestParam")
    public String param(@RequestParam(name = "texto", required = false, defaultValue = "algun valor") String texto, Model model) {
        model.addAttribute("resultado", "El resultado es: " + texto);
        return "params";
    }


    @GetMapping("/httpservlett")
    public String params(HttpServletRequest request, Model model) {
        Integer numero;
        String saludo = request.getParameter("saludo");
        try {
            numero = Integer.valueOf(request.getParameter("numero"));
        } catch( NumberFormatException e){
            numero = 0;
        }
        model.addAttribute("resultado", "El saludo enviado es: " + saludo + " - numero: " + numero);
        return "params";
    }
}
