package q;

public class FIFOQueue<T> extends AbstractQueue<T> {

	@SuppressWarnings("unchecked")
	@Override
	public T poll() {
		if (queue.length > 0) {
			T result = queue[0];
			T[] newQueue = (T[]) new Object[queue.length - 1];
			for (int i = 1; i <= queue.length - 1; i++)
				newQueue[i - 1] = queue[i];
			super.queue = newQueue;
			return result;
		} else {
			throw new RuntimeException("Cannot poll an empty queue");
		}
	}

}
