package com.example.TesteLearn.Service

import com.example.TesteLearn.Model.Covid

interface CovidService {



    fun create(covid: Covid)

    fun getById(id:Long) : Covid?

    fun delete(id: Long)

    fun update(id: Long,covid: Covid)

    fun searchByLocal(state:String):List<Covid>

    fun getAll(): List<Covid>

    fun getAllSortedByLocal() : List<Covid>

    fun getAllWeeks() : List<Covid>


    fun getALlPerState(estado : String) : List<Covid>
}