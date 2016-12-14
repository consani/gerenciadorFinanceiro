##Caso de Uso 004 - Visualizar Débitos

### Pré-Condições
1. O usuário tem que realizar login com sucesso no sistema

###FP : Fluxo Principal
1. O sistema exibe todos os débitos do mês corrente com o total de débitos (A1)
2. O caso de uso se encerra 

###A1 : O usuário filtra os débitos por algum critério
1. O usuário seleciona um determinado período data inicial e data final (opcional) (A2) 
2. O usuário seleciona um tipo de débito (A3)
3. O usuário informa as duas opções de filtro (A4)
4. O sistema exibe os dados conforme aplicação do filtro selecionado
5. O caso de uso se encerra

###A2 : Filtro por período
1. O sistema seleciona apenas os débitos registrados entre as datas inicial e final informadas. Caso somente a data inicial tenha sido informada, a data final é considerada a data corrente
2. Retorna para item 4) do fluxo A1

###A3 : Filtro pelo tipo de débito
1. O sistema seleciona apenas os débitos cujo tipo associado seja o determinado no filtro.
2. Retorna para item 4) do fluxo A1

###A4 : Filtro pelo tipo de débito e por período
1. O sistema seleciona apenas os débitos dentro do período informado e cumulativamente do tipo escolhido pelo usuário.
2. Retorna para item 4) do fluxo A1



