package com.computeralchemist.domain.components.motherboard;

import com.computeralchemist.domain.components.ComputerComponent;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

@Document(collection = "motherboards")
public class Motherboard extends ComputerComponent {

    @Id
    private long productId;

    private MotherboardParameters motherboardParameters;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public MotherboardParameters getMotherboardParameters() {
        return motherboardParameters;
    }

    public void setMotherboardParameters(MotherboardParameters motherboardParameters) {
        this.motherboardParameters = motherboardParameters;
    }
}
