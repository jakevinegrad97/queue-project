package q;

public class Subscriber<T> {

	private Queue<T> queue;

	public Subscriber(Queue<T> queue) {
		this.queue = queue;
	}

	public T subscribe() {
		T result = null;
		try {
			result = queue.poll();
		} catch(RuntimeException e) {
			System.err.println(e.getMessage());
		}
		return result;
	}
}
