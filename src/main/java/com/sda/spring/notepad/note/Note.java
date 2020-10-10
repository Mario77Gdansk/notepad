package com.sda.spring.notepad.note;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sda.spring.notepad.category.Category;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
    String content;
    LocalDateTime creationDate;
    LocalDateTime lastUpdateDate;

    @ManyToOne
    @JsonBackReference //dzięki tej adnotacji zignoruje mi relację i wypisze wszystko
    private Category category;
}
