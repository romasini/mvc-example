package ru.romasini.structure.pattern.mvc.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.romasini.structure.pattern.mvc.dto.StudentDto;
import ru.romasini.structure.pattern.mvc.entities.Student;
import ru.romasini.structure.pattern.mvc.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    public Optional<StudentDto> findById(Long id){
        Optional<Student> op = studentRepository.findById(id);
        return op.stream().map(StudentDto::new).findFirst();
    }

    public List<StudentDto> findAll(){
        return studentRepository.findAll().stream().map(StudentDto::new).collect(Collectors.toList());
    }

    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }
}
