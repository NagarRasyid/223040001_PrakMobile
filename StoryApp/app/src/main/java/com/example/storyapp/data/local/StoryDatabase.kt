import kotlin.reflect.KClass
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class StoryDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

annotation class Database(
    val entities: Array<KClass<UserEntity>>,
    val version: Int,
    val exportSchema: Boolean
)
