package till.edu.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtSo1, edtSo2;
    private Button btnTinhTong;
    private TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        btnTinhTong = findViewById(R.id.btnTinhTong);
        tvKetQua = findViewById(R.id.tvKetQua);

        btnTinhTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhTong();
            }
        });
    }

    private void tinhTong() {
        String str1 = edtSo1.getText().toString().trim();
        String str2 = edtSo2.getText().toString().trim();

        if (str1.isEmpty() || str2.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ 2 số!", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(str1);
        double num2 = Double.parseDouble(str2);
        double tong = num1 + num2;

        tvKetQua.setText("Kết quả: " + tong);
    }
}