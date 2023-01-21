package com.example.budgetLesh.Repo;

import com.example.budgetLesh.models.Budget;
import org.springframework.data.repository.CrudRepository;

// extends all functions from CrudRepository (Create, Read, Update< Delete),
// connect do Budget model and notice id is Long
public interface BudgetRepository extends CrudRepository<Budget, Long> {
}
