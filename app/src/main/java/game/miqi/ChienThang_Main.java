package game.miqi;

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
import game.miqi.Menu_Unit.Activity_Unit;

public class ChienThang_Main extends AppCompatActivity {
    public SoundPool soundPool;
    TextView result,nsthem;
    int sound_end;
    Button tieptuc;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chien_thang__main);
        result = (TextView)findViewById(R.id.result_main);
        nsthem=(TextView)findViewById(R.id.nsthem_main);
        mediaPlayer = new MediaPlayer();
        mediaPlayer =MediaPlayer.create(ChienThang_Main.this,R.raw.music_end);
        mediaPlayer.start();

        tieptuc = (Button)findViewById(R.id.tieptuc_main);
        tieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                Intent intent = new Intent(ChienThang_Main.this, Activity_Unit.class);
                startActivity(intent);
                finish();
            }
        });
        new ParticleSystem(this, 80, R.drawable.confeti, 10000)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 0)
                .setRotationSpeed(144)
                .setAcceleration(0.00005f, 90)
                .emit(findViewById(R.id.textright_main), 8);

        new ParticleSystem(this, 80, R.drawable.confeti1, 10000)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 0)
                .setRotationSpeed(144)
                .setAcceleration(0.00005f, 90)
                .emit(findViewById(R.id.textright_main), 8);
    }
    @Override
    public void onBackPressed() {
        Toasty.success(ChienThang_Main.this,"Press Tiếp Tục", Toast.LENGTH_SHORT).show();

    }
}
