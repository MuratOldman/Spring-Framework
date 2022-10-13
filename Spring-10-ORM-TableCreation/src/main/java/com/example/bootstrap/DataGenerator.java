package com.example.bootstrap;

import com.example.entity.Car;
import com.example.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    CarRepository carRepository;

    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Car car1=new Car("BMW","X5");
        Car car2=new Car("Audi","A5");
        Car car3=new Car("Mercedes","E");

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);

    }
}
