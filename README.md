# PicPay - Desafio Android

Para cada um dos problemas apresentados uma solução independente foi pensada.

## Mudanças de configuração de tela

    Para evitar com que a mudança de configuração de tela fizesse com que os dados fossem perdidos,
    utizou-se da prática de SSOT (Single Source of Truth), utilizando o banco de dados local para
    emitir dados salvos e fazendo com que, em paralelo, estes dados sejam atualizados através da api.

## Campos que não deveriam ser nulos sendo nulos e gerenciamento de lifecycle.

    No modelo de transferência de dados, o campo `img`, que poderia ser nulo estava como não nulo,
    isso foi corrigido utilizando `Null Safety`. Na tela de contatos, os dados estavam sendo solicitados da api dentro da
    callback de lifecycle `onResume`, fazendo com que os dados sempre fossem re-solicitados em qualquer
    mudança de configuração ou caso o usuário saisse da tela e retornasse. Assim, junto so SSOT, esta
    chamada foi movida para o `onViewCreated`, já que as soluções de visualização estabelecidas para
    o projeto utilizam `Fragments`.

## Gostaríamos de cachear os dados retornados pelo servidor.

    Utilizando `Room`, os dados agora são cacheados no banco de dados local

## Haverá mudanças na lógica de negócios e gostaríamos que a arquitetura reaja bem a isso.

    Para resolver esta necessidade, a aplicão de alguns padrões foi necessária. Agora, o app
    está utilizando Feature Modules e Clean Architecture, tendo suas soluções e camadas muito
    bem definidas, facilitando mudanças na regra de negócio e fazendo com que essa mudança
    seja refletida em todo o app.

## Haverá mudanças na lógica de apresentação. Gostaríamos que a arquitetura reaja bem a isso.

    Há diversas ferramentas no mercado que ajudam neste tipo de solução, assim como alguns padrões.
    Para tal, foi utilizado o padrão MVVM e Programação Reativa com RxJava e RxAndroid.

    Ainda, alguns componentes do Android Architecture Components foram adicionados, são eles:

    - ViewModel -> Para manter um estado independente do ciclo de vida e separar a lógica de solicitação
    de dados para apresentação;

    - LiveData -> Utilizado para lidar de maneira reativa com os estados dos componentes de visualização.

## Testes Unitários

    No módulo `feature:home`, onde há regras de negócio definidas para o app, todas as camadas foram
    testadas de acordo com o necessário.

## Testes de Instrumentação

    Devido a simplicidade do fluxo, e não haver interações diretas do usuário com a aplicação, além
    do scroll da listagem, o único teste instrumentado considerado foi o de banco de dados.
