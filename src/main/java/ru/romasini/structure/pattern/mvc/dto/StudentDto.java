package ru.romasini.structure.pattern.mvc.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.romasini.structure.pattern.mvc.entities.Student;

@Data
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private Integer age;

    public StudentDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.age = student.getAge();
    }

}
