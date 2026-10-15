<!--
  ============================================================================
  App.vue
  ----------------------------------------------------------------------------
  Este é o componente RAIZ de toda a aplicação — o "pai de todos". Todo
  arquivo .vue da sua aplicação, de um jeito ou de outro, acaba aparecendo
  dentro dele.

  Repara que ele é bem pequeno: praticamente só existe pra dizer "aqui é
  onde a página atual (seja ela qual for) deve aparecer" através do
  <RouterView />, e pra guardar estilos GLOBAIS (que valem pro site inteiro),
  como a fonte "Star Jedi" e o reset básico de margem/padding do navegador.
  ============================================================================
-->

<script setup lang="ts">
// RouterView é um componente especial do Vue Router: ele funciona como uma
// "moldura" que troca automaticamente de conteúdo dependendo da URL atual.
// Se a URL é "/welcome", o RouterView mostra a WelcomeView; se é "/home",
// mostra a HomeView — sem precisar de nenhum "if" manual nosso.
import { RouterView } from 'vue-router'
</script>

<template>
  <main>
    <RouterView /> 
  </main>
</template>

<style>
/* Este <style> aqui NÃO tem o atributo "scoped" (ao contrário dos outros
   arquivos do projeto). Isso é proposital: significa que este CSS é
   GLOBAL, ou seja, vale para o site inteiro, não só para este arquivo. */

/* @font-face é como a gente "cadastra" uma fonte customizada pra poder
   usar ela em qualquer lugar do CSS (ex: font-family: 'Star Jedi').
   O arquivo .ttf precisa estar em public/fonts/ pra esse caminho funcionar. */
@font-face {
  font-family: 'Star Jedi';
  src: url('/fonts/Starjedi.ttf') format('truetype');
  font-weight: normal;
  font-style: normal;
}

/* Reset básico: todo navegador aplica uma margem/padding padrão em html e
   body sem a gente pedir. Aqui zeramos isso, pra ter controle total do
   espaçamento nós mesmos, em vez de depender do "padrão" de cada navegador. */
html, body {
  margin: 0;
  padding: 0;
  width: 100%;
  min-height: 100vh;
  background-color: #111111;
  overflow-x: hidden; /* impede que qualquer coisa "vaze" pros lados e crie barra de rolagem horizontal */
}

#app {
  margin: 0;
  padding: 0;
  width: 100%;
  min-height: 100vh;
}
</style>