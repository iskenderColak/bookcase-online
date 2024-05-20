package com.icolak.dal.repository.library;

import com.icolak.dal.model.library.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
}