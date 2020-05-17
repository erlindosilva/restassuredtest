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
		.body("totalOrdersSent", equalTo(19))
		.body("totalOrdersDelivered", equalTo(92))
		.body("totalOrdersCanceled", equalTo(26))
		.body("totalOrdersReturned", equalTo(1))
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
	
	
	@Test
	void test_pedido_by_purchase_date_and_cb() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&minDate=2020-04-27&orderOwnerTp=3"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(4))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(3))
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
		util.checkTotalElements(urlToTest, 4);
	}
	
	
	@Test
	void test_pedido_by_purchase_date_and_approved_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&minDate=2020-04-23&startApprovedDate=2020-04-23T00:00:00Z&finishApprovedDate=2020-04-23T23:59:59Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(3))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(1))
		.body("totalOrdersDelivered", equalTo(2))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-23T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-23T23:59:59"));
		util.checkTotalElements(urlToTest, 3);
	}
	
	
	@Test
	void test_pedido_by_purchase_date_and_approved_date_and_order_id() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&minDate=2020-04-23&startApprovedDate=2020-04-23T00:00:00Z&finishApprovedDate=2020-04-23T23:59:59Z&orderId=20693299901"; 
		
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
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-23T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-23T23:59:59"));
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_different_purchase_date_and_approved_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&minDate=2020-04-24&startApprovedDate=2020-04-23T00:00:00Z&finishApprovedDate=2020-04-23T23:59:59Z"; 
		
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
	void test_pedido_by_approved_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&startApprovedDate=2020-04-23T00:00:00Z&finishApprovedDate=2020-04-23T23:59:59Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(7))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(2))
		.body("totalOrdersDelivered", equalTo(5))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null, false, "approvedDate");
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-23T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-23T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 7);
	}
	
	
	@Test
	void test_pedido_by_approved_date_cb() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&startApprovedDate=2020-04-23T00:00:00Z&finishApprovedDate=2020-04-23T23:59:59Z&orderOwnerTp=3"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(4))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(2))
		.body("totalOrdersDelivered", equalTo(2))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null, false, "approvedDate");
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-23T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-23T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 4);
	}
	
	
	@Test
	void test_pedido_by_approved_date_customer_name() throws ParseException {
		
		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Carolina Barros", "Carolina", "12910284638");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&startApprovedDate=2020-04-23T00:00:00Z&finishApprovedDate=2020-04-23T23:59:59Z&customerName=" + utilTemp.CUSTOMER_NAME_FILTER;
		
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
		
		util.checkDateLimit(urlToTest, null, null, false, "approvedDate");
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-23T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-23T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_new_pending_and_purchase_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=NEW,PENDING&minDate=2020-04-23"; 
		
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
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-23T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-23T23:59:59"));
		util.checkStatus(urlToTest, new String[] {"PEN"});
		util.checkTotalElements(urlToTest, 3);
	}
	
	
	@Test
	void test_pedido_by_new_pending_and_purchase_date_and_customer_name() throws ParseException {
		
		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Igor Pires da Silva Alves Pereira", "Igor", "45618928850");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=NEW,PENDING&minDate=2020-04-23&customerName=" + utilTemp.CUSTOMER_NAME_FILTER; 
		
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
		.body("orderList.customerName", hasItem(utilTemp.CUSTOMER_NAME_COMPARE));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-23T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-23T23:59:59"));
		util.checkStatus(urlToTest, new String[] {"PEN"});
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_new_pending_and_purchase_date_and_cb() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=NEW,PENDING&minDate=2020-04-23&orderOwnerTp=3"; 
		
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
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-23T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-23T23:59:59"));
		util.checkStatus(urlToTest, new String[] {"PEN"});
		util.checkTotalElements(urlToTest, 3);
	}
	
	
	@Test
	void test_pedido_by_new_pending_and_purchase_date_and_order_id() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=NEW,PENDING&minDate=2020-04-23&orderId=20685347201"; 
		
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
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-23T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-23T23:59:59"));
		util.checkStatus(urlToTest, new String[] {"PEN"});
		util.checkTotalElements(urlToTest, 1);
	}
		
	
	@Test
	void test_pedido_by_new_pending_and_purchase_date_and_approved_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=NEW,PENDING&minDate=2020-04-23&startApprovedDate=2020-04-23T00:00:00Z&finishApprovedDate=2020-04-23T23:59:59Z"; 
		
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
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-23T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-23T23:59:59"));
		util.checkStatus(urlToTest, new String[] {"PEN"});
		util.checkTotalElements(urlToTest, 3);
	}
	
	
	@Test
	void test_pedido_by_new_pending_and_approved_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=NEW,PENDING&startApprovedDate=2020-04-23T00:00:00Z&finishApprovedDate=2020-04-23T23:59:59Z"; 
		
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
		//util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-23T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-23T23:59:59"), false, "approvedDate");
		util.checkStatus(urlToTest, new String[] {"PEN"});
		util.checkTotalElements(urlToTest, 3);
	}
	
	
	@Test
	void test_pedido_by_approved_sent_partially() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=APPROVED,SENT_PARTIALLY"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(3))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(2))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(1))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"PAY","PSH"});
		util.checkTotalElements(urlToTest, 3);
	}
	
	
	@Test
	void test_pedido_by_approved_sent_partially_and_customer_name() throws ParseException {
		
		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Silvia Leticia Lopes Bio pessoa", "Silvia", "16361267822");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=APPROVED,SENT_PARTIALLY&customerName=" + utilTemp.CUSTOMER_NAME_FILTER; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(1))
		.body("totalOrdersSent", equalTo(0))
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
		util.checkStatus(urlToTest, new String[] {"PAY","PSH"});
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_approved_sent_partially_and_purchase_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=APPROVED,SENT_PARTIALLY&minDate=2020-04-29"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(2))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(2))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"PAY","PSH"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-29T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-29T23:59:59"));
		util.checkTotalElements(urlToTest, 2);
	}
	
	
	@Test
	void test_pedido_by_approved_sent_partially_and_purchase_date_and_approved_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=APPROVED,SENT_PARTIALLY&minDate=2020-04-29&startApprovedDate=2020-04-29T00:00:00Z&finishApprovedDate=2020-04-29T23:59:59Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(2))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(2))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"PAY","PSH"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-29T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-29T23:59:59"));
		util.checkTotalElements(urlToTest, 2);
	}
	
	
	@Test
	void test_pedido_by_approved_sent_partially_and_approved_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=APPROVED,SENT_PARTIALLY&startApprovedDate=2020-04-29T00:00:00Z&finishApprovedDate=2020-04-29T23:59:59Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(3))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(2))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(1))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"PAY","PSH"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-29T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-29T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 3);
	}
	
	
	@Test
	void test_pedido_by_sent_partially_delivered() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=SENT,PARTIALLY_DELIVERED"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(33))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(31))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(2))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"SHP","PDL"});
		util.checkTotalElements(urlToTest, 33);
	}
	

	
	@Test
	void test_pedido_by_sent_partially_delivered_by_customer() throws ParseException {
		
		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Amanda Grazielle Soares Giffoni", "Amanda", "07222133607");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=SENT,PARTIALLY_DELIVERED&customerName=" + utilTemp.CUSTOMER_NAME_FILTER; 
		
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
		util.checkStatus(urlToTest, new String[] {"SHP","PDL"});
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_sent_partially_delivered_and_purchase_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=SENT,PARTIALLY_DELIVERED&minDate=2020-04-28"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(2))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(2))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"SHP","PDL"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-28T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-28T23:59:59"));
		util.checkTotalElements(urlToTest, 2);
	}
	
	
	
	@Test
	void test_pedido_by_sent_partially_delivered_and_purchase_date_and_approved_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=SENT,PARTIALLY_DELIVERED&minDate=2020-04-28&startApprovedDate=2020-04-28T00:00:00Z&finishApprovedDate=2020-04-28T23:59:59Z"; 
		
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
		util.checkStatus(urlToTest, new String[] {"SHP","PDL"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-28T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-28T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_sent_partially_delivered_and_approved_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=SENT,PARTIALLY_DELIVERED&startApprovedDate=2020-04-28T00:00:00Z&finishApprovedDate=2020-04-28T23:59:59Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(6))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(6))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));
		
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"SHP","PDL"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-28T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-28T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 6);
	}
	
	
	
	@Test
	void test_pedido_by_sent_partially_delivered_and_approved_date_and_customer_name() throws ParseException {
		
		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Iracema Da Conceio Silva", "Iracema", "03969939585");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=SENT,PARTIALLY_DELIVERED&startApprovedDate=2020-04-28T00:00:00Z&finishApprovedDate=2020-04-28T23:59:59Z&customerName=" + utilTemp.CUSTOMER_NAME_FILTER; 
		
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
		util.checkStatus(urlToTest, new String[] {"SHP","PDL"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-28T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-28T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_delivered_cancel() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=DELIVERED,CANCEL"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(280))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(235))
		.body("totalOrdersCanceled", equalTo(45))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"DLV","CAN"});
		util.checkTotalElements(urlToTest, 280);
	}
	
	
	@Test
	void test_pedido_by_delivered_cancel_purchase_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=DELIVERED,CANCEL&minDate=2020-04-22"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(3))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(3))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"DLV","CAN"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-22T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-22T23:59:59"));
		util.checkTotalElements(urlToTest, 3);
	}
	
	
	@Test
	void test_pedido_by_delivered_cancel_purchase_date_and_approved_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=DELIVERED,CANCEL&minDate=2020-04-22&startApprovedDate=2020-04-22T00:00:00Z&finishApprovedDate=2020-04-22T23:59:59Z"; 
		
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

		
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"DLV","CAN"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-22T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-22T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 2);
	}
	
	
	@Test
	void test_pedido_by_delivered_cancel_and_approved_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=DELIVERED,CANCEL&startApprovedDate=2020-04-22T00:00:00Z&finishApprovedDate=2020-04-22T23:59:59Z"; 
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(6))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(6))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"DLV","CAN"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-22T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-22T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 6);
	}
	
	
	@Test
	void test_pedido_by_delivered_cancel_and_approved_date_and_customer_name() throws ParseException {
		
		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Narclio Laponez da Silveira", "Narclio", "19976577672");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=DELIVERED,CANCEL&startApprovedDate=2020-04-22T00:00:00Z&finishApprovedDate=2020-04-22T23:59:59Z&customerName=" + utilTemp.CUSTOMER_NAME_FILTER; 
		
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

		
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"DLV","CAN"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-22T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-22T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_approved_and_purchase_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=APPROVED&minDate=2020-04-29";
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(2))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(2))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"PAY"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-29T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-29T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 2);
	}
	
	
	
	@Test
	void test_pedido_by_approved_and_approved_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=APPROVED&startApprovedDate=2020-04-29T00:00:00Z&finishApprovedDate=2020-04-29T23:59:59Z";
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(2))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(2))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"PAY"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-29T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-29T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 2);
	}
	
	
	@Test
	void test_pedido_by_approved_and_purchase_date_and_approved_date() throws ParseException {
		
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=APPROVED&startApprovedDate=2020-04-29T00:00:00Z&finishApprovedDate=2020-04-29T23:59:59Z&minDate=2020-04-29";
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(2))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(2))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null);
		util.checkStatus(urlToTest, new String[] {"PAY"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-29T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-29T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 2);
	}
	
	
	@Test
	void test_pedido_by_approved_and_approved_date_and_customer_name() throws ParseException {
		
		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Silvia Leticia Lopes Bio pessoa", "Silvia", "16361267822");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=APPROVED&startApprovedDate=2020-04-29T00:00:00Z&finishApprovedDate=2020-04-29T23:59:59Z&customerName=" + utilTemp.CUSTOMER_NAME_FILTER;
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(1))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(1))
		.body("totalOrdersSent", equalTo(0))
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
		util.checkStatus(urlToTest, new String[] {"PAY"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-29T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-29T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_cancel_and_purchase_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=CANCEL&minDate=2020-04-18";
		
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
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "CAN");
		util.checkStatus(urlToTest, new String[] {"CAN"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-18T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-18T23:59:59"));
		util.checkTotalElements(urlToTest, 2);
	}
	
	
	@Test
	void test_pedido_by_cancel_and_approved_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=CANCEL&startApprovedDate=2020-04-29T00:00:00Z&finishApprovedDate=2020-04-29T23:59:59Z";
		
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

		
		util.checkDateLimit(urlToTest, null, null, true, "CAN");
		util.checkStatus(urlToTest, new String[] {"CAN"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-29T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-29T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	
	@Test
	void test_pedido_by_cancel_and_purchase_date_and_approved_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=CANCEL&minDate=2020-04-18&startApprovedDate=2020-04-20T00:00:00Z&finishApprovedDate=2020-04-20T23:59:59Z";
		
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

		
		util.checkDateLimit(urlToTest, null, null, true, "CAN");
		util.checkStatus(urlToTest, new String[] {"CAN"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-18T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-18T23:59:59"));
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	
	@Test
	void test_pedido_by_cancel_and_purchase_date_and_customer_name() throws ParseException {

		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Rosa Santos Azevedo", "Rosa", "86748777372");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=CANCEL&minDate=2020-04-18&customerName=" + utilTemp.CUSTOMER_NAME_FILTER;
		
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
		util.checkStatus(urlToTest, new String[] {"CAN"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-18T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-18T23:59:59"));
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_pending_and_purchase_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=PENDING&minDate=2020-04-16";
		
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
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "PEN");
		util.checkStatus(urlToTest, new String[] {"PEN"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-16T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-16T23:59:59"));
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	
	@Test
	void test_pedido_by_pending_and_purchase_date_and_approved_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=PENDING&minDate=2020-04-16&startApprovedDate=2020-04-16T00:00:00Z&finishApprovedDate=2020-04-16T23:59:59Z";
		
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
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "PEN");
		util.checkStatus(urlToTest, new String[] {"PEN"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-16T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-16T23:59:59"));
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	
	@Test
	void test_pedido_by_pending_and_approved_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=PENDING&startApprovedDate=2020-04-16T00:00:00Z&finishApprovedDate=2020-04-16T23:59:59Z";
		
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
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "PEN");
		util.checkStatus(urlToTest, new String[] {"PEN"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-16T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-16T23:59:59"));
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	
	@Test
	void test_pedido_by_sent_partially_and_purchase_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=SENT_PARTIALLY&minDate=2020-04-28";
		
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
		.body("totalOrdersSentPartially", equalTo(1))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		util.checkStatus(urlToTest, new String[] {"PSH"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-28T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-28T23:59:59"));
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_sent_partially_and_purchase_date_approved_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=SENT_PARTIALLY&minDate=2020-04-28&startApprovedDate=2020-04-29T00:00:00Z&finishApprovedDate=2020-04-29T23:59:59Z";
		
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
		.body("totalOrdersSentPartially", equalTo(1))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		util.checkStatus(urlToTest, new String[] {"PSH"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-28T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-28T23:59:59"));
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	
	@Test
	void test_pedido_by_sent_partially_and_approved_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=SENT_PARTIALLY&startApprovedDate=2020-04-29T00:00:00Z&finishApprovedDate=2020-04-29T23:59:59Z";
		
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
		.body("totalOrdersSentPartially", equalTo(1))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		util.checkStatus(urlToTest, new String[] {"PSH"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-29T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-29T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	
	@Test
	void test_pedido_by_sent_and_purchase_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=SENT&minDate=2020-04-27";
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(7))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(7))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		util.checkStatus(urlToTest, new String[] {"SHP"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-27T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-28T23:59:59"));
		util.checkTotalElements(urlToTest, 7);
	}
	
	
	
	@Test
	void test_pedido_by_sent_and_purchase_date_and_approved_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=SENT&minDate=2020-04-27&startApprovedDate=2020-04-27T00:00:00Z&finishApprovedDate=2020-04-27T23:59:59Z";
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(6))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(6))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		util.checkStatus(urlToTest, new String[] {"SHP"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-27T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-27T23:59:59"));
		util.checkTotalElements(urlToTest, 6);
	}
	
	
	@Test
	void test_pedido_by_sent_and_approved_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=SENT&startApprovedDate=2020-04-27T00:00:00Z&finishApprovedDate=2020-04-27T23:59:59Z";
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(8))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(8))
		.body("totalOrdersDelivered", equalTo(0))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		util.checkStatus(urlToTest, new String[] {"SHP"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-27T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-27T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 8);
	}
	
	
	@Test
	void test_pedido_by_partially_delivered_and_purchase_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=PARTIALLY_DELIVERED&minDate=2020-04-25";
		
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
		.body("totalOrdersPartiallyDelivered", equalTo(1))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		util.checkStatus(urlToTest, new String[] {"PDL"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-25T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-25T23:59:59"));
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_partially_delivered_and_purchase_date_and_approved_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=PARTIALLY_DELIVERED&minDate=2020-04-25&startApprovedDate=2020-04-25T00:00:00Z&finishApprovedDate=2020-04-25T23:59:59Z";
		
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
		.body("totalOrdersPartiallyDelivered", equalTo(1))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		util.checkStatus(urlToTest, new String[] {"PDL"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-25T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-25T23:59:59"));
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_partially_delivered_and_approved_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=PARTIALLY_DELIVERED&startApprovedDate=2020-04-25T00:00:00Z&finishApprovedDate=2020-04-25T23:59:59Z";
		
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
		.body("totalOrdersPartiallyDelivered", equalTo(1))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "ETR");
		util.checkStatus(urlToTest, new String[] {"PDL"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-25T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-25T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_delivered_and_purchase_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=DELIVERED&minDate=2020-01-07";
		
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

		
		util.checkDateLimit(urlToTest, null, null, true, "ENT");
		util.checkStatus(urlToTest, new String[] {"DLV"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-01-07T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-01-07T23:59:59"));
		util.checkTotalElements(urlToTest, 2);
	}
	
	
	@Test
	void test_pedido_by_delivered_and_purchase_date_and_approved_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=DELIVERED&minDate=2020-01-07&startApprovedDate=2020-01-09T00:00:00Z&finishApprovedDate=2020-01-09T23:59:59Z";
		
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

		
		util.checkDateLimit(urlToTest, null, null, true, "ENT");
		util.checkStatus(urlToTest, new String[] {"DLV"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-01-07T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-01-07T23:59:59"));
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_delivered_and_approved_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=DELIVERED&startApprovedDate=2020-01-09T00:00:00Z&finishApprovedDate=2020-01-09T23:59:59Z";
		
		get(urlToTest)
		.then()
		.assertThat()
		.statusCode(200)
		.body("totalRows", equalTo(3))
		.body("totalOrdersNew", equalTo(0))
		.body("totalOrdersApproved", equalTo(0))
		.body("totalOrdersSent", equalTo(0))
		.body("totalOrdersDelivered", equalTo(3))
		.body("totalOrdersCanceled", equalTo(0))
		.body("totalOrdersReturned", equalTo(0))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "ENT");
		util.checkStatus(urlToTest, new String[] {"DLV"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-01-09T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-01-09T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 3);
	}
	
	
	
	@Test
	void test_pedido_by_returned() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=RETURNED";
		
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
		.body("totalOrdersReturned", equalTo(1))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "DVC");
		util.checkStatus(urlToTest, new String[] {"DVC"});
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_returned_and_customer_name() throws ParseException {

		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Pmela Tailine de Souza", "Pmela", "46885350826");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=RETURNED&customerName=" + utilTemp.CUSTOMER_NAME_FILTER;
		
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
		.body("totalOrdersReturned", equalTo(1))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.customerName", hasItem(utilTemp.CUSTOMER_NAME_COMPARE));

		
		util.checkDateLimit(urlToTest, null, null, true, "DVC");
		util.checkStatus(urlToTest, new String[] {"DVC"});
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	
	@Test
	void test_pedido_by_returned_and_purchase_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=RETURNED&minDate=2020-04-09";
		
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
		.body("totalOrdersReturned", equalTo(1))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "DVC");
		util.checkStatus(urlToTest, new String[] {"DVC"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-09T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-09T23:59:59"));
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	
	@Test
	void test_pedido_by_returned_and_purchase_date_and_approved_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=RETURNED&minDate=2020-04-09&startApprovedDate=2020-04-09T00:00:00Z&finishApprovedDate=2020-04-09T23:59:59Z";
		
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
		.body("totalOrdersReturned", equalTo(1))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "DVC");
		util.checkStatus(urlToTest, new String[] {"DVC"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-09T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-09T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	@Test
	void test_pedido_by_returned_and_approved_date() throws ParseException {

		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=RETURNED&startApprovedDate=2020-04-09T00:00:00Z&finishApprovedDate=2020-04-09T23:59:59Z";
		
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
		.body("totalOrdersReturned", equalTo(1))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0));

		
		util.checkDateLimit(urlToTest, null, null, true, "DVC");
		util.checkStatus(urlToTest, new String[] {"DVC"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-09T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-09T23:59:59"), false, "approvedDate");
		util.checkTotalElements(urlToTest, 1);
	}
	
	
	
	@Test
	void test_pedido_by_returned_and_purchase_date_and_customer_name() throws ParseException {

		RestAssuredTestUtil utilTemp = new RestAssuredTestUtil("Pmela Tailine de Souza", "Pmela", "46885350826");
		String urlToTest = "http://localhost:8200/deprecated/api/compra/v2?storeQualifierId=33612&startRow=0&pageRows=350&status=RETURNED&minDate=2020-04-09&customerName=" + utilTemp.CUSTOMER_NAME_FILTER;
		
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
		.body("totalOrdersReturned", equalTo(1))
		.body("totalOrdersPartiallyDelivered", equalTo(0))
		.body("totalOrdersSentPartially", equalTo(0))
		.body("totalOrdersPending", equalTo(0))
		.body("totalOrdersRemovalAvailable", equalTo(0))
		.body("totalOrdersRefusedPayment", equalTo(0))
		.body("orderList.customerName", hasItem(utilTemp.CUSTOMER_NAME_COMPARE));

		
		util.checkDateLimit(urlToTest, null, null, true, "DVC");
		util.checkStatus(urlToTest, new String[] {"DVC"});
		util.checkDateLimit(urlToTest, RestAssuredTestUtil.dateFormat.parse("2020-04-09T00:00:00"), RestAssuredTestUtil.dateFormat.parse("2020-04-09T23:59:59"));
		util.checkTotalElements(urlToTest, 1);
	}
}
