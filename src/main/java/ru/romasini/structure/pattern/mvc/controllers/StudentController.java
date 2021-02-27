package ru.romasini.structure.pattern.mvc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.romasini.structure.pattern.mvc.dto.StudentDto;
import ru.romasini.structure.pattern.mvc.entities.Student;
import ru.romasini.structure.pattern.mvc.services.StudentService;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("/students")
    public String getAllStudent(Model model){
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @GetMapping("/add_student")
    public String newStudent(){
        return "new_student";
    }

    @GetMapping("/edit_student/{id}")
    public String editStudent(Model model, @PathVariable Long id){
        Optional<StudentDto> student = studentService.findById(id);
        if (student.isPresent()){
            model.addAttribute("student",student.get());
            return "edit_student";
        }else {
            return "redirect:/students";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        studentService.deleteById(id);
        return "redirect:/students";
    }

    @PostMapping("/save_student")
    public String saveStudent(@ModelAttribute Student student){
        studentService.save(student);
        return "redirect:/students";
    }
}
