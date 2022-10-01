package com.example.restfull.restfull.repos;

import com.example.restfull.restfull.entity.FilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepo extends JpaRepository<FilesEntity, Long> {
}
