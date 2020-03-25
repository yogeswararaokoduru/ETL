package com.org.csv.text.db.repository;

import com.org.csv.text.db.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpRepository extends MongoRepository<Employee,Integer> {
}
