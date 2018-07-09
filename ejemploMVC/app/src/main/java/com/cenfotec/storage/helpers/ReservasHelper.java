package com.cenfotec.storage.helpers;

import android.content.Context;

import com.cenfotec.storage.bd.DatabaseHelper;
import com.cenfotec.storage.bd.entities.Reservacion;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class ReservasHelper {

    private static Dao<Reservacion, Integer> dao;

    public static List<Reservacion> getReservas(Context ctx){
        if(dao == null){
            try {
                DatabaseHelper helper = DatabaseHelper.getInstance(ctx);
                helper.init();
                dao = helper.getReservaDao();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            return null;
        }

    }

}
