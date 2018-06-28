package com.nutfreedom.springtest.business;

import com.nutfreedom.springtest.data.SomeDataService;
import lombok.Setter;

import java.util.Arrays;

public class SomeBusinessImpl {
    @Setter
    private SomeDataService someDataService;

    public int calculateSum(int[] data) {
        return Arrays.stream(data).sum();
    }

    public int calculateSumUsingDataService() {
        return Arrays.stream(someDataService.retrieveAllData()).sum();
    }
}
