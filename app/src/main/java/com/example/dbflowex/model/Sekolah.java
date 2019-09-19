package com.example.dbflowex.model;

import com.example.dbflowex.GeotaggDatabases;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = GeotaggDatabases.class)
public class Sekolah extends BaseModel {

    @PrimaryKey
    public String sekolah_id;

    @Column
    public String nama_sekolah;

    @Column
    public String alamat_sekolah;

    @Column
    public int jumlah_ruang_rusak;

    @Column
    public int jumlah_ruang;

}
