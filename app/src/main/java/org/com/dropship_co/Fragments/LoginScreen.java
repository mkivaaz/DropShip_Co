package org.com.dropship_co.Fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.processbutton.FlatButton;

import org.com.dropship_co.R;

public class LoginScreen extends Fragment implements View.OnClickListener {

    private EditText emailET, passwordET;
    private FlatButton signInBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_screen,container,false);

        initiateItems(view);

        signInBtn.setOnClickListener(this);
        view.findViewById(R.id.signupTV).setOnClickListener(this);
        return view;
    }
    private void initiateItems(View view) {
        emailET = view.findViewById(R.id.emailEt);
        passwordET = view.findViewById(R.id.passEt);
        signInBtn = view.findViewById(R.id.signinBtn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signinBtn:
                if (!(emailET.getText().equals("")) && !(passwordET.getText().equals(""))){
                    verifyUser();
                }
                break;
        }
    }

    private void verifyUser() {
        String email = emailET.getText().toString().trim();
        String pass = passwordET.getText().toString().trim();

        if (email.equals("user@gmail.com") && pass.equals("abc123")){
            Toast.makeText(getContext(),"Success!!",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(),"Failed!!",Toast.LENGTH_SHORT).show();
        }


    }
}
