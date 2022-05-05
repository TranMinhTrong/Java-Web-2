package ntu.poly.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ntu.poly.shop.domain.Category;
import ntu.poly.shop.reponsitory.CategoryRepostiory;
import ntu.poly.shop.service.CategoryService;

@Service
public class CategoryServiceimpl implements CategoryService {
	
	CategoryRepostiory categoryRepostiory;

	public CategoryServiceimpl(CategoryRepostiory categoryRepostiory) {
		super();
		this.categoryRepostiory = categoryRepostiory;
	}

	@Override
	public <S extends Category> S save(S entity) {
		
		return categoryRepostiory.save(entity);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepostiory.findAll();
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepostiory.findAll(pageable);
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return categoryRepostiory.findAll(sort);
	}

	@Override
	public List<Category> findAllById(Iterable<Long> ids) {
		return categoryRepostiory.findAllById(ids);
	}

	@Override
	public Optional<Category> findById(Long id) {
		return categoryRepostiory.findById(id);
	}

	@Override
	public <S extends Category> List<S> saveAll(Iterable<S> entities) {
		return categoryRepostiory.saveAll(entities);
	}

	@Override
	public void flush() {
		categoryRepostiory.flush();
	}

	@Override
	public <S extends Category> S saveAndFlush(S entity) {
		return categoryRepostiory.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return categoryRepostiory.existsById(id);
	}

	@Override
	public <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities) {
		return categoryRepostiory.saveAllAndFlush(entities);
	}

	@Override
	public long count() {
		return categoryRepostiory.count();
	}

	@Override
	public <S extends Category> boolean exists(Example<S> example) {
		return categoryRepostiory.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		categoryRepostiory.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		categoryRepostiory.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Category entity) {
		categoryRepostiory.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		categoryRepostiory.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		categoryRepostiory.deleteAllInBatch();
	}

	@Override
	public void deleteAll(Iterable<? extends Category> entities) {
		categoryRepostiory.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		categoryRepostiory.deleteAll();
	}

	@Override
	public Category getById(Long id) {
		return categoryRepostiory.getById(id);
	}
	
	
	

}
