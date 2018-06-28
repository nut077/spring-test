package com.nutfreedom.springtest.business;

import com.nutfreedom.springtest.data.SomeDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {
    @Mock
    private SomeDataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @Test
    public void caculateSumUsingDataServiceBasic() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3});
        int expectedResult = 6;
        int actualResult = someBusiness.calculateSumUsingDataService();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void caculateSumUsingDataServiceEmpty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        int expectedResult = 0;
        int actualResult = someBusiness.calculateSumUsingDataService();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void caculateSumUsingDataServiceOneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
        int expectedResult = 5;
        int actualResult = someBusiness.calculateSumUsingDataService();
        assertEquals(expectedResult, actualResult);
    }
}
