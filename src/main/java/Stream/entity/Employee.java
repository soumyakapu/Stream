package Stream.entity;

import lombok.*;

import java.util.List;
@Setter
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String name;
    private String email;
    private List<String> role;
    private double salary;


}
