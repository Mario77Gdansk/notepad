package com.sda.spring.notepad.note;

import com.sda.spring.notepad.Censor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class NoteService {

    private final SpringNoteRepository noteRepository;
    private final Censor censor;

    public void save(Note note){


        Note censoredNote = censor.censore(note);
        noteRepository.save(note);

    //do wypisywania w konsoli
    //        Optional<Note> fetchNote = noteRepository.findById(1L);
    //        ;       log.info("_______________________");
    //        fetchNote.ifPresent(note1 -> log.info(note.toString()));
    //        log.info("_______________________");
    }

    public Note getById(Long id){
        Optional<Note> byId = noteRepository.findById(id);
        if(byId.isEmpty()){
            throw new RuntimeException("Note is required");
        }
        return byId.get();
    }

    public void deleteById(Long id){
        noteRepository.deleteById(id);

    }
    public List<Note> getAll(){
        List<Note> array = new ArrayList();
        noteRepository.findAll().forEach(array::add);
        return array;
    }
    public List<Note> getNoteByTitleAndContent(String title, String content){
        return noteRepository.findNoteByTitleAndContent(title, content);
    }

}
