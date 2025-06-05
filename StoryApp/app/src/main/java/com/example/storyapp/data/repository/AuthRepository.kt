import com.example.storyapp.data.helper.Result
import com.example.storyapp.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val apiService: ApiService,
    private val userDao: UserDao
) {
    suspend fun login(email: String, password: String): Flow<Result<UserEntity>> = flow {
        emit(Result.Loading)
        try {
            val response = apiService.login(LoginRequest(email, password))
            if (response.error) {
                emit(Result.Error(response.message))
            } else {
                val user = UserEntity(
                    userId = response.loginResult.userId,
                    name = response.loginResult.name,
                    token = response.loginResult.token
                )
                userDao.insertUser(user)
                emit(Result.Success(user))
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message ?: "Terjadi kesalahan"))
        }
    }
}