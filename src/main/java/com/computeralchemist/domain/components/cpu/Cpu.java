package com.computeralchemist.domain.components.cpu;

import com.computeralchemist.domain.components.ComputerComponent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @Author
 * Karol Meksuła
 * 03-04-2018
 * */

@Getter
@Setter
@Document(collection = "cpu")
public class Cpu extends ComputerComponent implements Serializable {

    @Id
    private long productId;

    private CpuParameters cpuParameters;

}
