package br.com.ft5.converter.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ft5.converter.entities.Currency;
import br.com.ft5.converter.repositories.CurrencyRepository;

/**
 * 
 * @author Antonio Alves
 *
 */

public class CurrencyConsumerDao implements CurrencyRepository {
	
	private String line="";
	private HttpURLConnection connect;
	private Currency currency = new Currency();
	private StringBuilder response = new StringBuilder();
	private CurrencyConnection connection = new CurrencyConnection();

	
	public CurrencyConsumerDao() {
	}

	@Override
	public Currency findCurrencyByCode(String code) {
		try {
			connect = connection.httpClient(code);
			BufferedReader br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
			while ((line = br.readLine()) != null) {
				response.append(line);
			}
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNodeRoot = objectMapper.readTree(response.toString());
			JsonNode jsonNodeNameRoot = jsonNodeRoot.get(code.replace("-", ""));

			currency.setRoot(jsonNodeNameRoot.asText());
			currency.setCode(jsonNodeNameRoot.get("code").asText());
			currency.setCodein(jsonNodeNameRoot.get("codein").asText());
			currency.setName(jsonNodeNameRoot.get("name").asText());
			currency.setHigh(jsonNodeNameRoot.get("high").asText());
			currency.setLow(jsonNodeNameRoot.get("low").asText());
			currency.setVarBid(jsonNodeNameRoot.get("varBid").asText());
			currency.setPctChange(jsonNodeNameRoot.get("pctChange").asText());
			currency.setBid(jsonNodeNameRoot.get("bid").asText());
			currency.setAsk(jsonNodeNameRoot.get("ask").asText());		
			
			System.out.println("Moedas root: " + currency.getName() + " Cotação: " + currency.getLow());

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return currency;
	}

}
