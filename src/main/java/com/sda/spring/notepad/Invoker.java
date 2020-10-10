package com.sda.spring.notepad;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Invoker implements CommandLineRunner {


    private final NoteService noteService;


    @Override
    public void run(String... args) throws Exception {
        Note note = new Note();
        note.setId(1L);
        note.setTitle("Sample note");
        note.setContent("Lorem ipsum ... jeden ... dwa ... trzy");
        note.setCreationDate(LocalDateTime.now());
        note.setLastUpdateDate(LocalDateTime.now());

        noteService.save(note);
    }
}
