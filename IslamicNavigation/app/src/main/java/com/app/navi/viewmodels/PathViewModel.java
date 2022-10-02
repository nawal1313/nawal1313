package com.app.navi.viewmodels;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.app.navi.database.DataBaseRepository;
import com.app.navi.models.Contact;
import com.app.navi.models.Path;

import java.util.List;



public class PathViewModel extends AndroidViewModel {

    private final DataBaseRepository repository;

    private final LiveData<List<Path>> allPaths;
    private final LiveData<List<Contact>> allConacts;

    public PathViewModel(Application application) {
        super(application);
        repository = new DataBaseRepository(application);
        allPaths = repository.getAllWords();
        allConacts = repository.getAllContacts();
    }

    public LiveData<List<Path>> getAllPaths() {
        return allPaths;
    }

    public LiveData<List<Contact>> getAllContacts() {
        return allConacts;
    }

    public void deletePath(int id) {
         repository.deletePath(id);
    }

    public void deleteContact(int id) {
        repository.deleteContact(id);
    }

    public void insert(Path path) {
        repository.insert(path);
    }

    public void insertContact(Contact contact) {
        repository.insertContact(contact);
    }
}
