package br.com.ft5.converter.services;

import br.com.ft5.converter.dao.CurrencyConsumerDao;
import br.com.ft5.converter.dto.CurrencyDTO;
import br.com.ft5.converter.entities.Currency;
import br.com.ft5.converter.repositories.CurrencyRepository;

public class CurrencyService {
	
	private CurrencyRepository currencyRepository = new CurrencyConsumerDao();

	public CurrencyDTO CurrencyServiceByCode(String code, Double value) {
		Currency currency = currencyRepository.findCurrencyByCode(code);
		CurrencyDTO dto = new CurrencyDTO(currency);
		dto.setValue(value);
		dto.setValue(dto.getLow() * dto.getValue());
		return dto;
	}
}
