package com.devsuperior.dslist.services;

// Por padrão, todas as bibliotecas abaixo foram inseridas com CTRO + SHIFT + O. Cada classe nova vai conter isso. Ai não fico me repetindo :)

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.devsuperior.dslist.dto.GameMinDTO;
//import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

//Serve para registrar um componente novo no sistema
@Service
public class GameService {

	// Injetar um GameRepository aqui no GameService
	@Autowired
	private GameRepository gameRepository;
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		// OU "return result.stream().map(x -> new GameMinDTO(x)).toList();"
	}		
	
	/*
	 * O Service acima vai devolver uma lista dos objetos "Min", como exmplo abaixo:
	 *  private Long id;
		private String title;		
		private Integer year;		
		private String imgUrl;		
		private String shortDescription;
	 */
	
}
