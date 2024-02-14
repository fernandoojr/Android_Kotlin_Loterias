package com.example.conferirnmeroslotofacil.Model


class Result {
    //lateinit var loteria: String
    //lateinit var nome: String
    var concurso: Int = 0
    //lateinit var data: String
    //lateinit var local: String
    lateinit var dezenas: Array<String>
    lateinit var premiacoes: Array<Premiacao>
    //var acumulou: Boolean = false
    //lateinit var acumuladaProxConcurso: String
    //lateinit var dataProxConcurso: String
    //var proxConcurso: Int = 0
    //lateinit var timeCoracao: String
    //lateinit var mesSorte: String
}

/*
{
    "loteria":"lotofacil",
    "concurso":3023,
    "data":"06/02/2024",
    "local":"ESPAÇO DA SORTE em SÃO PAULO, SP",
    "dezenasOrdemSorteio":["07","12","03","06","21","10","20","16","22","18","25","15","13","23","02"],
    "dezenas":["02","03","06","07","10","12","13","15","16","18","20","21","22","23","25"],
    "trevos":[],
    "timeCoracao":null,
    "mesSorte":null,
    "premiacoes":[
        {
            "descricao":"15 acertos",
            "faixa":1,
            "ganhadores":3,
            "valorPremio":1499556.38},
        {
            "descricao":"14 acertos","faixa":2,"ganhadores":595,"valorPremio":1270.4},{"descricao":"13 acertos","faixa":3,"ganhadores":17785,"valorPremio":30.0},{"descricao":"12 acertos","faixa":4,"ganhadores":200268,"valorPremio":12.0},{"descricao":"11 acertos","faixa":5,"ganhadores":1032454,"valorPremio":6.0}],"estadosPremiados":[],"observacao":"","acumulou":false,"proximoConcurso":3024,"dataProximoConcurso":"07/02/2024","localGanhadores":[{"ganhadores":1,"municipio":"RONDONOPOLIS","nomeFatansiaUL":"","serie":"","posicao":1,"uf":"MT"},{"ganhadores":1,"municipio":"NOVA FRIBURGO","nomeFatansiaUL":"","serie":"","posicao":1,"uf":"RJ"},{"ganhadores":1,"municipio":"GUARULHOS","nomeFatansiaUL":"","serie":"","posicao":1,"uf":"SP"}],"valorArrecadado":3.4477545E7,"valorAcumuladoConcurso_0_5":909194.21,"valorAcumuladoConcursoEspecial":5.359526081E7,"valorAcumuladoProximoConcurso":0.0,"valorEstimadoProximoConcurso":1700000.0}

 */







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