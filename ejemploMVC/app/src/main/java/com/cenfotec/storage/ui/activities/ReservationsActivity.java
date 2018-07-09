package com.cenfotec.storage.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cenfotec.storage.R;
import com.cenfotec.storage.bd.entities.Reservacion;
import com.cenfotec.storage.helpers.ReservasHelper;
import com.cenfotec.storage.ui.fragments.ReservationsFragment;

import java.util.List;

public class ReservationsActivity extends AppCompatActivity implements ReservationsFragment.ReservasListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new ReservationsFragment(), "")
                .commit();
    }

    @Override
    public List<Reservacion> getReservas() {
        return ReservasHelper.getReservas(this);
    }
}
