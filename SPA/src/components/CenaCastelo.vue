<!-- src/components/CenaCastelo.vue -->
<template>
  <section class="cena castelo">
    <!-- Chão com o tapete -->
    <div class="chao"></div>
    <div class="tapete"></div>

    <!-- Trono no topo -->
    <img class="trono" src="/castelo/Trono.png" alt="Trono" />

    <!-- Nome em cima do trono -->
    <h1 class="nome">João Pedro</h1>

    <!-- Estandartes ao lado do trono -->
    <img class="banner banner-esq" src="/castelo/Banner.png" alt="" />
    <img class="banner banner-dir" src="/castelo/Banner.png" alt="" />

    <!-- Janelas -->
    <img class="janela janela-esq" src="/castelo/Janela.png" alt="" />
    <img class="janela janela-dir" src="/castelo/Janela.png" alt="" />

    <!-- Colunas e tochas (2 pares) -->
    <template v-for="pos in [30, 65]" :key="pos">
      <img class="coluna coluna-esq" :style="{ top: pos + '%' }" src="/castelo/Coluna.png" alt="" />
      <img class="coluna coluna-dir" :style="{ top: pos + '%' }" src="/castelo/Coluna.png" alt="" />
      <img class="tocha tocha-esq" :style="{ top: pos - 8 + '%' }" src="/castelo/Tocha.png" alt="" />
      <img class="tocha tocha-dir" :style="{ top: pos - 8 + '%' }" src="/castelo/Tocha.png" alt="" />
    </template>

    <!-- Portão no final (saída pra cidade) -->
    <img class="portao" src="/castelo/Portão.jpg" alt="Portão" />
  </section>
</template>

<style scoped>
.cena {
  position: relative;
  min-height: 130vh;
  overflow: hidden;
  image-rendering: pixelated;
}

img {
  position: absolute;
  image-rendering: pixelated;
}

/* ---------- FUNDO ---------- */
/* Parede ocupa a cena inteira, o chão cobre a parte de baixo */
.castelo {
  background-image: url('/castelo/Parede_Pedra.jpg');
  background-size: 96px;
  background-repeat: repeat;
}

.chao {
  position: absolute;
  top: 22%;
  left: 0;
  right: 0;
  bottom: 0;
  background-image: url('/castelo/Chão_Pedra.jpg');
  background-size: 64px;
  background-repeat: repeat;
  /* sombra na junção parede/chão */
  box-shadow: inset 0 20px 30px -10px rgba(0, 0, 0, 0.6);
}

/* ---------- TAPETE ---------- */
.tapete {
  position: absolute;
  top: 18%;
  bottom: 0;
  left: 50%;
  transform: translateX(-50%);
  width: 160px;
  background-image: url('/castelo/Tapete.jpg');
  background-size: 160px;
  background-repeat: repeat-y;
}

/* ---------- TRONO E NOME ---------- */
.trono {
  top: 4%;
  left: 50%;
  transform: translateX(-50%);
  width: 192px; /* 64px × 3 */
  z-index: 2;
}

.nome {
  position: absolute;
  top: 28%;
  left: 50%;
  transform: translateX(-50%);
  z-index: 3;
  color: #e0b040;
  font-size: 2.5rem;
  text-shadow: 3px 3px 0 #000;
  white-space: nowrap;
}

/* ---------- DECORAÇÃO ---------- */
.banner   { top: 2%; width: 96px; }
.banner-esq { left: calc(50% - 260px); }
.banner-dir { left: calc(50% + 164px); }

.janela   { top: 3%; width: 144px; }
.janela-esq { left: 6%; }
.janela-dir { right: 6%; }

.coluna   { width: 96px; transform: translateY(-50%); z-index: 1; }
.coluna-esq { left: calc(50% - 280px); }
.coluna-dir { left: calc(50% + 184px); }

.tocha    { width: 48px; z-index: 2; filter: drop-shadow(0 0 12px #ff9a3c); }
.tocha-esq { left: calc(50% - 232px); }
.tocha-dir { left: calc(50% + 184px); }

/* ---------- PORTÃO ---------- */
.portao {
  bottom: 0;
  left: 50%;
  transform: translateX(-50%);
  width: 288px; /* 96px × 3 */
  z-index: 2;
}

/* ---------- CELULAR ---------- */
@media (max-width: 700px) {
  .janela, .banner, .coluna, .tocha { display: none; }
  .nome { font-size: 1.6rem; }
  .trono { width: 128px; }
}
</style>