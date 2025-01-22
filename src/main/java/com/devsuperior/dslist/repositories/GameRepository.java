package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;

// Objeto responsável por fazer consultas no Baco de Dados

public interface GameRepository extends JpaRepository<Game, Long> { // Importar as bibliotecas acima

}
