package com.computeralchemist.domain.components.supply;

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
 * 07-08-2018
 * */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Document(collection = "supply")
public class PowerSupply extends ComputerComponent implements Serializable {

    @Id
    private long productId;

    private PowerSupplyParameters powerSupplyParameters;

}
