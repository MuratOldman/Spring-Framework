package com.example.bootstrap;

import com.example.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public DataGenerator(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        accountRepository.findAllByCountry("United States").forEach(System.out::println);
        System.out.println("accountRepository.findAccountsByCountry(\"United States\") = " + accountRepository.findAccountsByCountry("United States"));

    }
}
