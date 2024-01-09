import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String gg[])
    {
        List<Student> studentList= Stream.of(
                new Student(1,"John Doe",30,"male","Computer Engineering","Mumbai",122,Arrays.asList("7412589633","4523698741")),
                new Student(2,"Tony Stark",56,"male","Mechanical Engineering","Delhi",67,Arrays.asList("9632587410","4569871236")),
                new Student(3,"Steve Rogers",25,"male","Mechanical Engineering","Kerala",164,Arrays.asList("7456321890","7458963210")),
                new Student(4,"Jane Foster",30,"female","Mechanical Engineering","Kerala",26,Arrays.asList("7896412563","9632587410")),
                new Student(5,"Logan Wolverine",23,"male","Biotech Engineering","Mumbai",12,Arrays.asList("7412589630","3214569870")),
                new Student(6,"Bruce Wayne",24,"male","Mechanical Engineering","Karnataka",90,Arrays.asList("9632587410","1236547809")),
                new Student(7,"Wonder Women",26,"female","Electronics Engineering","Karnataka",324,Arrays.asList("7896541253","1597536842")),
                new Student(8,"Black Widow",31,"female","Computer Engineering","Karnataka",433,Arrays.asList("7458963210","9632514780")),
                new Student(9,"Mack Miller",27,"male","Computer Engineering","Karnataka",7,Arrays.asList("7412589630","7896321045")),
                new Student(10,"Jeremy Runner",26,"male","Instrumentation Engineering","Mumbai",98,Arrays.asList("7896302145","4521789630"))
        ).collect(Collectors.toList());
        // 1. find the list of students whose rank is between 50 and 100
        List<Student> studentsByRank = studentList.stream().filter(student -> student.getRank() > 50 && student.getRank() < 100)
                .collect(Collectors.toList());
        //System.out.println(studentsByRank);
        // 2. find the list of student who lives in specific city and sort them according to their names
        List<Student> studentsByCity = studentList.stream().filter(student -> student.getCity().equals("Karnataka"))
                .sorted(Comparator.comparing(Student::getName,Comparator.reverseOrder()))
                .toList();
        //System.out.println(studentsByCity);
        // 3. get all the department names
        List<String> departmentsList = studentList.stream().map(student -> student.getDepartment()).distinct().toList();
        Set<String> departmentsList2 = studentList.stream().map(Student::getDepartment).collect(Collectors.toSet());
        //System.out.println(departmentsList);
        // 4. Find all the contact numbers
        List<List<String>> contactsList = studentList.stream().map(Student::getContacts).toList();
        //System.out.println(contactsList);
        List<String> contactList2 = studentList.stream().flatMap(student -> student.getContacts().stream()).toList();
        //System.out.println(contactList2);
        // 5. Group the students by department name
        Map<String, List<Student>> studentMap = studentList.stream().collect(Collectors.groupingBy(Student::getDepartment));
        //System.out.println(studentMap);
        // 6. find the numbers of the student each department have
        Map<String, Long> studentMap2 = studentList.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
        //System.out.println(studentMap2);
        // 7. find the department which have largest number of students
        Map.Entry<String, Long> largestDepartment = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()).get();
        //System.out.println(largestDepartment);
        // 8. find the average age of male and female students
        Map<String, Double> averageStudent = studentList.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        //System.out.println(averageStudent);
        // 9. Find the highest rank in all departments
        Map<String, Optional<Student>> highestRankOfStudent = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.minBy(Comparator.comparing(Student::getRank))));
        //System.out.println(highestRankOfStudent);
        // Find the student whose rank is second
        List<Student> sortByRank = studentList.stream().sorted(Comparator.comparing(Student::getRank)).collect(Collectors.toList());
        //System.out.println(sortByRank);
        Student secondRankStudent = studentList.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .skip(1)
                .findFirst().get();
        Student ThirdRankStudent = studentList.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .skip(2)
                .findFirst().get();
        System.out.println(secondRankStudent);

    }
}



