package com.github.lbovolini.vaccineapi.repository;

import com.github.lbovolini.vaccineapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, CustomUserRepository {
}
