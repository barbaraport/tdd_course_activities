public class Stack {
	
	private Object[] elements;
	private int size;

	public Stack(int i) {
		// TODO Auto-generated constructor stub
		this.elements = new Object[i];
		this.size = 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public void push(String string) {
		// TODO Auto-generated method stub
		if (size == elements.length) throw new StackWithoutSpaceEx("full");
		this.elements[size] = string;	
		size++;
	}

	public Object first() {
		// TODO Auto-generated method stub
		return this.elements[0];
	}

	public Object pop() {
		// TODO Auto-generated method stub
		if (isEmpty()) throw new EmptyStackEx("Empty!!!");
		Object popped = this.elements[size - 1];
		size--;
		return popped;
	}

}
