package com.ariefhirmanto.moovia_2;


import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {
    private Button btnChangeEnglish;
    private Button btnChangeIndonesia;
    private TextView tvTitle;
    private TextView tvChangeLanguage;
    private Locale myLocale;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnChangeEnglish = view.findViewById(R.id.btn_language_english);
        btnChangeIndonesia = view.findViewById(R.id.btn_language_indo);
        tvTitle = view.findViewById(R.id.tv_settings_title);
        tvChangeLanguage = view.findViewById(R.id.tv_settings_change);

        btnChangeIndonesia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String languageToLoad = "in";
                onChangeLanguage(languageToLoad);
                Toast.makeText(getActivity(), "Alih bahasa berhasil!",Toast.LENGTH_SHORT).show();
                tvTitle.setText(getResources().getString(R.string.setting));
                tvChangeLanguage.setText(getResources().getString(R.string.change_language));
            }
        });

        btnChangeEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String languageToLoad = "en";
                onChangeLanguage(languageToLoad);
                Toast.makeText(getActivity(), "Successfully change language!",Toast.LENGTH_SHORT).show();
                tvTitle.setText(getResources().getString(R.string.setting));
                tvChangeLanguage.setText(getResources().getString(R.string.change_language));
            }
        });
    }

    public void onChangeLanguage(String languageToLoad) {
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(
                config,
                getResources().getDisplayMetrics()
        );
    }
}
