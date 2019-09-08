package id.majalengka.androidfundamental.data

import id.majalengka.androidfundamental.data.remote.RemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(private val remoteSource: RemoteDataSource) {

}