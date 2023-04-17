package Demo.Android.Controller;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Demo.Android.ModelDB.DBHelper;
import Demo.Android.ModelDB.DbButton;
import Demo.Android.ModelDB.DbButtonPump;
import Demo.Android.ModelDB.DbHumi;
import Demo.Android.ModelDB.DbTemp;
import Demo.Android.R;

public class MainActivity extends AppCompatActivity {
    MQTTHelper mqttHelper;
    TextView txtTemp, txtHumi;
    private Button Login_button;
    DbHumi HumiHelper;
    DbTemp TempHelper;
    DBHelper LightHelper;
    Demo.Android.ModelDB.DbButton DbButton;
    Demo.Android.ModelDB.DbButtonPump DbButtonPump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        txtTemp = findViewById(R.id.txtTemperature);
//        txtHumi = findViewById(R.id.txtHumidity)
        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);
        Login_button = (Button) findViewById(R.id.Button_login);
        LightHelper = new DBHelper(this);
        HumiHelper = new DbHumi(this);
        TempHelper = new DbTemp(this);
        DbButton = new DbButton(this);
        DbButtonPump = new DbButtonPump(this);
        //Dòng này nên comment khi demo, dòng xóa hết dữ liệu của bảng
//        HumiHelper.deleteAllData();
//       TempHelper.deleteAllData();
//        LightHelper.deleteAllData();
//        DbButton.deleteAllData();
//        DbButtonPump.deleteAllData();
        //Login function
        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
//                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
//                    Loginsuccess();
//                } else {
//                    Toast.makeText(MainActivity.this, "Login fail!!!", Toast.LENGTH_SHORT).show();
//                }
                Loginsuccess();
            }
        });
        //startMQTT();
    }

    // Hàm chuyển trang sau khi đăng nhập thành công
    public void Loginsuccess() {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}