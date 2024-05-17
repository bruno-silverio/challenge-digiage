<div align="center">
  
  ## 🚀 Challenge Digiage 🚀
  
</div>

### What is this repository for?

Este é um teste para que possamos ver as suas habilidades como Back-end Developer.
O objetivo é conhecer seus skills técnicos e também nos ajudar a melhorar os nossos métodos de recrutamento. 

### TASKS

- [ ] Java
  - [X] TASK1 - Palindrome
  - [X] TASK2 - Manipulating List
  - [X] TASK3 - Distinct items on a list
  - [ ] TASK4 - Implementation of a Rest API client
  - [ ] TASK5 - Implementation of a Rest API
- [X] MySQL Querys
- [X] Grafana Dashboard
- [X] About me

## How to install and use the project (instructions)

  - TASK1 - Palindrome
    
    > Select the main class, and run Run As -> Java Application
    
  - TASK2 - Manipulating List
    
    > Select the main class, and run Run As -> Java Application
    
  - TASK3 - Distinct items on a list

     > Select the main class, and run Run As -> Java Application

  - TASK4 - Implementation of a Rest API client
  - TASK5 - Implementation of a Rest API

## Sobre o SQL
  
####	Query que retorna à quantidade de funcionários separados por sexo
  
```sql
SELECT count(*) AS qtd, gender FROM employees GROUP BY gender;
```

#### Query que retorna à quantidade de funcionários distintos por sexo, ano e ano de nascimento
    
```sql
SELECT count(*) AS qtd, gender, YEAR(hire_date) AS ano_contrato, YEAR(birth_date) AS ano_nascimento 
FROM employees 
GROUP BY gender, YEAR(hire_date), YEAR(birth_date);
```

#### Query que retorna a média, min e max de salário por sexo
  
```sql
SELECT e.gender, AVG(s.salary), MIN(s.salary), MAX(s.salary)
FROM employees e
JOIN salaries s
ON e.emp_no = s.emp_no
GROUP BY e.gender;
```

## Grafana Dashboard


## Um "Texto" qualquer

Desenvolvedor de software apaixonado por criar produtos de sucesso que enfrentem desafios com eficiência. Estudo as melhores práticas de desenvolvimento e arquitetura de software, como system design, clean code, microsserviços, SOLID, TDD/BDD, Git Flow e muito mais. Possuo experiência diversificada em áreas como gestão de eventos, imóveis de veraneio, mobilidade urbana e comércio exterior, adquirida em passagens pela startup Parkeen, pela multinacional Thomson Reuters e em projetos pessoais. Reconhecido como um team player dedicado, focado em entregar resultados e maximizar lucros.

Trago para a mesa um espírito colaborativo, dedicado a alcançar resultados tangíveis e otimizar a rentabilidade. Com uma base sólida na simplificação de processos para melhorar a experiência do cliente, estou comprometido em impulsionar a inovação e buscar excelência em todos os projetos e estudos. Gosto de passar tempo com amigos e família e de estudar temas variados como fé, lógica e filosofia. Faço atividade física regularmente, incluindo musculação e luta, e gosto de incentivar as pessoas próximas a participarem também.

## Presentation of the project


## Support

Use [our community](https://discord.gg/rdXbEvjsWu) to ask questions about the process or send a message directly to a specialist in the platform chat.
- Don't forget the [.gitignore](https://www.toptal.com/developers/gitignore)
  
> This is a challenge by [Coodesh](https://coodesh.com/) and [Digiage](https://digiage.com.br) 

##
<p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java" />
    <img src="https://skillicons.dev/icons?i=eclipse" />
    <img src="https://skillicons.dev/icons?i=mysql" />
    <img src="https://skillicons.dev/icons?i=aws" />
    <img src="https://skillicons.dev/icons?i=grafana" />
  </a>
</p>
