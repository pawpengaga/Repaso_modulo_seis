package com.pawpengaga.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // Lombok
@AllArgsConstructor // Lombok
@Data // Lombok
@Entity // Declara este objeto como una tabla de base de datos
public class Libro {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Lo mismo que `id SERIAL PRIMARY KEY` en SQL
  private Long id;

  @Column(unique = true) // Lo mismo que `isbn VARCHAR(cualquier_numero) UNIQUE` en SQL
  private String isbn;

  private String titulo;
  private String descripcion;

}
