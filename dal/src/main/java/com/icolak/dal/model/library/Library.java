package com.icolak.dal.model.library;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Library {

    @Id
    @Column(name = "library_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ElementCollection
    List<Integer> userBook;
}