package com.nutfreedom.springtest.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ItemControllerIntegration {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoad() throws JSONException {
        String response = restTemplate.getForObject("/all-items-from-database", String.class);
        JSONAssert.assertEquals("[" +
                        "{id: 1, name: Item1, price: 50, quantity: 2, value: 100}, " +
                        "{id: 2, name: Item2, price: 40, quantity: 1, value: 40}, " +
                        "{id: 3, name: Item3, price: 30, quantity: 3, value: 90}]",
                response, true);
    }
}
