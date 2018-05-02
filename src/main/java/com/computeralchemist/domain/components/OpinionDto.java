package com.computeralchemist.domain.components;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @Author
 * Karol Meksuła
 * 23-04-2018
 * */

@Getter
@Setter
@Document(collection = "opinions")
public class OpinionDto {

    @Id
    private long opinionId;

    private ComponentType componentType;
    private long productId;

    @NotNull
    private String date;

    @NotNull
    private String author;
    private String content;

    @Min(1)
    @Max(5)
    private double rate;

    @Override
    public String toString() {
        return componentType + " with ID: " + productId + ", author: " + author + ", content: "
                + content + ", rate: " + rate;
    }
}
