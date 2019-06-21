package com.example.myapplication.Propert.Ui_acivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.Propert.Propert_landing;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.interfaces.IBaseView;
import com.example.myapplication.interfaces.IPersenter;
import com.example.myapplication.interfaces.news.Landing;
import com.example.myapplication.model.http.bean.Bean_landing;
import com.example.myapplication.utils.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_denglus extends BaseActivity implements
Landing.View{

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.tv_password)
    TextView tvPassword;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.cb_Remember)
    CheckBox cbRemember;
    @BindView(R.id.landing)
    Button landing;
    @BindView(R.id.registered)
    Button registered;
    private String name;
    private String password;
    @Override
    protected int getLayout() {
        return R.layout.activity_zhuce;
    }

    @Override
    protected void initView() {

        registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_denglus.this,Activity_zhuce.class);
                startActivity(intent);
            }
        });

        landing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                landing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        name = etName.getText().toString();
                        password = etPassword.getText().toString();
                        if (name.equals("")||password.equals("")){
                           Toast.makeText(Activity_denglus.this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
                       }else{
                            ((Propert_landing)persenter).getda_Landing(name,password);
                        }
                    }
                });
            }
        });

        cbRemember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etName.getText().toString();
                password = etPassword.getText().toString();
                if (cbRemember.isChecked()){
                    SpUtil.setParam("name",name);
                    SpUtil.setParam("password",password);
                    SpUtil.setParam("da",true);
                    Toast.makeText(context, "已经记住账号密码", Toast.LENGTH_SHORT).show();
                }else {
                    SpUtil.setParam("da",false);
                    SpUtil.setParam("name","");
                    SpUtil.setParam("password","");
                    Toast.makeText(context, "取消记住账号密码", Toast.LENGTH_SHORT).show();
                }
            }
        });

        boolean da = (boolean) SpUtil.getParam("da", false);
        String param = (String) SpUtil.getParam("name", "dsa");
        String param1 = (String) SpUtil.getParam("password", "dsa");
        cbRemember.setChecked(da);
        etName.setText(param);
        etPassword.setText(param1);
    }
    @Override
    protected void initData() {

    }

    @Override
    protected Landing.Proeprt_Landing createPersenter() {
        return new Propert_landing();
    }

    @Override
    public void getIBseView_Landing(final Bean_landing bean_landing) {
         if (bean_landing !=null){
            if (bean_landing.getData()!=null){
                Bean_landing.DataBean data = bean_landing.getData();
                Toast.makeText(context, bean_landing.getData().getUsername(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("name",name);
                setResult(2,intent);
                finish();

            }else{
                Toast.makeText(Activity_denglus.this, "密码错误", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(Activity_denglus.this,"请求失败" , Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String err) {

    }
}