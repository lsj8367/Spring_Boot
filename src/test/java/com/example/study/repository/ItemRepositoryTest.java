package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
//        Item item = new Item();
//        item.setName("notebook");
//        item.setPrice(100000);
//        item.setContent("삼성 노트북");

        Item item = new Item();
        item.setStatus("Unregistered");
        item.setName("삼성 노트북");
        item.setTitle("삼성 노트북 A100");
        item.setContent("2020년형 노트북입니다.");
        item.setPrice(900000);
        item.setBrandName("삼성");
        //외래키가 연결되어있지 않으므로 에러가 발생한다. partner_id
        //item.setPartnerId(1L); // Long -> Partner

        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");

        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);


    }

    @Test
    public void read(){
        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);

        Assertions.assertTrue(item.isPresent());

//        item.ifPresent(i -> {
//            System.out.println(i);
//        });

    }


}
