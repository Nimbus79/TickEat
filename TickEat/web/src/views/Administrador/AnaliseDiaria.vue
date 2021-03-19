<template>
  <v-app>
    <Header titulo="ANÁLISE DIÁRIA" />
    <v-content>
      <section class="row">
        <div class="col-12">
          <div class="m-3">
            <b-card no-body>
              <b-tabs card active-nav-item-class="font-weight-bold text-uppercase" fill>
                <b-tab
                  title-item-class="text-uppercase"
                  title-link-class="text-dark"
                  v-for="(c,index) in cantinas"
                  :key="index"
                  :title="c.nome"
                >
                  <b-alert
                    v-if="c.refeicoes.length==0"
                    variant="danger"
                    show
                  >Não existem informações sobre esta cantina.</b-alert>
                  <div v-else>
                    <v-carousel
                      style="top:0;"
                      height="100%;"
                      :v-model="0"
                      :show-arrows="true"
                      :hide-delimiters="true"
                      :cycle="false"
                    >
                      <v-carousel-item v-for="(r,i) in c.refeicoes" :key="i">
                        <v-sheet color="white" height="100%" tile>
                          <div style="margin-right: 80px; margin-left: 80px;">
                            <h2
                              class="text-uppercase"
                              style="padding-top: 10px; color:#87132a;"
                            >{{ r.nome }}</h2>

                            <b-card-group deck>
                              <b-card border-variant="light" id="card">
                                <div class="row">
                                  <div
                                    class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                                    style="text-align: left;"
                                  >
                                    <h3 class="text-uppercase" style="color: black;">LUCRO</h3>
                                  </div>

                                  <div
                                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                                    style="text-align: left;"
                                  >
                                    <h5 class="text-uppercase" style="color: black;">LUCRO</h5>
                                  </div>
                                </div>
                                <div class="text-center p-3">
                                  <h1 style="padding-top: 10px; color:#87132a;">{{ r.lucro }}€</h1>
                                </div>
                              </b-card>
                              <b-card border-variant="light" id="card">
                                <div class="row">
                                  <div
                                    class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                                    style="text-align: left;"
                                  >
                                    <h3 class="text-uppercase" style="color: black;">PREVISÃO GERAL</h3>
                                  </div>

                                  <div
                                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                                    style="text-align: left;"
                                  >
                                    <h5 class="text-uppercase" style="color: black;">PREVISÃO GERAL</h5>
                                  </div>
                                </div>
                                <div class="text-center p-3">
                                  <h1
                                    style="padding-top: 10px; color:#87132a;"
                                  >{{ r.previsaoGeral }}</h1>
                                </div>
                              </b-card>

                              <b-card border-variant="light" id="card">
                                <div class="row">
                                  <div
                                    class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                                    style="text-align: left;"
                                  >
                                    <h3
                                      class="text-uppercase"
                                      style="color: black;"
                                    >NÚMERO DE AVALIAÇÕES</h3>
                                  </div>

                                  <div
                                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                                    style="text-align: left;"
                                  >
                                    <h5
                                      class="text-uppercase"
                                      style="color: black;"
                                    >NÚMERO DE AVALIAÇÕES</h5>
                                  </div>
                                </div>
                                <div class="text-center p-3">
                                  <h1
                                    style="padding-top: 10px; color:#87132a;"
                                  >{{ numAvaliacoes[index][i] }}</h1>
                                </div>
                              </b-card>

                              <b-card border-variant="light" id="card">
                                <div class="row">
                                  <div
                                    class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                                    style="text-align: left;"
                                  >
                                    <h3
                                      class="text-uppercase"
                                      style="color: black;"
                                    >MÉDIA DAS AVALIAÇÕES</h3>
                                  </div>

                                  <div
                                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                                    style="text-align: left;"
                                  >
                                    <h5
                                      class="text-uppercase"
                                      style="color: black;"
                                    >MÉDIA DAS AVALIAÇÕES</h5>
                                  </div>
                                </div>
                                <div class="text-center p-3">
                                  <h1
                                    style="padding-top: 10px; color:#87132a;"
                                  >{{ avaliacoesMedia[index][i] }}</h1>
                                </div>
                              </b-card>
                            </b-card-group>

                            <b-card-group deck class="mt-5">
                              <b-card border-variant="light" id="card">
                                <div class="row">
                                  <div
                                    class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                                    style="text-align: left;"
                                  >
                                    <h3 class="text-uppercase" style="color: black;">AVALIAÇÕES</h3>
                                  </div>

                                  <div
                                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                                    style="text-align: left;"
                                  >
                                    <h5 class="text-uppercase" style="color: black;">AVALIAÇÕES</h5>
                                  </div>
                                </div>
                                <b-card-text>
                                  <div id="chart">
                                    <apexchart
                                      type="bar"
                                      :options="chartOptionsAv"
                                      :series="avaliacoes[index][i]"
                                    ></apexchart>
                                  </div>
                                </b-card-text>
                              </b-card>
                              <b-card border-variant="light" id="card">
                                <div class="row">
                                  <div
                                    class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                                    style="text-align: left;"
                                  >
                                    <h3 class="text-uppercase" style="color: black;">COMENTÁRIOS</h3>
                                  </div>

                                  <div
                                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                                    style="text-align: left;"
                                  >
                                    <h5 class="text-uppercase" style="color: black;">COMENTÁRIOS</h5>
                                  </div>
                                </div>
                                <b-card-text>
                                  <div id="chart">
                                    <apexchart
                                      type="pie"
                                      :options="chartOptionsCom"
                                      :series="comentarios[index][i]"
                                    ></apexchart>
                                  </div>
                                </b-card-text>
                              </b-card>
                            </b-card-group>

                            <v-data-table
                              :headers="headers"
                              :items="r.ementas"
                              hide-default-footer
                              class="elevation-1 mt-5 mb-5"
                              light
                            ></v-data-table>
                          </div>
                        </v-sheet>
                      </v-carousel-item>
                    </v-carousel>
                  </div>
                </b-tab>
              </b-tabs>
            </b-card>
          </div>
        </div>
      </section>
    </v-content>
  </v-app>
</template>

<script>
import Header from "@/components/HeaderAdministrador.vue";
import VueApexCharts from "vue-apexcharts";

export default {
  name: "analisediaria",
  components: {
    Header,
    apexchart: VueApexCharts
  },
  data: () => ({
    cantinas: [],
    erro: "",
    numAvaliacoes: [],
    avaliacoesMedia: [],
    avaliacoes: [],
    comentarios: [],
    headers: [
      { text: "Componente", align: "left", value: "componenteNome" },
      { text: "Ementa", align: "left", value: "comida" },
      { text: "Previsão", align: "left", value: "previsao" },
      {
        text: "Validados",
        align: "left",
        value: "contagemValidados"
      }
    ],
    chartOptionsAv: {
      chart: {
        height: 350,
        type: "bar"
      },
      plotOptions: {
        bar: {
          dataLabels: {
            position: "top"
          }
        }
      },
      labels: ["1", "2", "3", "4", "5"],
      dataLabels: {
        enabled: true,
        style: {
          fontSize: "12px",
          colors: ["#FFFFFF"]
        }
      },
      colors: ["#87132A"],
      legend: {
        position: "bottom",
        horizontalAlign: "left"
      },
      yaxis: {
        axisBorder: {
          show: false
        },
        axisTicks: {
          show: false
        },
        labels: {
          show: true,
          formatter: function(val) {
            return val;
          }
        }
      },
      responsive: [
        {
          breakpoint: 600,
          options: {
            chart: {
              height: 150
            },
            legend: {
              position: "bottom"
            }
          }
        }
      ]
    },
    chartOptionsCom: {
      chart: {
        width: 400,
        type: "pie"
      },
      labels: [
        "A comida estava fria.",
        "Boa apresentação.",
        "A comida estava saborosa.",
        "Excesso de sal na comida.",
        "A comida estava insosa.",
        "Muito tempo à espera da refeição.",
        "Comida mal confecionada.",
        "Os funcionários foram antipáticos.",
        "Funcionários bastante amigáveis."
      ],
      dataLabels: {
        style: {
          colors: ["#FFFFFF"]
        }
      },
      colors: [
        "#000000",
        "#741025",
        "#87132A",
        "#9F1734",
        "#AF183B",
        "#CA1B45",
        "#EB2152"
      ],
      legend: {
        show: false
      },
      responsive: [
        {
          breakpoint: 600,
          options: {
            chart: {
              width: 150
            },
            legend: {
              position: "bottom"
            }
          }
        }
      ]
    },
    series: []
  }),
  mounted: async function() {
    const response = await fetch(
      "http://localhost:8080/tickeat_war_exploded/Analise",
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
        this.cantinas = json.cantinas;
        this.cantinas.push({ nome: "Geral", refeicoes: [] });
        var comentarios = [];
        var avaliacoes = [];
        this.numAvaliacoes = [];
        this.avaliacoesMedia = [];
        for (var i = 0; i < this.cantinas.length - 1; i++) {
          comentarios.push({});
          avaliacoes.push({});
          this.numAvaliacoes.push({});
          this.avaliacoesMedia.push({});
          var arrCom = [];
          var arrAv = [];
          var arrNum = [];
          var arrMed = [];
          for (var j = 0; j < this.cantinas[i].refeicoes.length; j++) {
            arrCom.push(this.cantinas[i].refeicoes[j].comentarios);
            arrAv.push(this.cantinas[i].refeicoes[j].pontuacoes);
            arrNum.push(this.cantinas[i].refeicoes[j].totalAvaliacoes);
            arrMed.push(this.cantinas[i].refeicoes[j].pontuacaoMedia);
          }
          comentarios[i] = arrCom;
          avaliacoes[i] = arrAv;
          this.numAvaliacoes[i] = arrNum;
          this.avaliacoesMedia[i] = arrMed;
        }

        for (var k = 0; k < avaliacoes.length; k++) {
          this.avaliacoes.push({});
          var av = [];
          for (i = 0; i < avaliacoes[k].length; i++) {
            var arr2 = [];
            arr2.push({ name: "Total", data: [0, 0, 0, 0, 0] });
            av.push(arr2);
            av[i][0].data[avaliacoes[k][i][0].pontuacao - 1] =
              avaliacoes[k][i][0].total;
          }
          this.avaliacoes[k] = av;
        }

        var labels = [
          "A comida estava fria.",
          "Boa apresentação.",
          "A comida estava saborosa.",
          "Excesso de sal na comida.",
          "A comida estava insosa.",
          "Muito tempo à espera da refeição.",
          "Comida mal confecionada.",
          "Os funcionários foram antipáticos.",
          "Funcionários bastante amigáveis."
        ];

        for (k = 0; k < comentarios.length; k++) {
          this.comentarios.push({});
          var com = [];
          for (i = 0; i < comentarios[k].length; i++) {
            var count = [0, 0, 0, 0, 0, 0, 0, 0, 0];
            for (j = 0; j < comentarios[k][i].length; j++) {
              var index = labels.indexOf(comentarios[k][i][j].comentario);
              count[index] += comentarios[k][i][j].total;
            }
            com.push(count);
          }
          this.comentarios[k] = com;
        }
      } else {
        window.location.href = "http://localhost:3000";
      }
    });
  }
};
</script>