package com.devsuperior.dslist.services;

// Por padrão, todas as bibliotecas abaixo foram inseridas com CTRO + SHIFT + O. Cada classe nova vai conter isso. Ai não fico me repetindo :)

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
//import com.devsuperior.dslist.dto.GameMinDTO;
//import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

//Serve para registrar um componente novo no sistema
@Service
public class GameListService {

	// Injetar um GameRepository aqui no GameService
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
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
	
	// Método para alterar a ordem das listas no Front end
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		// Remove um item de um certo Index (número) da lista (tira ele de uma posição)
		GameMinProjection obj = list.remove(destinationIndex);
		
		// Adiciona o item removido acima em um Index específico desejado
		list.add(destinationIndex, obj);
		
		// Criei o arquivo "PosicionamentoLista" na pasta, que ajuda explicar melhor o que foi feito
		
		// Encontra o Index MÍNIMO
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex; // "?" (ENTÃO)	":" (ELSE)
		
		// Encontra o Index MÁXIMO
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
	
}
