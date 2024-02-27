package com.vcr.vcr_project.controller;

import com.vcr.vcr_project.payload.menu.MenuDetailRequest;
import com.vcr.vcr_project.payload.menu.MenuRequest;
import com.vcr.vcr_project.service.menu.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class MenuController extends VCRRestController{
    private final IMenuService service;
    @PostMapping("/menu")
    public ResponseEntity<?>createMenu(@RequestBody MenuRequest payload){
        service.createMenu(payload);
        return ok();
    }
    @PostMapping("/menu-detail")
    public ResponseEntity<?>createMenuDetail(@RequestBody MenuDetailRequest payload){
        service.addMenuDetail(payload);
        return ok();
    }
}
