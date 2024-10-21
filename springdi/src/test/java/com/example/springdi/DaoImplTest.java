package com.example.springdi;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import dao.DaoImpl;
import dao.IDao;

/**
 * Unit test for DaoImpl.
 */
public class DaoImplTest extends TestCase {
    
    private IDao dao;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DaoImplTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(DaoImplTest.class);
    }

    @Override
    protected void setUp() throws Exception {
        dao = new DaoImpl(); // Initialisation de l'instance de DaoImpl
    }

    /**
     * Test for getValue method
     */
    public void testGetValue() {
        assertEquals(100.0, dao.getValue());
    }
}