package com.example.rinhabackend.app.repositories;

import com.example.rinhabackend.app.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
    Boolean existsByNickname(String nickname);
}
