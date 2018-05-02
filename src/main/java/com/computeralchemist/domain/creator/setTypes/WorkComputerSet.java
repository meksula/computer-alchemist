package com.computeralchemist.domain.creator.setTypes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Document(collection = "workset")
public class WorkComputerSet extends ComputerSet {

    @Id
    private long setId;

}
