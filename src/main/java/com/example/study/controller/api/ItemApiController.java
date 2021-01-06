package com.example.study.controller.api;

import com.example.study.controller.CrudController;
import com.example.study.ifs.CRUDInterface;
import com.example.study.model.entity.Item;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.ItemApiRequest;
import com.example.study.model.network.response.ItemApiResponse;
import com.example.study.service.ItemApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

    /*
    @Autowired
    private ItemApiLogicService itemApiLogicService;

    //@PostConstruct가 붙은 메서드는 클래스가 service(로직을 수행하려할 때로 생각 됨)를 수행하기 전에 발생한다.
    @PostConstruct //생성자처럼 작용
    public void init(){
        this.baseService = itemApiLogicService; //crud컨트롤러 객체가 생성될때 baseService를 itemlogic과 매칭시킴.
    }

     */

    //이 기능들이 작동하게 된다.
//    @Override
//    @PostMapping("") // api/item/
//    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
//        return itemApiLogicService.create(request);
//    }
//
//    @Override
//    @GetMapping("{id}") // api/item/1..? 1000
//    public Header<ItemApiResponse> read(@PathVariable Long id) {
//        return itemApiLogicService.read(id);
//    }
//
//    @Override
//    @PutMapping("")   // api/item
//    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
//        return itemApiLogicService.update(request);
//    }
//
//    @Override
//    @DeleteMapping("{id}") // api/item/1...1000
//    public Header delete(@PathVariable Long id) {
//        return itemApiLogicService.delete(id);
//    }

}
