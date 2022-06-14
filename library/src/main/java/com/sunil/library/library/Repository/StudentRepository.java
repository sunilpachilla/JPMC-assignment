package com.sunil.library.library.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunil.library.library.uiModel.Student;


@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
