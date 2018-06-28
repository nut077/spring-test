package com.nutfreedom.springtest.controller;

import com.nutfreedom.springtest.business.ItemBusinessService;
import com.nutfreedom.springtest.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    public void dummyItemBasic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Fruit\",\"price\":50.0,\"quantity\":2}"))
                .andReturn();
    }

    @Test
    public void itemFromitemBusinessServiceBasic() throws Exception {
        when(itemBusinessService.retreiveHardcodedItem()).thenReturn(new Item(2, "Fruit2", 50, 2));
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2,name:Fruit2,price:50.0,quantity:2}"))
                .andReturn();
    }

    @Test
    public void retrieveAllItemsBasic() throws Exception {
        when(itemBusinessService.retrieveAllItem()).thenReturn(
                Arrays.asList(
                        new Item(2, "Fruit2", 50, 2),
                        new Item(3, "Fruit3", 40, 1)
                ));
        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:2,name:Fruit2,price:50.0,quantity:2}, {id:3,name:Fruit3,price:40.0,quantity:1}]"))
                .andReturn();
    }
    
    @Test
    public void createItem() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/item")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"id\": 4, \"name\": \"Ball\", \"price\": 10, \"quantity\": 100}")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(header().string("location", containsString("/item/")))
                .andReturn();
    }


}