package br.com.ft5.converter.services;

public class TemperatureService {
	
	private Double temperature;

	public Double TemperatureServiceByCode(String code, Double value) {

		switch (code) {
		case "Kelvin-Celsius": {
			temperature = value + 273.0;
			break;
		}
		case "Kelvin-Fahrenheit": {
			temperature = (value*1.8) - 459.67;
			break;
		}
		case "Celsius-Fahrenheit": {
			temperature = (value*1.8) + 32.0;
			break;
		}
		case "Celsius-Kelvin": {
			temperature = value - 273.0;
			break;
		}
		case "Fahrenheit-Celsius": {
			temperature = (value - 32) / 1.8;
			break;
		}
		case "Fahrenheit-Kelvin": {
			temperature = (value + 459.67) * (5 / 9);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + code);
		}

		return temperature;
	}
}
