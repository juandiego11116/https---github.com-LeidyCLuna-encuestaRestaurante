package com.sura.encuesta.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateFomatter {

    public LocalDate dateStringtoLocalDate(String fecha){
        return fecha != null ? LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy")):null;
    }

    public String LocalDateToStringDate(LocalDate fecha){
        return fecha != null ?fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")):null;
    }
}
