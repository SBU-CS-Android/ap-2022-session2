package sbu.cs.ap.android.session1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

  String age;
  String name;
  String description;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    getSupportActionBar().hide();

    Button saveButton = findViewById(R.id.saveIDbutton);
    EditText nameInput = findViewById(R.id.name);
    EditText descriptionInput = findViewById(R.id.description);
    EditText ageInput =  findViewById(R.id.age);

    saveButton.setOnClickListener(new Button.OnClickListener() {

      @Override
      public void onClick(View view) {
        age = ageInput.getText().toString();
        name = nameInput.getText().toString();
        description = descriptionInput.getText().toString();

        boolean canSave = !age.isEmpty() && !name.isEmpty() && !description.isEmpty();

        if(canSave) {
          Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
          intent.putExtra("age",age);
          intent.putExtra("description",description);
          intent.putExtra("name",name);
          startActivity(intent);
        } else {
          Toast.makeText(SecondActivity.this,
                         "Fill in all the forms before saving!",
                         Toast.LENGTH_LONG).show();
        }
      }
    });
  }
}