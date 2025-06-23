package org.scoula.pokemon.dto;

import java.util.List;
import lombok.Data;

@Data
public class PokemonListResponse{
	private List<TypesItem> types;
	private List<StatsItem> stats;
	private String name;
	private int weight;
	private int id;
	private Sprites sprites;
	private int height;
}