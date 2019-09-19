package com.example.dbflowex.model;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class item_listView {

    // Ini temporary storage untuk listView.
    List<String> listNama = new ArrayList<>(); // Harus diinisialisasi

    // Ini listview diset sebagai class variable agar accessible anywhere
    ListView listViewNama = null;  // Inisialisasi di onCreate

}
