<template>
  <v-app>
    <Header titulo="CARREGAMENTO" />
    <v-content>
      <section class="row">
        <div class="col-12">
          <div class="m-3">
            <b-card border-variant="light" id="card">
              <div class="row">
                <div class="col-12" style="text-align: left;">
                  <img
                    v-if="movimento.evento.metodo=='Multibanco'"
                    class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    src="../../assets/multibanco.png"
                    width="300px"
                  />
                  <img
                    v-if="movimento.evento.metodo=='Multibanco'"
                    class="d-none d-sm-block d-md-none d-block d-sm-none"
                    src="../../assets/multibanco.png"
                    width="200px"
                  />
                  <img
                    v-if="movimento.evento.metodo=='Paypal'"
                    class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    src="../../assets/paypal.png"
                    width="250px"
                  />
                  <img
                    v-if="movimento.evento.metodo=='Paypal'"
                    class="d-none d-sm-block d-md-none d-block d-sm-none"
                    src="../../assets/paypal.png"
                    width="150px"
                  />
                  <img
                    v-if="movimento.evento.metodo=='MBWay'"
                    class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    src="../../assets/mbway.png"
                    width="150px"
                  />
                  <img
                    v-if="movimento.evento.metodo=='MBWay'"
                    class="d-none d-sm-block d-md-none d-block d-sm-none"
                    src="../../assets/mbway.png"
                    width="100px"
                  />
                  <img
                    v-if="movimento.evento.metodo=='Revolut'"
                    class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                    src="../../assets/revolut.png"
                    width="240px"
                  />
                  <img
                    v-if="movimento.evento.metodo=='Revolut'"
                    class="d-none d-sm-block d-md-none d-block d-sm-none"
                    src="../../assets/revolut.png"
                    width="140px"
                  />
                </div>
              </div>

              <div>
                <v-simple-table>
                  <template v-slot:default>
                    <tbody style="text-align: left; color:black;">
                      <tr>
                        <td style="font-weight: 700; font-size: 1.2em;">ENTIDADE:</td>
                        <td
                          style="font-weight: 100; font-size: 1.1em;"
                        >{{ movimento.evento.entidade }}</td>
                      </tr>
                      <tr>
                        <td style="font-weight: 700; font-size: 1.2em;">REFERÊNCIA:</td>
                        <td
                          style="font-weight: 100; font-size: 1.1em;"
                        >{{ movimento.evento.referencia }}</td>
                      </tr>
                      <tr>
                        <td style="font-weight: 700; font-size: 1.2em;">VALOR:</td>
                        <td style="font-weight: 100; font-size: 1.1em;">{{ movimento.valor }}€</td>
                      </tr>
                      <tr>
                        <td style="font-weight: 700; font-size: 1.2em;">VALIDADE:</td>
                        <td
                          style="font-weight: 100; font-size: 1.1em;"
                        >{{ movimento.evento.validade }}</td>
                      </tr>
                      <tr>
                        <td style="font-weight: 700; font-size: 1.2em;">ESTADO:</td>
                        <td
                          style="font-weight: 100; font-size: 1.1em;"
                          v-if="movimento.efetuado"
                        >Efetuado</td>
                        <td
                          style="font-weight: 100; font-size: 1.1em;"
                          v-else
                        >Pendente ({{ movimento.timestamp }})</td>
                      </tr>
                    </tbody>
                  </template>
                </v-simple-table>
              </div>
            </b-card>

            <div v-if="movimento.evento.fatura">
              <div class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block">
                <div class="row">
                  <div class="col-6">
                    <div class="text-center p-3 mt-2">
                      <button
                        type="button"
                        class="redbtn"
                        @click="$router.go(-1)"
                        style="width: 15em; font-size: 1em;"
                      >VOLTAR</button>
                    </div>
                  </div>
                  <div class="col-6">
                    <div class="text-center p-3 mt-2">
                      <a
                        :download="`fatura${movimento.id}.pdf`"
                        :href="`data:application/octet-stream;base64,${movimento.evento.fatura}`"
                      >
                        <button
                          type="button"
                          class="lightredbtn"
                          style="width: 15em; font-size: 1em;"
                        >DESCARREGAR FATURA</button>
                      </a>
                    </div>
                  </div>
                </div>
              </div>

              <div class="d-none d-sm-block d-md-none d-block d-sm-none">
                <div class="row">
                  <div class="col-12">
                    <div class="text-center p-1 mt-3">
                      <button
                        type="button"
                        class="redbtn"
                        @click="$router.go(-1)"
                        style="width: 12em; font-size: 0.8em;"
                      >VOLTAR</button>
                    </div>
                    <div class="text-center p-1">
                      <a
                        :download="`fatura${movimento.id}.pdf`"
                        :href="`data:application/octet-stream;base64,${movimento.evento.fatura}`"
                      >
                        <button
                          type="button"
                          class="lightredbtn"
                          style="width: 12em; font-size: 0.8em;"
                        >DESCARREGAR FATURA</button>
                      </a>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div v-else>
              <div class="d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block">
                <div class="text-center p-3 mt-2">
                  <button
                    type="button"
                    class="redbtn"
                    @click="$router.go(-1)"
                    style="width: 18em; font-size: 1.3em;"
                  >VOLTAR</button>
                </div>
              </div>

              <div class="d-none d-sm-block d-md-none d-block d-sm-none">
                <div class="text-center p-1 mt-3">
                  <button
                    type="button"
                    class="redbtn"
                    @click="$router.go(-1)"
                    style="width: 12em; font-size: 1em;"
                  >VOLTAR</button>
                </div>
              </div>
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
  name: "saldo",
  data: function() {
    return {
      movimento: {}
    };
  },
  components: {
    Header
  },
  mounted: async function() {
    const response = await fetch(
      "http://localhost:8080/tickeat_war_exploded/Saldos",
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
        const idMov = window.location.search.split("=")[1];
        for (var t in json.carteira.movimentos) {
          if (json.carteira.movimentos[t].id == idMov) {
            this.movimento = json.carteira.movimentos[t];
            return;
          }
        }
      } else {
        window.location.href = "http://localhost:3000/";
      }
    });
  },
  methods: {}
};
</script>