package com.example.FavoriteSports.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Table(name = "sportsTable")
public class PlayerDetails {
    @Id
    @Column
    private String name;
    @Column
    private String favorite_sport;
    @Column
    private String address;
    @Column
    private Date date_of_birth;
    @Column
    private String phone_number;
    @Column
    private String surname;
    @Column
    private String father_name;
    @Column
    private String mother_name;
}
