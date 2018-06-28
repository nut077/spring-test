package com.nutfreedom.springtest.business;

import com.nutfreedom.springtest.data.SomeDataService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SomeBusinessStubTest {

    @Test
    public void caculateSumUsingDataServiceBasic() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        someBusiness.setSomeDataService(new SomeDataServiceStub());
        int expectedResult = 6;
        int actualResult = someBusiness.calculateSumUsingDataService();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void caculateSumUsingDataServiceEmpty() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        someBusiness.setSomeDataService(new SomeDataServiceEmptyStup());
        int expectedResult = 0;
        int actualResult = someBusiness.calculateSumUsingDataService();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void caculateSumUsingDataServiceOneValue() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        someBusiness.setSomeDataService(new SomeDataServiceOneValueStup());
        int expectedResult = 5;
        int actualResult = someBusiness.calculateSumUsingDataService();
        assertEquals(expectedResult, actualResult);
    }
}

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{1, 2, 3};
    }

}

class SomeDataServiceEmptyStup implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }

}

class SomeDataServiceOneValueStup implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{5};
    }

}
