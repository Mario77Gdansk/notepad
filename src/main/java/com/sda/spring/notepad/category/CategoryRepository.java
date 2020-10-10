package com.sda.spring.notepad.category;

import com.sda.spring.notepad.note.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository <Category, Long>{

    public List<Category> findCategoryByNameAndColor(String name, String color);
//    public List<Category> findCategoryByName(String name);
}
