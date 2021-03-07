package com.dzmitrykavalioum.rsstut.ui.itemarticle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dzmitrykavalioum.rsstut.R;
import com.dzmitrykavalioum.rsstut.model.Article1;

import static com.dzmitrykavalioum.rsstut.utils.Constants.KEY_MAIN;

public class ArticleActivity extends AppCompatActivity {

    private TextView tvTitle;
    private Button btnOpen;
    private Article1 article1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        init();

        Intent intent = getIntent();
        if (intent != null) {
            article1 = (Article1) intent.getSerializableExtra(Article1.class.getName());
        }
        if (article1 != null) {
            tvTitle.setText(article1.getTitle());
        }

    }

    private void init() {
        tvTitle = findViewById(R.id.tvTitle);
        btnOpen = findViewById(R.id.btnOpenInBrowser);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if  (article1!=null){
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(article1.getLink()));
                    startActivity(intent);
                }
            }
        });
    }
}