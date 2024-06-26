package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        players = getResources().getStringArray(R.array.players_array);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, players);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedPlayer = players[position];
                Intent intent = new Intent(MainActivity.this, PlayerInfoActivity.class);
                intent.putExtra("playerName", selectedPlayer);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Selected Player: " + selectedPlayer, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
