package oy.interact.tira.factories;

import oy.interact.tira.NotYetImplementedException;
import oy.interact.tira.model.Coder;
import oy.interact.tira.student.QueueImplementation;
import oy.interact.tira.student.StackImplementation;
import oy.interact.tira.util.QueueInterface;
import oy.interact.tira.util.StackInterface;

public class QueueFactory {

	private QueueFactory() {
		// empty
	}

	public static QueueInterface<Integer> createIntegerQueue() {
		QueueInterface<Integer> intQueue = new QueueImplementation<Integer>();
		return intQueue;		
	}

	public static QueueInterface<Integer> createIntegerQueue(int capacity) {
		QueueInterface<Integer> intQueue = new QueueImplementation<Integer>(capacity);
		return intQueue;
	}

	public static QueueInterface<String> createStringQueue() {
		QueueInterface<String> strQueue = new QueueImplementation<>();
		return strQueue;
	}

	public static QueueInterface<String> createStringQueue(int capacity) {
		QueueInterface<String> strQueue = new QueueImplementation<>(capacity);
		return strQueue;
	}

	public static QueueInterface<Coder> createCoderQueue() {
		QueueInterface<Coder> coderQueue = new QueueImplementation<>();
		return coderQueue;
	}
}
