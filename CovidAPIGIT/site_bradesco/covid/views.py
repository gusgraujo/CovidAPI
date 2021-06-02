
from django.http import HttpResponse
import json
from django.shortcuts import render
from .models import Product
from GetJson import getEpi_week,getDeaths,getVacinados,getCasos,getRecuperados
import requests

def home(request):

    response = requests.get("http://localhost:8080/covid/estado?estado=SP")
    
    semana = getEpi_week(response)
    mortes = getDeaths(response)
    vacinados = getVacinados(response)
    casos = getCasos(response)
    recuperados = getRecuperados(response)

    context = {
        'semana': json.dumps(semana),
        'mortes': json.dumps(mortes),
        'vacinados': json.dumps(vacinados),
        'casos': json.dumps(casos),
        'recuperados' : json.dumps(recuperados)
    }
    
    return render(request, 'covid/deaths.html', context)