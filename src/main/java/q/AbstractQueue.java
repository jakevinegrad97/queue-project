package q;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

@SuppressWarnings("unchecked")
public abstract class AbstractQueue<T> implements Queue<T> {

	protected T[] queue;
	protected Map<Predicate<T>, Function<T, T>> conditions;
	
	@Override
	public void addCondition(Predicate<T> condition, Function<T, T> outcome) {
		conditions.put(condition, outcome);
	}
	
	protected AbstractQueue() {
		queue = (T[]) new Object[0];
		conditions = new HashMap<>();
	}
	
	public String toString() {
		if(queue.length == 0)
			return "{}";
		String result = "{" + queue[0];
		for(int i = 1; i < queue.length; i++)
			result += ", " + queue[i];
		result += "}";
		return result;
	}
	
	@Override
	public void add(T t) {
		T[] newQueue = (T[]) new Object[queue.length + 1];
		for(int i = 0; i < queue.length; i++)
			newQueue[i] = queue[i];
		for(Predicate<T> predicate : conditions.keySet()) {
			if(predicate.test(t))
				t = conditions.get(predicate).apply(t);
		}
		newQueue[queue.length] = t;
		this.queue = newQueue;
	}
	
}
