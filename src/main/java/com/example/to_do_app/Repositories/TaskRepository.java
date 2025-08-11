package com.example.to_do_app.Repositories;

import com.example.to_do_app.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task,Long> {

    @Query("FROM Task")
    List<Task> findAll();

    @Transactional
    @Modifying
    @Query("UPDATE Task SET description = :description WHERE id = :id")
    void update(@Param("description") String description, Long id);

}
