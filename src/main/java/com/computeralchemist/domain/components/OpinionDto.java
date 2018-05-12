package com.computeralchemist.domain.components;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.Identifiable;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Author
 * Karol Meksuła
 * 23-04-2018
 * */

@Getter
@Setter
@Document(collection = "opinions")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class OpinionDto extends ResourceSupport implements Identifiable<Link> {

    @Id
    private Long opinionId;

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
