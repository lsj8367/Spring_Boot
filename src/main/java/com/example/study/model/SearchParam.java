package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //롬복 라이브러리로 getter setter 생성자 다 만들어줌.
@AllArgsConstructor // 모든 매개변수 를 가지는 생성자 추가
public class SearchParam {
    private String account;
    private String email;
    private int page;
    // Lombok 라이브러리 사용
    // {"account" : "", "email" : "", "page" : 0}
//    public SearchParam(){
//
//    }
//
//    public SearchParam(String account){
//        this.account = account;
//    }
//
//    public SearchParam(String account, String email, int page){
//        this.account = account;
//        this.email = email;
//        this.page = page;
//    }
//
//    public String getAccount() {
//        return account;
//    }
//
//    public void setAccount(String account) {
//        this.account = account;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getPage() {
//        return page;
//    }
//
//    public void setPage(int page) {
//        this.page = page;
//    }
}
