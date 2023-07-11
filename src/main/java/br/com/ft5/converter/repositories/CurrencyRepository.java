package br.com.ft5.converter.repositories;

import br.com.ft5.converter.entities.Currency;

public interface CurrencyRepository {

	Currency findCurrencyByCode(String code);
	
}
