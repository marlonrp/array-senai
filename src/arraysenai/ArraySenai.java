package arraysenai;

import java.util.Arrays;
import java.util.Objects;


public class ArraySenai {
	private Integer[] arr;
	private int size = 10;
	private int initialCapacity;
	private int defaultResizeValue = 5;
	private int emptySpace = 0; 
	private boolean resizable = false;
	
	ArraySenai() {
		this.arr = new Integer[this.size];
		this.initialCapacity = this.size;
	}
	
	ArraySenai(int size) {
		this.arr = new Integer[size];
		this.initialCapacity = this.size = size;
	}
	
	ArraySenai(int size, boolean resizable) {
		this.arr = new Integer[size];
		this.initialCapacity = this.size = size;
		this.resizable = resizable;
	}
	
	public Integer[] get() {
		return this.arr;
	}
	
	public Integer get(int index) throws Exception {
		if (index < this.emptySpace) {
			return this.arr[index];
		} else {
			throw new Exception("Index inexistente!");
		}
	}

	public int size() {
//		return this.emptySpace > 0 ? (this.emptySpace - 1) : this.emptySpace;
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
	
	public void add(int index, Integer val) throws Exception {
		if(index > this.emptySpace) {
			throw new Exception("Index inexistente!");
		} else if(!this.resizable && index > this.size) {
			throw new Exception("Este array não pode ser redimencionado, index inexistente!");
		} else if (this.resizable && index > this.size - 2 ) {
			this.resize();
		}
//		if (this.emptySpace < this.size && Objects.nonNull(this.arr[index])){
//			
//		}
		if (Objects.isNull(this.arr[index])) {
			this.arr[index] = val;
			++this.emptySpace;
		} else {
			Integer aux = this.arr[index];
			this.arr[index] = val;
			if(index == this.emptySpace) {
				++this.emptySpace;
			}
			if (aux != null) {
				this.add(++index, aux);
			}
		}
	}
	
	private void resize() {
		this.size += this.defaultResizeValue;
		this.arr = Arrays.copyOf(this.arr, this.size);
	}
}
