package com.sda.spring.notepad;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
@Slf4j
public class Censor {

    private Map<String, String> blackList = new HashMap<>();

    @PostConstruct
    public void init(){
        blackList.put("twoja stara","twoja mamusia");
        blackList.put("kurwa", "kurcze");
        blackList.put("bóbr","warkocz");
    }

    public Note censore (Note note) {
        String content = note.getContent();
        for (String key : blackList.keySet()) {
            String censoredContent = content.replaceAll(key,blackList.get(key));
            content = censoredContent;
        }
        note.setContent(content);
        return note;
    }

}
