Descrição geral: Aplicação Java/Hibernate/JPA para gerenciamento de pacientes, consultas médicas, internações e exames em uma clínica médica.

Arquitetura: camada de negócios usando Java/Hibernate/JPA e camada de dados usando Oracle SQL Developer.

Modelo de dados: Tabelas Paciente, Consulta, Médico, Internação e Exame, com relacionamentos de um para muitos entre as tabelas TB_PACIENTE e TB_CONSULTA, e a tabela TB_MEDICO e TB_CONSULTA formando assim a entidade associativa TB_CONSULTA; TB_PACIENTE com relacionamento de um para muitos com a tabela TB_EXAME, TB_MEDICO e TB_EXAME com relacionamento de um para muitos, e por fim a tabela TB_CONSULTA com a TB_INTERNACAO com relacionamento de um para muitos.

Componentes: Classes Java principais para lógica de negócios e classes de mapeamento objeto-relacional para mapeamento de entidades Java para as tabelas do banco de dados.

Funcionalidades: Criação de novos pacientes, registro de consultas médicas, registro de internações e registro de novos exames.

Requisitos de sistema: Sistema operacional, servidor de aplicação, banco de dados Oracle SQL Developer e outras dependências de software.