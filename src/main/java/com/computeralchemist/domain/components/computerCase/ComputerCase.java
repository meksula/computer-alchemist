package com.computeralchemist.domain.components.computerCase;

import com.computeralchemist.domain.components.ComputerComponent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author
 * Karol Meksuła
 * 09-04-2018
 * */

@Getter
@Setter
@Document(collection = "computercase")
public class ComputerCase extends ComputerComponent {

    @Id
    private long productId;

    private ComputerCaseParameters computerCaseParameters;

}
