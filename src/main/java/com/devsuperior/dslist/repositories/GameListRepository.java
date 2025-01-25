package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.GameList;

// Objeto responsável por fazer consultas no Baco de Dados

public interface GameListRepository extends JpaRepository<GameList, Long> { // Importar as bibliotecas acima

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
	
}
