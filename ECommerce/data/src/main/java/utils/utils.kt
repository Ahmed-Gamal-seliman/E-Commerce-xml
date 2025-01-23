package utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.example.domain.common.InternetExceptionError
import com.example.domain.common.Resource
import com.example.domain.common.ServerError
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okio.IOException
import retrofit2.HttpException


suspend fun <T>executeApi(apiCall: suspend ()->T):T{


    try {
        val response = apiCall.invoke()
        return response
    }catch (ex:HttpException)
    {
        if(ex.code() in 400..600) {
            val serverResponse = ex.response()?.errorBody()?.string()
            val serverError = Gson().fromJson<ServerError>(serverResponse, ServerError::class.java)
            throw ServerError(
                serverError = serverError.serverError,
                statusMessage = serverError.statusMessage
            )
        }
        throw ex
    }catch (ex:IOException)
    {
        throw InternetExceptionError(ex)
    }catch (ex:Exception)
    {
        throw ex
    }

}


//Flow<Resource<List<Product?>?>
  fun <T>safeApiCall(getData: suspend ()->T): Flow<Resource<T>>
{
    return flow {
        emit(Resource.Loading)
        val response = getData.invoke()
        emit(Resource.Success(response))

    }.flowOn(Dispatchers.IO)
        .catch {ex->
       when(ex)
       {
           is ServerError -> emit(Resource.ServerFail(ex))
           is InternetExceptionError -> emit(Resource.Fail(ex))
           else -> emit(Resource.Fail(Exception(ex.message)))

       }
    }
}

fun hasNetworkConnection(context:Context):Boolean{
  val connectivityManager:ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val networkInfo:NetworkInfo? = connectivityManager.activeNetworkInfo

    return (networkInfo!=null) && (networkInfo.isConnectedOrConnecting)

}

