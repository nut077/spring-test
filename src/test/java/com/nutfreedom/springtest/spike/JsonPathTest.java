package com.nutfreedom.springtest.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {
    @Test
    public void learning() {
        String responseFromService = "[" +
                "{\"id\":1, \"name\": \"fruit1\", \"price\": 1, \"quantity\": 1}," +
                "{\"id\":2, \"name\": \"fruit2\", \"price\": 2, \"quantity\": 2}," +
                "{\"id\":3, \"name\": \"fruit3\", \"price\": 3, \"quantity\": 3}" +
                "]";
        DocumentContext context = JsonPath.parse(responseFromService);
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);
        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(1, 2, 3);
        List<String> name = context.read("$..name");
        assertThat(name).containsExactly("fruit1", "fruit2", "fruit3");

        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:1]").toString());
        System.out.println(context.read("$.[?(@.name == 'fruit2')]").toString());
        System.out.println(context.read("$.[?(@.quantity == '3')]").toString());
    }
}
