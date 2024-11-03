package com.example.imtent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText searchEditText; // EditText untuk mencari lagu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referensi tombol dan EditText yang ada di XML
        Button streamingMusicButton = findViewById(R.id.button2);
        searchEditText = findViewById(R.id.searchEditText); // Inisialisasi EditText

        streamingMusicButton.setOnClickListener(view -> {
            // Ambil teks dari EditText
            String songName = searchEditText.getText().toString().trim();

            if (!songName.isEmpty()) {
                // URL pencarian Spotify
                String spotifyUrl = "https://open.spotify.com/search/" + Uri.encode(songName);

                // Membuat intent untuk membuka URL Spotify
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(spotifyUrl));
                startActivity(intent);
            } else {
                Toast.makeText(this, "Masukkan nama lagu untuk mencari", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
