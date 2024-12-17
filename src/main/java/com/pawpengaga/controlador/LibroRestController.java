package com.pawpengaga.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pawpengaga.modelo.Libro;
import com.pawpengaga.servicio.LibroServicio;

@RestController
@RequestMapping("/api/libros")
public class LibroRestController {

  @Autowired
  LibroServicio libroService;

  /* ************** METODOS DE VISTAS ************** */

  @GetMapping
  public List<Libro> index(Model model){
    List<Libro> libros = libroService.getAllLibros();
    return libros;
  }

  // @GetMapping("/nuevo")
  // public String form(Model model){
  //   return "libros/form";
  // }

  @PostMapping("/nuevo")
  public Libro grabaLibro(@RequestBody Libro libro, Model model, RedirectAttributes redirect){
    Libro saved = libroService.grabarLibro(libro);
    return saved;
  }

}
