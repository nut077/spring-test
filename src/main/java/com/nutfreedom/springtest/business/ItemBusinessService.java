package com.nutfreedom.springtest.business;

import com.nutfreedom.springtest.data.ItemRepository;
import com.nutfreedom.springtest.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retreiveHardcodedItem() {
        return new Item(1, "Fruit", 50, 2);
    }

    public List<Item> retrieveAllItem() {
        return itemRepository.findAll()
                .stream()
                .peek(item -> item.setValue(item.getPrice() * item.getQuantity()))
                .collect(Collectors.toList());
    }

    public void createItem(Item item) {
         itemRepository.save(item);
    }
}
