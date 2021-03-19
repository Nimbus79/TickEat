<template>
  <v-app>
    <Header titulo="PERFIL" />
    <v-content>
      <section class="row">
        <div class="col-12">
          <div class="m-3">
            <b-card-group deck>
              <b-card border-variant="light" id="card">
                <div class="row">
                  <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 mt-auto mb-auto">
                    <h3 class="text-uppercase" style="color: black;">{{ nome }}</h3>
                    <h5 style="color: black; font-weight: 100;">{{ email }}</h5>
                    <h5
                      class="text-uppercase"
                      style="color: black; font-weight: 100;"
                      v-if="nif!=0"
                    >
                      <b>NIF:</b>
                      {{ nif }}
                    </h5>
                    <img
                      v-if="foto"
                      class="mr-auto ml-auto"
                      style="width: 150px; height: 150px; display: block; border-radius: 100px; -webkit-border-radius: 100px; -moz-border-radius: 100px;"
                      :src="`data:image/png;base64,${foto}`"
                    />
                    <img
                      v-else
                      class="mr-auto ml-auto"
                      style="width: 150px; height: 150px; display: block; border-radius: 100px; -webkit-border-radius: 100px; -moz-border-radius: 100px;"
                      src="../../assets/profile_pic.png"
                    />
                    <p
                      class="mt-1"
                      style="font-weight: 300; cursor:pointer;"
                      @click="$bvModal.show('alterarFoto')"
                    >
                      <span>
                        <i class="fa fa-camera" style="font-size:18px; color: black;"></i>
                        ALTERAR FOTOGRAFIA
                      </span>
                    </p>
                  </div>
                  <div
                    class="col-xl-6 col-lg-6 col-md-6 col-sm-12 mt-auto mb-auto"
                    style="text-align: center;"
                  >
                    <img
                      class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                      style="width: 95%;"
                      :src="`data:image/png;base64,${identificador}`"
                    />
                    <img
                      class="d-none d-sm-block d-md-none d-block d-sm-none mr-auto ml-auto"
                      style="width: 60%;"
                      :src="`data:image/png;base64,${identificador}`"
                    />
                  </div>
                </div>
              </b-card>
              <b-modal id="alterarFoto" hide-footer>
                <template v-slot:modal-title>ALTERAR FOTOGRAFIA</template>
                <div class="row">
                  <div class="col-12 text-center">
                    <input type="file" id="fileUpload" @change="handleImageUpload" />
                    <div class="text-center m-3">
                      <button
                        type="button"
                        class="redbtn mt-4"
                        @click="uploadFoto()"
                        style="width: 15em; font-size: 1.2em;"
                      >SUBMETER</button>
                    </div>
                  </div>
                </div>
              </b-modal>

              <b-card
                class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                border-variant="light"
                id="card"
              >
                <h3 class="text-uppercase" style="color: black;">CANTINAS VISÍVEIS</h3>
                <div v-for="(item, index) in cantinas" :key="index" class="row">
                  <b-card border-variant="light" id="smallcard" class="m-1">
                    <div class="col-12" style="text-align: left;">
                      <span
                        class="mr-4 step"
                        style="font-weight:1000; font-size: 1.2em; color: white;"
                      >{{ cantinas[index].posicao }}</span>
                      <span
                        style="font-weight:500; font-size: 1.2em; color: black;"
                      >{{ cantinas[index].cantinaNome }}</span>
                    </div>
                  </b-card>
                </div>
              </b-card>

              <b-card
                border-variant="light"
                id="card"
                class="d-none d-sm-block d-md-none d-block d-sm-none"
              >
                <h3 class="text-uppercase" style="font-size: 1.3em;color: black;">CANTINAS VISÍVEIS</h3>
                <div v-for="(item, index) in cantinas" :key="index" class="row">
                  <b-card border-variant="light" id="smallcard" class="m-1" style="width:100%;">
                    <div class="col-12" style="text-align: left;">
                      <span
                        class="mr-4 step"
                        style="font-weight:1000; font-size: 1.2em; color: white;"
                      >{{ cantinas[index].posicao }}</span>
                      <span
                        style="font-weight:500; font-size: 1.2em; color: black;"
                      >{{ cantinas[index].cantinaNome }}</span>
                    </div>
                  </b-card>
                </div>
              </b-card>
            </b-card-group>
            <b-alert v-if="erro" variant="danger" show>{{ erro }}</b-alert>
            <div
              class="text-center m-3 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
            >
              <button
                type="button"
                class="redbtn mt-4"
                v-on:click="editarPerfil()"
                style="width: 15em; font-size: 1.2em;"
              >EDITAR PERFIL</button>
            </div>

            <div class="text-center m-3 d-none d-sm-block d-md-none d-block d-sm-none">
              <button
                type="button"
                class="redbtn mt-4"
                v-on:click="editarPerfil()"
                style="width: 11em; font-size: 1em;"
              >EDITAR PERFIL</button>
            </div>
          </div>
        </div>
      </section>
    </v-content>
  </v-app>
</template>

<script>
import Header from "@/components/HeaderConsumidor.vue";

export default {
  name: "perfil",
  data: function() {
    return {
      nome: "",
      email: "",
      nif: "",
      foto: "",
      identificador: "",
      cantinas: [],
      ficheiroSelecionado: "",
      erro: ""
    };
  },
  components: {
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
        this.email = json.perfil.email;
        this.nif = json.perfil.contribuinte;
        this.cantinas = json.perfil.cantinasVisiveis;
        this.foto = json.perfil.fotografia;
        this.identificador = json.perfil.identificador;
      } else {
        window.location.href = "http://localhost:3000/";
      }
    });
  },
  methods: {
    editarPerfil: function() {
      this.$router.push("/editarPerfil");
    },
    handleImageUpload: function(event) {
      this.ficheiroSelecionado = event.target.files[0];
    },
    uploadFoto: async function() {
      var file = this.ficheiroSelecionado;
      let reader = new FileReader();
      reader.readAsDataURL(file);
      reader.onloadend = async function() {
        var b64 = reader.result.replace(/^data:.+;base64,/, "");
        this.ficheiroSelecionado = b64;
        const response = await fetch(
          "http://localhost:8080/tickeat_war_exploded/Perfil",
          {
            headers: {
              "Content-Type": "application/json; charset=utf-8"
            },
            credentials: "include",
            method: "POST",
            body: JSON.stringify({
              foto: this.ficheiroSelecionado
            })
          }
        );
        response.json().then(json => {
          if (json.success == false) {
            this.erro = "Ocorreu um erro no envio da fotografia.";
          } else {
            location.reload();
          }
        });
      };
    }
  }
};
</script>

<style>
.step {
  background: #87132a;
  border-radius: 0.8em;
  -moz-border-radius: 0.8em;
  -webkit-border-radius: 0.8em;
  display: inline-block;
  font-weight: bold;
  line-height: 1.6em;
  margin-right: 5px;
  text-align: center;
  width: 1.6em;
}
</style>