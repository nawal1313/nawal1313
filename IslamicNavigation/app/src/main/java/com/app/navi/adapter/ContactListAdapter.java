package com.app.navi.adapter;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.app.navi.App;
import com.app.navi.R;
import com.app.navi.databinding.DialogSendLocationBinding;
import com.app.navi.dialogs.DialogSendLocation;
import com.app.navi.models.Contact;
import com.app.navi.viewmodels.PathViewModel;


public abstract class ContactListAdapter extends ListAdapter<Contact, ContactListAdapter.MyViewHolder> {
    protected abstract void findRoute(Double destinationLatitude, double destinationLongitude);

    PathViewModel viewModel;
    Context context;

    public ContactListAdapter(PathViewModel viewModel, @NonNull DiffUtil.ItemCallback<Contact> diffCallback) {
        super(diffCallback);
        this.viewModel = viewModel;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);
        context = parent.getContext();
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contact current = getItem(position);

        holder.title.setText(current.getName());
        holder.place.setText(current.getNumber());

        holder.delete.setOnClickListener(v -> {
            viewModel.deleteContact(current.getId());
        });

        holder.call.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + current.getNumber()));
            context.startActivity(intent);
        });

        holder.message.setOnClickListener(v -> {

            DialogSendLocation location = new DialogSendLocation(context) {
                @Override
                protected void onBind(DialogSendLocationBinding binding) {
                    binding.btnSave.setOnClickListener(v -> {
                        SmsManager smsManager = SmsManager.getDefault();
                        String smsBody = "Hey Its me you can find me here " +
                                "http://maps.google.com?q=" +
                                App.currentLatitude+
                                "," +
                                App.currentLongitude ;
                        smsManager.sendTextMessage(current.getNumber(), null, smsBody, null, null);
                        Toast.makeText(context, "Message Send Successfully ", Toast.LENGTH_SHORT).show();
                        dismiss();
                    });

                    binding.btnCancel.setOnClickListener(v -> {
                        dismiss();
                    });
                }
            };
            location.show();

        });


    }

    static public class PathDiff extends DiffUtil.ItemCallback<Contact> {

        @Override
        public boolean areItemsTheSame(@NonNull Contact oldItem, @NonNull Contact newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Contact oldItem, @NonNull Contact newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        final TextView title;
        final TextView place;
        final ImageView delete;
        final ImageView call;
        final ImageView message;

        private MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            place = itemView.findViewById(R.id.tvPlace);
            delete = itemView.findViewById(R.id.ivDelete);
            call = itemView.findViewById(R.id.ivCall);
            message = itemView.findViewById(R.id.ivMessage);


        }


    }
}
