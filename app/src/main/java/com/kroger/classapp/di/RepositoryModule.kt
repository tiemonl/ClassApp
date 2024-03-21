package com.kroger.classapp.di

import com.kroger.classapp.data.repository.RickAndMortyRepository
import com.kroger.classapp.data.repository.RickAndMortyRepositoryReal
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRickAndMortyRepository(
        rickAndMortyRepositoryImpl: RickAndMortyRepositoryReal,
    ): RickAndMortyRepository
}