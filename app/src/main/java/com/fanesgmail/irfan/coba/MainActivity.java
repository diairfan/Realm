package com.fanesgmail.irfan.coba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RealmChangeListener<RealmResults<Kontak>> {

    EditText etNama;
    EditText etEmail;
    Button btnSimpan;
    ListView lvData;

    KontakAdapter kontakAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_nama);
        etEmail = findViewById(R.id.et_email);
        btnSimpan = findViewById(R.id.btn_simpan);
        lvData = findViewById(R.id.lv_data);

        kontakAdapter = new KontakAdapter();

        btnSimpan.setOnClickListener(this);
        lvData.setAdapter(kontakAdapter);

        Kontak.getAll(this);
    }

    @Override
    public void onClick(View view) {
        Kontak.save(new Kontak(
                etEmail.getText().toString(),
                etNama.getText().toString()
        ));
        etNama.setText("");
        etEmail.setText("");
    }

    @Override
    public void onChange(RealmResults<Kontak> kontakList) {
        if (kontakList != null) {
            if (kontakAdapter.getKontakList() == null) {
                kontakAdapter.setKontakList(new ArrayList<Kontak>());
            } else {
                kontakAdapter.getKontakList().clear();
            }
            kontakAdapter.getKontakList().addAll(kontakList);
            kontakAdapter.notifyDataSetChanged();
        }
    }
}
