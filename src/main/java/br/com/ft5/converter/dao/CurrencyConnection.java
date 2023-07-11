package br.com.ft5.converter.dao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import br.com.ft5.converter.dao.exceptions.ResourceNotFoundException;

public class CurrencyConnection {

	public HttpURLConnection httpClient(String money) throws RuntimeException {
		HttpURLConnection connect;
		try {
			URL url = new URL("https://economia.awesomeapi.com.br/last/" + money);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if(conn.getResponseCode() == 200) {
				connect = conn;
			} else {
				throw new ResourceNotFoundException("IOException - Connection: "
						+ conn.getResponseCode()
						+ " - "
						+ conn.getResponseMessage());
			}
		} catch(IOException ioe) {
			throw new ResourceNotFoundException("IOException - Connection: " + ioe.getMessage());
		}
		return connect;
	}
}
