package br.com.ft5.converter;

import java.text.DecimalFormat;

import br.com.ft5.converter.controllers.CurrencyController;
import br.com.ft5.converter.dto.CurrencyDTO;
import br.com.ft5.converter.views.CardLayoutDemo;

/**
 * 
 * @author Antonio Alves
 * 
 * @version 1.0
 *
 */

public class App {
	public static void main(String[] args) {

		
//		CurrencyConnection currencyConnection = new CurrencyConnection();
//		HttpURLConnection c = currencyConnection.httpClient("BRL-USD");

		
		
//		CurrencyController currencyController = new CurrencyController();
//		CurrencyDTO dto = currencyController.convertController("BRL-USD", 1000.099);

//
//		System.out.println("Valor convertido: " + df.format(dto.getValue()));
		
		new CardLayoutDemo();

		
////		System.out.println("Valor convertido: " + currencyController.convertController("BRL-USD", 10.0));
////		System.out.println("Hello World!");
	}
}
