# api-restfull-voting
Backend application for voting in assembly for members


Gerenciamento de sessões de votação

   Métodos da aplicação:

<h2>Inserindo um associado ao banco</h2>
<h3>1 - POST (localhost:8080/associated)</h3>
<json>
{
  "cpf": "11122233300",
  "name": "Walter Porfirio"
}
</json>
  
  
<h2>Inserindo uma Pauta ao banco</h2>
<h3>2 - POST (localhost:8080/guidelines)</h3>
{
    "guideline": "Nome da Pauta"
}


<h2>Inserindo uma votação, passando um JSON com a Pauta que deseja votar, o associado que deseja votar, e por fim seu voto.</h2>
<h3>3 - POST (localhost:8080/voting)</h3>
{"guideline": {"id": 1}, "associated": {"id": 1}, "choice": true }


Iniciando uma seção de votos, passando o "ano/mês/diaThora:minutos", minutos que a seção ficará aberta, e a pauta.
4 - POST (/session)
{
    "startTime": "2021-05-11T15:30",
    "sessionMinutes": null,
    "guideline": {"id": 1}
}


