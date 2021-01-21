#language: pt
Funcionalidade: : Armazenar dados fictícios de usuário e tentar cadastrar conta no google


@Cadastro_usuario_telefone_inválido
Esquema do Cenário: Cadastrar usuário com telefone inválido

Dado que estou acessando a aplicação
Quando armazeno os dados capturados
E clico no botão para acessar o google
E preencho os campos de cadastro
E informo "<Telefone Inválido>"
Então faço a validação da "<Mensagem>" de erro apresentada

Exemplos:
|                                 Mensagem                                    |Telefone Inválido|
|Este formato de número de telefone não é válido. Verifique o país e o número.|11123456789      |