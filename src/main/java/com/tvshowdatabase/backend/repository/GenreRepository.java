package com.tvshowdatabase.backend.repository;

import com.tvshowdatabase.backend.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
