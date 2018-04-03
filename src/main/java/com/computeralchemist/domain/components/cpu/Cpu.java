package com.computeralchemist.domain.components.cpu;

import com.computeralchemist.domain.components.ComputerComponent;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author
 * Karol Meksuła
 * 03-04-2018
 * */

@Document(collection = "cpu")
public class Cpu extends ComputerComponent {

    @Id
    private long productId;

    private CpuParameters cpuParameters;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public CpuParameters getCpuParameters() {
        return cpuParameters;
    }

    public void setCpuParameters(CpuParameters cpuParameters) {
        this.cpuParameters = cpuParameters;
    }
}
