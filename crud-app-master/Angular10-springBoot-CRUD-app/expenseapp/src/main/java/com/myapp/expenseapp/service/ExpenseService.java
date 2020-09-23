package com.myapp.expenseapp.service;

import java.util.List;

import com.myapp.expenseapp.model.Expense;

public interface ExpenseService {
	
	List<Expense> findAll();
	
	Expense save(Expense expense);

	Expense findById(Long id);
	
	void delete(Long id);

	
}