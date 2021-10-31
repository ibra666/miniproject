package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import com.example.custom_listview.databinding.ActivityMainBinding;
import com.example.custom_listview.databinding.ActivityUserBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int[] imageId = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
                R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j};
        String[] name = {"Pantollo Bale","Papiong","RW Patong","Tutuk Utan","Pokon","Ballo","Tamarella","Sirup Pisang","Sarabba", "Es Pisang Ijo"};
        String[] last1 = {"Khas Toraja","Khas Toraja","Khas Toraja","Khas Toraja","Khas Toraja",
                "Khas Toraja","Khas Toraja","Khas Toraja","Khas Toraja", "Khas Toraja"};
        String[] foodType = {"Makanan","Makanan","Makanan","Makanan","Makanan",
                "Minuman","Minuman","Minuman","Minuman","Minuman"};
        String[] deskripsi = {"Pantollo bale menggunakan daging ikan sebagai bahan pokok pembuatannya. Ikan yang biasa dipakai adalah ikan mas ataupun ikan tongkol, tergantung ikan jenis yang mudah didapat.",
                "Makanan khas Tanah Toraja ini dimasak dengan bambu dan biasa dihidangkan bersama dengan sayur bulunangko atau mayana atau bisa juga bersama dengan burak atau pohon pisang yang masih muda.",
                "RW (dibaca er-we) atau dikenal juga dengan nama Tarki merupakan sajian makanan khas Toraja yang dibuat dari daging anjing dengan campuran bumbu dan rempah khas pilihan.",
                "Tu’tuk utan artinya adalah segala jenis sayur yang ditumbuk. Biasanya sayur yang dipakai adalah yang berjenis daun singong. Makanan ini berbahan dasar daging babi yang dimasak hingga kering.",
                "Tampilan pokon tidak jauh beda dengan lontong, hanya saja bahan ukuran dan bungkusnya berbeda. Berbahan dasar beras ketan hitam yang dicampur dengan parutan kelapa untuk kemudian dibungkus.",
                "Ballo atau tuak khas Toraja merupakan minuman tradisional yang mengandung alkohol dan lumrah disajikan saat ada perhelatan besar di Tana Toraja. Ballo menjadi wajib disini.",
                "Tamarella juice adalah minuman khas toraja yang biasanya wajib disajikan atau dihidangkan saat hari besar atau adat di Tanah Toraja. Minuman ini sangat nikmat diminum bersama-sama.",
                "Sirup Pisang adalah minuman khas toraja yang biasanya wajib disajikan atau dihidangkan saat hari besar atau adat di Tanah Toraja. Minuman ini sangat nikmat diminum bersama-sama.",
                "Saraba adalah minuman khas toraja yang biasanya wajib disajikan atau dihidangkan saat hari besar atau adat di Tanah Toraja. Minuman ini sangat nikmat diminum saat cuaca dingin.",
                "Es Pisang Ijo adalah minuman khas toraja yang biasanya wajib disajikan atau dihidangkan saat hari besar atau adat di Tanah Toraja. Minuman ini sangat nikmat diminum saat cuaca panas."};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            User user = new User(name[i],last1[i],foodType[i],deskripsi[i],imageId[i]);
            userArrayList.add(user);

        }

        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this,UserActivity.class);
                i.putExtra("Nama Makanan",name[position]);
                i.putExtra("Jenis Makanan",foodType[position]);
                i.putExtra("Deskripsi",deskripsi[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);
            }
        });
    }
}