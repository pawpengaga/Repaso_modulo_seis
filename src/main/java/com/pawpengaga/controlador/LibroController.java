package com.pawpengaga.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pawpengaga.modelo.Libro;
import com.pawpengaga.servicio.LibroServicio;

@Controller
@RequestMapping("/libros")
public class LibroController {

  @Autowired
  LibroServicio libroService;

  /* ************** METODOS DE VISTAS ************** */

  @GetMapping
  public String index(Model model){
    List<Libro> libros = libroService.getAllLibros();
    model.addAttribute("libros", libros);
    return "libros/index";
  }

  @GetMapping("/nuevo")
  public String form(Model model){
    return "libros/form";
  }

  @PostMapping("/nuevo")
  public String grabaLibro(@ModelAttribute Libro libro, Model model){
    libroService.grabarLibro(libro);
    return "redirect:/libros/index";
  }

}