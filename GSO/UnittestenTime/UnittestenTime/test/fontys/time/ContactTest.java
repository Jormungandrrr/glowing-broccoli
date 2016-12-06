/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marc
 */
public class ContactTest {
    
    public ContactTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Contact.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Contact instance = new Contact("Rens");
        String expResult = "Rens";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of addAppointment method, of class Contact.
     */
    @Test
    public void testAddAppointmentTrue() {
        System.out.println("addAppointment");
        ITime Begintijd = new Time(2016,10,13,8,00);
        ITime Eindtijd = new Time(2016,10,13,9,00);
        TimeSpan timespan = new TimeSpan(Begintijd, Eindtijd);
        Appointment a = new Appointment("Test",timespan);
        Contact instance = new Contact("Rens");
        boolean expResult = true;
        boolean result = instance.addAppointment(a);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of addAppointment method, of class Contact.
     */
    @Test
    public void testAddAppointmentFalse() {
        System.out.println("addAppointment");
        ITime Begintijd = new Time(2016,10,13,8,00);
        ITime Eindtijd = new Time(2016,10,13,9,00);
        TimeSpan timespan = new TimeSpan(Begintijd, Eindtijd);
        Appointment a = new Appointment("Test",timespan);
        Contact instance = new Contact("Rens");
        boolean addA = instance.addAppointment(a);
        boolean expResult = false;
        boolean result = instance.addAppointment(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeAppointment method, of class Contact.
     */
    @Test
    public void testRemoveAppointmentTrue() {
        System.out.println("removeAppointmentTrue");
        ITime Begintijd = new Time(2016,10,13,8,00);
        ITime Eindtijd = new Time(2016,10,13,9,00);
        TimeSpan timespan = new TimeSpan(Begintijd, Eindtijd);
        Appointment a = new Appointment("Test",timespan);
        Contact instance = new Contact("Rens");
        instance.addAppointment(a);
        boolean expResult = true;
        boolean result = instance.removeAppointment(a);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of removeAppointment method, of class Contact.
     */
    @Test
    public void testRemoveAppointmentFalse() {
        System.out.println("removeAppointment");
        ITime Begintijd = new Time(2016,10,13,8,00);
        ITime Eindtijd = new Time(2016,10,13,9,00);
        TimeSpan timespan = new TimeSpan(Begintijd, Eindtijd);
        Appointment a = new Appointment("Test",timespan);
        Contact instance = new Contact("Rens");
        boolean expResult = false;
        boolean result = instance.removeAppointment(a);
        assertEquals(expResult, result);
    }
    
    

    /**
     * Test of appointments method, of class Contact.
     */
    @Test
    public void testAppointments() {
        System.out.println("appointments");
        Contact contact = new Contact("Rens");
        ITime Begintijd = new Time(2016,10,13,8,00);
        ITime Eindtijd = new Time(2016,10,13,9,00);
        TimeSpan timespan = new TimeSpan(Begintijd, Eindtijd);
        Appointment a = new Appointment("Test",timespan);
        contact.addAppointment(a);
        Iterator expResult = contact.agenda.iterator();
        Iterator result = contact.appointments();    
         while(result.hasNext() && expResult.hasNext()) {
         Object element1 = result.next();
         Object element2 = expResult.next();    
         assertEquals(element1, element2);
      }

    }
    
}
