package com.app.boot.dto;


import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


//DB接続できるようになったらEntityに変更する
@Data
public class User {


    private Integer id;
    private String name;

//    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd")
private LocalDate datee;



}
