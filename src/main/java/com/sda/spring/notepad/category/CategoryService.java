package com.sda.spring.notepad.category;


import com.sda.spring.notepad.note.Note;
import com.sda.spring.notepad.note.SpringNoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // when i code service I have to add this annotation
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public Category save(Category category) {
        log.info("saving new category");
        return categoryRepository.save(category);
    }

    public Category findById(Long id){
        log.info("Searching for category with id:{}", id);
        Optional<Category> byId = categoryRepository.findById(id);
        if(byId.isEmpty()){
            throw new RuntimeException("Category is required");
        }
        return byId.get();
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    public List<Category> getAll(){
        List<Category> array = new ArrayList();
        categoryRepository.findAll().forEach(array::add);
        return array;
    }

    public List<Category> getCategoryByNameAndColor(String name, String color){
        return categoryRepository.findCategoryByNameAndColor(name, color);
    }

//    public List<Category> getCategoryByName(String name){
//        return categoryRepository.findCategoryByName(name);
//    }

}
