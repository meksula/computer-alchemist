package com.computeralchemist.domain.components;

import com.computeralchemist.domain.components.specification.ComponentParameters;
import com.computeralchemist.repository.others.MongoIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

@Document(collection = "motherboards")
public class Motherboard extends ComputerComponent {

    @Id
    private long productId;

    private String producent;

    private String model;
    private String description;
    private ComponentParameters componentParameters;

    private double compatibiltyIndex;

    private String urlToPicture;

    public String getModel() {
        return model;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCompatibiltyIndex() {
        return compatibiltyIndex;
    }

    public void setCompatibiltyIndex(double compatibiltyIndex) {
        this.compatibiltyIndex = compatibiltyIndex;
    }

    public ComponentParameters getComponentParameters() {
        return componentParameters;
    }

    public void setComponentParameters(ComponentParameters componentParameters) {
        this.componentParameters = componentParameters;
    }

    public String getUrlToPicture() {
        return urlToPicture;
    }

    public void setUrlToPicture(String urlToPicture) {
        this.urlToPicture = urlToPicture;
    }
}
