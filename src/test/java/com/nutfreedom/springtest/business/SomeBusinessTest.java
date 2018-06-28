package com.nutfreedom.springtest.business;

import org.junit.Test;

import static org.junit.Assert.*;

public class SomeBusinessTest {

    @Test
    public void caculateSumBasic() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        int expectedResult = 6;
        int actualResult = someBusiness.calculateSum(new int[]{1, 2, 3});
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void caculateSumEmpty() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        int expectedResult = 0;
        int actualResult = someBusiness.calculateSum(new int[]{});
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void caculateSumOneValue() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        int expectedResult = 5;
        int actualResult = someBusiness.calculateSum(new int[]{5});
        assertEquals(expectedResult, actualResult);
    }
}
