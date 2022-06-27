package com.techwondoe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techwondoe.entities.Role;
 
public interface RoleRepository extends JpaRepository<Role, Integer> {
 
}