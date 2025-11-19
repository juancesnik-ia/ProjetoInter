# ProjetoInter

ConfereAI v1.0 Enterprise 🚀

Sistema de Gestão de Estoque Completo e Integrado

O EstoquePro é uma aplicação web moderna, responsiva e independente (single-file) desenvolvida para gerenciamento profissional de inventário. Ele oferece controle total sobre produtos, fornecedores e categorias, com um painel financeiro em tempo real e ferramentas de Business Intelligence (BI).

✨ Funcionalidades Principais

📊 Dashboard Financeiro & BI

KPIs em Tempo Real: Acompanhe Valor Total de Venda, Lucro Projetado, Margem de Lucro e Volume de Itens instantaneamente.

Gráficos Interativos: Análise de tendência de movimentação (7 dias), distribuição por categoria e comparativo financeiro (Custo vs. Venda).

Feed de Atividades: Log visual das últimas entradas e saídas.

📦 Gestão de Produtos

Cadastro Completo: Nome, SKU, Categoria, Fornecedor, Preço de Custo, Preço de Venda e Estoque Mínimo.

Upload de Imagem: Suporte para imagens locais com pré-visualização.

Alertas Automáticos: Identificação visual imediata de produtos com estoque baixo ou esgotado.

Busca e Filtros: Pesquise por nome, SKU ou filtre por Categoria/Fornecedor específico.

🚚 Módulo de Fornecedores

Cadastro Detalhado: CNPJ (com máscara automática), Telefone, E-mail e Endereço completo (CEP, Rua, Bairro, Cidade, UF).

Integração Total: Vínculo direto entre fornecedores e produtos. Ao cadastrar um produto, o fornecedor já aparece na lista.

🛡️ Segurança e Dados

Backup e Restauração: Exporte todos os seus dados para um arquivo .json e restaure quando quiser. Nunca perca seu cadastro.

Persistência Local: Os dados são salvos automaticamente no navegador.

Histórico de Movimentações: Auditoria completa de todas as entradas, saídas e criações de produtos.

🎨 Interface e UX

Design Responsivo: Funciona perfeitamente em Desktops e Celulares (Menu Mobile incluso).

Modo Escuro (Dark Mode): Tema integrado com troca suave e persistência de preferência.

Máscaras de Input: Formatação automática para Moeda (R$), CNPJ, Telefone e CEP.

🛠️ Tecnologias Utilizadas

Este projeto foi construído com foco em performance e simplicidade de implantação (sem necessidade de backend complexo).

HTML5 & JavaScript (ES6+): Lógica de negócio, manipulação do DOM e persistência (localStorage).

Tailwind CSS (CDN): Estilização moderna, responsividade e sistema de cores.

Chart.js: Renderização dos gráficos de análise.

Google Fonts (Inter): Tipografia profissional.

🚀 Como Usar

Não é necessária instalação de servidores (Node.js, PHP, etc). O sistema é Client-Side.

Baixe o arquivo: Faça o download ou clone este repositório.

Abra o arquivo: Dê um duplo clique em index.html para abrir no seu navegador (Chrome, Edge, Firefox).

Comece a usar:

O sistema iniciará com dados de exemplo para demonstração.

Vá em "Restaurar Fábrica" no menu lateral se quiser limpar tudo e começar do zero.

Use o botão "Exportar" regularmente para salvar seus backups.

📂 Estrutura de Dados (JSON)

O sistema utiliza a seguinte estrutura para backup e persistência:

{
  "products": [
    { "id": 1, "name": "...", "sku": "...", "supplierId": 1, "quantity": 10, "costPrice": 50.00, "price": 100.00 }
  ],
  "suppliers": [
    { "id": 1, "name": "Fornecedor A", "cnpj": "...", "phone": "..." }
  ],
  "categories": ["Eletrônicos", "Vestuário"],
  "movements": [],
  "theme": "light"
}


🤝 Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests com melhorias de código, novas funcionalidades ou correções de bugs.

📄 Licença

Este projeto está sob a licença MIT. Sinta-se livre para usar e modificar para fins pessoais ou comerciais.
