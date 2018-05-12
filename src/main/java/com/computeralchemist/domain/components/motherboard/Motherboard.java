package com.computeralchemist.domain.components.motherboard;

import com.computeralchemist.domain.components.ComputerComponent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Document(collection = "motherboards")
public class Motherboard extends ComputerComponent implements Serializable {

    @Id
    private long productId;

    private MotherboardParameters motherboardParameters;

}
