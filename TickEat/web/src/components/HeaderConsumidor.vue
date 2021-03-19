<template>
  <div>
    <v-navigation-drawer app v-model="drawer" absolute temporary>
      <v-list-item>
        <v-img src="../assets/logo_tijolo.png" class="mt-3"></v-img>
      </v-list-item>

      <v-divider></v-divider>

      <v-list dense>
        <v-list-item v-for="item in items" :key="item.title" link>
          <v-list-item-icon>
            <a v-if="item.click" @click="logout()" style="color: inherit; text-decoration: none;">
              <v-icon style="color:#87132a">{{ item.icon }}</v-icon>
            </a>

            <a v-else :href="item.ref" style="color: inherit; text-decoration: none;">
              <v-icon style="color:#87132a">{{ item.icon }}</v-icon>
            </a>
          </v-list-item-icon>

          <v-list-item-content>
            <span
              v-if="item.click"
              v-on:click="logout()"
              style="color: inherit; text-decoration: none;"
            >
              <v-list-item-title style="text-align: left; font-size: 0.9em;">{{ item.title }}</v-list-item-title>
            </span>
            <a v-else :href="item.ref" style="color: inherit; text-decoration: none;">
              <v-list-item-title style="text-align: left; font-size: 0.9em;">{{ item.title }}</v-list-item-title>
            </a>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar
      app
      style="background-color: white; box-shadow: 3px 5px 5px rgba(80, 81, 82, 0.705);"
    >
      <v-btn @click.stop="drawer = !drawer">
        <img
          src="../assets/menu.png"
          style="width:1.5em; cursor:pointer;"
          class="d-inline-block align-top"
        />
      </v-btn>
      <v-toolbar-title class="ml-5">
        <b>{{ titulo }}</b>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <img src="../assets/pt.png" class="mr-3" style="width:1.5em;" />
      <img src="../assets/en.png" style="width:1.5em;" />
    </v-app-bar>
  </div>
</template>

<script>
export default {
  props: ["titulo"],
  data: () => {
    return {
      drawer: null,
      items: [
        { title: "Página Inicial", icon: "fa fa-th-large", ref: "/inicio" },
        { title: "Perfil", icon: "fa fa-user-circle-o", ref: "/perfil" },
        { title: "Saldo", icon: "fa fa-money", ref: "/saldo" },
        { title: "Refeições", icon: "fa fa-cutlery", ref: "/calendario" },
        { title: "Informações", icon: "fa fa-info-circle", ref: "#" },
        { title: "Notificações", icon: "fa fa-bell", ref: "#" },
        { title: "Logout", icon: "fa fa-sign-out", click: "logout()" }
      ]
    };
  },
  methods: {
    logout: async function() {
      await fetch("http://localhost:8080/tickeat_war_exploded/Terminar", {
        headers: {
          "Content-Type": "application/json; charset=utf-8"
        },
        credentials: "include",
        method: "GET"
      });
      window.location.href = "http://localhost:3000/";
    }
  }
};
</script>