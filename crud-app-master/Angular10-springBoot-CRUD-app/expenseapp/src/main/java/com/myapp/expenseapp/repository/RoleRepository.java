package com.myapp.expenseapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.expenseapp.model.ERole;
import com.myapp.expenseapp.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(ERole name);

}
