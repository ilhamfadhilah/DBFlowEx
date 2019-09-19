package com.example.dbflowex;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Ini temporary storage untuk listView.
            List<String> listNama = new ArrayList<>(); // Harus diinisialisasi

    // Ini listview diset sebagai class variable agar accessible anywhere
    ListView listViewNama = null;  // Inisialisasi di onCreate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView) findViewById(R.id.textHasil);
        final EditText ed = (EditText) findViewById(R.id.textEditor);
        Button btn = (Button) findViewById(R.id.btnGanti);
        listViewNama = (ListView) findViewById(R.id.listViewNama);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(ed.getText());
            }
        });


        final MaterialDialog md = new MaterialDialog.Builder(MainActivity.this)
                .title("Info")
                .content("Anda menulis " + ed.getText() + ". Bener? ")
                .negativeText("Nggak Ah")
                .positiveText("Iyah")
                .show();
        /*
        new MaterialDialog.Builder(MainActivity.this)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(getApplicationContext(), "Oh nggak yah?", Toast.LENGTH_LONG).show();
                        md.dismiss();
                    }
                });

        new MaterialDialog.Builder(MainActivity.this)
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(getApplicationContext(), "Tuuuh bener kan?", Toast.LENGTH_LONG).show();
                        md.dismiss();
                    }
                });

*/
        md.getActionButton(DialogAction.NEGATIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Oh nggak yah?", Toast.LENGTH_LONG).show();
                md.dismiss();
            }
        });

        md.getActionButton(DialogAction.POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Tuuuh bener kan?", Toast.LENGTH_LONG).show();
                md.dismiss();
                listNama.add(tv.getText().toString());
                populateListViewNama();
            }
        });



    }
    // Buat adapter yang mendefinisikan bahwa adapter ini disuplay datanya dari listNama
    private class StrListAdapter extends ArrayAdapter<String> {
        public StrListAdapter() {
            super(MainActivity.this, R.layout.layout_itemlistview, listNama);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            // Pastikan ada view kalau null
            View itemView = convertView;

            if (itemView == null) {

                // Cari itemview yang mendefinisikan format penampilan data di tiap baris listview
                itemView = MainActivity.this.getLayoutInflater().inflate(R.layout.layout_itemlistview, parent, false);

                // Untuk setiap baris, ambil dari listview nama
                String namaStr = listNama.get(position);

                // Cari textview di format tadi, terus kita isi dengan data.
                TextView textViewNama = (TextView) itemView.findViewById(R.id.textViewNama);

                // Kemudian isikan textview tsb dengan string nama
                textViewNama.setText(namaStr);
            }

            return itemView;
        }
    }

    private void populateListViewNama() {

        // Definisikan adapter untuk mengisi listview tersebut
        ArrayAdapter<String> lvAdapter = new StrListAdapter();

        // Kasihtahu listview bahwa adapternya adalah lvAdapter
        listViewNama.setAdapter(lvAdapter);
        listViewNama.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
    }


}
