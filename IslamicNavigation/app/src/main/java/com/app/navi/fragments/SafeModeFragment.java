package com.app.navi.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.app.navi.ContactListActivity;

import com.app.navi.databinding.FragmentSafeModeBinding;
import com.app.navi.models.Contact;
import com.app.navi.viewmodels.PathViewModel;


public class SafeModeFragment extends Fragment {

    private FragmentSafeModeBinding binding;
    private PathViewModel viewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponent();
    }

    private void initComponent() {
        viewModel = new ViewModelProvider(this).get(PathViewModel.class);
        initClicks();
    }

    private void initClicks() {
        binding.btnSave.setOnClickListener(v -> {


            Editable name = binding.etName.getText();
            Editable number = binding.etContactNumber.getText();
            Editable relation = binding.etRelation.getText();


            if (name != null && name.length() <= 0 && number != null && number.length() <= 0 && relation != null && relation.length() <= 0 ) {
                Toast.makeText(requireContext(), "Please Fill Information Correctly", Toast.LENGTH_SHORT).show();
            } else {
                Contact contact = new Contact(name.toString(), number.toString(), relation.toString());
                viewModel.insertContact(contact);
                Toast.makeText(requireContext(), "Contact Save Successfully", Toast.LENGTH_SHORT).show();
            }


        });

        binding.btnShow.setOnClickListener(v -> {
            startActivity(new Intent(requireContext(), ContactListActivity.class));
        });
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentSafeModeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


}


