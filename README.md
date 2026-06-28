# Calculadora de IMC 

Sistema em Java focado na aplicação prática de Programação Orientada a Objetos (POO), herança multinível, polimorfismo, herança e recursão estruturada.

## 📋 Pré-requisitos
* Java JDK 17 ou superior instalado.
* Apache Maven 3.8+ configurado no PATH do sistema.

## 🚀 Como Compilar
No diretório raiz do projeto (onde está localizado o arquivo `pom.xml`), execute o comando de empacotamento:
```bash
mvn clean package

Após a compilação obter sucesso (BUILD SUCCESS), inicialize a aplicação executando:

Bash
java -jar target/calculadora-imc-1.0.0.jar

Alternativamente, você pode rodar direto via Maven sem gerar o .jar:

Bash
mvn exec:java -Dexec.mainClass="Main"
