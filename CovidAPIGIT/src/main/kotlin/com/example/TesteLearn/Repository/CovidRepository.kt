package com.example.TesteLearn.Repository

import com.example.TesteLearn.Model.Covid
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface CovidRepository: PagingAndSortingRepository<Covid, Long> {

    @Query(value = "SELECT * FROM covid GROUP by state,epi_week",
        nativeQuery = true)
    fun getAllWeeks():List<Covid>

    @Query(value = "SELECT * from covid  where state = :state ",
        nativeQuery = true)
    fun getALlPerState(@Param("state")estado : String) : List<Covid>



}