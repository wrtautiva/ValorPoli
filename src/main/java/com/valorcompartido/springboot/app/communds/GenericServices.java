package com.valorcompartido.springboot.app.communds;

import java.io.Serializable;
import java.util.List;

public interface GenericServices<T,ID extends Serializable> {
 
	//implement
	
	T save (T entity);
	void delete(ID id);
	T get(ID id);
	List<T> getAll();
	
}
