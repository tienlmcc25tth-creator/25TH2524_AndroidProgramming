package till.edu.appcon2so;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Khai báo các thành phần giao diện
    private EditText edtA, edtB;
    private Button btnTinhTong;
    private TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần từ giao diện XML qua ID
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnTinhTong = findViewById(R.id.btnTinhTong);
        tvKetQua = findViewById(R.id.tvKetQua);

        // Xử lý sự kiện khi người dùng nhấn nút TÍNH TỔNG
        btnTinhTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy chuỗi ký tự người dùng nhập vào
                String strA = edtA.getText().toString().trim();
                String strB = edtB.getText().toString().trim();

                // Kiểm tra xem người dùng đã nhập đủ dữ liệu chưa
                if (strA.isEmpty() || strB.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ số a và b!", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    // Chuyển chuỗi sang số
                    double a = Double.parseDouble(strA);
                    double b = Double.parseDouble(strB);

                    // Tính tổng
                    double sum = a + b;

                    // Hiển thị kết quả ra TextView
                    // Nếu là số nguyên thì bỏ phần .0 phía sau
                    if (sum == (long) sum) {
                        tvKetQua.setText(String.format("%d", (long) sum));
                    } else {
                        tvKetQua.setText(String.valueOf(sum));
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Dữ liệu nhập không hợp lệ!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}