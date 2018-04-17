package com.computeralchemist.domain.creator.setTypes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

@Document(collection = "familyset")
public class FamilyComputerSet extends ComputerSet {

    @Id
    private long id;

    public long getSetId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
