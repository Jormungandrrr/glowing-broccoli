/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorrit
 */
public class TimeTest {
    
    /**
     * Test of main method, of class Time.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Time.main(args);
    }

    public void TimeTest()
    {
     Time instance = new Time(2016,9,19,10,31);
     Time expResult = new Time(2016,9,19,10,31);
     assertEquals(expResult, instance);
    }
    
    @Test
    (expected = IllegalArgumentException.class)
        public void TimeTestMonthException() {
        try {        
            Time instance = new Time(2016,13,19,10,31);
	} catch (IllegalArgumentException exc) {}  
    }

    @Test
    (expected = IllegalArgumentException.class)
        public void TimeTestDayException() {
        try {        
            Time instance = new Time(2016,9,35,10,31);
	} catch (IllegalArgumentException exc) {}  
    }
        
        
    @Test
    (expected = IllegalArgumentException.class)
        public void TimeTestHourException() {
        try {        
            Time instance = new Time(2016,9,19,25,31);
	} catch (IllegalArgumentException exc) {}  
    }
        
    @Test
    (expected = IllegalArgumentException.class)
        public void TimeTestMinuteException() {
        try {        
            Time instance = new Time(2016,9,19,10,65);
	} catch (IllegalArgumentException exc) {}  
    }
        
    /**
     * Test of getDayInWeek method, of class Time.
     */
    @Test
    public void testGetDayInWeek() {
        System.out.println("getDayInWeek");
        Time instance = new Time(2016,9,19,10,31);
        DayInWeek expResult = DayInWeek.MON;
        DayInWeek result = instance.getDayInWeek();
        assertEquals(expResult, result);
        
        instance = new Time(2016,9,20,10,31);
        expResult = DayInWeek.TUE;
        result = instance.getDayInWeek();
        assertEquals(expResult, result);
        
        instance = new Time(2016,9,21,10,31);
        expResult = DayInWeek.WED;
        result = instance.getDayInWeek();
        assertEquals(expResult, result);
        
        instance = new Time(2016,9,22,10,31);
        expResult = DayInWeek.THU;
        result = instance.getDayInWeek();
        assertEquals(expResult, result);
        
        instance = new Time(2016,9,23,10,31);
        expResult = DayInWeek.FRI;
        result = instance.getDayInWeek();
        assertEquals(expResult, result);
        
        instance = new Time(2016,9,24,10,31);
        expResult = DayInWeek.SAT;
        result = instance.getDayInWeek();
        assertEquals(expResult, result);
        
        instance = new Time(2016,9,25,10,31);
        expResult = DayInWeek.SUN;
        result = instance.getDayInWeek();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getYear method, of class Time.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Time instance = new Time(2016,9,19,10,31);
        int expResult = 2016;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonth method, of class Time.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        Time instance = new Time(2016,9,19,10,31);
        int expResult = 9;
        int result = instance.getMonth();
        assertEquals(expResult, result);;
    }

    /**
     * Test of getDay method, of class Time.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        Time instance = new Time(2016,9,19,10,31);
        int expResult = 19;
        int result = instance.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHours method, of class Time.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        Time instance = new Time(2016,9,19,10,31);
        int expResult = 10;
        int result = instance.getHours();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinutes method, of class Time.
     */
    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
        Time instance = new Time(2016,9,19,10,31);
        int expResult = 31;
        int result = instance.getMinutes();
        assertEquals(expResult, result);
    }

    /**
     * Test of plus method, of class Time.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        int minutes = 10;
        Time instance = new Time(2016,9,19,10,31);
        ITime expResult = new Time(2016,9,19,10,41);
        ITime result = instance.plus(minutes);
        assertEquals(expResult.getMinutes(), result.getMinutes());
    }

    /**
     * Test of compareTo method, of class Time.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        ITime t = new Time(2016,9,20,10,31);
        Time instance = new Time(2016,9,19,10,31);
        int expResult = 1;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
    }

    /**
     * Test of difference method, of class Time.
     */
    @Test
    public void testDifference() {
        System.out.println("difference");
        ITime time = new Time(2016,9,19,10,31);
        Time instance = new Time(2016,9,29,10,31);
        int expResult = 1440; //24 x 60 = 1440 dus 1 dag
        int result = instance.difference(time);
        assertEquals(expResult, result);
    }
    
}
