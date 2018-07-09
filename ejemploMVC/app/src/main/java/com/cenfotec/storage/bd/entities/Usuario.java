package com.cenfotec.storage.bd.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Estudiantes on 24/08/2017.
 */

@DatabaseTable(tableName = "usuarios")
public class Usuario {

    @DatabaseField(generatedId = true, columnName = "user_id", canBeNull = false)
    public int userId;

    @DatabaseField(columnName = "username", canBeNull = false)
    public String username;

    @DatabaseField(columnName = "password", canBeNull = false)
    public String password;

    public Usuario() {}

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
