package com.sda.spring.notepad;


import com.sda.spring.notepad.category.Category;
import com.sda.spring.notepad.category.CategoryService;
import com.sda.spring.notepad.note.Note;
import com.sda.spring.notepad.note.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class Invoker implements CommandLineRunner {


    private final NoteService noteService;
    private final CategoryService categoryService;


    @Override
    public void run(String... args) throws Exception {
        saveNewNote();
        saveNewCategory();
    }

    private void saveNewCategory() { //shortcut CTRL+ALT+M creates separate method
        Category category = new Category();
        category.setId(1L);
        category.setName("Animals");
        category.setColor("red");

        categoryService.save(category);
    }

    private void saveNewNote() {
        Note note = new Note();
        note.setId(1L);
        note.setTitle("Sample note");
        note.setContent("Lorem ipsum ... jeden ... dwa ... trzy");
        note.setCreationDate(LocalDateTime.now());
        note.setLastUpdateDate(LocalDateTime.now());

        noteService.save(note);
    }
}
