package br.com.ft5.converter.dto;

import br.com.ft5.converter.entities.Currency;

public class CurrencyDTO {

	private String root;
	private String code;
	private String codein;
	private String name;
	private String low;
	
	private Double value;

	public CurrencyDTO() {
	}
	
	public CurrencyDTO(Currency entity) {
		root = entity.getRoot();
		code = entity.getCode();
		codein = entity.getCodein();
		name = entity.getName();
		low = entity.getLow();
	}

	public String getRoot() {
		return root;
	}

	public String getCode() {
		return code;
	}

	public String getCodein() {
		return codein;
	}

	public String getName() {
		return name;
	}

	public Double getLow() {
		return Double.parseDouble(low);
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
