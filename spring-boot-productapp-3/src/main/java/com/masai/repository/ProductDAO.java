package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.Model.Product;
import com.masai.Model.ProductDTO;

public interface ProductDAO extends JpaRepository<Product, Integer> {

	public List<Product> findByCategory(String category);
	
	@Query("select new com.masai.Model.ProductDTO(p.productName, p.quantity, p.price) from Product p")
	public List<ProductDTO> getProductNameAndQuantityAndPrice();
}
