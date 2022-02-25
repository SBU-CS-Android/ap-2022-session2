package sbu.cs.ap.android.session1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    Integer ourNumber = getIntent().getIntExtra("inputNumber",1);
    Toast.makeText(SecondActivity.this,ourNumber.toString(),Toast.LENGTH_SHORT).show();
  }
}