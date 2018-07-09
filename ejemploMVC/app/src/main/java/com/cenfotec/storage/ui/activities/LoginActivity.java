package com.cenfotec.storage.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.cenfotec.storage.bd.DatabaseHelper;
import com.cenfotec.storage.helpers.LoginHelper;
import com.cenfotec.storage.helpers.PreferencesManager;
import com.cenfotec.storage.R;
import com.cenfotec.storage.ui.fragments.LoginFragment;
import com.cenfotec.storage.ui.fragments.ReservationsFragment;

public class LoginActivity extends AppCompatActivity implements LoginFragment.LoginListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new LoginFragment(), "")
                .commit();
    }

    @Override
    public String getUsuario() {
        return PreferencesManager.getUsernameFromPreferences(this);
    }

    @Override
    public String getPassword() {
        return PreferencesManager.getPasswordFromPreferences(this);
    }

    @Override
    public boolean shouldRememberPass() {
        return PreferencesManager.getRememberFromPreferences(this);
    }

    @Override
    public boolean loginSuccessful(String user, String pass, boolean remember) {
        return LoginHelper.login(user, pass, remember, this);
    }

    @Override
    public void goToReservations() {
        Intent intent = new Intent(this, ReservationsActivity.class);
        startActivity(intent);
    }
}
