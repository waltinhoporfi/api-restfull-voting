# api-restfull-voting
Backend application for voting in assembly for members


Gerenciamento de sessões de votação

   Métodos da aplicação:

Inserindo um associado ao banco
<h1>1 - POST (localhost:8080/associated)</h1>
<json>{
  "cpf": "11122233300",
  "name": "Walter Porfirio"
}</json>
  
  
Inserindo uma Pauta ao banco
2 - POST (localhost:8080/guidelines)
{
    "guideline": "Nome da Pauta"
}


Inserindo uma votação, passando um JSON com a Pauta que deseja votar, o associado que deseja votar, e por fim seu voto.
3 - POST (localhost:8080/voting) 
{"guideline": {"id": 1}, "associated": {"id": 1}, "choice": true }


Iniciando uma seção de votos, passando o "ano/mês/diaThora:minutos", minutos que a seção ficará aberta, e a pauta.
4 - POST (/session)
{
    "startTime": "2021-05-11T15:30",
    "sessionMinutes": null,
    "guideline": {"id": 1}
}


