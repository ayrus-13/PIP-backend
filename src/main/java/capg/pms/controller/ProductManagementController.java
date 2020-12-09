package capg.pms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import capg.pms.ProductManagementSystemApplication;
import capg.pms.dto.Product;
import capg.pms.exception.PmsException;
import capg.pms.service.ProductManagementService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductManagementController {

	@Autowired
	ProductManagementService productManagementService;

	private static final Logger logger = LoggerFactory.getLogger(ProductManagementSystemApplication.class);

	@PostMapping(value = "/add")
	public ResponseEntity<Product> addProduct(@ModelAttribute Product product) throws PmsException {
		Product productToBeAdded =new Product();
		product.setIsActive(true);
		productToBeAdded =productManagementService.addProduct(product);
		System.out.println(product);
		if (productToBeAdded == null)
			return new ResponseEntity("Product not added", HttpStatus.INTERNAL_SERVER_ERROR);
		else
			return new ResponseEntity<Product>(productToBeAdded, HttpStatus.OK);
	}

	@GetMapping(value = "/showproducts")
	public ResponseEntity<List<Product>> viewProducts() {

		List<Product> productList = productManagementService.viewProducts();
		List<Product> filteredList = new ArrayList<Product>();
		if (productList == null)
			return new ResponseEntity("No product present", HttpStatus.INTERNAL_SERVER_ERROR);
		else {
			for (int i = 0; i < productList.size(); i++) {
				System.out.println(productList.get(i));
				if (productList.get(i).getIsActive()) {
					filteredList.add(productList.get(i));
				}
			}

			if (filteredList.isEmpty()) {
				return new ResponseEntity("No Product Present", HttpStatus.INTERNAL_SERVER_ERROR);
			} else
				return new ResponseEntity<List<Product>>(filteredList, HttpStatus.OK);
		}
	}

	

	
	  @PostMapping(value="/modifyproduct") public ResponseEntity<Product>
	  modifyProduct(@ModelAttribute Product product) throws PmsException{
	  
	  Product modifyProduct=productManagementService.modifyProduct(product);
	   
	  if (modifyProduct == null) { 
		  return new ResponseEntity("Product not modified", HttpStatus.INTERNAL_SERVER_ERROR); }
	     else { return new ResponseEntity<Product>(modifyProduct, HttpStatus.OK); }
 
	  }
	 

	/*
	 * @GetMapping(value = "/modifyproduct") public ResponseEntity<Product>
	 * modifyProduct() throws PmsException {
	 * 
	 * Product modifyProduct = productManagementService.modifyProduct(pid, pname,
	 * pdesc, pcost, pquantity, prating);
	 * 
	 * if (modifyProduct == null) { return new
	 * ResponseEntity("Product not modified", HttpStatus.INTERNAL_SERVER_ERROR); }
	 * else { return new ResponseEntity<Product>(modifyProduct, HttpStatus.OK); }
	 * 
	 * }
	 */

	@DeleteMapping(value = "/deleteproduct")
	public boolean deleteProduct(@RequestParam String productId) throws PmsException {

		boolean productToBeDeleted = productManagementService.deleteProduct(productId);

		return productToBeDeleted;

	}

}