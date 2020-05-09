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
class PendingNewRAT {

	RestAssuredTestUtil util = new RestAssuredTestUtil(); 
	
	//PENDING --start
	@Disabled
	@Test
	void test_pedido_antigo_by_new_pending() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=NEW,PENDING&startRow=0&pageRows=350"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(14))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(14))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
        
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"PEN"});
		util.checkTotalElements(urlToTest, 14);
	}
	
	@Disabled
	@Test
	void test_pedido_antigo_by_new_pending_and_customer_name() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=NEW,PENDING&startRow=0&pageRows=350&customerName=" + RestAssuredTestUtil.CUSTOMER_NAME_FILTER; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(1))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.customerName", hasItem(RestAssuredTestUtil.CUSTOMER_NAME_COMPARE));
		
        
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"PEN"});
		util.checkTotalElements(urlToTest, 1);
	}
	
	@Test
	void test_pedido_antigo_by_new_pending_and_doc_nr() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=NEW,PENDING&startRow=0&pageRows=350&documentNr=" + RestAssuredTestUtil.DOCUMENT_NR; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(1))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.documentNumber", hasItem(RestAssuredTestUtil.DOCUMENT_NR));
		
        
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"PEN"});
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Disabled
	@Test
	void test_pedido_antigo_by_new_pending_and_start_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=NEW,PENDING&startRow=0&pageRows=350&startPurchaseDate=2020-04-24T22:00:00Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(7))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(7))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-24T22:00:00"), null);
		util.checkStatus(urlToTest, new String[] {"PEN"});
		util.checkTotalElements(urlToTest, 7);
	}
	
	@Disabled
	@Test
	void test_pedido_antigo_by_new_pending_and_start_date_and_customer_name() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=NEW,PENDING&startRow=0&pageRows=350&startPurchaseDate=2020-04-24T22:00:00Z&customerName=" + RestAssuredTestUtil.CUSTOMER_NAME_FILTER;; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(1))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.customerName", hasItem(RestAssuredTestUtil.CUSTOMER_NAME_COMPARE));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-24T22:00:00"), null);
		util.checkStatus(urlToTest, new String[] {"PEN"});
		util.checkTotalElements(urlToTest, 1);
	}
	
	@Disabled
	@Test
	void test_pedido_antigo_by_new_pending_and_start_date_and_doc_nr() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=NEW,PENDING&startRow=0&pageRows=350&startPurchaseDate=2020-04-24T22:00:00Z&documentNr=" + RestAssuredTestUtil.DOCUMENT_NR;
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(1))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.documentNumber", hasItem(RestAssuredTestUtil.DOCUMENT_NR));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-24T22:00:00"), null);
		util.checkStatus(urlToTest, new String[] {"PEN"});
		util.checkTotalElements(urlToTest, 1);
	}
	
	@Disabled
	@Test
	void test_pedido_antigo_by_new_pending_and_end_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=NEW,PENDING&startRow=0&pageRows=350&finishPurchaseDate=2020-04-28T22:00:00Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(10))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(10))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkDateLimit(urlToTest, null, RestAssuredTestUtil.dateFormat.parse("2020-04-28T22:00:00"));
        util.checkStatus(urlToTest, new String[] {"PEN"});
        util.checkTotalElements(urlToTest, 10);
	}
	
	@Disabled
	@Test
	void test_pedido_antigo_by_new_pending_and_end_date_and_customer_name() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=NEW,PENDING&startRow=0&pageRows=350&finishPurchaseDate=2020-04-28T22:00:00Z&customerName=" + RestAssuredTestUtil.CUSTOMER_NAME_FILTER; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(1))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.customerName", hasItem(RestAssuredTestUtil.CUSTOMER_NAME_COMPARE));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkDateLimit(urlToTest, null, RestAssuredTestUtil.dateFormat.parse("2020-04-28T22:00:00"));
        util.checkStatus(urlToTest, new String[] {"PEN"});
        util.checkTotalElements(urlToTest, 1);
	}
	
	@Disabled
	@Test
	void test_pedido_antigo_by_new_pending_and_end_date_and_doc_nr() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=NEW,PENDING&startRow=0&pageRows=350&finishPurchaseDate=2020-04-28T22:00:00Z&documentNr=" + RestAssuredTestUtil.DOCUMENT_NR; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(1))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.documentNumber", hasItem(RestAssuredTestUtil.DOCUMENT_NR));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkDateLimit(urlToTest, null, RestAssuredTestUtil.dateFormat.parse("2020-04-28T22:00:00"));
        util.checkStatus(urlToTest, new String[] {"PEN"});
        util.checkTotalElements(urlToTest, 1);
	}
	
	@Disabled
	@Test
	void test_pedido_antigo_by_new_pending_and_start_date_and_end_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=NEW,PENDING&startRow=0&pageRows=350&startPurchaseDate=2020-04-24T04:00:00Z&finishPurchaseDate=2020-04-28T22:00:00Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(3))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(3))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-24T04:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-28T22:00:00"));
		util.checkStatus(urlToTest, new String[] {"PEN"});
		util.checkTotalElements(urlToTest, 3);
	}
	
	@Disabled
	@Test
	void test_pedido_antigo_by_new_pending_and_start_date_and_end_date_and_customer_name() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=NEW,PENDING&startRow=0&pageRows=350&startPurchaseDate=2020-04-24T04:00:00Z&finishPurchaseDate=2020-04-28T22:00:00Z&customerName=" + RestAssuredTestUtil.CUSTOMER_NAME_FILTER; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(1))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.customerName", hasItem(RestAssuredTestUtil.CUSTOMER_NAME_COMPARE));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-24T04:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-28T22:00:00"));
        util.checkStatus(urlToTest, new String[] {"PEN"});
        util.checkTotalElements(urlToTest, 1);
	}
	
	@Disabled
	@Test
	void test_pedido_antigo_by_new_pending_and_start_date_and_end_date_and_doc_nr() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=NEW,PENDING&startRow=0&pageRows=350&startPurchaseDate=2020-04-24T04:00:00Z&finishPurchaseDate=2020-04-28T22:00:00Z&documentNr=" + RestAssuredTestUtil.DOCUMENT_NR; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(1))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.documentNumber", hasItem(RestAssuredTestUtil.DOCUMENT_NR));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-24T04:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-28T22:00:00"));
        util.checkStatus(urlToTest, new String[] {"PEN"});
        util.checkTotalElements(urlToTest, 1);
	}

}
