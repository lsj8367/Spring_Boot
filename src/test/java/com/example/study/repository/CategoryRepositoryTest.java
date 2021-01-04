package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends StudyApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){
        String type = "Computer";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);


        Assertions.assertNotNull(newCategory);
        Assertions.assertEquals(newCategory.getType(), type);
        Assertions.assertEquals(newCategory.getTitle(), title);
    }

    @Test
    public void read(){
        //Optional<Category> optionalCategory = categoryRepository.findById(1L);

        //String type = "Computer";
        Optional<Category> optionalCategory = categoryRepository.findByType("Computer"); //repository에서 메소드를 생성해주고 type별 매칭 쿼리문 생성 가능함.


        // select * from category where type = 'Computer';

        optionalCategory.ifPresent(c -> {
            //Assertions.assertEquals(c.getType(), type); 여기서 직접 타입을 선언할수 있음.

            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());
        });

    }
}
