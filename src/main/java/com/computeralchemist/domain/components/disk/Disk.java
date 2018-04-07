package com.computeralchemist.domain.components.disk;

import com.computeralchemist.domain.components.ComputerComponent;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author
 * Karol Meksuła
 * 07-04-2018
 * */

@Document(collection = "disk")
public class Disk extends ComputerComponent {

    @Id
    private long productId;

    private DiskParameters diskParameters;

    public void setDiskParameters(DiskParameters diskParameters) {
        this.diskParameters = diskParameters;
    }

    public DiskParameters getDiskParameters() {
        return diskParameters;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
