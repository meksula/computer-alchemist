package com.computeralchemist.domain.components;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class ComputerComponent extends ResourceSupport {

    public abstract long getProductId();

    @NotNull
    private ComponentType componentType;

    @NotNull
    private String producent;

    @NotNull
    private String model;
    private String description;
    private String urlToResource;
    private double compatibleIndex;
    private long votes;
    private double allPoints;
    private double ratesEvg;

}
