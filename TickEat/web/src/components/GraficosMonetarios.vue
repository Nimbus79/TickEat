<template>
  <b-card no-body>
    <b-tabs card active-nav-item-class="font-weight-bold text-uppercase" fill>
      <b-tab
        title-item-class="text-uppercase"
        title-link-class="text-dark"
        v-for="(ano,index) in anos"
        :key="index"
        :title="`Gastos Mensais ${ano}`"
      >
        <div>
          <GChart
            class="ml-2 mr-2"
            :options="chartOptions"
            type="ColumnChart"
            :data="chartData[0]"
          />
        </div>
      </b-tab>
    </b-tabs>
  </b-card>
</template>

<script>
import { GChart } from "vue-google-charts";

export default {
  name: "graficos",
  components: { GChart },
  data() {
    return {
      chartData: [],
      anos: [],
      meses: [],
      movimentos: []
    };
  },
  computed: {
    chartOptions() {
      return {
        colors: ["#87132a"]
      };
    }
  },
  mounted: async function() {
    const response = await fetch(
      "http://localhost:8080/tickeat_war_exploded/Saldos",
      {
        headers: {
          "Content-Type": "application/json; charset=utf-8"
        },
        method: "GET",
        credentials: "include"
      }
    );
    response.json().then(json => {
      if (json.success) {
        this.movimentos = json.carteira.movimentos;
        const year = new Date().getFullYear();
        this.anos = [year + ""];

        this.chartData[0] = [
          ["Mês", "Saldo"],
          ["Jan", 0],
          ["Fev", 0],
          ["Mar", 0],
          ["Abr", 0],
          ["Mai", 0],
          ["Jun", 0],
          ["Jul", 0],
          ["Ago", 0],
          ["Set", 0],
          ["Out", 0],
          ["Nov", 0],
          ["Dez", 0]
        ];

        for (var t in this.movimentos) {
          var date = this.movimentos[t].timestamp.split(" ")[0];
          var date_year = date.split("-")[0];
          var month = date.split("-")[1];

          if (date_year == year) {
            if (
              this.movimentos[t].nome == "Carregamento" &&
              this.movimentos[t].efetuado == 1
            ) {
              this.chartData[0][month][1] += this.movimentos[t].valor;
            } else if (
              this.movimentos[t].nome != "Carregamento" &&
              this.movimentos[t].efetuado == 1
            ) {
              this.chartData[0][month][1] -= this.movimentos[t].valor;
            }
          }
        }
      }
      /* eslint-disable no-console */
      console.log(this.months);
      /* eslint-enable no-console */
    });
  }
};
</script>

<style scoped>
</style>