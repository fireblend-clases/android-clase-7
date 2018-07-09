package com.cenfotec.storage.bd.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by Estudiantes on 24/08/2017.
 */

@DatabaseTable(tableName = "reservas")
public class Reservacion {

    @DatabaseField(generatedId = true, columnName = "reserva_id", canBeNull = false)
    public int reservaId;

    @DatabaseField(columnName = "t_salida", canBeNull = false)
    public String tiempoSalida;

    @DatabaseField(columnName = "t_llegada", canBeNull = false)
    public String tiempoLlegada;

    @DatabaseField(columnName = "l_salida", canBeNull = false)
    public String lugarSalida;

    @DatabaseField(columnName = "l_llegada", canBeNull = false)
    public String lugarLlegada;

    @DatabaseField(columnName = "num_pasaporte", canBeNull = false)
    public String numPasaporte;

    public Reservacion() {}


    public Reservacion(String tiempoSalida, String tiempoLlegada, String lugarSalida, String lugarLlegada, String numPasaporte){
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoSalida = tiempoSalida;
        this.lugarLlegada = lugarLlegada;
        this.lugarSalida = lugarSalida;
        this.numPasaporte = numPasaporte;

    }

}
