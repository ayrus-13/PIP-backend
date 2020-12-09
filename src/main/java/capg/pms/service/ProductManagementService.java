package capg.pms.service;


import java.util.List;


import capg.pms.dto.Product;
import capg.pms.exception.PmsException;


public interface ProductManagementService {

	public Product addProduct(Product product);
    
	public List<Product> viewProducts();
    
	public Product modifyProduct(Product product) throws PmsException;
    
	public boolean deleteProduct(String productId) throws PmsException;
	
	
}