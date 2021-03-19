<template>
  <v-app>
    <Header titulo="AVALIAR REFEIÇÃO" />
    <v-content>
      <section class="row">
        <div class="col-12">
          <div class="m-3">
            <b-card border-variant="light" id="card">
              <div class="app d-none d-sm-block">
                <vue-feedback-reaction v-model="feedback" />
              </div>
              <div class="app d-block d-sm-none">
                <vue-feedback-reaction v-model="feedback" emojiWidth="25px" emojiHeight="25px" />
              </div>

              <b-card-text style="text-align:left;">
                <b-card
                  v-for="(item, index) in comentarios"
                  :key="index"
                  border-variant="light"
                  id="smallcard"
                  class="m-1"
                >
                  <b-form-checkbox
                    :id="index"
                    v-model="comentariosSelecionados"
                    name="`checkbox${index}`"
                    :value="comentarios[index].id"
                  >{{ comentarios[index].descricao }}</b-form-checkbox>
                </b-card>
              </b-card-text>

              <b-alert v-if="erro" variant="danger" show>{{ erro }}</b-alert>

              <div class="d-block text-center">
                <div
                  class="text-center p-3 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                >
                  <button
                    type="button"
                    class="redbtn"
                    v-on:click="avaliar()"
                    style="width:15em;"
                  >AVALIAR</button>
                </div>

                <div class="text-center p-3 d-none d-sm-block d-md-none d-block d-sm-none">
                  <button
                    type="button"
                    class="redbtn"
                    v-on:click="avaliar()"
                    style="width:10em; font-size: 1em;"
                  >AVALIAR</button>
                </div>
              </div>
            </b-card>
          </div>
        </div>
      </section>
    </v-content>
  </v-app>
</template>

<script>
import Header from "@/components/HeaderConsumidor.vue";
import { VueFeedbackReaction } from "vue-feedback-reaction";

export default {
  name: "avaliar",
  data: function() {
    return {
      feedback: "",
      comentarios: [],
      comentariosSelecionados: [],
      erro: ""
    };
  },
  components: {
    Header,
    VueFeedbackReaction
  },
  methods: {
    avaliar: async function() {
      if (this.feedback == "") {
        this.erro = "Por favor avalie a sua refeição.";
      } else {
        const response = await fetch(
          "http://localhost:8080/tickeat_war_exploded/Avaliar" +
            window.location.search,
          {
            headers: {
              "Content-Type": "application/json; charset=utf-8"
            },
            credentials: "include",
            method: "POST",
            body: JSON.stringify({
              pontuacao: this.feedback,
              comentarios: this.comentariosSelecionados
            })
          }
        );
        response.json().then(json => {
          if (json.success) {
            window.location.href =
              "http://localhost:3000/refeicao" + window.location.search;
          } else {
            this.erro = "Ocorreu um erro durante a avaliação.";
          }
        });
      }
    }
  },
  mounted: async function() {
    const response = await fetch(
      "http://localhost:8080/tickeat_war_exploded/Avaliar",
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
        this.comentarios = JSON.parse(json.comentarios);
      }
    });
  }
};
</script>