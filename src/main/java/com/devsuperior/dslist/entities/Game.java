package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity; // Importado para o @Entity funcionar. Atalho usado CTRL + SHIF + O
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//ORM (Mapeamento do Objeto Relacional) usado para mapear o Objeto Game para que ele vire um registro na Tabela Games do Banco Relacional
@Entity
@Table(name = "tb_game")
public class Game {			

	// Atributos da classe
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // <<pk>> significa Primary Key
	private String title;
	
	@Column(name = "game_year") // nome do "year" pode dar problema com um comando já reconhecido dentro do SQL. Precisa ser mudado na Tabela
	private Integer year;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	
	@Column(columnDefinition = "TEXT")
	// Instrução para JPA, na hora de gerar o Banco, gere esse campo como se fosse um "texto" (sem tamanho limite), e não um "varchar" de 255
	private String shortDescription;
	
	@Column(columnDefinition = "TEXT")
	private String longDescription;
	
	/*
	 * Se você está utilizando JPA para gerenciar sua conexão com o banco de dados, a recomendação geral é usar as classes wrapper (Integer, Double, etc.) 
	 * em vez dos tipos primitivos (int, double, etc.). Isso porque o JPA trabalha diretamente com bancos de dados, onde os valores podem ser NULL, e os tipos 
	 * primitivos não suportam essa condição.
	 */
	
	// Construtor vazio da classe
	public Game() {
		
	}
	
	// Construtor preenchido da classe
	// Atalho: Botão Direito > Source e escolher (no caso foi Generate Constructor Using Fields e selecionamos tudo) OU ALT + SHIFT + S
	public Game(Long id, String title, Integer year, String genre, String platforms, Double score, String imgUrl,
			String shortDescription, String longDescription) {
		super(); // É usado para chamar o construtor da classe pai (superclasse) a partir do construtor da classe filha
				 // Pode ser apagada nesse caso, pois a classe Game não está herdando de nenhuma outra classe personalizada
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.platforms = platforms;
		this.score = score;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	// Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String plataforma) {
		this.platforms = plataforma;
	}

	public double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	// Métodos hashcode e equals. Estão sendo usados para comparar Jogos apenas por IDs.
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
	}	
	
}