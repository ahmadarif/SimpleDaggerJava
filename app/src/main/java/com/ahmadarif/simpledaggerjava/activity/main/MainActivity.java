package com.ahmadarif.simpledaggerjava.activity.main;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.ahmadarif.simpledaggerjava.App;
import com.ahmadarif.simpledaggerjava.R;
import com.ahmadarif.simpledaggerjava.dagger.component.DaggerMainActivityComponent;
import com.ahmadarif.simpledaggerjava.helper.View;
import com.ahmadarif.simpledaggerjava.model.Response;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @Inject
    MainActivityPresenter presenter;

    @BindView(R.id.textView)
    TextView textView;

    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        DaggerMainActivityComponent.builder()
                .appComponent(App.component)
                .build().inject(this);

        onAttach();
    }

    @OnClick(R.id.btnLogin)
    public void btnLoginClick() {
        presenter.login();
    }

    @OnClick(R.id.btnLogout)
    public void btnLogoutClick() {
        presenter.logout();
    }

    @OnClick(R.id.btnHello)
    public void btnHelloClick() {
        progress.show();
        presenter.loadHello();
    }

    @OnClick(R.id.btnMessage)
    public void btnMessageClick() {
        progress.show();
        presenter.loadMessage();
    }

    @Override
    protected void onDestroy() {
        onDetach();
        super.onDestroy();
    }

    @Override
    public void onAttach() {
        presenter.onAttach(this);

        progress = View.progressDialog(this, "Loading..");
    }

    @Override
    public void onDetach() {
        presenter.onDetach();
    }

    @Override
    public void onLoadHelloSuccess(Response data) {
        progress.cancel();
        textView.setText(data.getMessage());
    }

    @Override
    public void onLoadHelloError(String data) {
        progress.cancel();
        textView.setText(data);
    }

    @Override
    public void onLoadMessageSuccess(Response data) {
        progress.cancel();
        textView.setText(data.getMessage());
    }

    @Override
    public void onLoadMessageError(String data) {
        progress.cancel();
        textView.setText(data);
    }

}