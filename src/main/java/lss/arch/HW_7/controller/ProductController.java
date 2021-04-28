package lss.arch.HW_7.controller;

import lombok.RequiredArgsConstructor;
import lss.arch.HW_7.model.Product;
import lss.arch.HW_7.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findProductById(id).orElseThrow(() -> new RuntimeException("product not found, id:" + id));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


    @GetMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewProduct(@RequestParam String title, @RequestParam Integer price) {
        productService.saveNewProduct(title, price);
    }

    // для thymeleaf

    @GetMapping ("/all")
    public String showAll(Model model) {
        model.addAttribute("products",productService.findAllProducts());
        return "products_view";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductTh(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/api/v1/products/all";
    }

    @PostMapping("/add")
//    @ResponseStatus(HttpStatus.CREATED)
    public String saveNewProductTh(@RequestParam String title, @RequestParam Integer price) {
        productService.saveNewProduct(title, price);
        return "redirect:/api/v1/products/all";
    }


}
