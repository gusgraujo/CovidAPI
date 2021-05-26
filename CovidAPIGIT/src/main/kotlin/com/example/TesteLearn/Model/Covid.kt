package com.example.TesteLearn.Model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*


@Entity
@Table(name = "COVID")
data class Covid(
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @JsonIgnore
                 var id :Long = 1,
                 var epi_week: String? = "",
                 var date: String? = "",
                 var country: String? = "",
                 var state: String? = "",
                 var city: String? = "",
                @JsonIgnore
                 var newDeaths: String? = "",
                 var deaths: String? = "",
                 var newCases: String? = "",
                 var totalCases: String? = "",
                 @JsonIgnore
                 var deathsMS: String? = "",
                 @JsonIgnore
                 var totalCasesMS: String? = "",
                @JsonIgnore
                 var deaths_per_100k_inhabitants: String? = "",
                @JsonIgnore
                 var totalCases_per_100k_inhabitants: String? ="",
                @JsonIgnore
                 var deaths_by_totalCases: String? = "",
                 var recovered: String? = "",
                 var suspects: String? = "",
                 var tests: String? = "",
                @JsonIgnore
                 var tests_per_100k_inhabitants: String? = "",
                 var vaccinated: String? = null,
                @JsonIgnore
                 var vaccinated_per_100k_inhabitants: String? = "",
                @JsonIgnore
                 var vaccinated_second: String? = "",
                @JsonIgnore
                 var vaccinated_second_per_100k_inhabitants: String? = ""
                )
