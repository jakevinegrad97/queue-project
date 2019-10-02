package q;

public class Publisher<T> {

	private Queue<T> queue;

	public Publisher(Queue<T> queue) {
		this.queue = queue;
	}

	public <S extends T> void publish(S s) {
		queue.add(s);
	}
	
}
