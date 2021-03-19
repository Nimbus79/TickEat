<template>
  <div class="p-3">
    <Language />
    <div>
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
    </div>
    <div>
      <div class="row">
        <div class="container col-12 d-flex justify-content-center">
          <form>
            <h1
              class="text-center pt-5 pb-3"
              style="color:#000000; font-size:2em; font-weight:600;"
            >DEFINIR PALAVRA-PASSE</h1>
            <p style="font-weight:100;">Por favor, defina a palavra-passe da sua conta.</p>

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
            <div class="form-group">
              <label
                for="password2"
                class="control-label"
                style="color:#c4c4c4; font-size:1.2em; float:left;"
              >Repete a Palavra-Passe</label>
              <input
                type="password"
                name="password2"
                class="form-control"
                id="password2"
                v-model="password2"
                required
              />
            </div>
            <br />
            <div>
              <b-alert v-if="erro" variant="danger" show>{{ erro }}</b-alert>
              <b-alert v-if="msg" variant="success" show>
                {{ msg }} Efetuar o
                <a href="/" style="color: inherit; text-decoration: none;">
                  <u>login</u>
                </a>.
              </b-alert>
              <br />
            </div>
            <div class="text-center p-3">
              <button type="button" class="redbtn" v-on:click="definirPassword()">ENVIAR</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import Language from "@/components/Language.vue";

export default {
  name: "login",
  components: {
    Language
  },
  data: () => ({
    password: "",
    password2: "",
    erro: "",
    msg: ""
  }),
  methods: {
    definirPassword: async function() {
      if (this.password != "") {
        if (this.password != this.password2) {
          this.erro = "As palavras-passe não correspondem!";
        } else {
          const response = await fetch(
            "http://localhost:8080/tickeat_war_exploded/Password",
            {
              headers: {
                "Content-Type": "application/json; charset=utf-8"
              },
              method: "POST",
              body: JSON.stringify({
                email: this.$route.query.email,
                password: this.password
              })
            }
          );
          response.json().then(json => {
            if (!json.success) {
              this.erro = "Já definiu a sua palavra-passe!";
            } else {
              this.msg = "Palavra-passe definida com sucesso.";
            }
          });
        }
      } else {
        this.erro = "Introduza uma palavra-passe!";
      }
    }
  }
};
</script>

<style scoped lang="scss">
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