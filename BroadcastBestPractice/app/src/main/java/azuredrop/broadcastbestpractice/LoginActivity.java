package azuredrop.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private EditText accountEdit;
    private EditText passwordEdit;
    private CheckBox rememberPass;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // SharedPreferences
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        // acount
        accountEdit = (EditText) findViewById(R.id.account);
        // password
        passwordEdit = (EditText) findViewById(R.id.password);
        // remember pass
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        // login
        loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                // if account is 'admin' and password is '123456', then pass
                if (account.equals("admin") && password.equals("123456")) {
                    editor = preferences.edit();
                    if (rememberPass.isChecked()) {
                        editor.putString("account", account);
                        editor.putString("password", password);
                        editor.putBoolean("remember_password", true);
                    } else {
                        editor.clear();
                    }
                    editor.apply();

                    // 启动活动
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "account or password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // init
        boolean isRemember = preferences.getBoolean("remember_password", false);
        if (isRemember) {
            String account = preferences.getString("account", "");
            String password = preferences.getString("password", "");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
    }
}
