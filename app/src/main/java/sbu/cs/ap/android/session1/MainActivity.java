package sbu.cs.ap.android.session1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  int ourNumber = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    getSupportActionBar().hide();

    TextView resultTextView = findViewById(R.id.resultTextView);
    Button calculateButton = findViewById(R.id.calculateButton);
    EditText inputField = findViewById(R.id.editTextNumber);
    Button nextPageButton = findViewById(R.id.nextPageButton);

    calculateButton.setOnClickListener(new Button.OnClickListener() {
      @Override
      public void onClick(View view) {
        String inputText = inputField.getText().toString();
        if(inputText.isEmpty()) {
          Toast.makeText(MainActivity.this,"Type in a number first!",
                         Toast.LENGTH_SHORT).show();
        } else {
          int inputNumber = Integer.parseInt(inputText);
          ourNumber = inputNumber;
          String isOddOrEven = isEven(inputNumber);
          int factorial = factorial(inputNumber);
          String resultText = String.format("duality: %s\n\n%d!: %d\n",isOddOrEven,
                                            inputNumber,factorial);
          resultTextView.setText(resultText);
        }
      }
    });

    nextPageButton.setOnClickListener(new Button.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
      }
    });
  }

  private String isEven(int number) {
    boolean isEven;
    if (number % 2 == 0) {
      isEven = true;
    } else {
      isEven = false;
    }
    return isEven? "even" : "odd";
  }

  private int factorial(int number) {
    int factorial = 1;
    while (number > 0) {
      factorial *= number;
      number--;
    }
    return factorial;
  }
}