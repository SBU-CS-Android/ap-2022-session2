package sbu.cs.ap.android.session1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_third);

    Button finalButton = findViewById(R.id.finalButton);
    EditText emailInput = findViewById(R.id.emailInput);
    EditText phoneInput = findViewById(R.id.phoneInput);


    finalButton.setOnClickListener(new Button.OnClickListener() {

      @Override
      public void onClick(View view) {
        String email = emailInput.getText().toString();
        String phone = phoneInput.getText().toString();
        boolean canSave = !email.isEmpty() && !phone.isEmpty();

        if (canSave) {
          String age = getIntent().getStringExtra("age");
          String name = getIntent().getStringExtra("name");
          String description = getIntent().getStringExtra("description");

          Intent finalIntent = new Intent(ThirdActivity.this,FinalActivity.class);

          finalIntent.putExtra("age",age);
          finalIntent.putExtra("name",name);
          finalIntent.putExtra("description",description);
          finalIntent.putExtra("phone",phone);
          finalIntent.putExtra("email",email);

          startActivity(finalIntent);
        } else {
          Toast.makeText(ThirdActivity.this,
                         "Fill in all the forms before saving!",
                         Toast.LENGTH_LONG).show();
        }
      }
    });
  }
}