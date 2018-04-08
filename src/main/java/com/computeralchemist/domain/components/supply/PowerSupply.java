package com.computeralchemist.domain.components.supply;

import com.computeralchemist.domain.components.ComputerComponent;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author
 * Karol Meksuła
 * 07-08-2018
 * */

@Document(collection = "supply")
public class PowerSupply extends ComputerComponent {

    @Id
    private long productId;

    private PowerSupplyParameters powerSupplyParameters;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public PowerSupplyParameters getPowerSupplyParameters() {
        return powerSupplyParameters;
    }

    public void setPowerSupplyParameters(PowerSupplyParameters powerSupplyParameters) {
        this.powerSupplyParameters = powerSupplyParameters;
    }
}
