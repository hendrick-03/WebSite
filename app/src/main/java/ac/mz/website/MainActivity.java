package ac.mz.website;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ac.mz.website.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private Button email_btn, website_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email_btn = findViewById(R.id.email_btn);
        website_btn = findViewById(R.id.website_btn);


        email_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EmailActivity.class);
                startActivity(i);
            }
        });

        website_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, WebsiteActivity.class);
                startActivity(i);
            }
        });

    }
}