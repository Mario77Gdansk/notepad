package com.sda.spring.notepad;


import com.sda.spring.notepad.category.Category;
import com.sda.spring.notepad.category.CategoryService;
import com.sda.spring.notepad.note.Note;
import com.sda.spring.notepad.note.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class Invoker implements CommandLineRunner {


    private final NoteService noteService;
    private final CategoryService categoryService;


    @Override
    public void run(String... args) throws Exception {
        Note note01 = saveNewNote("first tile");
        Note note02 = saveNewNote("second tile");
        Category category = saveNewCategory();
        note01.setCategory(category);
        note02.setCategory(category);

        categoryService.save(category);

        noteService.save(note01);
        noteService.save(note02);
    }

    private Category saveNewCategory() { //shortcut CTRL+ALT+M creates separate method
        Category category = new Category();
  //      category.setId(1L);
        category.setName("Animals");
        category.setColor("red");
        return category;


    }

    private Note saveNewNote(String title) {
        Note note = new Note();
  //      note.setId(1L);
        note.setTitle("Sample note");
        note.setContent("Lorem ipsum ... jeden ... dwa ... trzy");
        note.setCreationDate(LocalDateTime.now());
        note.setLastUpdateDate(LocalDateTime.now());
        return note;

    }
}
