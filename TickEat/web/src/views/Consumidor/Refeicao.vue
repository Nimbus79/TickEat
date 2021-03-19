<template>
  <v-app>
    <Header titulo="REFEIÇÃO" />
    <v-content>
      <section class="row">
        <div class="col-12">
          <div class="m-3">
            <b-card-group deck>
              <b-card border-variant="light" id="card">
                <div class="row">
                  <div
                    class="col-6 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    style="text-align: left;"
                  >
                    <h3 class="text-uppercase" style="color: black;">{{ refeicao.cantinaNome }}</h3>
                    <h5
                      class="text-uppercase"
                      style="color: black; font-weight: 100;"
                    >{{ refeicao.refeicaoNome }}</h5>
                  </div>
                  <div
                    class="col-6 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    style="text-align: right;"
                  >
                    <h3 class="text-uppercase" style="color: black;">{{ refeicao.diaDaSemana }}</h3>
                    <h5
                      class="text-uppercase"
                      style="color: black; font-weight: 100;"
                    >{{ refeicao.data }}</h5>
                  </div>
                  <div
                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                    style="text-align: left;"
                  >
                    <h5 class="text-uppercase" style="color: black;">{{ refeicao.cantinaNome }}</h5>
                    <h6
                      class="text-uppercase"
                      style="color: black; font-weight: 100;"
                    >{{ refeicao.refeicaoNome }}</h6>

                    <h5 class="text-uppercase" style="color: black;">{{ refeicao.diaDaSemana }}</h5>
                    <h6 style="color: black; font-weight: 100;">{{ refeicao.data }}</h6>
                  </div>
                  <div v-if="refeicao.reservada" class="col-12" style="text-align: left;">
                    <h6 class="text-uppercase" style="color: #87132a;">
                      <b>Ementa Selecionada:&nbsp;</b>
                      <span
                        v-for="(item3, index3) in refeicao.ementaSelecionada"
                        v-bind:key="index3"
                      >
                        <span v-if="index3!=0">,&nbsp;</span>
                        {{ refeicao.ementaSelecionada[index3].comida }}
                      </span>
                    </h6>
                    <h6
                      class="text-uppercase"
                      style="color: black; font-weight: 100;"
                    >{{ refeicao.preco }}€</h6>
                  </div>
                </div>

                <b-card-text v-if="refeicao.reservada && refeicao.passou==false">
                  <div class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block">
                    <div class="row">
                      <div class="col-6">
                        <div class="text-center p-3">
                          <button
                            type="button"
                            class="lightredbtn"
                            v-on:click="editarRefeicao()"
                            style="width: 15em; font-size: 1em;"
                          >EDITAR REFEIÇÃO</button>
                        </div>
                      </div>
                      <div class="col-6">
                        <div class="text-center p-3">
                          <button
                            type="button"
                            class="redbtn"
                            @click="$bvModal.show('cancelar')"
                            style="width: 15em; font-size: 1em;"
                          >CANCELAR REFEIÇÃO</button>
                        </div>
                      </div>
                    </div>
                  </div>

                  <b-alert v-if="erro" variant="danger" show>{{ erro }}</b-alert>

                  <div class="d-none d-sm-block d-md-none d-block d-sm-none">
                    <div class="row">
                      <div class="col-12">
                        <div class="text-center p-3">
                          <button
                            type="button"
                            class="lightredbtn"
                            v-on:click="editarRefeicao()"
                            style="width: 12em; font-size: 0.8em;"
                          >EDITAR REFEIÇÃO</button>
                        </div>
                        <div class="text-center p-3">
                          <button
                            type="button"
                            class="redbtn"
                            @click="$bvModal.show('cancelar')"
                            style="width: 12em; font-size: 0.8em;"
                          >CANCELAR REFEIÇÃO</button>
                        </div>
                      </div>
                    </div>
                  </div>
                </b-card-text>

                <b-modal id="cancelar" hide-footer>
                  <template v-slot:modal-title>CANCELAR RESERVA</template>
                  <div class="row">
                    <div class="col-12 text-center">
                      <h6>Tem a certeza que pretende cancelar a reserva desta refeição?</h6>
                    </div>
                  </div>
                  <div class="d-block text-center">
                    <button
                      v-on:click="cancelarRefeicao()"
                      type="button"
                      class="lightredbtn m-2"
                      style="width: 12em; font-size: 0.8em;"
                    >CONFIRMAR</button>
                  </div>
                </b-modal>

                <b-card-text v-if="refeicao.reservada==false && refeicao.passou==false">
                  <div
                    class="text-center p-3 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                  >
                    <button
                      type="button"
                      class="redbtn"
                      v-on:click="adquirirRefeicao()"
                      style="width:15em;"
                    >ADQUIRIR REFEIÇÃO</button>
                  </div>

                  <div class="text-center p-3 d-none d-sm-block d-md-none d-block d-sm-none">
                    <button
                      type="button"
                      class="redbtn"
                      v-on:click="adquirirRefeicao()"
                      style="width:10em; font-size: 1em;"
                    >ADQUIRIR REFEIÇÃO</button>
                  </div>
                </b-card-text>

                <b-card-text v-if="refeicao.reservada && refeicao.passou && !refeicao.avaliada">
                  <div
                    class="text-center p-3 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                  >
                    <button
                      type="button"
                      class="redbtn"
                      v-on:click="avaliarRefeicao()"
                      style="width:15em;"
                    >AVALIAR REFEIÇÃO</button>
                  </div>

                  <div class="text-center p-3 d-none d-sm-block d-md-none d-block d-sm-none">
                    <button
                      type="button"
                      class="redbtn"
                      v-on:click="avaliarRefeicao()"
                      style="width:10em; font-size: 1em;"
                    >AVALIAR REFEIÇÃO</button>
                  </div>
                </b-card-text>
              </b-card>

              <b-card border-variant="light" id="card">
                <div class="row">
                  <div
                    class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    style="text-align: left;"
                  >
                    <h3 style="color: black;">PESSOAS ESPERADAS</h3>
                  </div>
                  <div
                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                    style="text-align: left;"
                  >
                    <h5 style="color: black;">PESSOAS ESPERADAS</h5>
                  </div>
                </div>
                <b-card-text v-if="refeicao.aDecorrer">
                  <div class="text-center p-3">
                    <h1 style="padding-top: 10px; color:#87132a;">
                      {{ refeicao.previsaoGeral-refeicao.contagemValidados }}
                      <span
                        style="font-size:0.8em;"
                      >/ {{ refeicao.previsaoGeral }}</span>
                    </h1>
                  </div>
                </b-card-text>
                <b-card-text v-else>
                  <div class="text-center p-3">
                    <h1 style="padding-top: 10px; color:#87132a;">{{ refeicao.previsaoGeral }}</h1>
                  </div>
                </b-card-text>
              </b-card>
            </b-card-group>

            <b-card class="mt-3" border-variant="light" id="card">
              <div class="row">
                <div
                  class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                  style="text-align: left;"
                >
                  <h3 style="color: black;">EMENTA</h3>
                </div>
                <div
                  class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                  style="text-align: left;"
                >
                  <h5 style="color: black;">EMENTA</h5>
                </div>
              </div>
              <b-card-text v-for="(item, index) in refeicao.ementa" v-bind:key="index">
                <div
                  class="p-1"
                  style="text-align: left;"
                  v-if="refeicao.ementa[index].ementas.length > 0"
                >
                  <h5
                    class="text-uppercase d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    style="padding-top: 10px; color:#87132a;"
                  >
                    <b>{{ refeicao.ementa[index].componenteNome }}</b>
                  </h5>

                  <h6
                    class="text-uppercase d-none d-sm-block d-md-none d-block d-sm-none"
                    style="padding-top: 10px; color:#87132a;"
                  >
                    <b>{{ refeicao.ementa[index].componenteNome }}</b>
                  </h6>

                  <b-card
                    border-variant="light"
                    id="smallcard"
                    v-for="(item2, index2) in refeicao.ementa[index].ementas"
                    v-bind:key="index2"
                    class="m-2"
                  >
                    <div class="row">
                      <div class="col-9" style="text-align: left;">
                        <h5
                          style="color: black;"
                          v-if="refeicao.ementa[index].ementas[index2].ementaTipo"
                        >{{ refeicao.ementa[index].ementas[index2].ementaTipo }}</h5>
                        <h6
                          style="color: black;"
                        >{{ refeicao.ementa[index].ementas[index2].comida }}</h6>
                      </div>
                      <div class="col-3" style="text-align: right;">
                        <i
                          v-if="refeicao.ementa[index].ementas[index2].energia || refeicao.ementa[index].ementas[index2].lipidos || refeicao.ementa[index].ementas[index2].saturados || refeicao.ementa[index].ementas[index2].hidratos || refeicao.ementa[index].ementas[index2].acucar || refeicao.ementa[index].ementas[index2].fibra || refeicao.ementa[index].ementas[index2].proteinas || refeicao.ementa[index].ementas[index2].sal"
                          v-b-toggle="`collapse${refeicao.ementa[index].ementas[index2].ementaId}`"
                          class="fa fa-arrow-circle-down"
                          style="font-size:24px; cursor:pointer;"
                        ></i>
                        <i
                          v-else
                          v-b-toggle="`collapse${refeicao.ementa[index].ementas[index2].ementaId}`"
                          class="fa fa-arrow-circle-down"
                          style="font-size:24px; opacity:0.5;"
                        ></i>
                      </div>
                    </div>
                    <div
                      class="row"
                      v-if="refeicao.ementa[index].ementas[index2].energia || refeicao.ementa[index].ementas[index2].lipidos || refeicao.ementa[index].ementas[index2].saturados || refeicao.ementa[index].ementas[index2].hidratos || refeicao.ementa[index].ementas[index2].acucar || refeicao.ementa[index].ementas[index2].fibra || refeicao.ementa[index].ementas[index2].proteinas || refeicao.ementa[index].ementas[index2].sal"
                    >
                      <b-collapse
                        :id="`collapse${refeicao.ementa[index].ementas[index2].ementaId}`"
                        style="width: 100%;"
                        class="m-2 pl-2 pr-2"
                      >
                        <b-card
                          style="background-color: #EAEAEA; color: black; border: transparent;"
                        >
                          <h6 v-if="refeicao.ementa[index].ementas[index2].energia">
                            <b>Energia:</b>
                            {{ refeicao.ementa[index].ementas[index2].energia }} Kcal
                          </h6>
                          <h6 v-if="refeicao.ementa[index].ementas[index2].lipidos">
                            <b>Lípidos:</b>
                            {{ refeicao.ementa[index].ementas[index2].lipidos }} g
                          </h6>
                          <h6 v-if="refeicao.ementa[index].ementas[index2].saturados">
                            <b>Lípidos, dos quais saturados:</b>
                            {{ refeicao.ementa[index].ementas[index2].saturados }} g
                          </h6>
                          <h6 v-if="refeicao.ementa[index].ementas[index2].hidratos">
                            <b>Hidratos de carbono:</b>
                            {{ refeicao.ementa[index].ementas[index2].hidratos }} g
                          </h6>
                          <h6 v-if="refeicao.ementa[index].ementas[index2].acucar">
                            <b>Hidratos de carbono, dos quais açúcares:</b>
                            {{ refeicao.ementa[index].ementas[index2].acucar }} g
                          </h6>
                          <h6 v-if="refeicao.ementa[index].ementas[index2].fibra">
                            <b>Fibra:</b>
                            {{ refeicao.ementa[index].ementas[index2].fibra }} g
                          </h6>
                          <h6 v-if="refeicao.ementa[index].ementas[index2].proteinas">
                            <b>Proteínas:</b>
                            {{ refeicao.ementa[index].ementas[index2].proteinas }} g
                          </h6>
                          <h6 v-if="refeicao.ementa[index].ementas[index2].sal">
                            <b>Sal:</b>
                            {{ refeicao.ementa[index].ementas[index2].sal }} g
                          </h6>
                        </b-card>
                      </b-collapse>
                    </div>
                  </b-card>
                </div>
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

export default {
  name: "calendario",
  data: function() {
    return {
      refeicao: {},
      erro: ""
    };
  },
  components: {
    Header
  },
  mounted: async function() {
    const response = await fetch(
      "http://localhost:8080/tickeat_war_exploded/Refeicao" +
        window.location.search,
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
        this.refeicao = json.refeicao;
        this.refeicao.preco = parseFloat(this.refeicao.preco).toFixed(2);
      } else {
        window.location.href = "http://localhost:3000/";
      }
    });
  },
  methods: {
    adquirirRefeicao() {
      window.location.href =
        "http://localhost:3000/reservar" + window.location.search;
    },
    avaliarRefeicao() {
      window.location.href =
        "http://localhost:3000/avaliar" + window.location.search;
    },
    editarRefeicao() {
      window.location.href =
        "http://localhost:3000/editarRefeicao" + window.location.search;
    },
    cancelarRefeicao: async function() {
      const response = await fetch(
        "http://localhost:8080/tickeat_war_exploded/Cancelar" +
          window.location.search,
        {
          headers: {
            "Content-Type": "application/json; charset=utf-8"
          },
          credentials: "include",
          method: "POST",
          body: JSON.stringify({})
        }
      );
      response.json().then(json => {
        if (json.success) {
          window.location.href =
            "http://localhost:3000/refeicao" + window.location.search;
        } else {
          this.erro = "Ocorreu um erro no cancelamento da reserva.";
        }
      });
    }
  }
};
</script>

<style scoped>
</style>