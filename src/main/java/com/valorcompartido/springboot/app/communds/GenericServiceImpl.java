package com.valorcompartido.springboot.app.communds;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericServiceImpl <T,ID extends Serializable> implements GenericServices<T, ID>{

	//implemennt
	@Override
	public T save(T entity) {
	
		return getDao().save(entity);
	}

	@Override
	public void delete(ID id) {
	
		getDao().deleteById(id);
		
	}

	@Override
	public T get(ID id) {
		Optional<T> obj = getDao().findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}
		
		return null;
	}

	@Override
	public List<T> getAll() {
		List<T> retuList = new ArrayList<>();
		getDao().findAll().forEach(obj -> retuList.add(obj));
		return retuList;
	}
	
	public abstract CrudRepository<T,ID> getDao();

}
