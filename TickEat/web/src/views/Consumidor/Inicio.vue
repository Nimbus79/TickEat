<template>
  <v-app>
    <Header titulo="PÁGINA INICIAL" />
    <v-content>
      <section class="row">
        <div class="col-12">
          <div class="m-3">
            <b-card-group deck>
              <b-card border-variant="light" id="card">
                <div class="row">
                  <div
                    class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    style="text-align: left;"
                  >
                    <h3 class="text-uppercase" style="color: black;">PREVISÕES DA PRÓXIMA REFEIÇÃO</h3>
                  </div>

                  <div
                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                    style="text-align: left;"
                  >
                    <h5 class="text-uppercase" style="color: black;">PREVISÕES DA PRÓXIMA REFEIÇÃO</h5>
                  </div>
                </div>
                <b-card-text>
                  <v-carousel
                    height="100%;"
                    v-model="model1"
                    :show-arrows="showArrows"
                    :hide-delimiters="hideDelimiters"
                    :cycle="cycle"
                  >
                    <v-carousel-item v-for="cantina in cantinas" :key="cantina.cantinaNome">
                      <v-sheet color="white" height="100%" tile>
                        <div class="fill-height mt-auto mb-auto" align="center" justify="center">
                          <h3
                            class="text-uppercase"
                            style="color: #87132a; font-weight: 1000;"
                          >{{ cantina.cantinaNome }}</h3>
                          <h5
                            v-if="cantina.refeicaoNome && cantina.data"
                            class="text-uppercase"
                            style="color: black; font-weight: 100;"
                          >{{ cantina.refeicaoNome }} {{ cantina.data }}</h5>

                          <div v-if="cantina.previsaoGeral >= 0">
                            <h1
                              v-if="!cantina.aDecorrer"
                              style="padding-top: 10px; color:#87132a;"
                            >{{ cantina.previsaoGeral }}</h1>

                            <h1 v-else style="padding-top: 10px; color:#87132a;">
                              {{ cantina.previsaoGeral-cantina.contagemValidados }}
                              <span
                                style="font-size:0.8em;"
                              >/ {{ cantina.previsaoGeral }}</span>
                            </h1>
                          </div>

                          <div v-else>
                            <h5
                              style="padding-top: 10px; color:#87132a;"
                            >Não existem refeições para breve.</h5>
                          </div>
                        </div>
                      </v-sheet>
                    </v-carousel-item>
                  </v-carousel>
                </b-card-text>
              </b-card>

              <b-card border-variant="light" id="card">
                <div class="row">
                  <div
                    class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    style="text-align: left;"
                  >
                    <h3 class="text-uppercase" style="color: black;">ESTADO DA FILA</h3>
                  </div>
                  <div
                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                    style="text-align: left;"
                  >
                    <h5 class="text-uppercase" style="color: black;">ESTADO DA FILA</h5>
                  </div>
                </div>
                <b-card-text>
                  <v-carousel
                    height="100%;"
                    v-model="model2"
                    :show-arrows="showArrows"
                    :hide-delimiters="hideDelimiters"
                    :cycle="cycle"
                  >
                    <v-carousel-item v-for="cantina in cantinas" :key="cantina.cantinaNome">
                      <v-sheet color="white" height="100%" tile>
                        <div class="fill-height" align="center" justify="center">
                          <h3
                            class="text-uppercase"
                            style="color: #87132a; font-weight: 1000;"
                          >{{ cantina.cantinaNome }}</h3>

                          <div v-if="cantina.aDecorrer">
                            <h5
                              class="text-uppercase"
                              style="color: black; font-weight: 100;"
                            >{{ cantina.refeicaoNome }} {{ cantina.data }}</h5>

                            <h1 style="padding-top: 10px; color:#87132a;">{{ cantina.estadoFila }}</h1>
                          </div>

                          <div v-else>
                            <h5 style="padding-top: 10px; color:#87132a;">A cantina está encerrada.</h5>
                          </div>
                        </div>
                      </v-sheet>
                    </v-carousel-item>
                  </v-carousel>
                </b-card-text>
              </b-card>
            </b-card-group>

            <b-card-group deck class="mt-3">
              <b-card border-variant="light" id="card">
                <div class="row">
                  <div
                    class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    style="text-align: left;"
                  >
                    <h3 class="text-uppercase pb-2" style="color: black;">SALDO</h3>
                  </div>
                  <div
                    class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    style="text-align: left;"
                  >
                    <h5 class="text-uppercase" style="color: black; font-weight: 100;">Disponível</h5>
                    <h4 class="text-uppercase" style="color: #87132a;">{{ saldoDisponivel }}€</h4>
                  </div>
                  <div
                    class="col-12 mt-2 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    style="text-align: left;"
                  >
                    <h5
                      class="text-uppercase"
                      style="color: black; font-weight: 100;"
                    >Contabilístico</h5>
                    <h4 class="text-uppercase" style="color: #87132a;">{{ saldoContabilistico }}€</h4>
                  </div>

                  <div
                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                    style="text-align: left;"
                  >
                    <h4 class="text-uppercase pb-2" style="color: black;">SALDO</h4>
                    <h6 class="text-uppercase" style="color: black; font-weight: 100;">Disponível</h6>
                    <h5 style="color: #87132a;">{{ saldoDisponivel }}€</h5>
                    <h6
                      class="mt-4 text-uppercase"
                      style="color: black; font-weight: 100;"
                    >Contabilístico</h6>
                    <h5 style="color: #87132a;">{{ saldoContabilistico }}€</h5>
                  </div>
                </div>
              </b-card>

              <b-card border-variant="light" id="card">
                <GraficosMonetarios />
              </b-card>
            </b-card-group>
          </div>
        </div>
      </section>
    </v-content>
  </v-app>
</template>

<script>
import Header from "@/components/HeaderConsumidor.vue";
import GraficosMonetarios from "@/components/GraficosMonetarios.vue";

export default {
  name: "inicio",
  data: function() {
    return {
      cantinas: [],
      model1: 0,
      model2: 0,
      showArrows: true,
      hideDelimiters: true,
      cycle: false,
      saldoDisponivel: "",
      saldoContabilistico: ""
    };
  },
  components: {
    Header,
    GraficosMonetarios
  },
  mounted: async function() {
    const response = await fetch(
      "http://localhost:8080/tickeat_war_exploded/InicioConsumidor",
      {
        headers: {
          "Content-Type": "application/json; charset=utf-8"
        },
        credentials: "include",
        method: "GET"
      }
    );
    response.json().then(json => {
      if (json.success) {
        this.cantinas = json.paginaInicial;
        /* eslint-disable no-console */
        console.log(this.cantinas);
        /* eslint-enable no-console */
      } else {
        window.location.href = "http://localhost:3000/";
      }
    });
    const response2 = await fetch(
      "http://localhost:8080/tickeat_war_exploded/Saldos",
      {
        headers: {
          "Content-Type": "application/json; charset=utf-8"
        },
        credentials: "include",
        method: "GET"
      }
    );
    response2.json().then(json => {
      if (json.success) {
        this.saldoDisponivel = json.carteira.saldoDisponivel;
        this.saldoContabilistico = json.carteira.saldoContabilistico;
      } else {
        window.location.href = "http://localhost:3000/";
      }
    });
  }
};
</script>