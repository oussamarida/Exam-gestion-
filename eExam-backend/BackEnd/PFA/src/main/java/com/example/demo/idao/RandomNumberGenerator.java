package com.example.demo.idao;

import java.util.Random;

public class RandomNumberGenerator {
  

    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(100 - 1 + 1) + 1;
    }
}
