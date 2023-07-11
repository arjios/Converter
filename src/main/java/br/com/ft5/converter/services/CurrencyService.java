package br.com.ft5.converter.services;

public class CurrencyService {

	public Double CurrencyServiceByName(String currency, Double value) {
		Double valueCurrency = 4.6970 * value;
		return valueCurrency;
	}
}
