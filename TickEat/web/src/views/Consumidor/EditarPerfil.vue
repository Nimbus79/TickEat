<template>
  <v-app>
    <Header titulo="EDITAR PERFIL" />
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
                    <h3 class="text-uppercase" style="color: black;">NOME</h3>
                  </div>

                  <div
                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                    style="text-align: left;"
                  >
                    <h5 class="text-uppercase" style="color: black;">NOME</h5>
                  </div>
                </div>
                <b-card-text>
                  <p
                    style="font-weight:100; text-align: left;"
                    class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                  >Introduz o teu nome.</p>

                  <p
                    style="font-weight:100; text-align: left;"
                    class="d-none d-sm-block d-md-none d-block d-sm-none"
                  >Introduz o teu nome.</p>
                </b-card-text>
                <div class="form-group">
                  <input type="text" name="nome" class="form-control" id="nome" v-model="nome" />
                </div>
              </b-card>

              <b-card border-variant="light" id="card">
                <div class="row">
                  <div
                    class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    style="text-align: left;"
                  >
                    <h3 class="text-uppercase" style="color: black;">NIF</h3>
                  </div>

                  <div
                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                    style="text-align: left;"
                  >
                    <h5 class="text-uppercase" style="color: black;">NIF</h5>
                  </div>
                </div>
                <b-card-text>
                  <p
                    style="font-weight:100; text-align: left;"
                    class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                  >Introduz o número de contribuinte a ser utilizado na faturação.</p>

                  <p
                    style="font-weight:100; text-align: left;"
                    class="d-none d-sm-block d-md-none d-block d-sm-none"
                  >Introduz o número de contribuinte a ser utilizado na faturação.</p>
                </b-card-text>
                <div class="form-group">
                  <input type="text" name="nif" class="form-control" id="nif" v-model="nif" />
                </div>
              </b-card>
            </b-card-group>

            <b-card-group deck class="mt-3">
              <b-card border-variant="light" id="card">
                <div class="row">
                  <div
                    class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    style="text-align: left;"
                  >
                    <h3 class="text-uppercase" style="color: black;">CANTINAS</h3>
                  </div>

                  <div
                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                    style="text-align: left;"
                  >
                    <h5 class="text-uppercase" style="color: black;">CANTINAS</h5>
                  </div>
                </div>
                <b-card-text>
                  <p
                    style="font-weight:100; text-align: left;"
                    class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                  >Torne visíveis as cantinas que pretende consultar, e oculte as que pretende esconder na aplicação. Ordene-as pela sua preferência.</p>

                  <p
                    style="font-weight:100; text-align: left;"
                    class="d-none d-sm-block d-md-none d-block d-sm-none"
                  >Torne visíveis as cantinas que pretende consultar, e oculte as que pretende esconder na aplicação. Ordene-as pela sua preferência.</p>
                  <draggable v-model="cantinas" :sort="true" @change="onMoveCallback">
                    <transition-group>
                      <div v-for="c in cantinas" :key="c.cantinaVisivelId">
                        <b-card
                          border-variant="light"
                          id="smallcard"
                          class="m-1"
                          v-if="c.visivel==true"
                          style="cursor:pointer;"
                        >
                          <div class="row">
                            <div class="col-10" style="text-align: left;">
                              <span
                                class="mr-4 step"
                                style="font-weight:1000; font-size: 1.2em; color: white;"
                              >{{ c.posicao }}</span>
                              <span
                                style="font-weight:500; font-size: 1.2em; color: black;"
                              >{{ c.cantinaNome }}</span>
                            </div>
                            <div class="col-2" style="text-align: right;">
                              <div
                                class="mr-4"
                                style="font-weight:1000; font-size: 1.2em; color: black; text-align: right;"
                              >
                                <i @click="tornarInvisivel(c.cantinaVisivelId)" class="fa fa-eye"></i>
                              </div>
                            </div>
                          </div>
                        </b-card>

                        <b-card
                          border-variant="light"
                          id="smallcard"
                          class="m-1"
                          style="opacity: 0.5; cursor:pointer;"
                          v-else
                        >
                          <div class="row">
                            <div class="col-10" style="text-align: left;">
                              <span
                                class="mr-4 step"
                                style="font-weight:1000; font-size: 1.2em; color: white;"
                              >
                                <i class="fa fa-minus" style="font-size:1em"></i>
                              </span>
                              <span
                                style="font-weight:500; font-size: 1.2em; color: black;"
                              >{{ c.cantinaNome }}</span>
                            </div>
                            <div class="col-2" style="text-align: right;">
                              <div
                                class="mr-4"
                                style="font-weight:1000; font-size: 1.2em; color: black; text-align: right;"
                              >
                                <i
                                  @click="tornarVisivel(c.cantinaVisivelId)"
                                  class="fa fa-eye-slash"
                                ></i>
                              </div>
                            </div>
                          </div>
                        </b-card>
                      </div>
                    </transition-group>
                  </draggable>
                </b-card-text>
              </b-card>

              <b-card border-variant="light" id="card">
                <div class="row">
                  <div
                    class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    style="text-align: left;"
                  >
                    <h3 class="text-uppercase" style="color: black;">PALAVRA-PASSE</h3>
                  </div>

                  <div
                    class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                    style="text-align: left;"
                  >
                    <h5 class="text-uppercase" style="color: black;">PALAVRA-PASSE</h5>
                  </div>
                </div>
                <b-card-text>
                  <p
                    style="font-weight:100; text-align: left;"
                    class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                  >Deves usar uma palavra-passe forte que não uses em mais lado nenhum.</p>

                  <p
                    style="font-weight:100; text-align: left;"
                    class="d-none d-sm-block d-md-none d-block d-sm-none"
                  >Deves usar uma palavra-passe forte que não uses em mais lado nenhum.</p>
                </b-card-text>
                <div class="form-group">
                  <label
                    for="nome"
                    class="control-label"
                    style="color:#c4c4c4; font-size:1.2em; float:left;"
                  >Atual</label>
                  <br />
                  <input
                    type="password"
                    name="passatual"
                    class="form-control"
                    id="passatual"
                    v-model="atual"
                  />
                  <br />
                  <label
                    for="nome"
                    class="control-label"
                    style="color:#c4c4c4; font-size:1.2em; float:left;"
                  >Nova</label>
                  <br />
                  <input
                    type="password"
                    name="passnova"
                    class="form-control"
                    id="passnova"
                    v-model="nova"
                  />
                  <br />
                  <label
                    for="nome"
                    class="control-label"
                    style="color:#c4c4c4; font-size:1.2em; float:left;"
                  >Repete a nova</label>
                  <br />
                  <input
                    type="password"
                    name="passnova2"
                    class="form-control"
                    id="passnova2"
                    v-model="nova2"
                  />
                </div>
              </b-card>
            </b-card-group>
            <br />
            <b-alert v-if="erro" variant="danger" show>{{ erro }}</b-alert>
            <div
              class="text-center m-3 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
            >
              <button
                type="button"
                class="redbtn mt-4"
                v-on:click="editarPerfil()"
                style="width: 15em; font-size: 1.2em;"
              >CONFIRMAR</button>
            </div>

            <div class="text-center m-3 d-none d-sm-block d-md-none d-block d-sm-none">
              <button
                type="button"
                class="redbtn mt-4"
                v-on:click="editarPerfil()"
                style="width: 11em; font-size: 1em;"
              >CONFIRMAR</button>
            </div>
          </div>
        </div>
      </section>
    </v-content>
  </v-app>
</template>

<script>
import Header from "@/components/HeaderConsumidor.vue";
import draggable from "vuedraggable";

export default {
  name: "editarPerfil",
  data: function() {
    return {
      cantinasOld: [],
      nome: "",
      nif: "",
      cantinas: [],
      atual: "",
      nova: "",
      nova2: "",
      erro: ""
    };
  },
  components: {
    draggable,
    Header
  },
  mounted: async function() {
    const response = await fetch(
      "http://localhost:8080/tickeat_war_exploded/Perfil" +
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
        this.nome = json.perfil.nome;
        if (json.perfil.contribuinte != 0) {
          this.nif = json.perfil.contribuinte;
        }
      } else {
        window.location.href = "http://localhost:3000/";
      }
    });
    const response2 = await fetch(
      "http://localhost:8080/tickeat_war_exploded/EditarPerfil" +
        window.location.search,
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
        this.cantinasOld = json.cantinasVisiveis;
        this.cantinas = json.cantinasVisiveis;
      } else {
        window.location.href = "http://localhost:3000/";
      }
    });
  },
  methods: {
    tornarInvisivel: function(id) {
      for (var t in this.cantinas) {
        if (this.cantinas[t].cantinaVisivelId == id) {
          this.cantinas[t].visivel = false;
        }
      }
      let i = 1;
      for (var s in this.cantinas) {
        if (this.cantinas[s].visivel == true) {
          this.cantinas[s].posicao = i;
          i++;
        }
      }
    },
    tornarVisivel: function(id) {
      for (var t in this.cantinas) {
        if (this.cantinas[t].cantinaVisivelId == id) {
          this.cantinas[t].visivel = true;
        }
      }
      let i = 1;
      for (var s in this.cantinas) {
        if (this.cantinas[s].visivel == true) {
          this.cantinas[s].posicao = i;
          i++;
        }
      }
    },
    onMoveCallback: function() {
      let i = 1;
      for (var t in this.cantinas) {
        if (this.cantinas[t].visivel == true) {
          this.cantinas[t].posicao = i;
          i++;
        }
      }
    },
    editarPerfil: function() {
      this.erro = "";
      if (this.nova != "") {
        if (this.atual == "") {
          this.erro = "Por favor, introduza a sua palavra-passe atual.";
        }
        if (this.nova2 == "") {
          this.erro = "Por favor, repita a nova palavra-passe.";
        } else {
          if (this.nova != this.nova2) {
            this.erro = "A nova palavra-passe tem de corresponder.";
          }
        }
      } else {
        if (this.atual != "" || this.nova2 != "") {
          this.erro = "Por favor, introduza a sua nova palavra-passe.";
        }
      }
      let cantinasNew = this.cantinas;
      if (this.nif == "") {
        this.nif = 0;
      }
      if (this.erro == "") {
        const response = fetch(
          "http://localhost:8080/tickeat_war_exploded/EditarPerfil",
          {
            headers: {
              "Content-Type": "application/json; charset=utf-8"
            },
            credentials: "include",
            method: "POST",
            body: JSON.stringify({
              cantinasVisiveis: cantinasNew,
              nome: this.nome,
              contribuinte: this.nif + "",
              novaPassword: this.nova,
              atualPassword: this.atual
            })
          }
        );
        response
          .then(json => json.json())
          .then(json2 => {
            if (json2.success) {
              this.$router.push("/perfil");
            } else {
              this.erro = "Ocorreu um erro no processo de edição do perfil.";
            }
          });
      }
    }
  }
};
</script>

<style scoped>
input {
  border: none;
  border-bottom: 1px solid #c4c4c4;
  background-repeat: no-repeat;
  background-position: left center;
  -webkit-box-shadow: none;
  box-shadow: none;
  border-radius: 0;
}

input[name="nome"] {
  background-image: url(../../assets/user.png);
  background-size: 20px 20px;
  padding-left: 40px;
}

input[name="nif"] {
  background-image: url(../../assets/nif.png);
  background-size: 30px 20px;
  padding-left: 40px;
}
</style>