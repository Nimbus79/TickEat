<template>
  <div class="p-3">
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
      integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
      crossorigin="anonymous"
    />
    <Language />
    <div class="loginform">
      <img
        class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
        style="display: block; margin-left: auto; margin-right: auto;"
        src="../assets/logo_tijolo.png"
        width="25%"
      />
      <img
        class="d-none d-sm-block d-md-none d-block d-sm-none"
        style="display: block; margin-left: auto; margin-right: auto;"
        src="../assets/logo_tijolo.png"
        width="60%"
      />
      <div>
        <div class="row">
          <div class="container col-12 d-flex justify-content-center">
            <form>
              <h1
                class="text-center pt-5 pb-3 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                style="color:#000000; font-size:2em; font-weight:600;"
              >BEM-VINDO!</h1>

              <h1
                class="text-center pt-3 pb-3 d-none d-sm-block d-md-none d-block d-sm-none"
                style="color:#000000; font-size:1.2em; font-weight:600;"
              >BEM-VINDO!</h1>

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
                  for="password"
                  class="control-label"
                  style="color:#c4c4c4; font-size:1.2em; float:left;"
                >Palavra-Passe</label>
                <input
                  type="password"
                  name="password"
                  class="form-control"
                  id="password"
                  v-model="password"
                  required
                />
              </div>
              <br />
              <div style="float:left;">
                <input v-model="sessao" type="checkbox" name="sessao" /> Manter sessão iniciada
              </div>
              <br />
              <b-alert
                v-if="erro"
                variant="danger"
                style="width: 370px;"
                show
                class="mt-3 mb-1"
              >{{ erro }}</b-alert>
              <div class="text-center p-3">
                <button type="button" class="redbtn" v-on:click="login()">ENTRAR</button>
              </div>
              <h2 class="text-center p-1" style="color:#000000; font-size:1em;">
                <u>Esqueceste-te da tua palavra-passe?</u>
              </h2>

              <br />
              <h2 class="text-center p-1" style="color:#000000; font-size:1.1em;">
                AINDA NÃO TEM UMA CONTA?
                <b>
                  <u @click="registar()" style="cursor: pointer;">REGISTE-SE!</u>
                </b>
              </h2>
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
  name: "login",
  data: () => ({
    email: "",
    password: "",
    erro: "",
    sessao: false
  }),
  components: {
    Language
  },
  methods: {
    registar: function() {
      this.$router.push("/registo");
    },
    login: async function() {
      this.erro = "";
      if (this.email == "" && this.password == "") {
        this.erro =
          "Por favor, introduza o endereço de e-mail e a palavra-passe.";
      } else if (this.email == "" && this.password != "") {
        this.erro = this.erro = "Por favor, introduza o endereço de e-mail.";
      } else if (this.email != "" && this.password == "") {
        this.erro = this.erro = "Por favor, introduza a palavra-passe.";
      } else {
        const response = await fetch(
          "http://localhost:8080/tickeat_war_exploded/",
          {
            headers: {
              "Content-Type": "application/json; charset=utf-8"
            },
            credentials: "include",
            method: "POST",
            body: JSON.stringify({
              email: this.email,
              password: this.password,
              sessao: this.sessao + ""
            })
          }
        );
        response.json().then(json => {
          if (json.success) {
            if (json.tipo == "Consumidor") {
              window.location.href = "http://localhost:3000/perfil";
            }
            if (json.tipo == "Administrador") {
              window.location.href = "http://localhost:3000/pedidos";
            }
            if (json.tipo == "Cozinheiro") {
              window.location.href = "http://localhost:3000/inicioCoz";
            }
          } else {
            this.erro = "Endereço de e-mail ou palavra-passe inválidos.";
          }
        });
      }
    }
  }
};
</script>

<style scoped lang="scss">
input[type="email"],
select.form-control {
  border: none;
  border-bottom: 1px solid #c4c4c4;
  padding-left: 40px;
  background-image: url(../assets/envelope.png);
  background-repeat: no-repeat;
  background-size: 20px 20px;
  background-position: left center;
  -webkit-box-shadow: none;
  box-shadow: none;
  border-radius: 0;
}

input[type="password"],
select.form-control {
  border: none;
  border-bottom: 1px solid #c4c4c4;
  padding-left: 40px;
  background-image: url(../assets/cadeado.png);
  background-repeat: no-repeat;
  background-size: 20px 20px;
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