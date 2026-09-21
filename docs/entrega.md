# Material de Entrega DevSecOps

**Disciplina:** Segurança da Informação  
**Atividade:** Shift Left e Shift Right em pipelines de CI/CD  
**Repositório:** [gustavorieg/si08-atividade-baron](https://github.com/gustavorieg/si08-atividade-baron)  
**Pull Request:** [PR #1](https://github.com/gustavorieg/si08-atividade-baron/pull/1)  
**Autores:** Gustavo Rieg e Gustavo Fantoni do Rosário

## Documentos

- [Parte 1 — Pesquisa teórica](documentos/Parte1-Pesquisa-Teorica-ShiftLeft-ShiftRight.docx)
- [Discussão final Shift Left e Shift Right](documentos/Discussao-Final-ShiftLeft-ShiftRight.docx)
- O documento da Parte 1 já contém o diagrama autoral da linha do tempo Shift Left → Shift Right.

## Evidências dos gates

As imagens estão organizadas em [evidencias/actions](evidencias/actions). Os links levam diretamente às execuções do GitHub Actions para permitir a conferência do log completo.

| Ordem | Gate | Evidência | Execução/job |
|---:|---|---|---|
| 1 | Secret scan | Print original `erro 1.png` deve ser anexado separadamente, fora do Git | [Gitleaks](https://github.com/gustavorieg/si08-atividade-baron/actions/runs/35665205400/job/106549290285) |
| 2 | Unit tests | [02-unit-tests-falha.png](evidencias/actions/02-unit-tests-falha.png) | [Maven](https://github.com/gustavorieg/si08-atividade-baron/actions/runs/35665335418/job/106549764314) |
| 3 | SAST | [03-sast-falha.png](evidencias/actions/03-sast-falha.png) | [Semgrep](https://github.com/gustavorieg/si08-atividade-baron/actions/runs/35665443171/job/106550219504) |
| 4 | SCA | [04-sca-falha.png](evidencias/actions/04-sca-falha.png) | [Trivy](https://github.com/gustavorieg/si08-atividade-baron/actions/runs/35665688332/job/106551073582) |
| 5 | Dockerfile lint | [05-dockerfile-lint-falha.png](evidencias/actions/05-dockerfile-lint-falha.png) | [Hadolint](https://github.com/gustavorieg/si08-atividade-baron/actions/runs/35665912860/job/106551749035) |

## Resumo da pipeline

- [Pipeline bloqueada](evidencias/actions/06-security-summary-bloqueado.png): mostra `Resultado geral: BLOQUEADO`.
- [Pipeline liberada](evidencias/actions/07-security-summary-liberado.png): mostra todos os cinco gates verdes e `Resultado geral: LIBERADO`.
- [Execução em andamento](evidencias/actions/08-actions-em-execucao.png): registro complementar do acompanhamento do Actions.

## Evidências da aplicação

As telas locais estão em [evidencias/aplicacao](evidencias/aplicacao):

- [Resultado antes da correção](evidencias/aplicacao/09-api-desconto-antes.png)
- [Resultado corrigido](evidencias/aplicacao/10-api-desconto-corrigido.png)
- [Endpoint health](evidencias/aplicacao/11-health.png)
- [Testes Maven verdes](evidencias/aplicacao/12-maven-testes-verdes.png)

## Estado da entrega prática

Os cinco gates de segurança foram exercitados individualmente e as alterações temporárias usadas para provocar as falhas foram removidas da branch final. A base segura do código é o commit `3d649ad`, e a documentação organizada foi adicionada em commits posteriores, todos assinados por Gustavo Fantoni.

O print original do `secret-scan` não foi versionado porque contém o valor de demonstração exibido pelo Gitleaks. A atividade orienta a não copiar esse valor para nenhum arquivo do repositório; por isso, o arquivo `erro 1.png` deve ser enviado como anexo separado junto com a entrega.

Na execução da PR, o job `build-and-push` aparece como pulado porque o workflow publica a imagem somente em um `push` para a branch `main`. Para concluir os itens de publicação da atividade, é necessário fazer o merge da PR, capturar a execução no `main` com `Build e Push da Imagem (GHCR)` verde e anexar também o print do pacote publicado em `Packages`.
