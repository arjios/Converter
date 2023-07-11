package br.com.ft5.converter.controllers;

import br.com.ft5.converter.dto.CurrencyDTO;
import br.com.ft5.converter.services.CurrencyService;

public class CurrencyController {
	
	private CurrencyService currencyService = new CurrencyService();

	public CurrencyDTO convertController(String code, Double value) {
		System.out.println(code + ": " + value);	
		return currencyService.CurrencyServiceByCode(code, value);

	}

}
