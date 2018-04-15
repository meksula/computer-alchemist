package com.computeralchemist.domain.components.gpu;

import com.computeralchemist.domain.components.ComputerComponent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author
 * Karol Meksuła
 * 08-04-2018
 * */

@Getter
@Setter
@Document(collection = "gpu")
public class GraphicsCard extends ComputerComponent {

    @Id
    private long productId;

    private GraphicsCardParameters graphicsCardParameters;

}
