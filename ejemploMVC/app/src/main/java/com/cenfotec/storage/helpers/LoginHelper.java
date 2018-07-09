package com.cenfotec.storage.helpers;

import android.content.Context;
import android.widget.Toast;

import com.cenfotec.storage.bd.DatabaseHelper;
import com.cenfotec.storage.bd.entities.Usuario;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Estudiantes on 14/04/2018.
 */

public class LoginHelper {

    static Dao<Usuario, Integer> userDao;

    public static boolean login(String usuario, String password, boolean recordar, Context ctx){

        try {
            if(userDao == null) {
                PreferencesManager.savePreferences(ctx,
                        usuario, password, recordar);

                DatabaseHelper bdHelper = DatabaseHelper.getInstance(ctx);
                bdHelper.init();

                //Obtenemos el dao de la tabla de usuarios
                userDao = bdHelper.getUserDao();
            }

            //Generamos un filtro y obtenemos la lista resultado
            Where filtro = userDao.queryBuilder()
                    .where()
                    .eq("username", usuario);

            List<Usuario> usuarios = filtro.query();

            //Si no se encontro ningun usuario, es porque no existe
            if(usuarios.size() == 0){
                Toast.makeText(ctx, "Ese usuario no existe!", Toast.LENGTH_SHORT).show();
                return false;
            }

            //Obtenemos la referencia al usuario
            Usuario user = usuarios.get(0);

            //Si los passwords son diferentes, mostramos un error
            if(!user.password.equals(password)){
                Toast.makeText(ctx, "Password incorrecto!", Toast.LENGTH_SHORT).show();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }


}
