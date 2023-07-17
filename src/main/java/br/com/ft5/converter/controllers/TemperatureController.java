package br.com.ft5.converter.controllers;

import br.com.ft5.converter.services.TemperatureService;

public class TemperatureController {
	
	private TemperatureService temperatureService = new TemperatureService();

	public Double convertController(String code, Double value) {
		return temperatureService.TemperatureServiceByCode(code, value);
	}

}
