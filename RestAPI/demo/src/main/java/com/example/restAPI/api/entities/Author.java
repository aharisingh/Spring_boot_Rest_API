package com.example.restAPI.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name ="author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "author_id_seq")
    private Long id;
    private String name;
    private Integer age;

}
