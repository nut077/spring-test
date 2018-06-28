package com.nutfreedom.springtest.data;

import com.nutfreedom.springtest.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ItemRepositoryTest {
    @Autowired
    ItemRepository repository;

    @Test
    public void testFindAll() {
        assertEquals(3, repository.findAll().size());
    }

    @Test
    public void testCreate() {
        repository.save(new Item(4, "Fruit4", 2, 3));
    }
}
