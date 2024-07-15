package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;


@Controller
public class BuyNowController {

    @Autowired
    private ProductRepository repo;

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID")Long id, Model model) {
        Optional<Product> buying = repo.findById(id);
        if (buying.isPresent()) {
            Product product = buying.get();
            int inventory = product.getInv();
            if (inventory > 0) {
                product.setInv(inventory - 1);
                repo.save(product);
                return "/purchasesuccessful";
            }
            else {
                return "/outofstock";
            }
        }
        else {
            return "/doesnotexist";
        }
    }
}
