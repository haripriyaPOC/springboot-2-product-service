package com.example.productservice;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public List<Map<String, Object>> products() {
        return List.of(
            Map.of("id", 1, "name", "Laptop", "price", 65000),
            Map.of("id", 2, "name", "Keyboard", "price", 1800),
            Map.of("id", 3, "name", "Mouse", "price", 900)
        );
    }
}
