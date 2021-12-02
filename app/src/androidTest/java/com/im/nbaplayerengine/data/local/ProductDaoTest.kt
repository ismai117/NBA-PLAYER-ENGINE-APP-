package com.im.nbaplayerengine.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.im.nbaplayerengine.data.local.database.EngineDatabase
import com.im.nbaplayerengine.data.local.players.PlayerDao
import org.junit.Before

import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class ProductDaoTest {


    private lateinit var engineDatabase: EngineDatabase
    private lateinit var playerDao: PlayerDao

    @Before
    fun setUp(){
        engineDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            EngineDatabase::class.java,
            
        )
    }





}