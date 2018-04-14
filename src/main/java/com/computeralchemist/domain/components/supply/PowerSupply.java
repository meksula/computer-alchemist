package com.computeralchemist.domain.components.supply;

import com.computeralchemist.domain.components.ComputerComponent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author
 * Karol Meksuła
 * 07-08-2018
 * */

@Getter
@Setter
@Document(collection = "supply")
public class PowerSupply extends ComputerComponent {

    @Id
    private long productId;

    private PowerSupplyParameters powerSupplyParameters;

}
