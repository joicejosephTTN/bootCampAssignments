package org.ttn.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.ttn.domain.Order;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {


     /*
      A mock object is a proxy interface to hide an underlying dependency with cannot be tested in a test environment
     e.g. database, network locations etc. A method invoked using mocked reference does not execute the actual method
     body defined in the class file, rather the method behavior is configured using when(...).thenReturn(...) methods.

       - In a junit test, we create objects for the class which need to be tested and its methods to be invoked.
       - We create mocks for the dependencies which will not be present in the test environment and objects are
         dependent on it to complete the method call.
      */


    @Test
    public void testSendEmail_ExceptionThrown() {

        // Setup
        EmailService dummyService = mock(EmailService.class);
        Order order2 = new Order(1,"someBook",200);


        // Setting up stubbed responses using mocks
        // use doThrow, doReturn, doNothing, etc. to mock void methods
        doThrow(new RuntimeException("An Exception Occurred")).when(dummyService).sendEmail(order2);

        // Act
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            dummyService.sendEmail(order2);
        });


        // Assert
        String expectedMessage = "An Exception Occurred";
        String actualMessage = exception.getMessage();
        assertEquals(actualMessage,expectedMessage);

    }

    @Test
    public void testSendEmail(){

        EmailService dummyService = mock(EmailService.class);
        Order order1 = new Order(1,"someBook",200);

        when(dummyService.sendEmail(order1,"abc@gmail.com")).thenReturn(true);

        assertTrue(dummyService.sendEmail(order1,"abc@gmail.com"));

    }



}
