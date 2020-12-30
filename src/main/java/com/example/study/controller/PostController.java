package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //클래스가 매핑이 겹치는건 상관없음. 메소드만 영향이있다.
public class PostController {

    // HTML <form>
    // ajax 검색 등으로 post가 사용됨.
    // http post body -> data
    // json, xml, multipart-form (파일올릴때) / text-plain 타입 가능


    //@RequestMapping(method = RequestMethod.POST, path = "/postMethod") 이렇게도 사용이 가능함.
    @PostMapping(value = "/postMethod") //, produces = {"application-json"} 받는방식 지정하는법
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        return searchParam;
    }



    //업데이트 기능을 사용할때 두개의 메소드 사용
    @PutMapping("/putMethod")
    public void put(){

    }

    @PatchMapping("/patchMethod")
    public void patch(){

    }
}
