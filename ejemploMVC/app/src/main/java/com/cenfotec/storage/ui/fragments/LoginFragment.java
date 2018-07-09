package com.cenfotec.storage.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.cenfotec.storage.R;

public class LoginFragment extends Fragment implements View.OnClickListener {

    EditText usuario;
    EditText password;
    CheckBox remember;
    Button loginButton;

    LoginListener listener;

    public interface LoginListener{
        String getUsuario();
        String getPassword();
        boolean shouldRememberPass();
        boolean loginSuccessful(String user, String pass, boolean remember);
        void goToReservations();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (LoginListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main, container);

        usuario = (EditText)view.findViewById(R.id.user_input);
        password = (EditText)view.findViewById(R.id.password_input);
        remember = (CheckBox) view.findViewById(R.id.remember);
        loginButton = (Button)view.findViewById(R.id.login);

        setupUI();
        return view;
    }

    private void setupUI() {
        String usuarioStr = listener.getUsuario();
        usuario.setText(usuarioStr);

        if(listener.shouldRememberPass()) {
            remember.setChecked(true);
            String passwordStr = listener.getPassword();
            password.setText(passwordStr);
        }

        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(listener.loginSuccessful(
                usuario.getText().toString().trim(),
                password.getText().toString().trim(),
                remember.isChecked())) {

            listener.goToReservations();
        }
    }
}
