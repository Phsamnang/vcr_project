package com.vcr.vcr_project.service.menu;

import com.vcr.vcr_project.exception.EntityNotFoundException;
import com.vcr.vcr_project.model.category.Category;
import com.vcr.vcr_project.model.category.CategoryRepository;
import com.vcr.vcr_project.model.menu.Menu;
import com.vcr.vcr_project.model.menu.MenuDetailRepository;
import com.vcr.vcr_project.model.menu.MenuRepository;
import com.vcr.vcr_project.payload.menu.MenuRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class MenuService implements IMenuService {
    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;
    private final MenuDetailRepository menuDetailRepository;

    @Override
    public void createMenu(MenuRequest payload) {
        var category = categoryRepository.findById(payload.categoryId()).orElseThrow(() -> new EntityNotFoundException(Category.class, "Category not found"));
        menuRepository.save(Menu.builder().name(payload.name())
                .price(payload.price())
                .image(payload.image())
                .usd(payload.price().divide(BigDecimal.valueOf(4000)))
                .category(category).build());
    }
}
