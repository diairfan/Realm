package com.fanesgmail.irfan.coba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Van Noval on 12/7/2017.
 */

public class KontakAdapter extends BaseAdapter {

    private List<Kontak> kontakList;

    public List<Kontak> getKontakList() {
        return kontakList;
    }

    public void setKontakList(List<Kontak> kontakList) {
        this.kontakList = kontakList;
    }

    @Override
    public int getCount() {
        return (kontakList!=null)?kontakList.size():0;
    }

    @Override
    public Kontak getItem(int position) {
        return kontakList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kontak, parent, false);

        Kontak kontak = getItem(position);

        EditText etNama = view.findViewById(R.id.et_nama);
        EditText etEmail = view.findViewById(R.id.et_email);

        etNama.setText(kontak.getNama());
        etEmail.setText(kontak.getEmail());

        return view;
    }
}
