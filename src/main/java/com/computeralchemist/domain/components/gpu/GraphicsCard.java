package com.computeralchemist.domain.components.gpu;

import com.computeralchemist.domain.components.ComputerComponent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @Author
 * Karol Meksuła
 * 08-04-2018
 * */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Document(collection = "gpu")
public class GraphicsCard extends ComputerComponent implements Serializable {

    @Id
    private long productId;

    private GraphicsCardParameters graphicsCardParameters;

}
