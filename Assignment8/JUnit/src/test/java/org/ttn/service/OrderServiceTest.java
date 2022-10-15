package org.ttn.service;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.ttn.domain.Order;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    /*
    InjectMocks creates actual objects and injects mocked dependencies into it.

    - Use @InjectMocks to create class instances that need to be tested in the test class. We call it 'code under test'
      or 'system under test'.
    - Use @InjectMocks when actual method body needs to be executed for a given class.
    - Use @InjectMocks when we need all or few internal dependencies initialized with mock objects to work method correctly.
    - Use @Mock to create mocks that are needed to support the testing of SUT.
    - We must define the when(...).thenReturn(...) methods for mock objects whose class methods will be invoked during actual test execution.
     */

    // Spy and Inject mock sound similar ???

    // @Spy and @Mock are meant for dependencies, and not for the functionality you are testing.
    // you should use it when you have a collaborator that you want to stub or verify.


    @Mock
    EmailService emailService;

    @InjectMocks
    OrderService orderService; // System under test

    @Test
    public void testPlaceOrder(){
        // setup
        Order order = new Order(2, "30W Charger", 2999);

        // Act
        orderService.placeOrder(order);


        // Assertions
        // Since it does not return anything, I can check behaviour of the invoked methods inside it.


        // check the expected method is invoked by email service
        verify(emailService, atLeastOnce()).sendEmail(order);


        // check if Price with tax is set properly
        // 2999 + 0.2*2999 = priceWithTax
        assertEquals(3598.8d, order.getPriceWithTax(),0.1);

        // check that order notified property is true
        assertTrue(order.isCustomerNotified());

    }

    @Test
    public void testPlaceOrder_returnsTrue(){
        Order order = new Order(2, "30W Charger", 2999);

        when(emailService.sendEmail(order,"abc@example.com")).thenReturn(true);

        assertTrue(orderService.placeOrder(order,"abc@example.com"));

    }

}
