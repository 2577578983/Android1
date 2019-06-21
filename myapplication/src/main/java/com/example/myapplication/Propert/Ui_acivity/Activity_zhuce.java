package com.example.myapplication.Propert.Ui_acivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Propert.Propert_registered;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.interfaces.IBaseView;
import com.example.myapplication.interfaces.IPersenter;
import com.example.myapplication.interfaces.news.Landing;
import com.example.myapplication.interfaces.news.Registered;
import com.example.myapplication.model.http.bean.Bean_registered;
import com.example.myapplication.utils.MD5;
import com.example.myapplication.utils.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_zhuce extends BaseActivity
        implements Registered.View {
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.tv_password)
    TextView tvPassword;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_repassword)
    TextView tvRepassword;
    @BindView(R.id.et_repassword)
    EditText etRepassword;
    @BindView(R.id.bt_zhuce)
    Button btZhuce;
    private String name;
    private String password;
    private String repassword;

    @Override
    protected int getLayout() {
        return R.layout.activity_denglu;
    }

    @Override
    protected void initView() {
        btZhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etName.getText().toString();
                password = etPassword.getText().toString();
                repassword = etRepassword.getText().toString();
                //String s = MD5.md5(password);
                if (name.equals("") | password.equals("") | repassword.equals("")) {
                    Toast.makeText(context, "输入不能为空", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(repassword)) {
                    Toast.makeText(context, "请确认密码准确", Toast.LENGTH_SHORT).show();
                } else {

                    ((Propert_registered) persenter).getda_registered(name, password, repassword);
                }
            }
        });
    }

    @Override
    protected void initData() {

    }


    @Override
    protected Registered.Proeprt_registered createPersenter() {
        return new Propert_registered();
    }

    @Override
    public void getIBseView_registered(Bean_registered bean_registered) {
        if (bean_registered != null) {
            if (bean_registered.getErrorCode() == 0) {
                Toast.makeText(context, bean_registered.getErrorMsg(), Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(context, "网络请求失败"+bean_registered.getErrorMsg(), Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(context, "数据为空", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showLoading() {

    }

    private static final String TAG = "Activity_zhuce";
    @Override
    public void showError(String err) {
        Log.i(TAG, "showError: "+err.toString());
    }
}

