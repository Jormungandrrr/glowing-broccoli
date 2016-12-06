/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

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
public class TimeSpanTest {
    
 
    
    public TimeSpanTest() {
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
     * Test of getBeginTime method, of class TimeSpan.
     */
    
        @Test
    (expected = IllegalArgumentException.class)
        public void TimeSpanTestException() {     
        ITime Begintijd = new Time(1992,10,13,7,40);
        ITime Eindtijd = new Time(1991,11,14,8,40);
        TimeSpan instance = new TimeSpan(Begintijd, Eindtijd);
        }
         
    @Test
    public void testGetBeginTime() {
        System.out.println("getBeginTime");
        ITime Begintijd = new Time(1992,10,13,7,40);
        ITime Eindtijd = new Time(1993,11,14,8,40);
        TimeSpan instance = new TimeSpan(Begintijd, Eindtijd);
        ITime expResult = Begintijd;
        ITime result = instance.getBeginTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEndTime method, of class TimeSpan.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        ITime Begintijd = new Time(1992,10,13,7,40);
        ITime Eindtijd = new Time(1993,11,14,8,40);
        TimeSpan instance = new TimeSpan(Begintijd, Eindtijd);
        ITime expResult = Eindtijd;
        ITime result = instance.getEndTime();
        assertEquals(expResult, result);
    }

    
    



    /**
     * Test of length method, of class TimeSpan.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        ITime Begintijd = new Time(1992,10,13,7,40);
        ITime Eindtijd = new Time(1992,10,13,7,50);
        TimeSpan instance = new TimeSpan(Begintijd, Eindtijd);
        int expResult = 1;
        int result = instance.length();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBeginTime method, of class TimeSpan.
     */
    @Test
    public void testSetBeginTime() {
        ITime Begintijd = new Time(1992,10,13,7,40);
        ITime Eindtijd = new Time(1993,11,14,8,40);
        ITime Testtijd = new Time(1992,10,20,6,40);
        TimeSpan instance = new TimeSpan(Begintijd, Eindtijd);
        instance.setBeginTime(Testtijd);
        assertEquals(Testtijd,instance.getBeginTime());
        
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    (expected = IllegalArgumentException.class)
    public void testSetBeginTime2() {
        // TODO review the generated test code and remove the default call to fail.      
        ITime Begintijd = new Time(1992,10,13,7,40);
        ITime Eindtijd = new Time(1993,11,14,8,40);
        ITime Testtijd = new Time(1994,9,20,5,40);
        TimeSpan instance = new TimeSpan(Begintijd, Eindtijd);
        instance.setBeginTime(Testtijd);
    }

    /**
     * Test of setEndTime method, of class TimeSpan.
     */
    @Test
    public void testSetEndTime() {
        ITime Begintijd = new Time(1992,10,13,7,40);
        ITime Eindtijd = new Time(1993,11,14,8,40);
        ITime Testtijd = new Time(1992,11,20,7,40);
        TimeSpan instance = new TimeSpan(Begintijd, Eindtijd);
        instance.setEndTime(Testtijd);
        assertEquals(Testtijd,instance.getEndTime());
        // TODO review the generated test code and remove the default call to fail.
    }
    
        @Test
    (expected = IllegalArgumentException.class)
        public void testSetEndTime2() {
        // TODO review the generated test code and remove the default call to fail.     
        ITime Begintijd = new Time(1992,10,13,7,40);
        ITime Eindtijd = new Time(1993,11,14,8,40);
        ITime Testtijd = new Time(1991,8,20,7,40);
        TimeSpan instance = new TimeSpan(Begintijd, Eindtijd);
        instance.setEndTime(Testtijd);
    }

    /**
     * Test of move method, of class TimeSpan.
     */
    @Test
    public void testMove() {
        int minutes = 1;
        ITime Begintijd = new Time(1992,10,13,7,40);
        ITime Eindtijd = new Time(1993,11,14,8,40);
        TimeSpan instance = new TimeSpan(Begintijd, Eindtijd);
        instance.move(minutes);
        assertEquals(41 , instance.getBeginTime().getMinutes());
        assertEquals(41 , instance.getEndTime().getMinutes());
        
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of changeLengthWith method, of class TimeSpan.
     */
    @Test
    public void testChangeLengthWith() {
        int minutes = 1;
        ITime Begintijd = new Time(1992,10,13,7,40);
        ITime Eindtijd = new Time(1993,11,14,8,40);
        TimeSpan instance = new TimeSpan(Begintijd, Eindtijd);
        instance.changeLengthWith(minutes);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(41 , instance.getEndTime().getMinutes());
    }
    
    @Test 
    (expected = IllegalArgumentException.class)
    public void testChangeLengthWith2() {
        // TODO review the generated test code and remove the default call to fail.     
        int minutes = -1;
        ITime Begintijd = new Time(1992,10,13,7,40);
        ITime Eindtijd = new Time(1993,11,14,8,40);
        TimeSpan instance = new TimeSpan(Begintijd, Eindtijd);
        instance.changeLengthWith(minutes);
    }



    /**
     * Test of isPartOf method, of class TimeSpan.
     */
    @Test
    public void testIsPartOf() {
        System.out.println("isPartOf");
        ITime Begintijd = new Time(1992,10,13,7,40);
        ITime Eindtijd = new Time(1993,11,14,8,40);
        ITime Begintijd1 = new Time(1994,8,13,7,40);
        ITime Eindtijd1 = new Time(1995,11,14,8,40);
        ITimeSpan timeSpan = new TimeSpan(Begintijd,Eindtijd);
        TimeSpan instance = new TimeSpan(Begintijd1,Eindtijd1);
        boolean expResult = false;
        boolean result = instance.isPartOf(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
        @Test
    public void testIsPartOf2() {
        System.out.println("isPartOf");
        ITime Begintijd = new Time(1995,10,13,7,40);
        ITime Eindtijd = new Time(1996,8,14,8,40);
        ITime Begintijd1 = new Time(1994,8,13,7,40);
        ITime Eindtijd1 = new Time(1998,11,14,8,40);
        ITimeSpan timeSpan = new TimeSpan(Begintijd,Eindtijd);
        TimeSpan instance = new TimeSpan(Begintijd1,Eindtijd1);
        boolean expResult = true;
        boolean result = instance.isPartOf(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testIsPartOf3() {
        System.out.println("isPartOf");
        ITime Begintijd = new Time(1997,10,13,7,40);
        ITime Eindtijd = new Time(1999,8,14,8,40);
        ITime Begintijd1 = new Time(1994,8,13,7,40);
        ITime Eindtijd1 = new Time(1998,11,14,8,40);
        ITimeSpan timeSpan = new TimeSpan(Begintijd,Eindtijd);
        TimeSpan instance = new TimeSpan(Begintijd1,Eindtijd1);
        boolean expResult = false;
        boolean result = instance.isPartOf(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of unionWith method, of class TimeSpan.
     */
    @Test
    public void testUnionWith() {
        System.out.println("unionWith");
        ITime Begintijd = new Time(1992,10,13,7,40);
        ITime Eindtijd = new Time(1993,11,14,8,40);
        ITime Begintijd1 = new Time(1994,8,13,7,40);
        ITime Eindtijd1 = new Time(1995,11,14,8,40);
        ITimeSpan timeSpan = new TimeSpan(Begintijd,Eindtijd);
        TimeSpan instance = new TimeSpan(Begintijd1,Eindtijd1);
        ITimeSpan expResult = null;
        ITimeSpan result = instance.unionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
        @Test
    public void testUnionWith2() {
        System.out.println("unionWith");
        ITime Begintijd = new Time(1995,10,13,7,40);
        ITime Eindtijd = new Time(1997,11,14,8,40);
        ITimeSpan timeSpan = new TimeSpan(Begintijd,Eindtijd);
        
        ITime Begintijd1 = new Time(1994,8,13,7,40);
        ITime Eindtijd1 = new Time(1996,11,14,8,40);
        TimeSpan instance = new TimeSpan(Begintijd1,Eindtijd1);
        
        ITimeSpan expResult = null;
        ITimeSpan result = instance.unionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testUnionWith3() {
        System.out.println("unionWith");
        ITime Begintijd = new Time(1993,10,13,7,40);
        ITime Eindtijd = new Time(1995,11,14,8,40);
        ITime Begintijd1 = new Time(1994,8,13,7,40);
        ITime Eindtijd1 = new Time(1996,11,14,8,40);
        ITimeSpan timeSpan = new TimeSpan(Begintijd,Eindtijd);
        TimeSpan instance = new TimeSpan(Begintijd1,Eindtijd1);
        ITimeSpan expResult = null;
        ITimeSpan result = instance.unionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testUnionWith4() {
        System.out.println("unionWith");
        ITime Begintijd = new Time(1993,10,13,7,40);
        ITime Eindtijd = new Time(1997,8,13,7,40);
        ITime Begintijd1 = new Time(1994,8,13,7,40);
        ITime Eindtijd1 = new Time(1996,11,14,8,40);
        ITimeSpan timeSpan = new TimeSpan(Begintijd,Eindtijd);
        TimeSpan instance = new TimeSpan(Begintijd1,Eindtijd1);
        ITimeSpan expResult = null;
        ITimeSpan result = instance.unionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
        @Test
    public void testUnionWith5() {
        System.out.println("unionWith");
        ITime Begintijd = new Time(1997,10,13,7,40);
        ITime Eindtijd = new Time(1998,8,13,7,40);
        ITime Begintijd1 = new Time(1994,8,13,7,40);
        ITime Eindtijd1 = new Time(1996,11,14,8,40);
        ITimeSpan timeSpan = new TimeSpan(Begintijd,Eindtijd);
        TimeSpan instance = new TimeSpan(Begintijd1,Eindtijd1);
        ITimeSpan expResult = null;
        ITimeSpan result = instance.unionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of intersectionWith method, of class TimeSpan.
     */
    @Test
    public void testIntersectionWith() {
        System.out.println("intersectionWith");
        ITime Begintijd = new Time(1992,10,13,7,40);
        ITime Eindtijd = new Time(1993,11,14,8,40);
        ITime Begintijd1 = new Time(1994,8,13,7,40);
        ITime Eindtijd1 = new Time(1995,11,14,8,40);
        ITimeSpan timeSpan = new TimeSpan(Begintijd,Eindtijd);
        TimeSpan instance = new TimeSpan(Begintijd1,Eindtijd1);
        ITimeSpan expResult = null;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
        @Test
    public void testIntersectionWith2() {
        System.out.println("intersectionWith");
        ITime Begintijd = new Time(1995,10,13,7,40);
        ITime Eindtijd = new Time(1997,11,14,8,40);
        ITime Begintijd1 = new Time(1994,8,13,7,40);
        ITime Eindtijd1 = new Time(1996,11,14,8,40);
        ITimeSpan timeSpan = new TimeSpan(Begintijd,Eindtijd);
        TimeSpan instance = new TimeSpan(Begintijd1,Eindtijd1);
        ITimeSpan expResult = null;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
        @Test
    public void testIntersectionWith3() {
        System.out.println("intersectionWith");
        ITime Begintijd = new Time(1993,10,13,7,40);
        ITime Eindtijd = new Time(1995,11,14,8,40);
        ITime Begintijd1 = new Time(1994,8,13,7,40);
        ITime Eindtijd1 = new Time(1996,11,14,8,40);
        ITimeSpan timeSpan = new TimeSpan(Begintijd,Eindtijd);
        TimeSpan instance = new TimeSpan(Begintijd1,Eindtijd1);
        ITimeSpan expResult = null;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
            @Test
    public void testIntersectionWith4() {
        System.out.println("intersectionWith");
        ITime Begintijd = new Time(1993,10,13,7,40);
        ITime Eindtijd = new Time(1997,8,13,7,40);
        ITime Begintijd1 = new Time(1994,8,13,7,40);
        ITime Eindtijd1 = new Time(1996,11,14,8,40);
        ITimeSpan timeSpan = new TimeSpan(Begintijd,Eindtijd);
        TimeSpan instance = new TimeSpan(Begintijd1,Eindtijd1);
        ITimeSpan expResult = null;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testIntersectionWith5() {
        System.out.println("intersectionWith");
        ITime Begintijd = new Time(1997,10,13,7,40);
        ITime Eindtijd = new Time(1998,8,13,7,40);
        ITime Begintijd1 = new Time(1994,8,13,7,40);
        ITime Eindtijd1 = new Time(1996,11,14,8,40);
        ITimeSpan timeSpan = new TimeSpan(Begintijd,Eindtijd);
        TimeSpan instance = new TimeSpan(Begintijd1,Eindtijd1);
        ITimeSpan expResult = null;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    
    @Test
    public void testIntersectionWith6() {
        System.out.println("intersectionWith");
        ITime Begintijd = new Time(1996,10,13,7,40);
        ITime Eindtijd = new Time(1998,8,13,7,40);
        ITime Begintijd1 = new Time(1997,10,13,7,40);
        ITime Eindtijd1 = new Time(1998,8,13,7,40);
        ITimeSpan timeSpan = new TimeSpan(Begintijd,Eindtijd);
        TimeSpan instance = new TimeSpan(Begintijd1,Eindtijd1);
        ITimeSpan expResult = null;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
}
