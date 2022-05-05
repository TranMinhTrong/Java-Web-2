package ntu.poly.shop.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ntu.poly.shop.domain.Category;

@Repository
public interface CategoryRepostiory extends JpaRepository<Category, Long>{
	
	
}
