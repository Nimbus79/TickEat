<template>
  <v-app>
    <Header titulo="CARREGAR" />
    <v-content>
      <section class="row">
        <div class="col-12">
          <div class="m-3">
            <b-card class="mt-3" border-variant="light" id="card">
              <div class="row">
                <div
                  class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                  style="text-align: left;"
                >
                  <h3 style="color: black;">CARREGAR SALDO</h3>
                  <h4
                    class="mb-4 mt-4"
                    style="color: black; font-weight: 100;"
                  >Indique o valor que pretende carregar.</h4>
                  <input
                    type="text"
                    name="valor"
                    class="form-control"
                    id="valor"
                    v-model="valor"
                    required
                    style="width: 20%;"
                  />
                  <h4
                    style="color: black; font-weight: 100;"
                    class="mb-4 mt-4"
                  >Selecione o método de pagamento com que pretende carregar o seu saldo.</h4>
                  <b-form-radio
                    class="mb-3 mt-3"
                    value="Multibanco"
                    v-model="metodo"
                    style="color: black;"
                  >
                    <img src="../../assets/multibanco.png" width="150px" />
                  </b-form-radio>
                  <b-form-radio
                    class="mb-3 mt-3"
                    value="MBWay"
                    v-model="metodo"
                    style="color: black;"
                  >
                    <img src="../../assets/mbway.png" width="70px" />
                  </b-form-radio>
                  <b-form-radio
                    class="mb-3 mt-3"
                    value="Paypal"
                    v-model="metodo"
                    style="color: black;"
                  >
                    <img src="../../assets/paypal.png" width="130px" />
                  </b-form-radio>
                  <b-form-radio
                    class="mb-3 mt-3"
                    value="Revolut"
                    v-model="metodo"
                    style="color: black;"
                  >
                    <img src="../../assets/revolut.png" width="110px" />
                  </b-form-radio>
                </div>

                <div
                  class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                  style="text-align: left;"
                >
                  <h4 style="color: black;">CARREGAR SALDO</h4>
                  <h5
                    class="mb-4 mt-4"
                    style="color: black; font-weight: 100;"
                  >Indique o valor que pretende carregar.</h5>
                  <input
                    type="text"
                    name="valor"
                    class="form-control"
                    id="valor"
                    v-model="valor"
                    required
                    style="width: 70%;"
                  />
                  <h5
                    style="color: black; font-weight: 100;"
                    class="mb-4 mt-4"
                  >Selecione o método de pagamento com que pretende carregar o seu saldo.</h5>
                  <b-form-radio
                    class="mb-3 mt-3"
                    value="Multibanco"
                    v-model="metodo"
                    style="color: black;"
                  >
                    <img src="../../assets/multibanco.png" width="125px" />
                  </b-form-radio>
                  <b-form-radio
                    class="mb-3 mt-3"
                    value="MBWay"
                    v-model="metodo"
                    style="color: black;"
                  >
                    <img src="../../assets/mbway.png" width="60px" />
                  </b-form-radio>
                  <b-form-radio
                    class="mb-3 mt-3"
                    value="Paypal"
                    v-model="metodo"
                    style="color: black;"
                  >
                    <img src="../../assets/paypal.png" width="100px" />
                  </b-form-radio>
                  <b-form-radio
                    class="mb-3 mt-3"
                    value="Revolut"
                    v-model="metodo"
                    style="color: black;"
                  >
                    <img src="../../assets/revolut.png" width="90px" />
                  </b-form-radio>
                </div>
              </div>
            </b-card>
            <br />
            <div>
              <b-alert v-if="erro" variant="danger" show>{{ erro }}</b-alert>
            </div>
            <div class="text-center p-3">
              <button
                type="button"
                style="width:12em;"
                class="redbtn"
                v-on:click="carregar()"
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

export default {
  name: "carregar",
  data: function() {
    return {
      valor: "",
      metodo: "",
      erro: ""
    };
  },
  components: {
    Header
  },
  methods: {
    carregar: async function() {
      this.erro = "";
      if (!this.valor) {
        if (this.erro) {
          this.erro += "\n";
        }
        this.erro += "Por favor, introduza um valor para o carregamento.";
      }
      if (this.valor > 750) {
        if (this.erro) {
          this.erro += "\n";
        }
        this.erro += "Por favor, introduza um valor menor.";
      }
      if (!this.metodo) {
        if (this.erro) {
          this.erro += "\n";
        }
        this.erro += "Por favor, selecione o método de pagamento.";
      } else {
        this.erro = "";
        const response = fetch(
          "http://localhost:8080/tickeat_war_exploded/Carregar",
          {
            headers: {
              "Content-Type": "application/json; charset=utf-8"
            },
            credentials: "include",
            method: "POST",
            body: JSON.stringify({
              valor: this.valor,
              metodo: this.metodo
            })
          }
        );
        response
          .then(json => json.json())
          .then(json2 => {
            if (json2.success) {
              this.$router.push("/carregamento?car=" + json2.id);
            } else {
              this.erro = "Ocorreu um erro no processo de carregamento!";
            }
          });
      }
    }
  }
};
</script>

<style scoped lang="scss">
input[type="text"],
select.form-control {
  border: none;
  border-bottom: 1px solid #c4c4c4;
  padding-left: 40px;
  background-image: url(../../assets/euro.png);
  background-repeat: no-repeat;
  background-size: 20px 20px;
  background-position: left center;
  -webkit-box-shadow: none;
  box-shadow: none;
  border-radius: 0;
}
</style>
