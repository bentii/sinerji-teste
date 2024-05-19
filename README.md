# Teste para Sinerji

## Projeto criado em **Spring Boot** utilizando **H2** como banco de dados integrado.

Por ser um projeto em framework o diretório da lógica está localizado em src/main/java/sinerji/teste/

## **Execute o arquivo sinerji/teste/TesteApliccation.java** para iniciar o programa

A injeção dos dados fornecidos nas tabelas do teste são automáticamente inseridas no banco de dados pelo arquivo
**DataInitializer.java**


## Todos métodos utilizam o mesmo caminho da RestAPI para buscar os dados no banco de dados HTTP:

### POST: http://localhost:8080/funcionarios/pesquisar


## Segue a forma para fazer o request para cada método cobrado no teste, lembrando que todos utilizam o mesmo caminho HTTP:
**(O código dos métodos está em src/main/java/sinerji/teste/Services/FuncionarioService.java)**

#### As requisições consistem em um objeto contendo um array de nomes, uma data no tipo "yyyy-MM" e o nome do método desejado no formato JSON.

1. #### "Um método que receba uma lista de funcionários, mês e ano e retorne o valor total
      ## pago (salário e benefício) a esses funcionários no mês."
   
     ```json   
    {
    "nomes": ["Nome 01", "Nome 02", "Nome 03"],
    "data": "yyyy-MM",
    "metodo": "Valor total pago no mês"
    }
    ```

2. #### Um método que receba uma lista de funcionários, mês e ano e retorne o total pago
      somente em salários no mês.
   
     ```json
    {
    "nomes": ["Nome 01", "Nome 02", "Nome 03"],
    "data": "yyyy-MM",
    "metodo": "Valor somente em salário no mês"
    }
    ```

3. #### Um método que receba uma lista somente com os funcionários que recebem
      benefícios, mês e ano e retorne o total pago em benefícios no mês.

    ```json
    {
    "nomes": ["Nome 01", "Nome 02", "Nome 03"],
    "data": "yyyy-MM",
    "metodo": "Valor somente em benefício no mês"
    }
    ```

4. #### Um método que receba uma lista de funcionários, mês e ano e retorne o que
    recebeu o valor mais alto no mês.

    ```json
    {
    "nomes": ["Nome 01", "Nome 02", "Nome 03"],
    "data": "yyyy-MM",
    "metodo": "Funcionário com maior salário no mês"
    }
    ```

5. #### Um método que receba uma lista somente com os funcionários que recebem
    benefícios, mês e ano e retorne o nome do funcionário que recebeu o valor mais
    alto em benefícios no mês.

    ```json
    {
    "nomes": ["Nome 01", "Nome 02", "Nome 03"],
    "data": "yyyy-MM",
    "metodo": "Funcionário com maior benefício no mês"
    }
    ```

6. #### Um método que receba uma lista de vendedores, mês e ano e retorne o que mais
    vendeu no mês.

    ```json
    {
    "nomes": ["Nome 01", "Nome 02", "Nome 03"],
    "data": "yyyy-MM",
    "metodo": "Funcionário com mais vendas no mês"
    }
    ```
