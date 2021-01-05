package com.example.study.service;

import com.example.study.ifs.CRUDInterface;
import com.example.study.model.entity.Category;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.CategoryApiRequest;
import com.example.study.model.network.response.CategoryApiResponse;
import com.example.study.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
public class CategoryApiLogicService implements CRUDInterface<CategoryApiRequest, CategoryApiResponse> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Header<CategoryApiResponse> create(Header<CategoryApiRequest> request) {

        CategoryApiRequest body = request.getData();

        Category category = Category.builder()
                .type(body.getType())
                .title(body.getTitle())
                .build();

        Category newCategory = categoryRepository.save(category);


        return response(newCategory);
    }

    @Override
    public Header<CategoryApiResponse> read(Long id) {

        return categoryRepository.findById(id)
                .map(this::response)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<CategoryApiResponse> update(Header<CategoryApiRequest> request) {

        CategoryApiRequest body = request.getData();
        return categoryRepository.findById(body.getId())
                .map(category -> {
                    category.setType(body.getType())
                            .setTitle(body.getTitle());
                            return category;
                })
                .map(newCategory -> categoryRepository.save(newCategory))
                .map(c -> response(c))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {

        Optional<Category> optional = categoryRepository.findById(id);

        return optional.map(category -> {
                    categoryRepository.delete(category);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    private Header<CategoryApiResponse> response(Category category){
        CategoryApiResponse body = CategoryApiResponse.builder()
                .id(category.getId())
                .type(category.getType())
                .title(category.getTitle())
                .build();
        return Header.OK(body);
    }

}