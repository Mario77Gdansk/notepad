package com.sda.spring.notepad;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/api/note") // ten wpis umożliwił mi skasowanie zawartości w cudzysłowiu z wszystkich @GetMapping
                            //dopisałem to na końcu wcześniej
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;


    @PostMapping()
    public void save (@RequestBody Note note){
        noteService.save(note);
    }


    //GET BY ID

    @GetMapping("{id}") //ta sama zmienna id musi być poniżej jako Long id
    public ResponseEntity<Note> getById(@PathVariable Long id){ //to id będzie pobrane z góry
        Note note = null;
        try{
            note = noteService.getById(id);
        } catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.I_AM_A_TEAPOT)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(note);
    }

    //GET BY ID

    @GetMapping("/find") //
    public List<Note> getByTitleAndContent(
            @RequestParam("title") String title,
            @RequestParam("content")String content){ //
       return noteService.getNoteByTitleAndContent(title, content);
    }


    //GET ALL

    @GetMapping()
    public ResponseEntity<List<Note>> getAll(){
        List<Note> all = noteService.getAll();
         return ResponseEntity
                 .status(HttpStatus.OK)
                 .body(all);
    }

    //DELETE BY ID

    @DeleteMapping("{id}") //
    public void deleteById(@PathVariable Long id) { //
        noteService.deleteById(id);
    }


}
