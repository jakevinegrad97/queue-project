package model;

public class Person {

	private String name;
	private int age;
	private String membership;

	{
		membership = "Bronze";
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getMembership() {
		return membership;
	}
	
	public String toString() {
		return "[" + name + ", " + age + ", " + membership + "]";
	}

}
