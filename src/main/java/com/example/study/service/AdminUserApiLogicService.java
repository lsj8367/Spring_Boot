package com.example.study.service;

import com.example.study.ifs.CRUDInterface;
import com.example.study.model.entity.AdminUser;
import com.example.study.model.network.Header;
import com.example.study.model.network.Pagination;
import com.example.study.model.network.request.AdminUserApiRequest;
import com.example.study.model.network.response.AdminUserApiResponse;
import com.example.study.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminUserApiLogicService extends BaseService<AdminUserApiRequest, AdminUserApiResponse, AdminUser> {

//    @Autowired
//    private AdminUserRepository adminUserRepository;

    @Override
    public Header<AdminUserApiResponse> create(Header<AdminUserApiRequest> request) {

        AdminUserApiRequest body = request.getData();


        // lastloginat, loginfailcount, password updateat, unregisteredat 제외 하였음 일단은....
        AdminUser adminUser = AdminUser.builder()
                .account(body.getAccount())
                .password(body.getPassword())
                .status(body.getStatus())
                .role(body.getRole())
                .registeredAt(LocalDateTime.now())
                .build();

        AdminUser newAdminUser = baseRepository.save(adminUser);

        return Header.OK(response(newAdminUser));
    }

    @Override
    public Header<AdminUserApiResponse> read(Long id) {

        return baseRepository.findById(id)
                .map(this::response)
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<AdminUserApiResponse> update(Header<AdminUserApiRequest> request) {

        AdminUserApiRequest body = request.getData();

        return baseRepository.findById(body.getId())
                .map(entityAdmin ->{
                    entityAdmin.setAccount(body.getAccount())
                            .setPassword(body.getPassword())
                            .setStatus(body.getStatus())
                            .setRole(body.getRole())
                            .setRegisteredAt(body.getRegisteredAt())
                            .setUnregisteredAt(body.getUnregisteredAt());
                    return entityAdmin;
                })
                .map(entity -> baseRepository.save(entity))
                .map(updateAdminUser -> response(updateAdminUser))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {

        Optional<AdminUser> adminUserOptional = baseRepository.findById(id);

        return adminUserOptional
                .map(adminUser -> {
                    baseRepository.delete(adminUser);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    private AdminUserApiResponse response(AdminUser adminUser){
        AdminUserApiResponse adminUserApiResponse = AdminUserApiResponse
                .builder()
                .id(adminUser.getId())
                .account(adminUser.getAccount())
                .password(adminUser.getPassword())
                .status(adminUser.getStatus())
                .role(adminUser.getRole())
                .registeredAt(adminUser.getRegisteredAt())
                .unregisteredAt(adminUser.getUnregisteredAt())
                .build();
        return adminUserApiResponse;
    }


    @Override
    public Header<List<AdminUserApiResponse>> search(Pageable pageable) {
        Page<AdminUser> adminUsers = baseRepository.findAll(pageable);

        List<AdminUserApiResponse> adminUserApiResponses = adminUsers.stream()
                .map(adminUser -> response(adminUser))
                .collect(Collectors.toList());

        Pagination pagination = Pagination.builder()
                .totalPages(adminUsers.getTotalPages())
                .totalElements(adminUsers.getTotalElements())
                .currentPage(adminUsers.getNumber())
                .currentElements(adminUsers.getNumberOfElements())
                .build();


        return Header.OK(adminUserApiResponses, pagination);
    }
}
