package com.nutfreedom.springtest.data;

import com.nutfreedom.springtest.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
