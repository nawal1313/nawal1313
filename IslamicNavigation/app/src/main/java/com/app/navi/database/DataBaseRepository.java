package com.app.navi.database;



import android.app.Application;

import androidx.lifecycle.LiveData;

import com.app.navi.models.Contact;
import com.app.navi.models.Path;

import java.util.List;


public class  DataBaseRepository {

    private DataDao mDataDao;
    private LiveData<List<Path>> mAllWords;
    private LiveData<List<Contact>> mAllContacts;


    public DataBaseRepository(Application application) {
        RoomDatabase db = RoomDatabase.getDatabase(application);
        mDataDao = db.wordDao();
        mAllWords = mDataDao.getAlphabetizedWords();
        mAllContacts = mDataDao.getAlphabetizedContacts();
    }


    public LiveData<List<Path>> getAllWords() {
        return mAllWords;
    }

    public LiveData<List<Contact>> getAllContacts() {
        return mAllContacts;
    }


    public void insert(Path path) {
        RoomDatabase.databaseWriteExecutor.execute(() -> {
            mDataDao.insert(path);
        });
    }

    public void insertContact(Contact contact)  {
        RoomDatabase.databaseWriteExecutor.execute(() -> {
            mDataDao.insertContact( contact);
        });
    }
    public void deletePath(int id) {
        RoomDatabase.databaseWriteExecutor.execute(() -> {
            mDataDao.deletePath(id);
        });
    }
    public void deleteContact(int id) {
        RoomDatabase.databaseWriteExecutor.execute(() -> {
            mDataDao.deleteContact(id);
        });
    }
}
