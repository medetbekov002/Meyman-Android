package com.example.meyman.core.base

import com.example.meyman.domain.utils.Either
import com.example.meyman.presentation.base.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseRepository {

    protected open fun <T> doRequest(request: suspend () -> T) = flow<Either<String, T>>{
        emit(Either.Right(data = request()))
    }.flowOn(Dispatchers.IO).catch { exception ->
        emit(Either.Left(message = exception.localizedMessage ?: "Error occurred"))
    }

    protected open fun <T> doRequests(request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        } catch (ioException: Exception) {
            emit(Resource.Error(ioException.localizedMessage ?: "Что-то пошло не так..."))
        }
    }
}