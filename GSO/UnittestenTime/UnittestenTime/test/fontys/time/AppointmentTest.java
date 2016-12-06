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
 * @author Jorrit
 */
public class AppointmentTest {
    
        ITime Begintijd = new Time(1992,10,13,7,40);
        ITime Eindtijd = new Time(1993,11,14,8,40);
    
    public AppointmentTest() {
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
     * Test of getSubject method, of class Appointment.
     */
    @Test
    public void testGetSubject() {
        System.out.println("getSubject");
        Appointment instance = new Appointment("Subject", new TimeSpan2(Begintijd, Eindtijd));
        String expResult = "Subject";
        String result = instance.getSubject();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTimeSpan method, of class Appointment.
     */
    @Test
    public void testGetTimeSpan() {
        System.out.println("getTimeSpan");
        Appointment instance = new Appointment("Subject", new TimeSpan2(Begintijd, Eindtijd));
        ITimeSpan expResult = new TimeSpan2(Begintijd, Eindtijd);
        ITimeSpan result = instance.getTimeSpan();
        assertEquals(expResult.getBeginTime(), result.getBeginTime());
        assertEquals(expResult.getEndTime(), result.getEndTime());
    }

    /**
     * Test of invitees method, of class Appointment.
     */
    @Test
    public void testInvitees() {
        System.out.println("invitees");
        Appointment instance = new Appointment("Subject", new TimeSpan2(Begintijd, Eindtijd));
        Contact c = new Contact("Henk");
        instance.addContact(c);
        Iterator<Contact> result = instance.invitees();
        
        List<Contact> expinvitees = new ArrayList<Contact>();
        expinvitees.add(c);
        Iterator<Contact> expResult = expinvitees.iterator();
        
        while(result.hasNext() && expResult.hasNext())
        {
            Object e1 = result.next();
            Object e2 = expResult.next();
            assertEquals(e1,e2);
        }
    }

    /**
     * Test of addContact method, of class Appointment.
     */
    @Test
    public void testAddContact() {
        System.out.println("addContact");
        Contact c = new Contact("Henk");
        Appointment instance = new Appointment("Subject", new TimeSpan2(Begintijd, Eindtijd));
        assertEquals(true,instance.addContact(c));
        assertEquals(false,instance.addContact(c));
    }

    /**
     * Test of removeContact method, of class Appointment.
     */
    @Test
    public void testRemoveContact() {
        System.out.println("removeContact");
        Contact c = new Contact("Henk");
        Appointment instance = new Appointment("Subject", new TimeSpan2(Begintijd, Eindtijd));
        instance.addContact(c);
        instance.removeContact(c);
        assertEquals(instance.invitees.isEmpty(), true);
    }
    
}
