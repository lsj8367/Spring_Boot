package com.example.study.ifs;

import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CRUDInterface<Req, Res> { //모든 ApiController 클래스가 잘 상속받을수 있게 제네릭 타입 설정.

    Header<Res> create(Header<Req> request); // todo request object 추가

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header delete(Long id);

}
