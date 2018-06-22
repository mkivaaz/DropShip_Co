package org.com.dropship_co.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.com.dropship_co.R;

public class SignUpScreen extends Fragment implements View.OnClickListener{
    private EditText emailEt, fullnameEt, passEt,confPassEt, mobileEt;
    private Button signUpBtn;
    private TextView signInBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup_screen,container,false);
        iniateItems(view);
        signInBtn.setOnClickListener(this);
        return view;
    }

    private void iniateItems(View view) {
        emailEt = view.findViewById(R.id.emailEt);
        fullnameEt = view.findViewById(R.id.fullnameEt);
        passEt = view.findViewById(R.id.passEt);
        confPassEt = view.findViewById(R.id.confPassEt);
        mobileEt = view.findViewById(R.id.mobileEt);

        signUpBtn = view.findViewById(R.id.signupBtn);
        signInBtn = view.findViewById(R.id.signinTV);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signinTV:
                break;
        }
    }
}
