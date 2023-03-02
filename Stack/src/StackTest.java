import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	
	private Stack stack;
	
	@Before
	public void initializeStack() {
		stack = new Stack(10);
	}

	@Test
	public void emptyStack() {
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}
	
	@Test
	public void push1() {
		stack.push("first");
		
		assertFalse(stack.isEmpty());
		assertEquals(1, stack.size());
		assertEquals("first", stack.first());
	}
	
	@Test
	public void push2() {
		stack.push("first");
		stack.push("second");
		
		assertFalse(stack.isEmpty());
		assertEquals(2, stack.size());
		assertEquals("first", stack.first());
		
		Object popped = stack.pop();
		assertEquals("second", popped);
		assertEquals(1, stack.size());
		assertEquals("first", stack.first());
	}

	@Test(expected=EmptyStackEx.class)
	public void removeFromEmptyStack() {
		stack.pop();
	}
	
	@Test(expected=StackWithoutSpaceEx.class)
	public void addToAllStack() {
		for (int i = 0; i < 11; i++) {
			stack.push(String.valueOf(i));
		}
	}
}
