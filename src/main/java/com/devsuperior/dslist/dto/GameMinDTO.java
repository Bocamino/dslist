package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

// Nessa Classe, vamos apenas deixar as poucas informações que queremos exibir
public class GameMinDTO {
	
		private Long id;
		private String title;		
		private Integer year;		
		private String imgUrl;		
		private String shortDescription;		
				
		public GameMinDTO() {
			
		}
		
		// Logo abaixo, em "public GameMinDTO", seu parâmetro "(Long id, String title, Integer year, String imgUrl, String shortDescription)" foi deletado
		// O intuito é ele receber/copiar os dados da Entidade
		public GameMinDTO(Game entity) { // Deve importar sua biblioteca
			this.id = entity.getId();
			this.title = entity.getTitle();
			this.year = entity.getYear();
			this.imgUrl = entity.getImgUrl();
			this.shortDescription = entity.getShortDescription();
			// Pode também remover os "this." acima, pois não há ambiguigade no parâmetro 
		}
		
		public GameMinDTO(GameMinProjection projection) {
			this.id = projection.getId();
			this.title = projection.getTitle();
			this.year = projection.getGameYear();
			this.imgUrl = projection.getImgUrl();
			this.shortDescription = projection.getShortDescription();
		}

		public Long getId() {
			return id;
		}

		public String getTitle() {
			return title;
		}

		public Integer getYear() {
			return year;
		}

		public String getImgUrl() {
			return imgUrl;
		}

		public String getShortDescription() {
			return shortDescription;
		}

		
	
}
