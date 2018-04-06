package com.computeralchemist.domain.components.ram;

import com.computeralchemist.domain.components.ComputerComponent;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author
 * Karol Meksuła
 * 05-04-2018
 * */

@Document(collection = "ram")
public class Ram extends ComputerComponent {

    @Id
    private long productId;

    private RamParameters ramParameters;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public RamParameters getRamParameters() {
        return ramParameters;
    }

    public void setRamParameters(RamParameters ramParameters) {
        this.ramParameters = ramParameters;
    }
}
