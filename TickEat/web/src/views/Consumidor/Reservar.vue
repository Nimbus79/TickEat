<template>
  <v-app>
    <Header titulo="RESERVAR REFEIÇÃO" />
    <v-content>
      <section class="row">
        <div class="col-12">
          <div class="m-3">
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
                <h6
                  class="text-uppercase"
                  style="color: black; font-weight: 100;"
                >{{ refeicao.data }}</h6>
              </div>
            </div>

            <b-card class="mt-3" border-variant="light" id="card">
              <div class="row" style="text-align: left;">
                <div
                  class="col-12"
                  style="font-weight: 100;"
                >Selecione o tipo de refeição que deseja consumir.</div>

                <b-form-group class="m-3">
                  <b-form-radio
                    v-for="(item, index) in refeicao.tiposRefeicao"
                    v-bind:key="index"
                    name="tipo"
                    v-model="tipoSelecionado"
                    :value="index"
                    style="color: #87132a;"
                    @click="limparEmentas"
                  >
                    {{ refeicao.tiposRefeicao[index].tipoRefeicaoNome }}
                    <p
                      style="color: black; font-weight:100;"
                    >{{ refeicao.tiposRefeicao[index].preco }}€</p>
                  </b-form-radio>
                </b-form-group>
              </div>
            </b-card>

            <b-card class="mt-3" border-variant="light" id="card" v-if="tipoSelecionado >= 0">
              <div class="row" style="text-align: left;">
                <div
                  class="col-12 mb-3"
                  style="font-weight: 100;"
                >Selecione a ementa de cada componente que deseja.</div>

                <div
                  class="col-12"
                  v-for="(item2, index2) in refeicao.tiposRefeicao[tipoSelecionado].ementa"
                  v-bind:key="index2"
                >
                  <b-form-group
                    v-if="refeicao.tiposRefeicao[tipoSelecionado].ementa[index2].ementas.length > 0"
                  >
                    <div>
                      <h4
                        class="text-uppercase"
                        style="color: #87132a;"
                      >{{ refeicao.tiposRefeicao[tipoSelecionado].ementa[index2].componenteNome }}</h4>

                      <b-form-radio
                        v-for="(item3, index3) in refeicao.tiposRefeicao[tipoSelecionado].ementa[index2].ementas"
                        v-bind:key="index3"
                        :name="refeicao.tiposRefeicao[tipoSelecionado].ementa[index2].ementas[index3].componenteNome"
                        :value="refeicao.tiposRefeicao[tipoSelecionado].ementa[index2].ementas[index3].ementaId"
                        v-model="ementasSelecionadas[index2]"
                        style="color: black;"
                      >
                        {{ refeicao.tiposRefeicao[tipoSelecionado].ementa[index2].ementas[index3].comida }}
                        <p
                          :v-if="refeicao.tiposRefeicao[tipoSelecionado].ementa[index2].ementas[index3].ementaTipo"
                          style="color: black; font-weight:100;"
                        >{{ refeicao.tiposRefeicao[tipoSelecionado].ementa[index2].ementas[index3].ementaTipo }}</p>
                      </b-form-radio>
                    </div>
                  </b-form-group>
                </div>
              </div>
            </b-card>
            <br />
            <b-alert v-if="erro" variant="danger" show>{{ erro }}</b-alert>

            <h4 v-if="tipoSelecionado>=0" class="text-uppercase mt-4" style="color: black;">
              TOTAL:
              <span style="color: #87132a; font-weight: 150;">{{ precoTotal }}€</span>
            </h4>

            <div class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block">
              <div class="row">
                <div class="col-6">
                  <div class="text-center p-3 mt-2">
                    <button
                      type="button"
                      class="redbtn"
                      v-on:click="cancelar()"
                      style="width: 15em; font-size: 1em;"
                    >CANCELAR</button>
                  </div>
                </div>
                <div class="col-6">
                  <div class="text-center p-3 mt-2">
                    <button
                      @click="pre_reservar"
                      type="button"
                      class="lightredbtn"
                      style="width: 15em; font-size: 1em;"
                    >RESERVAR</button>
                  </div>
                </div>
              </div>
            </div>

            <div class="d-none d-sm-block d-md-none d-block d-sm-none">
              <div class="row">
                <div class="col-12">
                  <div class="text-center p-1 mt-3">
                    <button
                      type="button"
                      class="redbtn"
                      v-on:click="cancelar()"
                      style="width: 12em; font-size: 0.8em;"
                    >CANCELAR</button>
                  </div>
                  <div class="text-center p-1">
                    <button
                      @click="pre_reservar"
                      type="button"
                      class="lightredbtn"
                      style="width: 12em; font-size: 0.8em;"
                    >RESERVAR</button>
                  </div>
                </div>
              </div>
            </div>
            <b-modal id="reservar" hide-footer>
              <template v-slot:modal-title>RESERVA</template>
              <div class="row">
                <div class="col-6" style="text-align: left;">
                  <h6>{{ refeicao.cantinaNome }}</h6>
                  <h6 style="font-weight:100;">{{ refeicao.refeicaoNome }}</h6>
                </div>
                <div class="col-6" style="text-align: right;">
                  <h6>{{ refeicao.diaDaSemana }}</h6>
                  <h6 style="font-weight:100;">{{ refeicao.data }}</h6>
                </div>
                <div class="col-12 text-center">
                  <h6
                    v-if="tipoSelecionado>=0"
                    class="text-uppercase mt-2 mb-4"
                    style="color: black;"
                  >
                    TOTAL:
                    <span style="color: #87132a; font-weight: 150;">{{ precoTotal }}€</span>
                  </h6>
                </div>
              </div>
              <div class="d-block text-center">
                <button
                  v-on:click="reservar()"
                  type="button"
                  class="lightredbtn"
                  style="width: 12em; font-size: 0.8em;"
                >CONFIRMAR</button>
              </div>
            </b-modal>
          </div>
        </div>
      </section>
    </v-content>
  </v-app>
</template>

<script>
import Header from "@/components/HeaderConsumidor.vue";

export default {
  name: "adquiriRefeicao",
  data: function() {
    return {
      refeicao: {},
      tipoSelecionado: -1,
      ementasSelecionadas: [],
      erro: ""
    };
  },
  components: {
    Header
  },
  mounted: async function() {
    const response = await fetch(
      "http://localhost:8080/tickeat_war_exploded/Reservar" +
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
        this.refeicao = json.menuRefeicao;
        for (var t in this.refeicao.tiposRefeicao) {
          this.refeicao.tiposRefeicao[t].preco = parseFloat(
            this.refeicao.tiposRefeicao[t].preco
          ).toFixed(2);
        }
      } else {
        window.location.href = "http://localhost:3000/";
      }
    });
  },
  methods: {
    limparEmentas: function() {
      this.ementasSelecionadas = [];
    },
    pre_reservar: function() {
      if (this.ementasSelecionadas.length == 0) {
        this.erro = "Tem de escolher a ementa que pretende consumir.";
      } else {
        this.erro = "";
        this.$bvModal.show("reservar");
      }
    },
    reservar: async function() {
      const response = await fetch(
        "http://localhost:8080/tickeat_war_exploded/Reservar" +
          window.location.search,
        {
          headers: {
            "Content-Type": "application/json; charset=utf-8"
          },
          credentials: "include",
          method: "POST",
          body: JSON.stringify({
            tipoRefeicaoId:
              this.refeicao.tiposRefeicao[this.tipoSelecionado].tipoRefeicaoId +
              "",
            ementas: this.ementasSelecionadas,
            preco: this.refeicao.tiposRefeicao[this.tipoSelecionado].preco + ""
          })
        }
      );
      response.json().then(json => {
        if (json.success) {
          window.location.href =
            "http://localhost:3000/refeicao" + window.location.search;
        } else {
          this.erro = "Ocorreu um erro na sua reserva.";
        }
      });
    },
    cancelar() {
      window.location.href =
        "http://localhost:3000/refeicao" + window.location.search;
    }
  },
  computed: {
    precoTotal: function() {
      return this.refeicao.tiposRefeicao[this.tipoSelecionado].preco;
    }
  }
};
</script>

<style scoped>
</style>