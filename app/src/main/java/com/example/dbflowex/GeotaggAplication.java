package com.example.dbflowex;

import android.app.Application;
import android.widget.Toast;

import com.example.dbflowex.model.Sekolah;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.UUID;

public class GeotaggAplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);

        long count = SQLite.selectCountOf().from(Sekolah.class).count();
        Toast.makeText(getApplicationContext(),"Ditemukan data " + count, Toast.LENGTH_LONG).show();

        if (count < 1) {
            Sekolah sekolah = new Sekolah();
            sekolah.sekolah_id = UUID.randomUUID().toString();
            sekolah.nama_sekolah = "SD Panjang Akal 1";
            sekolah.alamat_sekolah = "Jl. Sudirman 212 - Kota Cimahi";
            sekolah.jumlah_ruang_rusak = 12;
            sekolah.jumlah_ruang = 22;
            sekolah.save();

            sekolah = new Sekolah();
            sekolah.sekolah_id = UUID.randomUUID().toString();
            sekolah.nama_sekolah = "SD Gembira Ria 1945";
            sekolah.alamat_sekolah = "Jl. Gembira 313 - Kota Cimahi";
            sekolah.jumlah_ruang_rusak = 13;
            sekolah.jumlah_ruang = 19;
            sekolah.save();

            sekolah = new Sekolah();
            sekolah.sekolah_id = UUID.randomUUID().toString();
            sekolah.nama_sekolah = "SD Cerdas Sejahtera";
            sekolah.alamat_sekolah = "Jl. Peta 354 - Kota Cimahi";
            sekolah.jumlah_ruang_rusak = 21;
            sekolah.jumlah_ruang = 25;
            sekolah.save();

            sekolah = new Sekolah();
            sekolah.sekolah_id = UUID.randomUUID().toString();
            sekolah.nama_sekolah = "SD Akhlak Jaya";
            sekolah.alamat_sekolah = "Jl. Pejuang 45 - Kota Cimahi";
            sekolah.jumlah_ruang_rusak = 9;
            sekolah.jumlah_ruang = 13;
            sekolah.save();
        }


    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        FlowManager.destroy();
    }
}
