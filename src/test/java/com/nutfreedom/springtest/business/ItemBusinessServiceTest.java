package com.nutfreedom.springtest.business;

import com.nutfreedom.springtest.data.ItemRepository;
import com.nutfreedom.springtest.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {
    @InjectMocks
    private ItemBusinessService business;

    @Mock
    private ItemRepository repository;

    @Test
    public void retrieveAllItemsBasic() {
        when(repository.findAll()).thenReturn(
                Arrays.asList(
                        new Item(2, "Fruit2", 50, 2),
                        new Item(3, "Fruit3", 40, 1)
                )
        );
        List<Item> items = business.retrieveAllItem();

        assertEquals(100, items.get(0).getValue(), 0);
        assertEquals(40, items.get(1).getValue(), 0);
    }

    @Test
    public void retreiveHardcodedItem() {
        Item item = business.retreiveHardcodedItem();
        assertEquals(50, item.getPrice(), 0);
    }

    @Test
    public void testCreateItem() {
        business.createItem(new Item(1, "Item1", 5, 2));
    }
}
