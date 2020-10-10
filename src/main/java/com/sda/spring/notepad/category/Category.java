package com.sda.spring.notepad.category;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//link do przeglądarki http://localhost:8080/api/category/1

@Data //i can type @Entity, @Getter, @Setter, @NoArgsConstructor
@Entity
public class Category {
    @Id //
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String color;
}
