package com.computeralchemist.domain.components.ram;

import com.computeralchemist.domain.components.ComputerComponent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author
 * Karol Meksuła
 * 05-04-2018
 * */

@Getter
@Setter
@Document(collection = "ram")
public class Ram extends ComputerComponent {

    @Id
    private long productId;

    private RamParameters ramParameters;

}
