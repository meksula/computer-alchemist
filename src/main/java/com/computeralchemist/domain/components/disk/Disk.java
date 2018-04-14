package com.computeralchemist.domain.components.disk;

import com.computeralchemist.domain.components.ComputerComponent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author
 * Karol Meksuła
 * 07-04-2018
 * */

@Getter
@Setter
@Document(collection = "disk")
public class Disk extends ComputerComponent {

    @Id
    private long productId;

    private DiskParameters diskParameters;

}
