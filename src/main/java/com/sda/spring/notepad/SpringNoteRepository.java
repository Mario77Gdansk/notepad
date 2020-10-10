package com.sda.spring.notepad;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringNoteRepository extends CrudRepository<Note, Long> {

    public List<Note> findNoteByTitleAndContent(String title, String content);
}
