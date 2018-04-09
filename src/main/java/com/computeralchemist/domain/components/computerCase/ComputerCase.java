package com.computeralchemist.domain.components.computerCase;

import com.computeralchemist.domain.components.ComputerComponent;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author
 * Karol Meksuła
 * 09-04-2018
 * */

@Document(collection = "computercase")
public class ComputerCase extends ComputerComponent {

    @Id
    private long productId;

    private ComputerCaseParameters computerCaseParameters;

    public ComputerCaseParameters getComputerCaseParameters() {
        return computerCaseParameters;
    }

    public void setComputerCaseParameters(ComputerCaseParameters computerCaseParameters) {
        this.computerCaseParameters = computerCaseParameters;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
