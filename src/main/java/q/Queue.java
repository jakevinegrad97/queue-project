package q;

import java.util.function.Function;
import java.util.function.Predicate;

public interface Queue<T> {

	T poll() throws RuntimeException;
	
	void add(T t);

	void addCondition(Predicate<T> condition, Function<T, T> outcome);

}
