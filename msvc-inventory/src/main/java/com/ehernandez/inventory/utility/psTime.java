package com.platzi.market.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Erik Darío Hernández Vásquez - erikdhv@gmail.com
 * @version 1.0
 */
public class psTime {
    /**
     * El metodo retorna el fecha y hora de tipo TimeStamp y con el formato yyyy-MM-dd HH:mm:ss
     * @return yyyy-MM-dd HH:mm:ss
     */
    public LocalDateTime getPsTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime = new Date();

        //return LocalDateTime.parse(dateFormat.format(dateTime));
        return LocalDateTime.now();
    }
}
