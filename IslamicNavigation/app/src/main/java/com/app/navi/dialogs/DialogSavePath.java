package com.app.navi.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.app.navi.databinding.DialogSavePathBinding;

abstract public class DialogSavePath extends Dialog {

    Context context;


    protected abstract void onBind(DialogSavePathBinding binding);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DialogSavePathBinding binding = DialogSavePathBinding.inflate(LayoutInflater.from(context));
        setContentView(binding.getRoot());
        onBind(binding);
    }

    public DialogSavePath(@NonNull Context context) {
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
