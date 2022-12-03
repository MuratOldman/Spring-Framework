package com.example.repository;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> findAccountsByCountry(String country);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findAccountsByAgeLessThanEqual(int age);

    //Write a derived query to list all accounts with a specific role
    List<Account> findAccountsByRole(String role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findAccountsByAgeIsBetween(int age1,int age2);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findAccountsByAddressStartingWith(String pattern);

    //Write a derived query to sort the list of accounts with age


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts

    //Write a JPQL query to list all admin accounts

    //Write a JPQL query to sort all accounts with age

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city

    //Write a native query to read all accounts with an age lower than a specific value
}
