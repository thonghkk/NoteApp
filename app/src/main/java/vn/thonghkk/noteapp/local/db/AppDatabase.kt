package vn.thonghkk.noteapp.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import vn.thonghkk.noteapp.local.db.dao.TaskDao
import vn.thonghkk.noteapp.local.db.entities.TaskEntity


@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {

        //show all filed inserted in threads
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "NoteAppDatabase.db"
            )
                .fallbackToDestructiveMigration()
                .build()

    }
}