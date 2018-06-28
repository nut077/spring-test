package com.nutfreedom.springtest.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    private String actualResponse = "{\"id\":1,\"name\":\"Fruit\",\"price\":50.0,\"quantity\":2}";

    @Test
    public void jsonAssertStrictTrueExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\":1, \"name\":\"Fruit\", \"price\":50.0, \"quantity\":2}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssertStrictFalse() throws JSONException {
        String expectedResponse = "{\"id\":1, \"name\":\"Fruit\", \"price\":50.0}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssertWithoutEscapeCharacter() throws JSONException {
        String expectedResponse = "{id: 1, name: Fruit, price: 50.0}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
