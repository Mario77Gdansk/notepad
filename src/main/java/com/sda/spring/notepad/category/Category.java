package com.sda.spring.notepad.category;

import com.sda.spring.notepad.note.Note;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

//link do przeglądarki http://localhost:8080/api/category/1

//@Data //i can type @Entity, @Getter, @Setter, @NoArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category {
    @Id //
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String color;


    @OneToMany (mappedBy = "category")
    Set<Note> noteSet;
}
