package com.example.CsvFileUploader.Repository;

import com.example.CsvFileUploader.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
