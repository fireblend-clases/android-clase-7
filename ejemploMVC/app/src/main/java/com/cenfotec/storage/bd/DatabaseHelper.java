package com.cenfotec.storage.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.cenfotec.storage.bd.entities.Reservacion;
import com.cenfotec.storage.bd.entities.Usuario;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Estudiantes on 24/08/2017.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private Dao<Usuario, Integer> mUserDao = null;
    private Dao<Reservacion, Integer> mReservaDao = null;
    private static int DATABASE_VERSION = 1;

    private static DatabaseHelper instance;

    public static DatabaseHelper getInstance(Context ctx){
        if(instance == null){
            instance = new DatabaseHelper(ctx);
        }
        return instance;
    }

    private DatabaseHelper(Context context) {
        super(context, "ormlite.db", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db,
                         ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Usuario.class);
            TableUtils.createTable(connectionSource, Reservacion.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,
                          ConnectionSource connectionSource,
                          int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Usuario.class, true);
            TableUtils.dropTable(connectionSource, Reservacion.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //Metodos de ayuda para Usuario.java
    public Dao<Usuario, Integer> getUserDao() throws SQLException {
        if (mUserDao == null) {
            mUserDao = getDao(Usuario.class);
        }
        return mUserDao;
    }

    //Metodos de ayuda para Reservacion.java
    public Dao<Reservacion, Integer> getReservaDao() throws SQLException {
        if (mReservaDao == null) {
            mReservaDao = getDao(Reservacion.class);
        }
        return mReservaDao;
    }

    @Override
    public void close() {
        mUserDao = null;
        mReservaDao = null;
        super.close();
    }

    public void init() {
        try {
            if(getUserDao().queryForAll().size() != 0) {
                return;
            }

            Usuario usuario1 = new Usuario("Sergio", "123");
            Usuario usuario2 = new Usuario("Andres", "321");
            Usuario usuario3 = new Usuario("Nuria", "abc");

            Reservacion reserva1 = new Reservacion("1/2/2018", "8/2/2018", "SJO", "JFK", "12345");
            Reservacion reserva2 = new Reservacion("7/4/2018", "20/4/2018", "JFK", "SJO", "54321");
            Reservacion reserva3 = new Reservacion("12/5/2018", "22/5/2018", "ABC", "PRG", "09876");
            Reservacion reserva4 = new Reservacion("2/7/2018", "9/9/2018", "DSC", "NTH", "92462");

            getUserDao().createIfNotExists(usuario1);
            getUserDao().createIfNotExists(usuario2);
            getUserDao().createIfNotExists(usuario3);

            getReservaDao().createIfNotExists(reserva1);
            getReservaDao().createIfNotExists(reserva2);
            getReservaDao().createIfNotExists(reserva3);
            getReservaDao().createIfNotExists(reserva4);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
