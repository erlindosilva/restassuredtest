package br.com.viavarejo.restassuredtest;

import static io.restassured.RestAssured.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import io.restassured.response.Response;

public class RestAssuredTestUtil {

	public final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
	public final static String CUSTOMER_NAME_COMPARE = "Cinira Ribeiro";
	public final static String CUSTOMER_NAME_FILTER = "Cinira";
	public final static String DOCUMENT_NR = "15139645858";
	
	//verifica se dado a lista de elementos, há algum item que está abaixo da data limite
	public void checkDateLimit(String urlToTest, 
			Date dataInicialConsultaLimite, Date dataFinalConsultaLimite) throws ParseException
	{
		Response resp = get(urlToTest)
				.then()
				.extract()
				.response();
		
		List<HashMap<String, Object>> list = resp.getBody().jsonPath().getList("orderList");
		
		LocalDateTime dataConsulta = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC).minusMonths(6);
        
		if(dataInicialConsultaLimite == null)
			dataInicialConsultaLimite = Date.from(dataConsulta.toInstant(ZoneOffset.UTC));
        
		for (HashMap<String, Object> jsonObject : list) {
		    String purchaseDateElement = (String)jsonObject.get("purchaseDate");
		    Date currentDate = dateFormat.parse(purchaseDateElement);
		    if(currentDate.before(dataInicialConsultaLimite)) 
		    	assertEquals("dataInicialConsultaLimite", "dataInicialConsultaLimite1");
		    
		    if(dataFinalConsultaLimite != null && currentDate.after(dataFinalConsultaLimite)) 
		    	assertEquals("dataFinalConsultaLimite", "dataFinalConsultaLimite1");
		}
	}
	
	//para verificar se todos são de um determinado lista de status
	public void checkStatus(String urlToTest, String[] status) throws ParseException
	{
		Response resp = get(urlToTest)
				.then()
				.extract()
				.response();
		
		List<HashMap<String, Object>> list = resp.getBody().jsonPath().getList("orderList");
		
		for (HashMap<String, Object> jsonObject : list) {
		    String currentStatus = (String)jsonObject.get("status");
		    
		    boolean found = false;
		    for(int i = 0; i < status.length; i++)
		    {
		    	if(status[i].equalsIgnoreCase(currentStatus))
		    	{
		    		found = true;
		    		break;
		    	}
		    }
		    
		    if(!found)
		    {
		    	assertEquals("1 ou mais status", "nenhum status");
		    }
		}
	}
	
	//verifica se o total de elementos que veio na coleção bate com o total que foi informado
	public void checkTotalElements(String urlToTest, int totalElementsExpected)
	{
		Response resp = get(urlToTest)
				.then()
				.extract()
				.response();
		
		List<HashMap<String, Object>> list = resp.getBody().jsonPath().getList("orderList");
		
		assertEquals(list.size(), totalElementsExpected);
	}
	
}
