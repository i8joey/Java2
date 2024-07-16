package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.validators.ValidInventoryRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;
import java.util.Set;


@Controller
public class BuyNowController {

    @Autowired
    private ProductRepository repo;
    @Autowired
    private PartRepository partRepo;

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID")Long id, Model model) {
        Optional<Product> buying = repo.findById(id);
        if (buying.isPresent()) {
            Product product = buying.get();
            int inventory = product.getInv();
            Set<Part> parts = product.getParts();
            if (inventory > 0) {
                if (parts.stream().allMatch(part -> part.getInv() > 0 && part.getInv() > part.getMinInv())) {
                    parts.forEach(part -> {
                        part.setInv(part.getInv() - 1);
                        partRepo.save(part);
                    });
                    product.setInv(inventory - 1);
                    repo.save(product);
                    return "/purchasesuccessful";
                }
                else {
                    return "/partsoutofstock";
                }
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
