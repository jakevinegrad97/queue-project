package processing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Person;

public class MemberProcessor implements Processor {

	@Override
	public List<Person> getPeople() {
		List<Person> people = new ArrayList<>();
		try {
			people = 
				Files.lines(Paths.get("src/main/resources/people.csv"))
					.map(line -> {
						String[] parts = line.split(",");
						return new Person(parts[0].trim(), Integer.valueOf(parts[1].trim()));
					})
					.collect(Collectors.toList());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return people;
	}

}
