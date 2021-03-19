<template>
  <v-app>
    <Header titulo="PEDIDOS" />
    <v-content>
      <section class="row">
        <div class="col-12">
          <div class="m-3">
            <b-alert
              class="ml-auto mr-auto"
              style="width:50%;"
              v-if="pedidos.length == 0"
              variant="danger"
              show
            >Não possui pedidos de conta pendentes!</b-alert>

            <v-data-table
              v-else
              :headers="headers"
              :items="pedidos"
              hide-default-footer
              class="elevation-1"
            >
              <template v-slot:item.aceitar="{ item }">
                <button type="button" id="aceitar" v-on:click="aceitar(item.id)">Aceitar</button>
              </template>

              <template v-slot:item.recusar="{ item }">
                <button type="button" id="recusar" v-on:click="recusar(item.id)">Recusar</button>
              </template>
            </v-data-table>
          </div>
        </div>
      </section>
    </v-content>
  </v-app>
</template>

<style lang="scss" scoped>
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  border: none;
  color: black;
}

#aceitar {
  border: none;
  border-radius: 45px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
  padding: 5px;
  width: 100%;
  background-color: #13872e;
  color: white;

  &:hover {
    color: white;
    background-color: #13872e;
    text-decoration: none;
    box-shadow: 0px 5px 5px rgba(2, 29, 44, 0.705);
    transform: translateY(-5px);
  }
}

#recusar {
  border: none;
  border-radius: 45px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
  padding: 5px;
  width: 100%;
  background-color: #d22346;
  color: white;

  &:hover {
    color: white;
    background-color: #d22346;
    text-decoration: none;
    box-shadow: 0px 5px 5px rgba(2, 29, 44, 0.705);
    transform: translateY(-5px);
  }
}
</style>

<script>
import Header from "@/components/HeaderAdministrador.vue";

export default {
  name: "pedidosConta",
  components: {
    Header
  },
  data: () => ({
    pedidos: [],
    headers: [
      { text: "Email", align: "left", value: "consumidorEmail" },
      { text: "Tipo de Consumidor", align: "left", value: "tipoConsumidor" },
      { text: "Aceitar", align: "left", value: "aceitar" },
      { text: "Recusar", align: "left", value: "recusar" }
    ]
  }),
  mounted: async function() {
    const response = await fetch(
      "http://localhost:8080/tickeat_war_exploded/Pedidos",
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
        this.pedidos = json.pedidos;
      } else {
        window.location.href = "http://localhost:3000";
      }
    });
  },
  methods: {
    aceitar: async function(id) {
      await fetch("http://localhost:8080/tickeat_war_exploded/Pedidos", {
        headers: {
          "Content-Type": "application/json; charset=utf-8"
        },
        credentials: "include",
        method: "POST",
        body: JSON.stringify({
          valida: "true",
          pedidoId: id + ""
        })
      });
      location.reload();
    },
    recusar: async function(id) {
      await fetch("http://localhost:8080/tickeat_war_exploded/Pedidos", {
        headers: {
          "Content-Type": "application/json; charset=utf-8"
        },
        credentials: "include",
        method: "POST",
        body: JSON.stringify({
          valida: "false",
          pedidoId: id + ""
        })
      });
      location.reload();
    }
  }
};
</script>