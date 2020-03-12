package arraysenai;

import java.util.Arrays;
import java.util.Objects;

public class ArraySenai<T> {
	private Object[] arr;
	private int size = 10;
	private int initialCapacity;
	private int defaultResizeValue = 10;
	private int emptySpace = 0; 
	private boolean resizable = false;
	
	ArraySenai() {
		this.arr = new Object[this.size];
		this.initialCapacity = this.size;
	}
	
	ArraySenai(int size) {
		this.arr = new Object[size];
		this.initialCapacity = this.size = size;
	}
	
	ArraySenai(int size, boolean resizable) {
		this.arr = new Object[size];
		this.initialCapacity = this.size = size;
		this.resizable = resizable;
	}
	
	public Object get(int index) throws Exception {
		if (index < this.emptySpace) {
			return this.arr[index];
		} else {
			throw new Exception("Index inexistente!");
		}
	}
	
	public void set(int index, T value) {
		this.arr[index] = value;
	}

	public int size() {
		return this.emptySpace;
	}
	
	public void add(Integer val) throws Exception {
		if (this.resizable && this.emptySpace == this.size - 2) {
			this.resize();
		} else if(!this.resizable && this.emptySpace > this.size - 1) {
			throw new Exception("Este array não pode ser redimencionado, index inexistente!");
		}
		if (Objects.isNull(this.arr[this.emptySpace])) {
			this.arr[this.emptySpace] = val;
			++this.emptySpace;
		} else {
			++this.emptySpace;
			this.add(val);
		}
	}
	
	public void add(int index, Object val) throws Exception {
		if(index > this.emptySpace) {
			throw new Exception("Index inexistente!");
		} else if(!this.resizable && index > this.size) {
			throw new Exception("Este array não pode ser redimencionado, index inexistente!");
		} else if (this.resizable && index > this.size - 2 ) {
			this.resize();
		}

		if (Objects.isNull(this.arr[index])) {
			this.arr[index] = val;
			++this.emptySpace;
		} else {
			Object aux = this.arr[index];
			this.arr[index] = val;
			if(index == this.emptySpace) {
				++this.emptySpace;
			}
			if (aux != null) {
				this.add(++index, aux);
			}
		}
	}
	
	public void clear() {
		this.arr = new Integer[this.initialCapacity];
		this.emptySpace = 0;
	}
	
	private void resize() {
		this.size += this.defaultResizeValue;
		this.arr = Arrays.copyOf(this.arr, this.size);
	}
	
	public boolean isEmpty() {
		return this.emptySpace == 0;
	}
	
	public boolean isFull() {
		return !this.resizable && this.emptySpace >= this.initialCapacity;
	}
	
	public int indexOf(T value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) return i;
		}
		return -1;
	}
	
	public boolean contains(T value) {
		return this.emptySpace > 0 && this.indexOf(value) > -1;
	}
	
	public int lastIndexOf(T value) {
		for (int i = (this.emptySpace - 1); 0 <= i; i--) {
			if (arr[i] == value) return i; 
		}
		return -1;
	}
}
