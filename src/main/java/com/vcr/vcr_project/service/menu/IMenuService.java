package com.vcr.vcr_project.service.menu;

import com.vcr.vcr_project.payload.menu.MenuDetailRequest;
import com.vcr.vcr_project.payload.menu.MenuRequest;

public interface IMenuService {
    void createMenu(MenuRequest payload);
    void addMenuDetail(MenuDetailRequest payload);
}
