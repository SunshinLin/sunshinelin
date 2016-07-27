package zx.myapplication.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zx.myapplication.MainActivity;
import zx.myapplication.R;
import zx.myapplication.base.BaseActivity;

/**
 * Created by lin on 2016/7/26.
 */
public class SplashActivity extends BaseActivity {
    @Bind(R.id.btnLogin)
    Button btnLogin;
    @Bind(R.id.btnEnter)
    Button btnEnter;

    @Override
    public void getData() {
        setContentView(R.layout.activity_splash);

    }

    @Override
    public void setView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnLogin, R.id.btnEnter})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:

                break;
            case R.id.btnEnter:
                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
