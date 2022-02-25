package sbu.cs.ap.android.session1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    getSupportActionBar().hide();

    TextView resultTextView = findViewById(R.id.resultTextView);
    Button calculateButton = findViewById(R.id.calculateButton);
    EditText inputField = findViewById(R.id.editTextNumber);
    
    calculateButton.setOnClickListener(new Button.OnClickListener() {
      @Override
      public void onClick(View view) {
        String inputText = inputField.getText().toString();
        if(inputText.isEmpty()) {
          inputField.setHint("Type in a number first!");
          inputField.setHintTextColor(Color.RED);
        } else {
          int inputNumber = Integer.parseInt(inputText);
          String isOddOrEven = isEven(inputNumber);
          int factorial = factorial(inputNumber);
          String resultText = String.format("duality: %s\n\n%d!: %d\n",isOddOrEven,
                                            inputNumber,factorial);
          resultTextView.setText(resultText);
        }
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