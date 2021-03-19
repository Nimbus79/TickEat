<template>
  <v-app>
    <Header titulo="REFEIÇÕES" />
    <v-content>
      <section class="row">
        <div class="col-12">
          <div class="m-3">
            <b-card no-body class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block">
              <b-tabs card active-nav-item-class="font-weight-bold text-uppercase" fill>
                <b-tab
                  title-item-class="text-uppercase"
                  title-link-class="text-dark"
                  v-for="cantina in cantinas"
                  :key="cantina.nome"
                  :title="cantina.nome"
                >
                  <div>
                    <vue-cal
                      :time="false"
                      :disable-views="['years', 'year']"
                      default-view="month"
                      :events="cantina.refeicoes"
                      :events-on-month-view="true"
                      style="width: 100%;"
                      :on-event-click="consultarRefeicao"
                    ></vue-cal>
                  </div>
                </b-tab>
              </b-tabs>
            </b-card>

            <b-card no-body class="d-none d-sm-block d-md-none d-block d-sm-none">
              <b-tabs
                card
                active-nav-item-class="font-weight-bold text-uppercase"
                fill
                style="font-size:0.8em;"
              >
                <b-tab
                  title-item-class="text-uppercase"
                  title-link-class="text-dark"
                  v-for="cantina in cantinas"
                  :key="cantina.nome"
                  :title="cantina.nome"
                >
                  <div>
                    <vue-cal
                      xsmall
                      :time="false"
                      :disable-views="['years','year']"
                      :events="cantina.refeicoes"
                      default-view="month"
                      style="width: 100%;"
                      :on-event-click="consultarRefeicao"
                      :events-on-month-view="true"
                    ></vue-cal>
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

<style scoped>
</style>

<script>
//import Sidebar from "@/components/Sidebar.vue";
import Header from "@/components/HeaderConsumidor.vue";
import VueCal from "vue-cal";
import "vue-cal/dist/vuecal.css";

export default {
  name: "calendario",
  data: function() {
    return {
      cantinas: []
    };
  },
  mounted: async function() {
    const response = await fetch(
      "http://localhost:8080/tickeat_war_exploded/Calendario",
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
      } else {
        window.location.href = "http://localhost:3000/";
      }
    });
  },
  methods: {
    consultarRefeicao(event, e) {
      window.location.href =
        "http://localhost:3000/refeicao?ref=" +
        event.id +
        "&cant=" +
        event.cantinaId;
      e.stopPropagation();
    }
  },
  components: {
    Header,
    VueCal
  }
};
</script>
