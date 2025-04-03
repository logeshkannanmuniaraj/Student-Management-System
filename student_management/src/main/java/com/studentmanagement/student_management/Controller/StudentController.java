package com.studentmanagement.student_management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.studentmanagement.student_management.Entity.Student;
import com.studentmanagement.student_management.Service.StudentService;

@Controller
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listStudents", studentService.getAllStudents());
        return "students";
    }
    
    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {
    	System.out.println("Student data is added");
        Student student = new Student();
        System.out.println("Student data is added2 ");
        model.addAttribute("student", student);
        return "add-student";
    }
    
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit-student";
    }
    
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id) {
        this.studentService.deleteStudentById(id);
        return "redirect:/";
    }
}