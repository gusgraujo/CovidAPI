package com.example.TesteLearn.Controller


import com.example.TesteLearn.Service.CovidService

import com.example.TesteLearn.Model.Covid


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap


@RestController
@RequestMapping("/covid")
class PromocaoController {

    @Autowired
    lateinit var covidService : CovidService

    @GetMapping("/{id}")
    fun getGeBytId(@PathVariable id:Long):ResponseEntity<Covid?> {
        var covid = covidService.getById(id)

        var status = if (covid==null) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(covid,status)
    }

    @PostMapping()
    fun create(@RequestBody covid: Covid):ResponseEntity<Map<String,String>>{

        this.covidService.create(covid)
        val map = mapOf("Message" to "OK")
        return ResponseEntity(map,HttpStatus.CREATED)
    }


    @DeleteMapping()
    fun delete(@PathVariable id: Long):ResponseEntity<Unit>{
        this.covidService.delete(id)

        var status = HttpStatus.NOT_FOUND

        if(this.covidService.getById(id)!=null){
            this.covidService.delete(id)
            HttpStatus.ACCEPTED
        }
        return ResponseEntity(Unit,status)
    }


    @PutMapping("/{id}")
    fun update(@PathVariable id:Long,@RequestBody covid: Covid){
        this.covidService.update(id,covid)
    }


    @GetMapping()
    fun getAll(@RequestParam(required = false,defaultValue = "") localFilter: String):ResponseEntity<List<Covid>> {
        val listPromocao = this.covidService.getAll()
        val status = if(listPromocao.size == 0) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(listPromocao,status)
    }
    @GetMapping("/ordenado")
    fun ordenados() = this.covidService.getAllSortedByLocal()

    @GetMapping("/weeks")
    fun getAllWeeks() = this.covidService.getAllWeeks()

    @GetMapping("/estado")
    fun getALlPerState(@RequestParam(required = false,defaultValue = "") estado : String) : ResponseEntity<List<Covid>>{
        val listEstados = this.covidService.getALlPerState(estado)
        val status = if(listEstados.size == 0) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(listEstados,status)
    }
}