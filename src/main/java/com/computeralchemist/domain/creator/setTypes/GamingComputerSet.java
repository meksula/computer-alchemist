package com.computeralchemist.domain.creator.setTypes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

@Document(collection = "gamingset")
public class GamingComputerSet extends ComputerSet {

    @Id
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
