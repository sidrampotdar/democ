package com.example.democ;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.codehaus.janino.CompilerFactoryFactory;
import org.codehaus.janino.ScriptEvaluator;

public class MainActivity extends AppCompatActivity {

    private EditText codeEditText;
    private Button compileButton;
    private TextView outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        codeEditText = findViewById(R.id.codeEditText);
        compileButton = findViewById(R.id.compileButton);
        outputTextView = findViewById(R.id.outputTextView);

        // Set click listener for compile button
        compileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compileCode();
            }
        });
    }

    private void compileCode() {
        // Get the Java code entered by the user
        String javaCode = codeEditText.getText().toString();

        // Create a new ScriptEvaluator
        ScriptEvaluator scriptEvaluator = new ScriptEvaluator();

        try {
            // Set the script source code
            scriptEvaluator.cook(javaCode);

            // Execute the script
            Object result = scriptEvaluator.evaluate(null);

            // Display the result
            outputTextView.setText("Output: " + result.toString());
        } catch (Exception e) {
            // Handle any errors that occur during compilation or execution
            outputTextView.setText("Error: " + e.getMessage());
        }
    }
}
