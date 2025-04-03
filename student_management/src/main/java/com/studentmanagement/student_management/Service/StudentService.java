package com.studentmanagement.student_management.Service;

import com.studentmanagement.student_management.Entity.Student;
import com.studentmanagement.student_management.Repository.StudentRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentService 
{
    @Autowired
    private StudentRepository studentRepository;
    
    public List<Student> getAllStudents() 
    {
        return studentRepository.findAll();
    }
    
    public Student saveStudent(Student student) 
    {
        return studentRepository.save(student);
    }
    
    public Student getStudentById(Long id) 
    {
        return studentRepository.findById(id).get();
    }
    
    public Student updateStudent(Student student) 
    {
        return studentRepository.save(student);
    }
    
    public void deleteStudentById(Long id) 
    {
        studentRepository.deleteById(id);
    }
}