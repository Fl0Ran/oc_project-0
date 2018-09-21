package com.lambazon.controller;

import javax.inject.Inject;

import com.lambazon.repository.ProductRepository;
import javafx.scene.control.Tab;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lambazon.domain.Product;
import com.lambazon.service.ProductService;


@Controller
public class ProductController {

	@Inject
	private ProductService productService;

	@GetMapping("/products")
	public String products	(Model model) {
		model.addAttribute("prods", productService.products());
		model.addAttribute("totalInventoryAmount", calculateTotalInventoryAmount());
 		return "products";
	}

	@GetMapping("/products/{id}/details")
	public String product	(@PathVariable Integer id, Model model) {
		model.addAttribute("prod", productService.product(id));
		return "product";
	}

    /**
     * calculate the amount of each product in relation to it's stock in inventory
     * @return total amount of inventory
     */
	private double calculateTotalInventoryAmount() {
        double totalInventoryPrice = 0.0;
        for (Product prod : productService.products()) {
            //add price of all product in inventory
            totalInventoryPrice += prod.getInventoryPrice();
        }
        return totalInventoryPrice ;
    }

}
