package oy.interact.tira.factories;

import oy.interact.tira.student.StackImplementation;
import oy.interact.tira.util.StackInterface;

public class StackFactory {
	private StackFactory() {
		// Empty
	}

	public static StackInterface<Integer> createIntegerStack() {
		StackInterface<Integer> intStack = new StackImplementation<Integer>();
		return intStack;
	}

	public static StackInterface<Integer> createIntegerStack(int capacity) {
		StackInterface<Integer> intStack = new StackImplementation<Integer>(capacity);
		return intStack;
	}

	public static StackInterface<Character> createCharacterStack() {
		StackInterface<Character> charStack = new StackImplementation<Character>();
		return charStack;
	}

	public static StackInterface<Character> createCharacterStack(int capacity) {
		StackInterface<Character> charStack = new StackImplementation<Character>(capacity);
		return charStack;
	}

}
