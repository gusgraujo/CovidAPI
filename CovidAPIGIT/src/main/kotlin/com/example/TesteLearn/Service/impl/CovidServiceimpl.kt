package com.example.TesteLearn.Service.impl

import com.example.TesteLearn.Repository.CovidRepository
import com.example.TesteLearn.Service.CovidService
import com.example.TesteLearn.Model.Covid

import org.springframework.data.domain.Sort

import org.springframework.stereotype.Component




@Component
class CovidServiceimpl(val covidRepository : CovidRepository): CovidService {




    override fun create(covid: Covid){
        this.covidRepository.save(covid)

    }

    override fun getById(id: Long): Covid? {
        return covidRepository.findById((id)).orElseGet(null)
    }

    override fun delete(id: Long) {
        this.covidRepository.deleteById(id)
    }

    override fun update(id: Long, covid: Covid) {
        delete(id)
        create(covid)
    }

    override fun searchByLocal(state: String): List<Covid>  = listOf()


    override fun getAll(): List<Covid> {
        return this.covidRepository.findAll().toList()
    }

    override fun getAllSortedByLocal(): List<Covid> {
        return this.covidRepository.findAll(Sort.by("state").descending()).toList()
    }

    override fun getAllWeeks(): List<Covid> {
        return this.covidRepository.getAllWeeks()
    }

    override fun getALlPerState(estado : String) : List<Covid> = this.covidRepository.getALlPerState(estado)

}