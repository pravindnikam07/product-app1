package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.Product;
import com.masai.Model.ProductDTO;
import com.masai.exceptions.ProductException;
import com.masai.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/products")
	public ResponseEntity<Product> registerProductHandler(@RequestBody Product p) throws ProductException {
		return new ResponseEntity<Product>(productService.registerProduct(p), HttpStatus.OK);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProductsHandler() throws ProductException {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}
	
	@PutMapping("/products/{productId}")
	public ResponseEntity<Product> updateProdctHandler(@RequestBody Product p) throws ProductException {
		return new ResponseEntity<Product>(productService.updateProdcut(p), HttpStatus.OK);
	}
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<Product> deleteProductHandler(@PathVariable("productId") Integer productId) throws ProductException {
		return new ResponseEntity<Product>(productService.deleteProductById(productId), HttpStatus.OK);
	}
	
	@GetMapping("/products/{category}")
	public ResponseEntity<List<Product>> getProductByCategoryHandler(@PathVariable("category") String category) throws ProductException {
		return new ResponseEntity<List<Product>>(productService.getsProductByCategory(category), HttpStatus.OK);
	}
	
	@GetMapping("/productsdto")
	public ResponseEntity<List<ProductDTO>> getProductNameQtyPriceHandler() throws ProductException {
		return new ResponseEntity<List<ProductDTO>>(productService.getProductNameQtyPrice(), HttpStatus.OK);
	}
}
