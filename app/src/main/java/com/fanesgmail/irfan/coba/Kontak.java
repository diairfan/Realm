package com.fanesgmail.irfan.coba;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Van Noval on 12/7/2017.
 */

public class Kontak extends RealmObject {

    @PrimaryKey
    private String email;
    private String nama;

    public Kontak() {
    }

    public Kontak(String email, String nama) {
        this.email = email;
        this.nama = nama;
    }

    public static void save(final Kontak kontak) {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(kontak);
            }
        });
    }

    public static void getAll(RealmChangeListener<RealmResults<Kontak>> listener) {
        Realm.getDefaultInstance().where(Kontak.class).findAllAsync().addChangeListener(listener);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
