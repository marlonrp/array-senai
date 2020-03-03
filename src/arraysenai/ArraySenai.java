package arraysenai;

import java.util.Arrays;
import java.util.Objects;


public class ArraySenai {
	private Integer[] arr;
	private int size = 10;
	private int initialCapacity = 10;
	private int defaultResizeValue = 5;
	private int emptySpace = 0; 
	private boolean resizable = true;
	
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
	
	public Integer get(int index) {
		return this.arr[index];
	}

	public int getSize() {
		return size;
	}
	
	public void add(Integer val) throws Exception {
		if (this.resizable && this.emptySpace == this.size - 2) {
			this.resize();
		} else if(!this.resizable && this.emptySpace > this.defaultResizeValue) {
			throw new Exception("Exception message");
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
		if (this.resizable && index >= this.size - 2) {
			this.resize();
		} else if(!this.resizable && index > this.size) {
			throw new Exception("Este array não pode ser redimencionado, index inexistente!");
		}
		if (Objects.isNull(this.arr[index])) {
			this.arr[index] = val;
		} else {
			Integer aux = this.arr[index];
			this.arr[index] = val;
			this.add(++index, aux);
		}
	}
	
	private void resize() {
		this.size += this.defaultResizeValue;
		this.arr = Arrays.copyOf(this.arr, this.size);
	}
}
