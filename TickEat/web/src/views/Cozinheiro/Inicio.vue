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
                    <h3 class="text-uppercase" style="color: black;">CANTINA</h3>
                  </div>

                  <div
                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                    style="text-align: left;"
                  >
                    <h5 class="text-uppercase" style="color: black;">CANTINA</h5>
                  </div>
                </div>
                <b-card-text>
                  <h3
                    class="text-uppercase"
                    style="color: #87132a; font-weight: 1000;"
                  >{{ cantinas.cantinaNome }}</h3>
                </b-card-text>
              </b-card>
              <b-card border-variant="light" id="card">
                <div class="row">
                  <div
                    class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    style="text-align: left;"
                  >
                    <h3 class="text-uppercase" style="color: black;">PRÓXIMA REFEIÇÃO</h3>
                  </div>

                  <div
                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                    style="text-align: left;"
                  >
                    <h5 class="text-uppercase" style="color: black;">PRÓXIMA REFEIÇÃO</h5>
                  </div>
                </div>
                <b-card-text>
                  <h3
                    v-if="cantinas.refeicaoNome && cantinas.data"
                    class="text-uppercase"
                    style="color: #87132a; font-weight: 1000;"
                  >{{ cantinas.refeicaoNome }}</h3>
                  <h5
                    v-if="cantinas.refeicaoNome && cantinas.data"
                    class="text-uppercase"
                    style="color: black; font-weight: 1000;"
                  >{{ cantinas.data }}</h5>
                  <h5 style="color:black; font-weight: 100;">{{ horaInicio }}h - {{ horaFim }}h</h5>

                  <h5
                    v-if="cantinas.previsaoGeral"
                    style="padding-top: 10px; color:#87132a;"
                  >Não existem refeições para breve.</h5>
                  <div v-if="cantinas.aDecorrer">
                    <h5
                      style="padding-top: 10px; color:#87132a;"
                    >A refeição encontra-se a decorrer...</h5>
                  </div>
                  <div v-else>
                    <div
                      class="text-center p-3 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    >
                      <button
                        type="button"
                        class="redbtn"
                        v-on:click="iniciarRefeicao(cantinas.refeicaoId)"
                        style="width:12em;"
                      >INICIAR REFEIÇÃO</button>
                    </div>

                    <div class="text-center p-3 d-none d-sm-block d-md-none d-block d-sm-none">
                      <button
                        type="button"
                        class="redbtn"
                        v-on:click="iniciarRefeicao(cantinas.refeicaoId)"
                        style="width:10em; font-size: 1em;"
                      >INICIAR REFEIÇÃO</button>
                    </div>
                  </div>
                  <b-alert v-if="erro" variant="danger" show>{{ erro }}</b-alert>
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
                  <div v-if="cantinas.aDecorrer">
                    <h5
                      class="text-uppercase"
                      style="color: black; font-weight: 100;"
                    >{{ cantinas.refeicaoNome }} {{ cantinas.data }}</h5>

                    <h1 style="padding-top: 10px; color:#87132a;">{{ cantinas.estadoFila }}</h1>
                  </div>

                  <div v-else>
                    <h5 style="padding-top: 10px; color:#87132a;">A cantina está encerrada.</h5>
                  </div>
                </b-card-text>
              </b-card>
            </b-card-group>

            <b-card-group deck class="mt-3">
              <b-card border-variant="light" id="card" v-if="cantinas.ementa">
                <div class="row">
                  <div
                    class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    style="text-align: left;"
                  >
                    <h3 class="text-uppercase" style="color: black;">EMENTA</h3>
                  </div>

                  <div
                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                    style="text-align: left;"
                  >
                    <h5 class="text-uppercase" style="color: black;">EMENTA</h5>
                  </div>
                </div>
                <b-card-text style="text-align: left;">
                  <div v-for="componente in cantinas.ementa" :key="componente.componenteNome">
                    <h5
                      v-if="componente.ementas.length > 0"
                      class="text-uppercase d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                      style="padding-top: 10px; color:#87132a;"
                    >
                      <b>{{ componente.componenteNome }}</b>
                    </h5>

                    <h6
                      v-if="componente.ementas.lenght>0"
                      class="text-uppercase d-none d-sm-block d-md-none d-block d-sm-none"
                      style="padding-top: 10px; color:#87132a;"
                    >
                      <b>{{ componente.componenteNome }}</b>
                    </h6>

                    <b-card
                      border-variant="light"
                      id="smallcard"
                      v-for="e in componente.ementas"
                      :key="e.componenteNome"
                      class="m-2"
                    >
                      <div>
                        <h5 style="color: black;" v-if="e.ementaTipo">{{ e.ementaTipo }}</h5>
                        <h6 style="color: black;">{{ e.comida }}</h6>
                      </div>
                      <div>
                        <h5>
                          <span
                            style="color: #87132a; font-weight: 100; font-size: 0.7em;"
                          >PESSOAS ESPERADAS:&nbsp;</span>
                          <span
                            v-if="cantinas.aDecorrer"
                            style="color: #87132a; font-weight: 1000;"
                          >
                            <span style="padding-top: 10px; color:#87132a;">
                              {{ e.previsao-e.contagemValidados }}
                              <span
                                style="font-size:0.8em;"
                              >/ {{ e.previsao }}</span>
                            </span>
                          </span>
                          <span v-else style="color: #87132a; font-weight: 1000;">{{ e.previsao }}</span>
                        </h5>
                      </div>
                    </b-card>
                  </div>
                </b-card-text>
              </b-card>
            </b-card-group>
          </div>
        </div>
      </section>
    </v-content>
  </v-app>
</template>


<script>
import Header from "@/components/HeaderCozinheiro.vue";

export default {
  name: "inicioCoz",
  data: function() {
    return {
      cantinas: {},
      horaInicio: "",
      horaFim: "",
      erro: ""
    };
  },
  components: {
    Header
  },
  mounted: async function() {
    const response = await fetch(
      "http://localhost:8080/tickeat_war_exploded/InicioCozinheiro",
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
        this.horaInicio = this.cantinas.horaInicio.substring(0, 5);
        this.horaFim = this.cantinas.horaFim.substring(0, 5);
      } else {
        window.location.href = "http://localhost:3000/";
      }
    });
  },
  methods: {
    iniciarRefeicao: async function(id) {
      this.erro = "";
      const response = await fetch(
        "http://localhost:8080/tickeat_war_exploded/InicioCozinheiro",
        {
          headers: {
            "Content-Type": "application/json; charset=utf-8"
          },
          credentials: "include",
          method: "POST",
          body: JSON.stringify({
            refeicaoId: id + ""
          })
        }
      );
      response.json().then(json => {
        if (json.success) {
          location.reload();
        } else {
          this.erro = "Ocorreu um erro a iniciar a refeição.";
        }
      });
    }
  }
};
</script>