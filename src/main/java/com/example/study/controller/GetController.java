package com.example.study.controller;

import com.example.study.model.SearchParam;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController //컨트롤러라는것을 명시
@RequestMapping("/api") // localhost:8080/api 까지 연결
public class GetController { //GET 메소드 주소에대한 캐시가 이루어 지므로, 정보를 얻을때 사용한다.
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") //localhost:8080/api/getMethod 주소 호출 받음
    public String getRequest(){

        return "Hi getMethod"; //웹에 출력해줌
    }

    @GetMapping("/getParameter") // get방식 처리 메소드 지정 X 주소만  설정해주면 된다.   localhost:8080/api/getParameter?id=1234&password=abcd 주소로 요청
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd){ // 제대로 매핑시키기 위해서 name값을 할당
        String password = "bbbb"; //로컬변수로 password를 사용해야 할 경우

        System.out.println("id " + id);
        System.out.println("password " + password);

        return id+password;
    }

    //localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        // {"account" : "", "email" : "", "page" : 0} json형식

        return searchParam; //json형식으로 내보냄 jackson라이브러리
    }

    @GetMapping("/header")
    public Header getHeader(){

        //{"resultCode":"OK", "description": "OK"}
        return Header.builder().resultCode("OK").description("OK").build();
    }



}

