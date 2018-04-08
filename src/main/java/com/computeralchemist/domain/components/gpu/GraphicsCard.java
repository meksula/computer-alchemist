package com.computeralchemist.domain.components.gpu;

import com.computeralchemist.domain.components.ComputerComponent;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author
 * Karol Meksuła
 * 08-04-2018
 * */

@Document(collection = "gpu")
public class GraphicsCard extends ComputerComponent {

    @Id
    private long producentId;

    private GraphicsCardParameters graphicsCardParameters;

    public long getProducentId() {
        return producentId;
    }

    public void setProducentId(long producentId) {
        this.producentId = producentId;
    }

    public GraphicsCardParameters getGraphicsCardParameters() {
        return graphicsCardParameters;
    }

    public void setGraphicsCardParameters(GraphicsCardParameters graphicsCardParameters) {
        this.graphicsCardParameters = graphicsCardParameters;
    }
}
