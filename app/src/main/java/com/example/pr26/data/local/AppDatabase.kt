package com.example.pr26.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pr26.data.local.dao.UserDao
import com.example.pr26.data.local.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: build(context.applicationContext).also { INSTANCE = it }
            }
        }

        private fun build(appContext: Context): AppDatabase {
            return Room.databaseBuilder(
                appContext,
                AppDatabase::class.java,
                "app_db"
            ).addCallback(
                object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        prepopulate(db, replace = true)
                    }

                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)
                        // Ensure users exist even if DB was reused between test runs.
                        prepopulate(db, replace = false)
                    }
                }
            ).fallbackToDestructiveMigration()
                .build()
        }

        private fun prepopulate(db: SupportSQLiteDatabase, replace: Boolean) {
            val cmd = if (replace) "INSERT OR REPLACE" else "INSERT OR IGNORE"
            db.execSQL("$cmd INTO users(email, password) VALUES('test1@mail.com','123456')")
            db.execSQL("$cmd INTO users(email, password) VALUES('test2@mail.com','123456')")
            db.execSQL("$cmd INTO users(email, password) VALUES('test3@mail.com','123456')")
            db.execSQL("$cmd INTO users(email, password) VALUES('test4@mail.com','123456')")
            db.execSQL("$cmd INTO users(email, password) VALUES('test5@mail.com','123456')")
        }
    }
}
