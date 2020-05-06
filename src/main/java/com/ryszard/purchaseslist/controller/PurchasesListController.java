package com.ryszard.purchaseslist.controller;

import com.ryszard.purchaseslist.persist.ShoppingItem;
import com.ryszard.purchaseslist.persist.ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PurchasesListController {

    private final ShoppingItemRepository repository;

    @Autowired
    public PurchasesListController(ShoppingItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("items", repository.findAll());
        model.addAttribute("item", new ShoppingItem());
        return "index";
    }

    public String newShoppingItem(ShoppingItem item){
        repository.save(item);
        return "redirect:/";
    }
}
