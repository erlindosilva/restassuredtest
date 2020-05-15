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
class ApiOrderGetV2NasRAT {

	RestAssuredTestUtil util = new RestAssuredTestUtil("CARLOS TADEU CORREIA LARA", "CARLOS", "45181926991"); 
	

	@Test
	void test_pedido_by_site_id_pf() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&orderOwnerTp=4"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(44))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(3))
		.body("totalOrdersDelivered", equalTo(37))
		.body("totalOrdersCanceled", equalTo(4))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkTotalElements(urlToTest, 44);
	}
	
	
	@Test
	void test_pedido_by_site_id_ex() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&orderOwnerTp=2"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(139))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(9))
		.body("totalOrdersDelivered", equalTo(106))
		.body("totalOrdersCanceled", equalTo(15))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(2))
		.body("totalOrdersSentPartially", equalTo(1))
		.body("totalOrdersPending", equalTo(6))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkTotalElements(urlToTest, 139);
	}
	
	
	@Test
	void test_pedido_by_site_id_cb() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&orderOwnerTp=3"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(147))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(2))
		.body("totalOrdersSent", equalTo(20))
		.body("totalOrdersDelivered", equalTo(92))
		.body("totalOrdersCanceled", equalTo(26))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(7))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkTotalElements(urlToTest, 147);
	}
	
	
	@Test
	void test_pedido_by_site_id_cb_customer_name() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&orderOwnerTp=3&customerName=" + util.CUSTOMER_NAME_FILTER; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(2))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(1))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(1))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.customerName", hasItem(util.CUSTOMER_NAME_COMPARE));
		
        
		util.checkDateLimit(urlToTest, null, null);
		util.checkTotalElements(urlToTest, 2);
	}
	
	
	@Test
	void test_pedido_by_purchase_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&minDate=2020-04-27"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(8))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(7))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(1))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-27T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-27T23:59:59"));
		util.checkTotalElements(urlToTest, 8);
	}
	
	
	@Test
	void test_pedido_by_purchase_date_and_order_id() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&minDate=2020-04-27&orderId=20750750401"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(1))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-27T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-27T23:59:59"));
		util.checkTotalElements(urlToTest, 1);
	}
	

	@Test
	void test_pedido_by_purchase_date_and_order_master_id() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&minDate=2020-04-27&orderMasterId=207507504"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(1))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-27T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-27T23:59:59"));
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_purchase_date_and_customer_name() throws ParseException {
		
		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("claudinei de jesus costa", "claudinei", "56392451900");
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&minDate=2020-04-27&customerName=" + utilTemp.CUSTOMER_NAME_FILTER;
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(1))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.customerName", hasItem(utilTemp.CUSTOMER_NAME_COMPARE));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-27T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-27T23:59:59"));
		util.checkTotalElements(urlToTest, 1);
	}
	
}
