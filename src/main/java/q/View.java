package q;

import java.util.List;

import model.Person;
import processing.MemberProcessor;
import processing.Processor;

public class View {

	public static void main(String[] args) {
		Queue<Person> queue = new FILOQueue<>();
		Publisher<Person> publisher = new Publisher<>(queue);
		Subscriber<Person> subscriber = new Subscriber<>(queue);
		
		queue.addCondition(
				person -> {
					return person.getAge() >= 40;
				},
				person -> {
					person.setMembership("Silver");
					return person;
				}
				);
		queue.addCondition(
				person -> {
					return person.getAge() >= 60;
				},
				person -> {
					person.setMembership("Gold");
					return person;
				}
				);
		
		Processor processor = new MemberProcessor();
		List<Person> members = processor.getPeople();
		
		members.forEach(publisher::publish);
		
		System.out.println(queue);
	}
}
