package com.example.springdi;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import dao.IDao;
import metier.MetierImpl;
import org.mockito.Mockito;

/**
 * Unit test for MetierImpl.
 */
public class MetierImplTest extends TestCase {
    
    private MetierImpl metier;
    private IDao daoMock;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MetierImplTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(MetierImplTest.class);
    }

    @Override
    protected void setUp() throws Exception {
        daoMock = Mockito.mock(IDao.class); // Création d'un mock pour IDao
        metier = new MetierImpl();
        metier.setDao(daoMock); // Injection du mock dans MetierImpl
    }

    /**
     * Test for calcul method
     */
    public void testCalcul() {
        Mockito.when(daoMock.getValue()).thenReturn(100.0); // Définir le comportement du mock
        assertEquals(200.0, metier.calcul());
    }
}