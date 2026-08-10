package com.thejoa703.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.domain.DeptUser;

@Repository
public interface DeptUserRepository extends JpaRepository<DeptUser, Long>{
}
