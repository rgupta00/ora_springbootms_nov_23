package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.entities.Product;
import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.repo.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{


	private ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Product getById(int id) {
		return productDao.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("product with id" + id + " is not found"));
	}

	@Override
	public Product addProduct(Product product) {
		productDao.save(product);
		return product;
	}

	@Override
	public Product updateProduct(int id, Product product) {
		Product productToUpdate= getById(id);
		productToUpdate.setPrice(product.getPrice());
		productDao.save(productToUpdate);
		return productToUpdate;
	}

	@Override
	public Product deleteProduct(int id) {
		Product productToDelete= getById(id);
		productDao.delete(productToDelete);
		return productToDelete;
	}


}
