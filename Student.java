import lombok.*;

import java.util.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String department;
    private String city;
    private int rank;
    private List<String> contacts;
}
