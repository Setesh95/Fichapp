package com.example.fichapp.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.fichapp.model.Converters;
import com.example.fichapp.model.RegisterHistoryModel;
import com.example.fichapp.model.UserModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(
        entities = {
                UserModel.class,
                RegisterHistoryModel.class
        },
        version = 1,
        exportSchema = false
)
@TypeConverters({Converters.class})
public abstract class FichappRoomDb extends RoomDatabase {
    public abstract UserDao fichappDao();
    public abstract RegisterDao registerDao();
    private static volatile FichappRoomDb INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriterExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static FichappRoomDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FichappRoomDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FichappRoomDb.class, "fichapp_db")
                            .addCallback(roomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };
}

