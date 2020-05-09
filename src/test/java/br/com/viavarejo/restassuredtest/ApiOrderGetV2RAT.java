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
class ApiOrderGetV2RAT {

	RestAssuredTestUtil util = new RestAssuredTestUtil(); 
	
	@Test
	void test_pedido_antigo_by_id() {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&orderId=18822007301&startRow=0&pageRows=350";
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("orderList.orderId", hasItems("18822007301"))
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
		
		util.checkTotalElements(urlToTest, 1);
	}
	
	@Test
	void test_pedido_antigo_by_order_master_id() {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&orderMasterId=188220073&startRow=0&pageRows=350";
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("orderList.orderId", hasItems("18822007301"))
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
		
		util.checkTotalElements(urlToTest, 1);
	}
	
	@Test
	void test_pedido_antigo_by_no_one() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(335))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(3))
		.body("totalOrdersSent", equalTo(34))
		.body("totalOrdersDelivered", equalTo(235))
		.body("totalOrdersCanceled", equalTo(46))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(2))
		.body("totalOrdersSentPartially", equalTo(1))
		.body("totalOrdersPending", equalTo(14))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkTotalElements(urlToTest, 335);
	}
	
}
