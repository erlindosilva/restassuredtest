package br.com.viavarejo.restassuredtest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.*;
import java.text.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
//@Disabled
class PartiallyDeliveredRAT {

	RestAssuredTestUtil util = new RestAssuredTestUtil("Giovanna Padovam Mota", "Giovanna", "23755108879"); 
	
	
	@Test
	void test_pedido_by_partially_delivered() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=PARTIALLY_DELIVERED&startRow=0&pageRows=350"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(2))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(2))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
        
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		util.checkStatus(urlToTest, new String[] {"PDL"});
		util.checkTotalElements(urlToTest, 235);
	}
	
	@Disabled
	@Test
	void test_pedido_by_partially_delivered_and_customer_name() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=PARTIALLY_DELIVERED&startRow=0&pageRows=350&customerName=" + util.CUSTOMER_NAME_FILTER; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(1))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.customerName", hasItem(util.CUSTOMER_NAME_COMPARE));
		
        
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		util.checkStatus(urlToTest, new String[] {"PDL"});
		util.checkTotalElements(urlToTest, 1);
	}
	
	@Disabled
	@Test
	void test_pedido_by_partially_delivered_and_doc_nr() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=PARTIALLY_DELIVERED&startRow=0&pageRows=350&documentNr=" + util.DOCUMENT_NR; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(1))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.documentNumber", hasItem(util.DOCUMENT_NR));
		
        
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		util.checkStatus(urlToTest, new String[] {"PDL"});
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Disabled
	@Test
	void test_pedido_by_partially_delivered_and_start_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=PARTIALLY_DELIVERED&startRow=0&pageRows=350&startSentDate=2020-03-05T17:00:00Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(145))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(145))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		//util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-03-05T17:00:00"), null, true, "ETR");
		util.checkStatus(urlToTest, new String[] {"PDL"});
		util.checkTotalElements(urlToTest, 145);
	}
	
	@Disabled
	@Test
	void test_pedido_by_partially_delivered_and_start_date_and_customer_name() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=PARTIALLY_DELIVERED&startRow=0&pageRows=350&startSentDate=2020-03-05T17:00:00Z&customerName=" + util.CUSTOMER_NAME_FILTER; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(1))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.customerName", hasItem(util.CUSTOMER_NAME_COMPARE));
		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-03-05T17:00:00"), null, true, "ETR");
		util.checkStatus(urlToTest, new String[] {"PDL"});
		util.checkTotalElements(urlToTest, 1);
	}
	
	@Disabled
	@Test
	void test_pedido_by_partially_delivered_and_start_date_and_doc_nr() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=PARTIALLY_DELIVERED&startRow=0&pageRows=350&startSentDate=2020-03-05T17:00:00Z&documentNr=" + util.DOCUMENT_NR;
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(1))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.documentNumber", hasItem(util.DOCUMENT_NR));
		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-03-05T17:00:00"), null, true, "ETR");
		util.checkStatus(urlToTest, new String[] {"PDL"});
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Disabled
	@Test
	void test_pedido_by_partially_delivered_and_end_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=PARTIALLY_DELIVERED&startRow=0&pageRows=350&finishSentDat=2020-03-26T10:12:36Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(132))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(132))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		//util.checkDateLimit(urlToTest, null, RestAssuredTestUtil.dateFormat.parse("2020-03-26T10:12:36"), true, "ETR");
        util.checkStatus(urlToTest, new String[] {"PDL"});
        util.checkTotalElements(urlToTest, 132);
	}
	
	@Disabled
	@Test
	void test_pedido_by_partially_delivered_and_end_date_and_customer_name() throws ParseException {
		
		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Guilherme Macedo Moreira Matos", "Guilherme", "05121988613");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=PARTIALLY_DELIVERED&startRow=0&pageRows=350&finishSentDat=2020-03-26T10:12:36Z&customerName=" + utilTemp.CUSTOMER_NAME_FILTER; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(1))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.customerName", hasItem(utilTemp.CUSTOMER_NAME_COMPARE));
		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		//util.checkDateLimit(urlToTest, null, RestAssuredTestUtil.dateFormat.parse("2020-02-25T11:00:00"), true, "ETR");
        util.checkStatus(urlToTest, new String[] {"PDL"});
        util.checkTotalElements(urlToTest, 1);
	}
	
	@Disabled
	@Test
	void test_pedido_by_partially_delivered_and_end_date_and_doc_nr() throws ParseException {
		
		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Guilherme Macedo Moreira Matos", "Guilherme", "05121988613");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=PARTIALLY_DELIVERED&startRow=0&pageRows=350&finishSentDat=2020-03-26T10:12:36Z&documentNr=" + utilTemp.DOCUMENT_NR; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(1))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.documentNumber", hasItem(utilTemp.DOCUMENT_NR));
		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		//util.checkDateLimit(urlToTest, null, RestAssuredTestUtil.dateFormat.parse("2020-02-25T11:00:00"), true, "ETR");
        util.checkStatus(urlToTest, new String[] {"PDL"});
        util.checkTotalElements(urlToTest, 1);
	}

	@Disabled
	@Test
	void test_pedido_by_partially_delivered_and_start_date_and_end_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=PARTIALLY_DELIVERED&startRow=0&pageRows=350&startSentDate=2020-03-05T17:00:00Z&finishSentDat=2020-03-26T10:12:36Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(42))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(42))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		//util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-02-25T11:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-21T07:00:00"), true, "ETR");
		util.checkStatus(urlToTest, new String[] {"PDL"});
		util.checkTotalElements(urlToTest, 42);
	}
	
	@Disabled
	@Test
	void test_pedido_by_partially_delivered_and_start_date_and_end_date_and_customer_name() throws ParseException {
		
		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Guilherme Macedo Moreira Matos", "Guilherme", "05121988613");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=PARTIALLY_DELIVERED&startRow=0&pageRows=350&startSentDate=2020-03-05T17:00:00Z&finishSentDat=2020-03-26T10:12:36Z&customerName=" + utilTemp.CUSTOMER_NAME_FILTER; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(1))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.customerName", hasItem(utilTemp.CUSTOMER_NAME_COMPARE));
		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		//util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-02-25T11:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-21T07:00:00"), true, "ETR");
        util.checkStatus(urlToTest, new String[] {"PDL"});
        util.checkTotalElements(urlToTest, 1);
	}
	
	@Disabled
	@Test
	void test_pedido_by_partially_delivered_and_start_date_and_end_date_and_doc_nr() throws ParseException {
		
		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Guilherme Macedo Moreira Matos", "Guilherme", "05121988613");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=PARTIALLY_DELIVERED&startRow=0&pageRows=350&startSentDate=2020-03-05T17:00:00Z&finishSentDat=2020-03-26T10:12:36Z&documentNr=" + utilTemp.DOCUMENT_NR; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(1))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.documentNumber", hasItem(utilTemp.DOCUMENT_NR));
		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		//util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-02-25T11:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-21T07:00:00"), true, "ETR");
        util.checkStatus(urlToTest, new String[] {"PDL"});
        util.checkTotalElements(urlToTest, 1);
	}
	
	
	//pedidos antigos
	@Disabled
	@Test
	void test_pedido_by_partially_delivered_and_old_start_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=PARTIALLY_DELIVERED&startRow=0&pageRows=350&startSentDate=2019-01-05T17:00:00Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(236))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(236))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null, true, "ETR", true);
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2019-01-05T07:00:00"), null, true, "ETR", true);
		util.checkStatus(urlToTest, new String[] {"PDL"});
		util.checkTotalElements(urlToTest, 236);
	}
	
	
	@Disabled
	@Test
	void test_pedido_by_partially_delivered_and_old_end_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=PARTIALLY_DELIVERED&startRow=0&pageRows=350&finishSentDat=2019-01-10T10:12:36Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(0))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
        util.checkTotalElements(urlToTest, 0);
	}
	
	@Disabled
	@Test
	void test_pedido_by_partially_delivered_and_old_start_date_and_old_end_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=PARTIALLY_DELIVERED&startRow=0&pageRows=350&startSentDate=2019-01-05T17:00:00Z&finishSentDat=2019-01-10T10:12:36Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(1))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null, true, "ETR", true);
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2019-01-05T17:00:00"), RestAssuredTestUtil.dateFormat.parse("2019-01-10T10:12:36"), true, "ETR", true);
		util.checkStatus(urlToTest, new String[] {"PDL"});
		util.checkTotalElements(urlToTest, 1);
	}

}