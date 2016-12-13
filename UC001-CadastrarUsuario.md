##Caso de Uso 001 - Cadastrar Novo Usuário

###FP : Fluxo Principal
1. O usuário informa o nome
2. O usuário informa login
3. O usuário informa a senha 
4. O sistema verifica os dados informados (E1)(E2) 
5. O sistema exibe os dados para confirmação do usuário
6. O usuário confirma os dados (A1)
7. O sistema registra os dados informados (E3)
8. O caso de uso se encerra

###A1 : O usuário não confirma os dados
1. O usuário não confirma os dados exibidos pelo sistema
2. O sistema encerra o caso de uso e exibe a tela principal da aplicação

###E1 : Dados obrigatórios não informados
1. O sistema identifica que ao menos um dos dados não foi informado
2. O sistema exibe ao usuário a mensagem informativa
3. O caso de uso se reinicia

###E2 : Login informado já existe cadastrado no sistema
1. O sistema identifica que o login digitado já está cadastrado para outro usuário.
2. O sistema exibe a mensagem informativa para o usuário
3. O caso de uso se reinicia

###E3 : Erro ao registrar os dados
1. O sistema identifica que houve falha no registro dos dados
2. O sistema exibe a mensagem informativa
3. O caso de uso se encerra
