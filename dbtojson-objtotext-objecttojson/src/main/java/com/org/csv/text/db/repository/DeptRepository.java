package com.org.csv.text.db.repository;

import com.org.csv.text.db.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeptRepository extends MongoRepository<Department,Integer> {
}
