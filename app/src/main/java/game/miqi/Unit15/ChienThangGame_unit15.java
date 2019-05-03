package game.miqi.Unit15;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.plattysoft.leonids.ParticleSystem;

import es.dmoral.toasty.Toasty;
import game.miqi.R;

public class ChienThangGame_unit15 extends AppCompatActivity {
    public SoundPool soundPool;
    TextView result,nsthem;
    int score;
    Button button ;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chien_thang_game_unit15);
        result = (TextView)findViewById(R.id.result_game2_unit15);
        nsthem=(TextView)findViewById(R.id.nsthem_game2_unit15);
        button = (Button)findViewById(R.id.tieptuc_game2_unit15);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                Intent intent = new Intent(ChienThangGame_unit15.this, Unit15.class);
                startActivity(intent);
                finish();

            }
        });

        mediaPlayer = new MediaPlayer();
        mediaPlayer =MediaPlayer.create(ChienThangGame_unit15.this,R.raw.music_end);
        mediaPlayer.start();

        Bundle bundle = getIntent().getExtras();
        score = bundle.getInt("Score_game2_unit15");
        result.setText("Score: "+ score);
        if(score<5)
        { nsthem.setText("Quá Gà");}
        if(score>=5)
        { nsthem.setText("Tạm Được");}

        if(score>10)
        { nsthem.setText("Tốt Lắm !");}


        new ParticleSystem(this, 80, R.drawable.confeti, 10000)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 0)
                .setRotationSpeed(144)
                .setAcceleration(0.00005f, 90)
                .emit(findViewById(R.id.textright_game2_unit15), 8);

        new ParticleSystem(this, 80, R.drawable.confeti1, 10000)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 0)
                .setRotationSpeed(144)
                .setAcceleration(0.00005f, 90)
                .emit(findViewById(R.id.textright_game2_unit15), 8);
    }
    @Override
    public void onBackPressed() {
        Toasty.success(ChienThangGame_unit15.this,"Press Tiếp Tục", Toast.LENGTH_SHORT).show();

    }
}

