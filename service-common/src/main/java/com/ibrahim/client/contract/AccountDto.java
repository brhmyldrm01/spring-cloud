package com.ibrahim.client.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private String id;

    private String username;

    private String name;

    private String surname;

    private LocalDate birthDate;

    private String email;

    public String getNameAndSurname(){
        return this.name + " " + this.surname;
    }
}
