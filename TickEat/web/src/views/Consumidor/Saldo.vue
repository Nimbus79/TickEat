<template>
  <v-app>
    <Header titulo="SALDO" />
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

                <b-card-text
                  class="text-center d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                >
                  <button
                    type="button"
                    class="redbtn mt-4"
                    v-on:click="carregar()"
                    style="width: 15em; font-size: 1.2em;"
                  >FAZER CARREGAMENTO</button>
                </b-card-text>
                <b-card-text class="text-center d-none d-sm-block d-md-none d-block d-sm-none">
                  <button
                    type="button"
                    class="redbtn mt-4"
                    v-on:click="carregar()"
                    style="width: 12em; font-size: 1em;"
                  >FAZER CARREGAMENTO</button>
                </b-card-text>
              </b-card>

              <b-card border-variant="light" id="card">
                <GraficosMonetarios />
              </b-card>
            </b-card-group>
          </div>
        </div>
      </section>

      <section class="row">
        <div class="col-12">
          <div class="m-3">
            <b-card border-variant="light" id="card">
              <div class="row">
                <div class="col-12" style="text-align: left;">
                  <h3 class="text-uppercase pb-2" style="color: black;">MOVIMENTOS</h3>
                </div>
              </div>

              <b-card-text>
                <v-timeline dense>
                  <div v-for="(item, index) in movimentos" :key="index">
                    <v-timeline-item
                      v-if="movimentos[index].efetuado==0 && movimentos[index].nome=='Carregamento'"
                      color="#F4C52C"
                      fill-dot
                      icon="fa fa-plus"
                    >
                      <v-card class="elevation-2">
                        <div class="row">
                          <div
                            class="col-xl-6 col-lg-6 col-md-6 col-sm-12"
                            style="text-align: left;"
                          >
                            <v-card-title
                              @click="consultarCarregamento(movimentos[index].id)"
                              style="font-weight:1000; font-size: 1.3em; color: black; cursor: pointer;"
                            >{{ movimentos[index].nome }}</v-card-title>
                            <v-card-text
                              style="font-weight:100; font-size: 1.2em; color: black;"
                            >{{ movimentos[index].evento.metodo }}</v-card-text>
                            <v-card-text
                              style="font-weight:1000; font-size: 1.3em; color: grey;"
                            >+{{ movimentos[index].valor }}€</v-card-text>
                          </div>

                          <div
                            class="col-xl-6 col-lg-6 col-md-6 col-sm-12"
                            style="text-align: right;"
                          >
                            <v-card-text
                              style="font-weight:100; font-size: 1em; color: black;"
                            >{{ movimentos[index].timestamp }}</v-card-text>
                            <v-card-text
                              class="text-uppercase"
                              style="font-weight:1000; font-size: 1em; color: black;"
                              v-if="movimentos[index].efetuado==0"
                            >Pendente</v-card-text>
                            <v-card-text
                              class="text-uppercase"
                              style="font-weight:1000; font-size: 1em; color: black;"
                              v-else
                            >Efetuado</v-card-text>
                            <v-card-text
                              style="font-weight:1000; font-size: 1.2em; color: #87132a;"
                            >+{{ movimentos[index].saldoResultante }}€</v-card-text>
                          </div>
                        </div>
                      </v-card>
                    </v-timeline-item>

                    <v-timeline-item
                      v-if="movimentos[index].efetuado==1 && movimentos[index].nome=='Carregamento'"
                      color="#13872E"
                      fill-dot
                      icon="fa fa-plus"
                    >
                      <v-card class="elevation-2">
                        <div class="row">
                          <div
                            class="col-xl-6 col-lg-6 col-md-6 col-sm-12"
                            style="text-align: left;"
                          >
                            <v-card-title
                              @click="consultarCarregamento(movimentos[index].id)"
                              style="font-weight:1000; font-size: 1.3em; color: black; cursor: pointer;"
                            >{{ movimentos[index].nome }}</v-card-title>
                            <v-card-text
                              style="font-weight:100; font-size: 1.2em; color: black;"
                            >{{ movimentos[index].evento.metodo }}</v-card-text>
                            <v-card-text
                              style="font-weight:1000; font-size: 1.3em; color: grey;"
                            >+{{ movimentos[index].valor }}€</v-card-text>
                          </div>

                          <div
                            class="col-xl-6 col-lg-6 col-md-6 col-sm-12"
                            style="text-align: right;"
                          >
                            <v-card-text
                              style="font-weight:100; font-size: 1em; color: black;"
                            >{{ movimentos[index].timestamp }}</v-card-text>
                            <v-card-text
                              class="text-uppercase"
                              style="font-weight:1000; font-size: 1em; color: black;"
                              v-if="movimentos[index].efetuado==0"
                            >Pendente</v-card-text>
                            <v-card-text
                              class="text-uppercase"
                              style="font-weight:1000; font-size: 1em; color: black;"
                              v-else
                            >Efetuado</v-card-text>
                            <v-card-text
                              style="font-weight:1000; font-size: 1.2em; color: #87132a;"
                            >+{{ movimentos[index].saldoResultante }}€</v-card-text>
                          </div>
                        </div>
                      </v-card>
                    </v-timeline-item>

                    <v-timeline-item
                      v-if="movimentos[index].efetuado==1 && movimentos[index].nome!='Carregamento'"
                      color="#13872E"
                      fill-dot
                      icon="fa fa-minus"
                    >
                      <v-card class="elevation-2">
                        <div class="row">
                          <div
                            class="col-xl-6 col-lg-6 col-md-6 col-sm-12"
                            style="text-align: left;"
                          >
                            <v-card-title
                              v-if="movimentos[index].nome=='Reserva'"
                              @click="consultarRefeicao(movimentos[index].evento.refeicao.refeicaoId, movimentos[index].evento.refeicao.cantinaId)"
                              style="font-weight:1000; font-size: 1.3em; color: black; cursor: pointer;"
                            >{{ movimentos[index].nome }}</v-card-title>
                            <v-card-title
                              v-else
                              style="font-weight:1000; font-size: 1.3em; color: black; cursor: pointer;"
                            >{{ movimentos[index].nome }}</v-card-title>
                            <v-card-text
                              style="font-weight:100; font-size: 1.2em; color: black; cursor: pointer;"
                              v-if="movimentos[index].nome=='Reserva'"
                            >{{ movimentos[index].evento.refeicao.refeicaoNome + ' ' + movimentos[index].evento.refeicao.data }}</v-card-text>
                            <v-card-text
                              style="font-weight:1000; font-size: 1.3em; color: grey;"
                            >-{{ movimentos[index].valor }}€</v-card-text>
                          </div>

                          <div
                            class="col-xl-6 col-lg-6 col-md-6 col-sm-12"
                            style="text-align: right;"
                          >
                            <v-card-text
                              style="font-weight:100; font-size: 1em; color: black;"
                            >{{ movimentos[index].timestamp }}</v-card-text>
                            <v-card-text
                              class="text-uppercase"
                              style="font-weight:1000; font-size: 1em; color: black;"
                              v-if="movimentos[index].efetuado==0"
                            >Pendente</v-card-text>
                            <v-card-text
                              class="text-uppercase"
                              style="font-weight:1000; font-size: 1em; color: black;"
                              v-else
                            >Efetuado</v-card-text>
                            <v-card-text
                              style="font-weight:1000; font-size: 1.2em; color: #87132a;"
                            >+{{ movimentos[index].saldoResultante }}€</v-card-text>
                          </div>
                        </div>
                      </v-card>
                    </v-timeline-item>

                    <v-timeline-item
                      v-if="movimentos[index].efetuado==0 && movimentos[index].nome!='Carregamento'"
                      color="#F4C52C"
                      fill-dot
                      icon="fa fa-minus"
                    >
                      <v-card class="elevation-2">
                        <div class="row">
                          <div
                            class="col-xl-6 col-lg-6 col-md-6 col-sm-12"
                            style="text-align: left;"
                          >
                            <v-card-title
                              v-if="movimentos[index].nome=='Reserva'"
                              @click="consultarRefeicao(movimentos[index].evento.refeicao.refeicaoId, movimentos[index].evento.refeicao.cantinaId)"
                              style="font-weight:1000; font-size: 1.3em; color: black; cursor: pointer;"
                            >{{ movimentos[index].nome }}</v-card-title>
                            <v-card-title
                              v-else
                              style="font-weight:1000; font-size: 1.3em; color: black;"
                            >{{ movimentos[index].nome }}</v-card-title>
                            <v-card-text
                              style="font-weight:100; font-size: 1.2em; color: black; cursor: pointer;"
                              v-if="movimentos[index].nome=='Reserva'"
                            >{{ movimentos[index].evento.refeicao.refeicaoNome + ' ' + movimentos[index].evento.refeicao.data }}</v-card-text>
                            <v-card-text
                              style="font-weight:1000; font-size: 1.3em; color: grey;"
                            >-{{ movimentos[index].valor }}€</v-card-text>
                          </div>

                          <div
                            class="col-xl-6 col-lg-6 col-md-6 col-sm-12"
                            style="text-align: right;"
                          >
                            <v-card-text
                              style="font-weight:100; font-size: 1em; color: black;"
                            >{{ movimentos[index].timestamp }}</v-card-text>
                            <v-card-text
                              class="text-uppercase"
                              style="font-weight:1000; font-size: 1em; color: black;"
                              v-if="movimentos[index].efetuado==0"
                            >Pendente</v-card-text>
                            <v-card-text
                              class="text-uppercase"
                              style="font-weight:1000; font-size: 1em; color: black;"
                              v-else
                            >Efetuado</v-card-text>
                            <v-card-text
                              style="font-weight:1000; font-size: 1.2em; color: #87132a;"
                            >+{{ movimentos[index].saldoResultante }}€</v-card-text>
                          </div>
                        </div>
                      </v-card>
                    </v-timeline-item>
                  </div>
                </v-timeline>
              </b-card-text>
            </b-card>
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
  name: "saldo",
  data: function() {
    return {
      saldoDisponivel: "",
      saldoContabilistico: "",
      movimentos: []
    };
  },
  components: {
    Header,
    GraficosMonetarios
  },
  mounted: async function() {
    const response = await fetch(
      "http://localhost:8080/tickeat_war_exploded/Saldos",
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
        this.movimentos = json.carteira.movimentos;
        this.saldoDisponivel = json.carteira.saldoDisponivel;
        this.saldoContabilistico = json.carteira.saldoContabilistico;
      } else {
        window.location.href = "http://localhost:3000/";
      }
    });
  },
  methods: {
    consultarCarregamento: function(id) {
      this.$router.push("/carregamento?car=" + id);
    },
    consultarRefeicao: function(ref, cant) {
      this.$router.push("/refeicao?ref=" + ref + "&cant=" + cant);
    },
    carregar: function() {
      this.$router.push("/carregar");
    }
  }
};
</script>