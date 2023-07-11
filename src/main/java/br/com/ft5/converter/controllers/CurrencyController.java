package br.com.ft5.converter.controllers;

import br.com.ft5.converter.services.CurrencyService;

public class CurrencyController {
	
	private CurrencyService currencyService = new CurrencyService();

	public Double convertController(String Currency, Double value) {
		System.out.println(Currency + ": " + value);
		return currencyService.CurrencyServiceByName(Currency, value);

	}

}
