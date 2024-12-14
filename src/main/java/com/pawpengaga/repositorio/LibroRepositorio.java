package com.pawpengaga.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pawpengaga.modelo.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {

  // Consulta personalizada aplicada a método JPA pre existente
  @Query(value = "SELECT * FROM libro ORDER BY id DESC", nativeQuery = true)
  List<Libro> findAll();

  Libro findByIsbn(String isbn);

}
