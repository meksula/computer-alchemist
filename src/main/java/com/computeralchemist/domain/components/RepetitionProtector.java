package com.computeralchemist.domain.components;

import com.computeralchemist.repository.components.cpu.CpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author
 * Karol Meksuła
 * 09-04-2018
 * */

@Service
public class RepetitionProtector {
    private CpuRepository cpuRepository;

    @Autowired
    public void setCpuRepository(CpuRepository cpuRepository) {
        this.cpuRepository = cpuRepository;
    }

    /*
    * A może by zrobić tak, że dodane komponenty przechodziłyby do poczekalni,
    * a dopiero wtedy wymagałyby potwierdzenia przez admina ?
    * Wtedy system by sobie sprawdzał, czy nie ma powtórzeń.
    * Albo taka poczekalnia by się sama włączała np. co godzinę, albo w nocy o 3:00 ?
    * Pomyśl nad tym
    * */

    public boolean documentExist(String producent, String model) {
        //return cpuRepository.findByProducentAndModel(producent, model);
        return true;
    }

}
