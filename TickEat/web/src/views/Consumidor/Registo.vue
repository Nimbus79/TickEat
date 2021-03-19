<template>
  <div class="p-3">
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
      integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
      crossorigin="anonymous"
    />
    <div style="float:left;">
      <i
        @click="$router.go(-1)"
        class="fas fa-angle-left p-4"
        style="font-size:40px; color:black; cursor:pointer; position: fixed;"
      ></i>
    </div>
    <Language />
    <div class="container">
      <img
        class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
        style="display: block; margin-left: auto; margin-right: auto;"
        src="../../assets/logo_tijolo.png"
        width="35%"
      />
      <img
        class="d-none d-sm-block d-md-none d-block d-sm-none"
        style="display: block; margin-left: auto; margin-right: auto;"
        src="../../assets/logo_tijolo.png"
        width="60%"
      />
      <div>
        <div class="row">
          <div class="col-12 d-flex" style="justify-content: center;">
            <form id="registo">
              <h1
                class="text-center pt-5 pb-3 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                style="color:#000000; font-size:2em; font-weight:600;"
              >NOVA CONTA</h1>

              <h1
                class="text-center pt-3 pb-3 d-none d-sm-block d-md-none d-block d-sm-none"
                style="color:#000000; font-size:1.2em; font-weight:600;"
              >NOVA CONTA</h1>

              <p
                style="font-weight:100;"
                class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
              >
                Por favor, introduza o seu endereço de e-mail institucional.
                <br />Irá receber um e-mail onde deverá definir a sua palavra-passe.
              </p>

              <p style="font-weight:100;" class="d-none d-sm-block d-md-none d-block d-sm-none">
                Por favor, introduza o seu nome e endereço de e-mail institucional.
                Irá receber um e-mail onde deverá definir a sua palavra-passe.
              </p>

              <div class="form-group">
                <label
                  for="nome"
                  class="control-label"
                  style="color:#c4c4c4; font-size:1.2em; float:left;"
                >Nome</label>
                <br />
                <input
                  type="text"
                  name="nome"
                  class="form-control"
                  id="nome"
                  v-model="nome"
                  required
                />
              </div>

              <div class="form-group">
                <label
                  for="email"
                  class="control-label"
                  style="color:#c4c4c4; font-size:1.2em; float:left;"
                >E-mail</label>
                <br />
                <input
                  type="email"
                  name="email"
                  class="form-control"
                  id="email"
                  v-model="email"
                  required
                />
              </div>
              <br />
              <div class="form-group">
                <label
                  for="tipo"
                  class="control-label"
                  style="color:#c4c4c4; font-size:1.2em; float:left;"
                >Tipo de Utilizador</label>

                <select
                  name="tipo"
                  class="form-control"
                  id="tipo"
                  form="registo"
                  v-model="tipoConsumidorId"
                  required
                >
                  <option
                    v-for="tipo in tiposConsumidor"
                    :key="tipo.id"
                    :value="tipo.id"
                  >{{ tipo.nome }}</option>
                </select>
              </div>
              <br />
              <b-alert v-if="erro" variant="danger" show>{{ erro }}</b-alert>
              <b-alert v-if="msg" variant="success" show>{{ msg }}</b-alert>
              <div class="text-center p-3">
                <button type="button" class="redbtn" v-on:click="registo()">ENVIAR</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Language from "@/components/Language.vue";

export default {
  name: "registo",
  components: {
    Language
  },
  data: () => ({
    nome: "",
    email: "",
    tipoConsumidorId: "",
    tiposConsumidor: [],
    erro: "",
    msg: ""
  }),
  mounted: async function() {
    const response = await fetch(
      "http://localhost:8080/tickeat_war_exploded/Registar",
      {
        headers: {
          "Content-Type": "application/json; charset=utf-8"
        },
        method: "GET"
      }
    );
    response.json().then(json => {
      if (json.success) {
        this.tiposConsumidor = JSON.parse(json.tiposConsumidor);
      } else {
        window.location.href = "http://localhost:3000/";
      }
    });
  },
  methods: {
    registo: async function() {
      const response = await fetch(
        "http://localhost:8080/tickeat_war_exploded/Registar",
        {
          headers: {
            "Content-Type": "application/json; charset=utf-8"
          },
          credentials: "include",
          method: "POST",
          body: JSON.stringify({
            nome: this.nome,
            utilizadorEmail: this.email,
            tipoConsumidorId: this.tipoConsumidorId + ""
          })
        }
      );
      response.json().then(json => {
        if (json.success) {
          this.msg = "Registo efetuado com sucesso.";
        } else {
          this.erro = "Ocorreu um erro no seu registo.";
        }
      });
    }
  }
};
</script>

<style scoped lang="scss">
input[type="text"] {
  border: none;
  border-bottom: 1px solid #c4c4c4;
  padding-left: 40px;
  background-image: url(../../assets/user.png);
  background-repeat: no-repeat;
  background-size: 20px 20px;
  background-position: left center;
  -webkit-box-shadow: none;
  box-shadow: none;
  border-radius: 0;
}

input[type="email"] {
  border: none;
  border-bottom: 1px solid #c4c4c4;
  padding-left: 40px;
  background-image: url(../../assets/envelope.png);
  background-repeat: no-repeat;
  background-size: 20px 20px;
  background-position: left center;
  -webkit-box-shadow: none;
  box-shadow: none;
  border-radius: 0;
}

select,
select.form-control {
  border: none;
  border-bottom: 1px solid #c4c4c4;
  padding-left: 40px;
  background-position: left center;
  -webkit-box-shadow: none;
  box-shadow: none;
  border-radius: 0;
}

#redbtn {
  font-weight: 500;
  border: none;
  border-radius: 45px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
  font-size: 1.2em;
  text-align: center;
  margin-left: 2%;
  padding-top: 10px;
  padding-bottom: 10px;
  padding-right: 40px;
  padding-left: 40px;
  background-color: #545871;
  color: #fff;
}

#redbtn:hover {
  color: #545871;
  background-color: white;
  text-decoration: none;
  box-shadow: 0px 5px 5px rgba(2, 29, 44, 0.705);
  transform: translateY(-5px);
}
</style>
