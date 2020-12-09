package capg.pms.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capg.pms.ProductManagementSystemApplication;
import capg.pms.dto.Product;
import capg.pms.exception.PmsException;

import capg.pms.repository.ProductRepository;


@Service
@Transactional
public class ProductManagementServiceImpl implements ProductManagementService {
	
	
	@Autowired
	ProductRepository productRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductManagementSystemApplication.class);

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

//	public Product viewProducts(Integer productId) throws PmsException {
//		if(productId==null) {
//			throw new PmsException("Enter ProductId");
//		}
//		Product product=productRepository.getOne(productId);
//		if(product==null) {
//			throw new PmsException("Product does not exist");
//		}
//		else
//		return product;
//	}

	public List<Product> viewProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Product modifyProduct(Product product) throws PmsException {
		Product updateProduct=productRepository.getOne(product.getProductId());
		if(updateProduct==null) {
			throw new PmsException("Product does not exist");
		}
		else {
			updateProduct.setProductDesc(product.getProductDesc());
			updateProduct.setProductName(product.getProductName());
			updateProduct.setPrice(product.getPrice());
			updateProduct.setQuantity(product.getQuantity());
			updateProduct.setRatings(product.getRatings());
			productRepository.save(updateProduct);
		}
		return updateProduct;
	}

	public boolean deleteProduct(String productId) throws PmsException {
		if(productId==null)
			throw new PmsException("Enter ProductId");
		Product product=productRepository.getOne(productId);
		product.setIsActive(false);
		//productRepository.deleteById(productId);
		return false;
	}


	

}
