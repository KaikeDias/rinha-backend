package com.example.rinhabackend.app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    private String name;
    private String nickname;
    private String birthday;

    @Column(nullable = true)
    @ElementCollection
    private List<String> stackList;
}
