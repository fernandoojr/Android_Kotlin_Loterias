package com.example.conferirnmeroslotofacil.Model

import kotlin.properties.Delegates

class Result {
    lateinit var loteria: String
    lateinit var nome: String
    var concurso: Int = 0
    lateinit var data: String
    lateinit var local: String
    lateinit var dezenas: Array<String>
    lateinit var premiacoes: Array<Premiacao>
    var acumulou: Boolean = false
    lateinit var acumuladaProxConcurso: String
    lateinit var dataProxConcurso: String
    var proxConcurso: Int = 0
    lateinit var timeCoracao: String
    lateinit var mesSorte: String
}

/*{
    "loteria":"lotofacil",
    "nome":"Lotofácil",
    "concurso":2477,
    "data":"22/03/2022",
    "local":"ESPAÇODASORTE em SÃOPAULO,SP",
    "dezenas":["01","02","03","05","07","08","09","10","13","14","15","18","19","20","24"],
    "premiacoes":[
        {
            "acertos":"15 Pontos",
            "vencedores":4,
            "premio":"835.568,35"
        },
        {
            "acertos":"14 Pontos",
            "vencedores":496,
            "premio":"1.047,16"
        },
        {
            "acertos":"13 Pontos",
            "vencedores":16120,
            "premio":"25,00"
        },
        {
            "acertos":"12 Pontos",
            "vencedores":181898,
            "premio":"10,00"
        },
        {
            "acertos":"11 Pontos",
            "vencedores":949748,
            "premio":"5,00"
        }
    ],
    "estadosPremiados":[],
    "acumulou":false,
    "acumuladaProxConcurso":"R$ 1,5 Milhão",
    "dataProxConcurso":"23/03/2022",
    "proxConcurso":2478,
    "timeCoracao":null,
    "mesSorte":null
}*/