package com.example.budgetLesh.Repo;

import com.example.budgetLesh.models.Section;
import org.springframework.data.repository.CrudRepository;

// extends all functions from CrudRepository (Create, Read, Update< Delete),
// connect do Section model and notice id is Long
public interface SectionRepository extends CrudRepository<Section, Long> {
}
