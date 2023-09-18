package com.example.rinhabackend.app.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record PersonDTO(
   @NotNull
   @Size(max = 100)
   String name,

   @NotNull
   @Size(max = 32)
   String nickname,

   @NotNull
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
   String birthday,

   List<@Size(min = 1, max = 32)String> stackList
) {}
