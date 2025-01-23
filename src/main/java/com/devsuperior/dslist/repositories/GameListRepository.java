package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.GameList;

// Objeto responsável por fazer consultas no Baco de Dados

public interface GameListRepository extends JpaRepository<GameList, Long> { // Importar as bibliotecas acima

}
