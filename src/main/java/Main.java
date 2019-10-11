import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) 
  {
    List<Person> people = getPeople();
    
// Imperative approach
//-------------------------------------------------------
    // First defines a list
//    List<Person> females = new ArrayList<>();
//    
//    // Performs loop through list
//    for(Person person : people)
//    {
//    	// Checks if
//    	if(person.getGender().equals(Gender.FEMALE))
//    	{
//    		females.add(person);
//    	}
//    }
//    
//    // Finally prints out
//    females.forEach(System.out::println);
    
    
// Declarative Approach
//-------------------------------------------------
// Creates a new list of persons
    // Gets the stream of people
    // Filters through stream looking for females
    // Returns a list of all the females
    List<Person> females = people.stream()
    	.filter(person -> person.getGender().equals(Gender.FEMALE))
    	.collect(Collectors.toList());
    
    // females.forEach(System.out::println);
    
// To sort the data
    // This creates a new list sorted
    // Gets the stream of people and sorts the stream
    // based on the getAge getter
    // Then uses then comparing to sort by gender as well
    // Then uses .reversed to reverse the order
    // Then returns a list
    List<Person> sorted = people.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
    .collect(Collectors.toList());
    
    //sorted.forEach(System.out::println);

// Using All Match
    // This looks through the list making sure
    //everyone has age greater than 5 and returns
    // true because thats true
    // if we were to use 8 it would be false
    boolean allMatch = people.stream()
    	.allMatch(person -> person.getAge() > 8);
    
    // System.out.println(allMatch);
    
// Using Any Match
    // This will print true if any age is greater than
    // 8
    boolean anyMatch = people.stream()
    		.anyMatch(person -> person.getAge() > 8);
    
    // System.out.println(anyMatch);
    
// Using None match
    // If no ones name matches the name Tom it returns true
    // But if a name is matched then it returns false
    boolean noneMatch = people.stream()
    	.noneMatch(person -> person.getName().equals("Tom"));
    
    // System.out.println(noneMatch);
    
// Using Max
    // Searches through the stream for the max age
    // Must use the comparator.comparing then the age
    // If a value is found prints it out
	people.stream()
    		.max(Comparator.comparing(Person::getAge))
    		.ifPresent(System.out::println);
	
// Using Min
	// Just use min instead of max
	people.stream()
		.min(Comparator.comparing(Person::getAge))
		.ifPresent(System.out::println);
	
// Using Group
	//create a map out of of the groups you want to sort
	//with the list of persons in that group
	Map<Gender, List<Person>> groupingBy = people.stream()
	.collect(Collectors.groupingBy(Person::getGender));
	
	// a for each for each map then
	// a foreach for each people list in map
	groupingBy.forEach((gender, people1) -> {
		System.out.println(gender);
		people1.forEach(System.out::println);
		System.out.println();
	});
  }

  private static List<Person> getPeople()
  {
    return List.of(
        new Person("James Bond", 20, Gender.MALE),
        new Person("Alina Smith", 33, Gender.FEMALE),
        new Person("Helen White", 57, Gender.FEMALE),
        new Person("Alex Boz", 14, Gender.MALE),
        new Person("Jamie Goa", 99, Gender.MALE),
        new Person("Anna Cook", 7, Gender.FEMALE),
        new Person("Zelda Brown", 120, Gender.FEMALE)
    );
  }
}
