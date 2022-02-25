package sbu.cs.ap.android.session1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_final);
    getSupportActionBar().hide();

    Button emailButton = findViewById(R.id.emailButton);
    Button phoneButton = findViewById(R.id.phoneButton);
    TextView nameTextView = findViewById(R.id.textView);
    TextView descriptionTextView = findViewById(R.id.textView2);


    String name = getIntent().getStringExtra("name");
    String description = getIntent().getStringExtra("description");
    String phoneNumber = getIntent().getStringExtra("phone");
    String emailAddress = getIntent().getStringExtra("email");

    nameTextView.setText(name);
    descriptionTextView.setText(description);

    emailButton.setOnClickListener(new Button.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + emailAddress));
        startActivity(emailIntent);
      }
    });

    phoneButton.setOnClickListener(new Button.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(phoneIntent);
      }
    });
  }
}