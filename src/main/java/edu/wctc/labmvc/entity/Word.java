package edu.wctc.labmvc.entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Word {
    private String term;
    private String definition;
}
