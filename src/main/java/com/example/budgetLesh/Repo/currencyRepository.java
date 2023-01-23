package com.example.budgetLesh.Repo;

import com.example.budgetLesh.models.Currency;
import org.springframework.data.repository.CrudRepository;

// extends all functions from CrudRepository (Create, Read, Update< Delete),
// connect do Currency model and notice id is Long
public interface currencyRepository extends CrudRepository<Currency, Long>{
}
