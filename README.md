# projeto_java_git

- Este programa é um sistema simples de gerenciamento de usuários com interface gráfica em Java, desenvolvido utilizando a biblioteca Swing para criar telas interativas. O sistema conecta-se a um banco de dados MySQL para armazenar informações de login, permitindo que usuários se cadastrem, façam login, atualizem suas senhas, visualizem os registros existentes e excluam suas contas.

- O sistema implementa funcionalidades essenciais de segurança, como a utilização da biblioteca BCrypt para realizar o hash das senhas, garantindo que os dados sensíveis não sejam armazenados em texto simples no banco de dados. Além disso, o programa possui mecanismos de validação de dados, tratamento de exceções e registro de logs para acompanhar tentativas de acesso e erros.

Os botões da interface permitem realizar as seguintes ações:

Cadastrar: permite registrar um novo usuário no sistema com login e senha.

Entrar: autentica o usuário com base nas credenciais informadas.

Alterar: possibilita a atualização da senha do usuário.

Deletar: exclui o usuário do banco de dados.

Registro: exibe uma tabela com os usuários cadastrados e suas senhas hash.



- Botão de Entrar:
Função: Realiza o login do usuário.

Verifica se o nome de usuário e senha são válidos (validação básica de formato).

Conecta ao banco de dados login, busca a senha associada ao login informado.

Compara a senha digitada com a senha do banco (criptografada com BCrypt).

Se for igual, exibe "Login bem-sucedido!".

Registra a tentativa de login na tabela logins (com sucesso ou falha).


- Botão de Registro 
Função: Exibe uma lista de todos os usuários cadastrados.

Executa um SELECT login, senha FROM clientes.

Monta uma tabela (JTable) com os resultados.

Exibe a tabela em um JOptionPane.

- Botão Cadastrar 
Função: Cadastra um novo usuário no banco.

Valida se os campos estão preenchidos.

Verifica se o usuário já existe (SELECT).

Se não existir, criptografa a senha com BCrypt.

Insere os dados na tabela clientes.

- Botão Alterar
Função: Altera a senha de um usuário já cadastrado.

Verifica se os campos estão preenchidos.

Criptografa a nova senha.

Executa um UPDATE na tabela clientes, atualizando a senha para o login informado.


- Botão Deletar 
Função: Deleta um usuário da tabela clientes.

Executa DELETE FROM clientes WHERE login = ?.

Se o usuário existir e for deletado, exibe mensagem de sucesso.

Se não for encontrado, exibe mensagem de erro.

Em caso de exceção, registra o erro com o método logErro(e) (não está incluído nesse trecho, mas provavelmente está em outra parte do seu código).


