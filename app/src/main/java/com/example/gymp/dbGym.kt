package com.example.gymp

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

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
     fun getUserById(userId: Int): User?

    @Update
     fun updateUser(user: User)
}
//////////////////////////////////////////////////// Exercice DB //////////////////////////////////////////////
@Entity
data class Exercice(
    @PrimaryKey(autoGenerate = true) val idExercice: Int = 0,
    val ExerciceName: String,
    val BodyPart: String,
    val TrainingTime: Double,
    val TrainingDate: String,
    val TrainingDone: Boolean,
    val idUserExercice: Int
)

@Dao
interface ExerciceDao {
    @Insert
    suspend fun insert(exercice: Exercice)

    @Query("SELECT * FROM Exercice WHERE idUserExercice = :userId")
    suspend fun getExercicesByUserId(userId: Int): List<Exercice>

    @Delete
    suspend fun deleteExercice(exercice: Exercice)
}
//////////////////////////////////////////////////// Coach DB //////////////////////////////////////////////
@Entity
data class Coach(
    @PrimaryKey(autoGenerate = true) val idCoach: Int = 0,
    val nameCoach: String,
    val idUserForCoach: Int,
)

@Dao
interface CoachDao{
    @Insert
    suspend fun insertCoach(newCoach: Coach)


}
//////////////////////////////////////////////////// DATABASE ////////////////////////////////////////////
@Database(entities = [User::class, Exercice::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun exerciceDao(): ExerciceDao


    companion object {
        val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Migration logic
            }
        }

        @Volatile
    private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "AppDatabase"
                )
                    .addMigrations(migration_1_2) // Add migration here
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}


