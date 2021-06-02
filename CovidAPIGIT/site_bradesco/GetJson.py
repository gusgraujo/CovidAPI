import requests
import json

#response = requests.get("http://localhost:8080/covid/estado?estado=MG")


death = []


def jprint(obj):
    # create a formatted string of the Python JSON object
    text = json.dumps(obj, sort_keys=True, indent=4)
    print(text)

#jprint(response.json())



def getEpi_week(response):
    epi_week = []
    dados = response.json()

    for d in dados:
        epie = d['epi_week']
        epi_week.append(epie)

    #print(epi_week)

    return epi_week

#getEpi_week(response)


def getDeaths(response):
    deaths = []
    dados = response.json()

    for d in dados:
        mortes = d['deaths']
        deaths.append(mortes)

    #print(deaths)

    return deaths
    
#getDeaths(response)


def getVacinados(response):
    vacinados = []
    dados = response.json()

    for d in dados:
        vac = d['vaccinated']
        vacinados.append(vac)

    #print(epi_week)

    return vacinados


def getCasos(response):
    casos = []
    dados = response.json()

    for d in dados:
        cas = d['totalCases']
        casos.append(cas)

    #print(epi_week)

    return casos


def getRecuperados(response):
    recover = []
    dados = response.json()

    for d in dados:
        rec = d['recovered']
        recover.append(rec)

    #print(epi_week)

    return recover
