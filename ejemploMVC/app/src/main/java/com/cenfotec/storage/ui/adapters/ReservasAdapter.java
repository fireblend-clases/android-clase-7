package com.cenfotec.storage.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cenfotec.storage.R;
import com.cenfotec.storage.bd.entities.Reservacion;

import java.util.List;

public class ReservasAdapter extends BaseAdapter {

    private final Context context;
    List<Reservacion> reservas;

    public ReservasAdapter(Context ctx, List<Reservacion> reservas) {
        this.context = ctx;
        this.reservas = reservas;
    }

    @Override
    public int getCount() {
        return reservas.size();
    }

    @Override
    public Object getItem(int position) {
        return reservas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = LayoutInflater.from(context).inflate(R.layout.reserva_item, parent, false);

        TextView lugarSalida, lugarLlegada, tiempoSalida;

        lugarSalida = (TextView) row.findViewById(R.id.l_salida);
        lugarLlegada = (TextView) row.findViewById(R.id.l_llegada);
        tiempoSalida = (TextView) row.findViewById(R.id.s_salida);

        lugarSalida.setText("Lugar de Salida: " + reservas.get(position).lugarSalida);
        lugarLlegada.setText("Lugar de Llegada: " + reservas.get(position).lugarLlegada);
        tiempoSalida.setText("Fecha de Salida: " + reservas.get(position).tiempoSalida);

        return row;
    }

}
