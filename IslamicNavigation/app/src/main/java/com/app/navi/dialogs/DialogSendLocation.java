package com.app.navi.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.app.navi.databinding.DialogSavePathBinding;
import com.app.navi.databinding.DialogSendLocationBinding;

abstract public class DialogSendLocation extends Dialog {

    Context context;


    protected abstract void onBind(DialogSendLocationBinding binding);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DialogSendLocationBinding binding = DialogSendLocationBinding.inflate(LayoutInflater.from(context));
        setContentView(binding.getRoot());
        onBind(binding);
    }

    public DialogSendLocation(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().setLayout(
                WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT
        );
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }
}
