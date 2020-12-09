package capg.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import capg.pms.dto.Product;
/**
* @author: SURYA
* description: Product Repository
* created date: 04/11/2020
*/

@Repository

public interface ProductRepository extends JpaRepository<Product,String>{
	public Product findByProductId(String productId);

}
