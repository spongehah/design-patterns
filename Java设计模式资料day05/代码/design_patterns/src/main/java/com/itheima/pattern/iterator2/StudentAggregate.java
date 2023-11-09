package com.itheima.pattern.iterator2;

public interface StudentAggregate {
    
    void addStudent(Student student);
    
    void removeStudent(Student student);
    
    StudentIterator getStudentIterator();
}
