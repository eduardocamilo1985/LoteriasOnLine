# Projeto de teste automático 🤖: Jogos de loteria - Mega-sena 💰🤑🚗🏄‍♂️🚁

<!--ts-->
* [Objetivo](#objetivo)
* [Tecnologias utilizadas](#tecnologia)
* [Utilização/estrutura](#utilizacao)
* [Desafios](#desafios)
* [Funcionalidades/Casos de teste](#funcionalidades)
* [Links para consulta](#link)
<!--te-->

# <a name="objetivo"></a>Objetivo

Este projeto tem como objetivo demonstrar os meus conhecimentos sobre as ferramentas de **automação de teste**.

O diferencial desse projeto é que ele usa o Selenium 4.1.4, Junit 5.8.2 e também uma biblioteca para gerar relatórios 
chamada ExtentReports.

O sistema usado aqui é o de loterias da Caixa, mais precisamente o Jogo da **Mega-Sena**. Ele 
pode ser acessado por qualquer pessoa através do link "https://www.loteriasonline.caixa.gov.br/silce-web"

## <a name="tecnologia"></a>Tecnologias utilizadas
![JUnit](icon/Junit.png)
![Selenium](icon/SeleniumWebDriver.png)
![java](icon/java.png)
![IntelliJ](icon/IntelliJ.png)
![Maven](icon/Maven.png)
![Maven](icon/ExtentReport.jpg)


**Linguagem:** Java

**Frameworks:** JUnit 5, Selenium WebDriver 4

**Integrador/Compilador:** Maven

**Criação de relatórios:** Biblioteca ExtentReports

**IDE:** IntelliJ

## <a name="utilizacao"></a>Utilização/estrutura

Realizar o download do projeto (via git clone ou arquivo zip).

Importar o projeto na sua IDE de desenvolvimento favorita

**Estrutura do projeto**

A estrutura principal do projeto está localizada no diretório src/main/java. Os principais packages são:

* Estrutura — Contém as classes estruturais do projeto (base para outras classes).
* Pages — Contém o mapeamento dos elementos das páginas.
* Funcionalidades - Os casos de testes

O projeto utiliza os conceitos de DSL e Page Object

**Explicando algumas classes**

A classe **Basic** contém toda a parte Selenium utilizada.

A classe **Relatorios** é responsável por gerar o relatório de teste. Nesse início decidi gerar um único relatório
para todo o conjunto de teste. Cada teste realizado é nomeado pela anotação DisplayName do Junit. 

A classe **Parametros** contém somente variáveis tais como quantidade de jogos a fazer, valor de cada tipo de jogo, etc. 

A classe **Util** contém métodos de fato úteis 😅😹 como por exemplo a escolha dos números a serem jogados. 
Com isso a massa de teste é sempre dinâmica.

A **package Page** contém todo o mapeamento de elementos da aplicação. Para cada página da aplicação web,
existe uma classe chamada NomePaginaPage que estende da classe Basic. Exemplo página de jogos da mega-sena 
= MegaSenaPage.

## <a name="desafios"></a>Alguns desafios que encontrei 👊💪🧠

Como já estava acostumado com o JUnit 4, ao migrar para o JUnit 5 senti algumas diferenças, não por ser mais complicado, 
mas sim pelo vício mesmo. Quando já estamos no automático mudar as vezes se torna um desafio pessoal.   

Exemplo de diferenças entre o JUnit 4 para o JUnit5: O uso da anotação @BeforeAll, que no Junit 4 é somente @Before. 
As assertivas também mudam no JUnit 5. O que era Assert.assertEquals(valorEsperado,ValorAtual) passou a ser simplesmente assertEquals(valorEsperado,ValorAtual).

Usar o ExtentReports foi um desafio também. Não existe muito material em português sobre biblioteca. Tive que assistir 
alguns vídeos em outros idiomas para ver o uso da ferramenta. De fato a leitura do relatório facilita aos gestores 
sobre os casos de testes que passaram ou falharam. 

Para a massa de teste tive que usar recursos do próprio Java para criar um método que além de escolher os números 
de forma aleatória não houvesse repetições. 

## <a name="funcionalidades"></a>Funcionalidade - Aposta Mega Sena

### Caso de teste: realizarApostaSimples

Essa automação realiza uma aposta simples da mega-sena. Uma aposta simples é um jogo de 6 números.

O robô acessa o site, informa que possui mais de 18 anos, escolhe o jogo MegaSena, escolhe os números, 
confirma se a quantidade de itens selecionados bate com o números necessários para a aposta,
verifica se o valor está correto (parametrizado), insere no carrinho e verifica o valor total. 
Por fim vai para a tela de pagamento.

### Caso de teste: realizaApostaMaisNumeros

Essa automação realiza uma aposta que possui mais de 6 números. Uma aposta pode ter de 6 a 
15 números. A quantidade de números a serem jogados está parametrizado na classe Parametros 'apostaMaisNumeros'

O robô acessa o site, informa que possui mais de 18 anos, escolhe o jogo MegaSena, escolhe os números,
confirma se a quantidade de itens selecionados bate com o números necessários para a aposta,
verifica se o valor está correto (parametrizado), insere no carrinho.
Por fim vai para a tela de pagamento.

### Caso de teste: realizaVariosJogosSimples
Essa automação realiza várias apostas (valor parametrizado) simples da mega-sena.

O robô acessa o site, informa que possui mais de 18 anos, escolhe o jogo MegaSena, escolhe os números,
confirma se a quantidade de itens selecionados bate com o números necessários para a aposta, insere no carrinho. 
Essa parte de escolher os números e inserir no carrinho é repetidas por n vezes, onde n está 
parametrizado (pode ser alterado conforme a necessidade). Verifica o valor total

## <a name="link"></a>Links para consulta

[Documentação Selenium](https://www.selenium.dev/documentation/webdriver/)

[Documentação ExtentReport](https://www.extentreports.com/docs/versions/5/java/index.html)

[Documentação JUnit5](https://junit.org/junit5/docs/current/user-guide/)

Esses vídeos me ajudaram bastante a entender o ExtentReport.

[Vídeos ExtentReports 3](https://www.youtube.com/watch?v=eF_Vb-d4kIo)

[Vídeos ExtentReports 5](https://www.youtube.com/watch?v=MHgSAmDXIWs&t=1462s)