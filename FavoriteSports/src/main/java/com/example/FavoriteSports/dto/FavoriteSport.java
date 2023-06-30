package com.example.FavoriteSports.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FavoriteSport {
    private List<String> favorite_sports;


}
