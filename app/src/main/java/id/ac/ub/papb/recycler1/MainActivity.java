package id.ac.ub.papb.recycler1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv1;
    EditText etNim, etNama;
    Button btSimpan;
    MahasiswaAdapter adapter;
    ArrayList<Mahasiswa> data;

    public static String TAG = "RV1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv1 = findViewById(R.id.rv1);
        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNama);
        btSimpan = findViewById(R.id.bt1);

        data = new ArrayList<>(); // Pastikan data adalah list kosong yang bisa diisi nanti
        adapter = new MahasiswaAdapter(this, data);
        rv1.setLayoutManager(new LinearLayoutManager(this));
        rv1.setAdapter(adapter);

        // Tambahkan event klik untuk menambahkan item
        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nimBaru = etNim.getText().toString().trim();
                String namaBaru = etNama.getText().toString().trim();

                if (!nimBaru.isEmpty() && !namaBaru.isEmpty()) {
                    adapter.addItem(new Mahasiswa(nimBaru, namaBaru));

                    // Kosongkan input setelah ditambahkan
                    etNim.setText("");
                    etNama.setText("");
                }
            }
        });
    }

    public ArrayList<Mahasiswa> getData() {
        ArrayList<Mahasiswa> data = new ArrayList<>();
        List<String> nim = Arrays.asList(getResources().getStringArray(R.array.nim));
        List<String> nama = Arrays.asList(getResources().getStringArray(R.array.nama));

        for (int i = 0; i < nim.size(); i++) {
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNim(nim.get(i));
            mhs.setNama(nama.get(i));
            data.add(mhs);
        }
        return data;
    }
}
