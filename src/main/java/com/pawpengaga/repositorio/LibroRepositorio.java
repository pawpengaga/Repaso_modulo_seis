package com.pawpengaga.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawpengaga.modelo.Libro;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {

  Libro findByIsbn(String isbn);

}
