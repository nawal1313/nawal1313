package com.app.navi.database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.app.navi.models.Contact;
import com.app.navi.models.Path;

import java.util.List;



@Dao
public interface DataDao {


    @Query("SELECT * FROM path_table ORDER BY id ASC")
    LiveData<List<Path>> getAlphabetizedWords();

    @Query("SELECT * FROM contact ORDER BY id ASC")
    LiveData<List<Contact>> getAlphabetizedContacts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Path path);

    @Query("DELETE FROM path_table")
    void deleteAll();

    @Query("DELETE FROM path_table where id = :pathID")
    void deletePath(int pathID);

    @Query("DELETE FROM contact where id = :pathID")
    void deleteContact(int pathID);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertContact(Contact contact);
}
