package testes.myarraylist;

import java.lang.reflect.Array;
import java.util.List;

public class MyArrayList<E> {
	private E[] array;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.array = (E[]) Array.newInstance(getClass(), 1);
	}
	
	
	public void add(E item) {
		
	}
	
	

}
