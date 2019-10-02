package q;

public class FILOQueue<T> extends AbstractQueue<T> {

	@SuppressWarnings("unchecked")
	@Override
	public T poll() {
		if (queue.length > 0) {
			T result = queue[queue.length - 1];
			T[] newQueue = (T[]) new Object[queue.length - 1];
			for (int i = 0; i < queue.length - 1; i++)
				newQueue[i] = queue[i];
			super.queue = newQueue;
			return result;
		} else {
			throw new RuntimeException("Cannot poll an empty queue");
		}
	}

}
