package br.com.ft5.converter;

import java.net.HttpURLConnection;

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
		CurrencyConnection currencyConnection = new CurrencyConnection();
		HttpURLConnection c = currencyConnection.httpClient("BRL-USD");
		System.out.println("Hello World!");
	}
}
