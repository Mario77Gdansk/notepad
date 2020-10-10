package com.sda.spring.notepad.category;


import com.sda.spring.notepad.note.Note;
import com.sda.spring.notepad.note.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category") // ten wpis umożliwił mi skasowanie zawartości w cudzysłowiu z wszystkich @GetMapping
//dopisałem to na końcu wcześniej
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    //SAVE
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category save (@RequestBody Category category){
        return categoryService.save(category);
    }

    //GET BY ID
    @GetMapping("{id}") //ta sama zmienna id musi być poniżej jako Long id
    public ResponseEntity<Category> findById(@PathVariable Long id) { //to id będzie pobrane z góry
           Category category = null;
        try{
            category = categoryService.findById(id);
        } catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.I_AM_A_TEAPOT)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(category);
    }

//    Optional<Category> category = categoryService.findById(id);
//    if(category.isPresent()){
//    return ResponseEntity.status(HttpStatus.OK).body(category.get());}
//    else{
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
//    }


    //GET BY NAME AND COLOR
    @GetMapping("/find") //
    public List<Category> getByNameAndColor(
            @RequestParam("name") String name,
            @RequestParam("color")String color){ //
        return categoryService.getCategoryByNameAndColor(name, color);
    }

    //GET BY NAME ONLY
//    @GetMapping("/find") //
//    public List<Category> getByName(
//            @RequestParam("name") String name){ //
//        return categoryService.getCategoryByName(name);
//    }

    //GET ALL
    @GetMapping()
    public ResponseEntity<List<Category>> getAll(){
        List<Category> all = categoryService.getAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(all);
    }

    //DELETE BY ID
    @DeleteMapping("{id}") //
    public void deleteById(@PathVariable Long id) { //
        categoryService.deleteById(id);
    }


}
