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
	private int year;
	private String genre;
	private String plataforma;
	private double score;
	private String imgUrl;
	private String shortDescription;
	private String longDescription;
	
	// Construtor vazio da classe
	public Game() {
		
	}
	
	// Construtor preenchido da classe
	// Atalho: Botão Direito > Source e escolher (no caso foi Generate Constructor Using Fields e selecionamos tudo) OU ALT + SHIFT + S
	public Game(Long id, String title, int year, String genre, String plataforma, double score, String imgUrl,
			String shortDescription, String longDescription) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.plataforma = plataforma;
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

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
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