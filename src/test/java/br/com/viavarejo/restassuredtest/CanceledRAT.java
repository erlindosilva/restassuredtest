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
@Disabled
class CanceledRAT {

	RestAssuredTestUtil util = new RestAssuredTestUtil("CARLOS TADEU CORREIA LARA", "Carlos", "45181926991"); 
	
	
	@Test
	void test_pedido_by_canceled() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=CANCEL&startRow=0&pageRows=350"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(45))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(45))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
        
		util.checkDateLimit(urlToTest, null, null, true, "CAN");
		util.checkStatus(urlToTest, new String[] {"CAN"});
		util.checkTotalElements(urlToTest, 45);
	}
	
	
	@Test
	void test_pedido_by_canceled_and_customer_name() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=CANCEL&startRow=0&pageRows=350&customerName=" + util.CUSTOMER_NAME_FILTER; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(1))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.customerName", hasItem(util.CUSTOMER_NAME_COMPARE));
		
        
		util.checkDateLimit(urlToTest, null, null, true, "CAN");
		util.checkStatus(urlToTest, new String[] {"CAN"});
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_canceled_and_doc_nr() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=CANCEL&startRow=0&pageRows=350&documentNr=" + util.DOCUMENT_NR; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(1))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.documentNumber", hasItem(util.DOCUMENT_NR));
		
        
		util.checkDateLimit(urlToTest, null, null, true, "CAN");
		util.checkStatus(urlToTest, new String[] {"CAN"});
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	
	@Test
	void test_pedido_by_canceled_and_start_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=CANCEL&startRow=0&pageRows=350&startCanceledDate=2020-04-21T07:00:00Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(6))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(6))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null, true, "CAN");
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-21T07:00:00"), null, true, "CAN");
		util.checkStatus(urlToTest, new String[] {"CAN"});
		util.checkTotalElements(urlToTest, 6);
	}
	
	
	@Test
	void test_pedido_by_canceled_and_start_date_and_customer_name() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=CANCEL&startRow=0&pageRows=350&startCanceledDate=2020-04-21T07:00:00Z&customerName=" + util.CUSTOMER_NAME_FILTER; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(1))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.customerName", hasItem(util.CUSTOMER_NAME_COMPARE));
		
		util.checkDateLimit(urlToTest, null, null, true, "CAN");
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-21T07:00:00"), null, true, "CAN");
		util.checkStatus(urlToTest, new String[] {"CAN"});
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_canceled_and_start_date_and_doc_nr() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=CANCEL&startRow=0&pageRows=350&startCanceledDate=2020-04-21T07:00:00Z&documentNr=" + util.DOCUMENT_NR;
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(1))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.documentNumber", hasItem(util.DOCUMENT_NR));
		
		util.checkDateLimit(urlToTest, null, null, true, "CAN");
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-21T07:00:00"), null, true, "CAN");
		util.checkStatus(urlToTest, new String[] {"CAN"});
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	
	@Test
	void test_pedido_by_canceled_and_end_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=CANCEL&startRow=0&pageRows=350&finishCanceledDate=2020-02-25T11:00:00Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(20))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(20))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null, true, "CAN");
		//util.checkDateLimit(urlToTest, null, RestAssuredTestUtil.dateFormat.parse("2020-02-25T11:00:00"), true, "CAN");
        util.checkStatus(urlToTest, new String[] {"CAN"});
        util.checkTotalElements(urlToTest, 20);
	}
	
	
	@Test
	void test_pedido_by_canceled_and_end_date_and_customer_name() throws ParseException {
		
		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Erica Pereira", "Erica", "05819215346");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=CANCEL&startRow=0&pageRows=350&finishCanceledDate=2020-02-25T11:00:00Z&customerName=" + utilTemp.CUSTOMER_NAME_FILTER; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(1))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.customerName", hasItem(utilTemp.CUSTOMER_NAME_COMPARE));
		
		util.checkDateLimit(urlToTest, null, null, true, "CAN");
		//util.checkDateLimit(urlToTest, null, RestAssuredTestUtil.dateFormat.parse("2020-02-25T11:00:00"), true, "CAN");
        util.checkStatus(urlToTest, new String[] {"CAN"});
        util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_canceled_and_end_date_and_doc_nr() throws ParseException {
		
		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Erica Pereira", "Erica", "05819215346");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=CANCEL&startRow=0&pageRows=350&finishCanceledDate=2020-02-25T11:00:00Z&documentNr=" + utilTemp.DOCUMENT_NR; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(1))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.documentNumber", hasItem(utilTemp.DOCUMENT_NR));
		
		util.checkDateLimit(urlToTest, null, null, true, "CAN");
		//util.checkDateLimit(urlToTest, null, RestAssuredTestUtil.dateFormat.parse("2020-02-25T11:00:00"), true, "CAN");
        util.checkStatus(urlToTest, new String[] {"CAN"});
        util.checkTotalElements(urlToTest, 1);
	}

	
	@Test
	void test_pedido_by_canceled_and_start_date_and_end_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=CANCEL&startRow=0&pageRows=350&startCanceledDate=2020-02-25T11:00:00Z&finishCanceledDate=2020-04-21T07:00:00Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(26))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(26))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null, true, "CAN");
		//util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-02-25T11:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-21T07:00:00"), true, "CAN");
		util.checkStatus(urlToTest, new String[] {"CAN"});
		util.checkTotalElements(urlToTest, 26);
	}
	
	
	@Test
	void test_pedido_by_canceled_and_start_date_and_end_date_and_customer_name() throws ParseException {
		
		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Neliza machado faria", "Neliza", "11639255605");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=CANCEL&startRow=0&pageRows=350&startCanceledDate=2020-02-25T11:00:00Z&finishCanceledDate=2020-04-21T07:00:00Z&customerName=" + utilTemp.CUSTOMER_NAME_FILTER; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(2))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(2))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.customerName", hasItem(utilTemp.CUSTOMER_NAME_COMPARE));
		
		util.checkDateLimit(urlToTest, null, null, true, "CAN");
		//util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-02-25T11:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-21T07:00:00"), true, "CAN");
        util.checkStatus(urlToTest, new String[] {"CAN"});
        util.checkTotalElements(urlToTest, 2);
	}
	
	
	@Test
	void test_pedido_by_canceled_and_start_date_and_end_date_and_doc_nr() throws ParseException {
		
		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Neliza machado faria", "Neliza", "11639255605");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=CANCEL&startRow=0&pageRows=350&startCanceledDate=2020-02-25T11:00:00Z&finishCanceledDate=2020-04-21T07:00:00Z&documentNr=" + utilTemp.DOCUMENT_NR; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(2))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(2))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.documentNumber", hasItem(utilTemp.DOCUMENT_NR));
		
		util.checkDateLimit(urlToTest, null, null, true, "CAN");
		//util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-02-25T11:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-21T07:00:00"), true, "CAN");
        util.checkStatus(urlToTest, new String[] {"CAN"});
        util.checkTotalElements(urlToTest, 2);
	}
	
	
	//pedidos antigos
	@Test
	void test_pedido_by_canceled_and_old_start_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=CANCEL&startRow=0&pageRows=350&startCanceledDate=2019-01-05T07:00:00Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(46))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(46))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null, true, "CAN", true);
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2019-01-05T07:00:00"), null, true, "CAN", true);
		util.checkStatus(urlToTest, new String[] {"CAN"});
		util.checkTotalElements(urlToTest, 46);
	}
	
	
	@Test
	void test_pedido_by_canceled_and_old_end_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=CANCEL&startRow=0&pageRows=350&finishCanceledDate=2019-01-07T11:00:00Z"; 
		
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
	
	@Test
	void test_pedido_by_canceled_and_old_start_date_and_old_end_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&status=CANCEL&startRow=0&pageRows=350&startCanceledDate=2019-01-05T07:00:00Z&finishCanceledDate=2019-01-07T11:00:00Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(1))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null, true, "CAN", true);
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2019-01-05T07:00:00"), RestAssuredTestUtil.dateFormat.parse("2019-01-07T11:00:00"), true, "CAN", true);
		util.checkStatus(urlToTest, new String[] {"CAN"});
		util.checkTotalElements(urlToTest, 1);
	}

}
