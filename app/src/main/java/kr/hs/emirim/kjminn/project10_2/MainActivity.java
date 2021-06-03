package kr.hs.emirim.kjminn.project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] imgId = {R.id.img01, R.id.img02, R.id.img03, R.id.img04, R.id.img05, R.id.img06, R.id.img07, R.id.img08, R.id.img09};
    ImageView[] imgV = new ImageView[imgId.length];
    int[] voteCount = new int[imgId.length];
    String[] imgName = {"IKON", "MAMAMOO", "BTS", "BRAVE GIRLS", "ITZY", "OH MY GIRL", "BLACK PINK", "WINNER", "AESPA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        for (int i = 0; i < imgV.length; i++){
            final int index = i;
            voteCount[index] = 0;
            imgV[index] = findViewById(imgId[index]);
            imgV[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgName[index] + "총 " + voteCount[index] + "표", Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnDone = findViewById(R.id.btn_done);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("imgName", imgName);
                intent.putExtra("voteCount", voteCount);
                startActivity(intent);
            }
        });
    }

}