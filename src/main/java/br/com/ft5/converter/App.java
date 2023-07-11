package br.com.ft5.converter;

import java.net.HttpURLConnection;

import br.com.ft5.converter.controllers.CurrencyController;
import br.com.ft5.converter.dao.CurrencyConnection;

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
		CurrencyController currencyController = new CurrencyController();
		System.out.println("Valor convertido: " + currencyController.convertController("BRL-USD", 10.0));
		System.out.println("Hello World!");
	}
}
