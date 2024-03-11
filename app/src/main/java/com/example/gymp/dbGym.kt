package com.example.gymp

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val Firstname: String,
    val Lastname : String,
    val Email : String,
    val Password : String,
    val Birthday: String
)


@Dao
interface UserDao {
    @Query("SELECT * FROM user")
   suspend fun getAll(): List<User>

    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM user WHERE id = :userId")
    suspend fun getUserById(userId: Int): User?

    @Update
    suspend fun updateUser(user: User)
}
//////////////////////////////////////////////////// Exercice DB //////////////////////////////////////////////
@Entity
data class Exercice(
    @PrimaryKey(autoGenerate = true) val idExercice: Int = 0,
    val ExerciceName: String,
    val BodyPart: String,
    val TrainingTime: Double,
    val TrainingDate: String // Utilisez Long pour stocker les dates dans Room
)

@Dao
interface ExerciceDao {
    @Insert
    suspend fun insert(exercice: Exercice)
}


//////////////////////////////////////////////////// DATABASE ////////////////////////////////////////////
@Database(entities = [User::class, Exercice::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun exerciceDao(): ExerciceDao // Ajoutez cette fonction abstraite

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "AppDatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}


