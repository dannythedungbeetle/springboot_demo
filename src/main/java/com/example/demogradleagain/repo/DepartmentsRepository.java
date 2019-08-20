package com.example.demogradleagain.repo;

import com.example.demogradleagain.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by v.daniel.gunturu on 8/18/2019
 */
@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Integer> {

}
