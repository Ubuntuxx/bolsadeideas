package com.example.demo.controllers;

import com.example.demo.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @GetMapping({"/index", "/home"})
    public String index(Model model) {
        model.addAttribute("titulo", "Bienvenido a spring");
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setApellido("Amador");
        usuario.setNombre("Luis");
        usuario.setEmail("ianodf@corre.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Datos del usuario: " + usuario.getNombre());
        return "perfil";
    }


    @GetMapping("/listar")
    public String listar(Model model) {
        Usuario usuario = new Usuario();
        usuario.setApellido("Amador");
        usuario.setNombre("Luis");
        usuario.setEmail("ianodf@corre.com");

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Gonzalo", "Amador", "gon@corre.com"));
        usuarios.add(new Usuario("Pablo", "Amador", "gon@corre.com"));
        usuarios.add(new Usuario("Pedro", "Amador", "gon@corre.com"));

        model.addAttribute("usuarios", usuarios);
        model.addAttribute("titulo", "listado de usuarios usuario: " + usuario.getNombre());
        return "listar";
    }
}
