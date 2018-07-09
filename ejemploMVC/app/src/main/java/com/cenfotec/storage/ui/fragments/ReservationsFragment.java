package com.cenfotec.storage.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cenfotec.storage.R;
import com.cenfotec.storage.bd.entities.Reservacion;
import com.cenfotec.storage.ui.adapters.ReservasAdapter;

import java.util.List;

public class ReservationsFragment extends Fragment {
    ReservasListener listener;

    public interface ReservasListener{
        List<Reservacion> getReservas();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (ReservasListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservas, container);
        ListView list = (ListView)view.findViewById(R.id.lista_reservas);
        list.setAdapter(new ReservasAdapter(this.getActivity(), listener.getReservas()));
        return view;
    }
}
