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
@RequestMapping("/libros") // SE REFIERE AL ENDOPOINT
public class LibroController {

  @Autowired
  LibroServicio libroService;

  /* ************** METODOS DE VISTAS ************** */

  @GetMapping
  public String index(Model model){
    List<Libro> libros = libroService.getAllLibros();
    model.addAttribute("libros", libros);
    return "libros/index"; // SE REFIERE A UN ARCHIVO FISICO
  }

  @GetMapping("/nuevo") // SE REFIERE AL ENDOPOINT
  public String form(Model model){
    return "libros/form"; // SE REFIERE A UN ARCHIVO FISICO
  }

  @PostMapping("/nuevo") // SE REFIERE AL ENDOPOINT
  public String grabaLibro(@ModelAttribute Libro libro, Model model){
    libroService.grabarLibro(libro);
    return "redirect:/libros/index"; // SE REFIERE A UN ARCHIVO FISICO
  }

}