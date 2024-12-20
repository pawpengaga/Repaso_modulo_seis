package com.pawpengaga.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawpengaga.modelo.Libro;
import com.pawpengaga.repositorio.LibroRepositorio;

@Service
public class LibroServicio {

  @Autowired
  LibroRepositorio libroRepo;

  /* ****************** METODOS QUE IMPLEMENTAN ****************** */

  /**
   * Metodo usado por POST
   */
  public Libro grabarLibro(Libro libro){
    Libro savedLibro = libroRepo.save(libro);
    System.out.println("LIBRO GUARDADO EN BASE DE DATOS");
    return savedLibro;
  }

  /**
   * Metodo usado por GET
   */
  public Libro getLibro(String isbn){
    return libroRepo.findByIsbn(isbn);
  }

  /**
   * Metodo usado por GET
   */
  public List<Libro> getAllLibros(){
    return libroRepo.findAllByIdDesc();
  }



}
