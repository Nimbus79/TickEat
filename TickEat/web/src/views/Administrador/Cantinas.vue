<template>
  <v-app>
    <Header titulo="CANTINAS" />
    <v-content>
      <section class="row">
        <div class="col-12">
          <div class="m-3">
            <a href="/adicionarCantina">
              <button
                class="mt-2 mb-2"
                style="width: 20em;"
                type="button"
                id="nova"
              >Adicionar Cantina</button>
            </a>
            <b-alert
              class="ml-auto mr-auto"
              style="width:50%;"
              v-if="cantinas.length == 0"
              variant="danger"
              show
            >Não possui cantinas definidas!</b-alert>
            <v-data-table
              v-else
              :headers="headers"
              :items="cantinas"
              hide-default-footer
              class="elevation-1"
            >
              <template v-slot:item.ativo="{ item }">
                <i v-if="item.ativo" class="fa fa-eye"></i>
                <i v-else class="fa fa-eye-slash" style="opacity: 0.5;"></i>
              </template>
            </v-data-table>
          </div>
        </div>
      </section>
    </v-content>
  </v-app>
</template>

<script>
import Header from "@/components/HeaderAdministrador.vue";

export default {
  name: "cantinas",
  components: {
    Header
  },
  data: () => ({
    cantinas: [],
    headers: [
      { text: "Nome", align: "left", value: "nome" },
      { text: "Localização", align: "left", value: "localizacao" },
      { text: "Descrição", align: "left", value: "descricao" },
      { text: "Ativo", align: "left", value: "ativo" }
    ]
  }),
  mounted: async function() {
    const response = await fetch(
      "http://localhost:8080/tickeat_war_exploded/Cantinas",
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
      }
      else {
        window.location.href = "http://localhost:3000";
      }
    });
  }
};
</script>

<style scoped lang="scss">
button {
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
</style>