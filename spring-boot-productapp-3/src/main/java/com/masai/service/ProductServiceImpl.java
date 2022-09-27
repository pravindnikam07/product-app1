package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Model.Product;
import com.masai.Model.ProductDTO;
import com.masai.exceptions.ProductException;
import com.masai.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO pdao;
	
	@Override
	public Product registerProduct(Product p) throws ProductException {
		return pdao.save(p);
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		List<Product> products = pdao.findAll();
		if(products.size()>0)
			return products;
		throw new ProductException("Products not in the store");
	}

	@Override
	public Product updateProdcut(Product p) throws ProductException {
		pdao.findById(p.getProductId()).orElseThrow(() -> new ProductException("Product not in the store with id : "+p.getProductId()));
		return pdao.save(p);
	}

	@Override
	public Product deleteProductById(Integer pid) throws ProductException {
		Product product =pdao.findById(pid).orElseThrow(() -> new ProductException("Product not in the store with id : "+pid));
		pdao.deleteById(pid);
		return product;
	}

	@Override
	public List<Product> getsProductByCategory(String category) throws ProductException {
		
		List<Product> products = pdao.findByCategory(category);
		
		if(products.size()>0)
			return products;
		throw new ProductException("Product not in the store with the category : "+category);
	}

	@Override
	public List<ProductDTO> getProductNameQtyPrice() throws ProductException {
		
		List<ProductDTO> productDTOs = pdao.getProductNameAndQuantityAndPrice();
		
		if(productDTOs.size()>0)
			return productDTOs;
		throw new ProductException("Product not in the store");
	}

}
