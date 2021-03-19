<template>
  <v-app>
    <Header titulo="ADICIONAR CANTINA" />
    <v-content>
      <section class="row">
        <div class="col-12">
          <div class="m-3">
            <b-card border-variant="light" id="card">
              <div class="row">
                <div
                  class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                  style="text-align: left;"
                >
                  <h3 class="text-uppercase" style="color: black;">CANTINA</h3>
                </div>

                <div
                  class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                  style="text-align: left;"
                >
                  <h5 class="text-uppercase" style="color: black;">CANTINA</h5>
                </div>
              </div>
              <b-card-text>
                <form>
                  <div class="form-row" style="text-align: left;">
                    <div class="form-group col-md-6">
                      <label style="color: #87132a;" for="nome">NOME</label>
                      <input
                        type="text"
                        class="form-control"
                        id="nome"
                        placeholder="Nome da cantina"
                        v-model="nome"
                      />
                    </div>
                    <div class="form-group col-md-6">
                      <label style="color: #87132a;" for="local">LOCALIZAÇÃO</label>
                      <input
                        type="text"
                        class="form-control"
                        id="local"
                        placeholder="Localização"
                        v-model="localizacao"
                      />
                    </div>
                    <div class="form-group col-md-12">
                      <label style="color: #87132a;" for="desc">DESCRIÇÃO</label>
                      <input
                        type="text"
                        class="form-control"
                        id="desc"
                        placeholder="Descrição"
                        v-model="descricao"
                      />
                    </div>
                  </div>
                </form>
              </b-card-text>
            </b-card>

            <b-card border-variant="light" id="card" class="mt-3">
              <div class="row">
                <div
                  class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                  style="text-align: left;"
                >
                  <h3 class="text-uppercase" style="color: black;">REFEIÇÕES</h3>
                </div>

                <div
                  class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                  style="text-align: left;"
                >
                  <h5 class="text-uppercase" style="color: black;">REFEIÇÕES</h5>
                </div>
              </div>
              <b-card-text>
                <form>
                  <div class="row">
                    <div class="col-2">
                      <button
                        type="button"
                        v-on:click="addNewRefeicaoInfo"
                        class="btn btn-block btn-success"
                      >Adicionar</button>
                    </div>
                  </div>
                  <hr />
                  <div v-for="(refeicaoInfo, index) in refeicoesInfo" v-bind:key="index">
                    <div>
                      <label>&nbsp;</label>
                      <button
                        style="width: 15%;"
                        type="button"
                        v-on:click="removeRefeicaoInfo(index)"
                        class="btn btn-block btn-danger"
                      >Remover</button>
                    </div>
                    <div class="row" style="text-align: left;">
                      <div class="form-group col-4">
                        <label style="color: #87132a;" for="nome">NOME</label>
                        <input
                          type="text"
                          class="form-control"
                          id="nome"
                          placeholder="Nome da refeição"
                          v-model="refeicaoInfo.nome"
                        />
                      </div>

                      <div class="form-group col-4">
                        <label style="color: #87132a;" for="nome">HORA DE INÍCIO</label>
                        <input
                          type="time"
                          class="form-control"
                          id="horaInicio"
                          placeholder="Hora de início da refeição"
                          v-model="refeicaoInfo.horaInicio"
                        />
                      </div>

                      <div class="form-group col-4">
                        <label style="color: #87132a;" for="nome">HORA DE FIM</label>
                        <input
                          type="time"
                          class="form-control"
                          id="horaFim"
                          placeholder="Hora de fim da refeição"
                          v-model="refeicaoInfo.horaFim"
                        />
                      </div>
                    </div>

                    <div class="row" style="text-align: left;">
                      <div class="form-group col-4">
                        <label style="color: #87132a;" for="nome">HORA LIMITE</label>
                        <input
                          type="time"
                          class="form-control"
                          id="horaLimite"
                          placeholder="Hora limite para reserva e cancelamento sem penalização"
                          v-model="refeicaoInfo.horaLimite"
                        />
                      </div>

                      <div class="form-group col-4">
                        <label style="color: #87132a;" for="nome">DESCONTO</label>
                        <input
                          type="number"
                          step="0.01"
                          class="form-control"
                          id="desconto"
                          placeholder="Desconto para reservas até à hora limite"
                          v-model="refeicaoInfo.desconto"
                        />
                      </div>

                      <div class="form-group col-4">
                        <label style="color: #87132a;" for="nome">TAXA DE CANCELAMENTO</label>
                        <input
                          type="number"
                          step="0.01"
                          class="form-control"
                          id="cancelamento"
                          placeholder="Taxa para cancelamentos após a hora limite"
                          v-model="refeicaoInfo.taxaCancelamento"
                        />
                      </div>
                    </div>

                    <div style="text-align: left;">
                      <div class="form-group">
                        <div class="row">
                          <label class="col-12" style="color: #87132a;">DIAS DA SEMANA</label>
                        </div>
                        <div class="row ml-1">
                          <div class="custom-control custom-checkbox col-1">
                            <input
                              type="checkbox"
                              class="custom-control-input"
                              :id="`seg${index}`"
                              v-model="refeicaoInfo.segunda"
                            />
                            <label class="custom-control-label" :for="`seg${index}`">Segunda</label>
                          </div>

                          <div class="custom-control custom-checkbox col-1">
                            <input
                              type="checkbox"
                              class="custom-control-input"
                              :id="`ter${index}`"
                              v-model="refeicaoInfo.terca"
                            />
                            <label class="custom-control-label" :for="`ter${index}`">Terça</label>
                          </div>

                          <div class="custom-control custom-checkbox col-1">
                            <input
                              type="checkbox"
                              class="custom-control-input"
                              :id="`qua${index}`"
                              v-model="refeicaoInfo.quarta"
                            />
                            <label class="custom-control-label" :for="`qua${index}`">Quarta</label>
                          </div>

                          <div class="custom-control custom-checkbox col-1">
                            <input
                              type="checkbox"
                              class="custom-control-input"
                              :id="`qui${index}`"
                              v-model="refeicaoInfo.quinta"
                            />
                            <label class="custom-control-label" :for="`qui${index}`">Quinta</label>
                          </div>

                          <div class="custom-control custom-checkbox col-1">
                            <input
                              type="checkbox"
                              class="custom-control-input"
                              :id="`sex${index}`"
                              v-model="refeicaoInfo.sexta"
                            />
                            <label class="custom-control-label" :for="`sex${index}`">Sexta</label>
                          </div>

                          <div class="custom-control custom-checkbox col-1">
                            <input
                              type="checkbox"
                              class="custom-control-input"
                              :id="`sab${index}`"
                              v-model="refeicaoInfo.sabado"
                            />
                            <label class="custom-control-label" :for="`sab${index}`">Sábado</label>
                          </div>

                          <div class="custom-control custom-checkbox col-1">
                            <input
                              type="checkbox"
                              class="custom-control-input"
                              :id="`dom${index}`"
                              v-model="refeicaoInfo.domigo"
                            />
                            <label class="custom-control-label" :for="`dom${index}`">Domingo</label>
                          </div>
                        </div>
                      </div>
                    </div>
                    <hr />
                  </div>
                </form>
              </b-card-text>
            </b-card>

            <b-card border-variant="light" id="card" class="mt-3">
              <div class="row">
                <div
                  class="col-12 d-none d-md-block d-lg-none d-lg-block d-xl-none d-xl-block"
                  style="text-align: left;"
                >
                  <h3 class="text-uppercase" style="color: black;">TIPOS DE REFEIÇÃO</h3>
                </div>

                <div
                  class="col-12 d-none d-sm-block d-md-none d-block d-sm-none"
                  style="text-align: left;"
                >
                  <h5 class="text-uppercase" style="color: black;">TIPOS DE REFEIÇÃO</h5>
                </div>
              </div>
              <b-card-text>
                <form>
                  <div class="row">
                    <div class="col-2">
                      <button
                        type="button"
                        v-on:click="addNewTipoRefeicao"
                        class="btn btn-block btn-success"
                      >Adicionar</button>
                    </div>
                  </div>
                  <hr />
                  <div v-for="(tipoRefeicao, index) in tiposRefeicao" v-bind:key="index">
                    <div>
                      <label>&nbsp;</label>
                      <button
                        style="width: 15%;"
                        type="button"
                        v-on:click="removeTipoRefeicao(index)"
                        class="btn btn-block btn-danger"
                      >Remover</button>
                    </div>
                    <div class="row" style="text-align: left;">
                      <div class="form-group col-12">
                        <label style="color: #87132a;" for="nome">NOME</label>
                        <input
                          type="text"
                          class="form-control"
                          id="nome"
                          placeholder="Nome do tipo de refeição"
                          v-model="tipoRefeicao.nome"
                        />
                      </div>
                    </div>

                    <div style="text-align: left;">
                      <div class="form-group">
                        <div class="row">
                          <label class="col-12" style="color: #87132a;">COMPONENTES</label>
                        </div>
                        <p
                          style="font-weight:100;"
                        >Por favor, selecione os componentes que integram este tipo de refeição.</p>
                        <div class="row ml-1">
                          <div
                            class="custom-control custom-checkbox col-2"
                            v-for="(componente, index2) in componentes"
                            v-bind:key="componente.componenteId"
                          >
                            <input
                              type="checkbox"
                              class="custom-control-input"
                              :id="`${index2}${index}`"
                              v-model="tipoRefeicao.componentes"
                              :value="componente.componenteId"
                            />
                            <label
                              class="custom-control-label"
                              :for="`${index2}${index}`"
                            >{{ componente.componenteNome }}</label>
                          </div>
                        </div>
                      </div>
                    </div>

                    <div style="text-align: left;">
                      <div class="form-group">
                        <div class="row">
                          <label class="col-12" style="color: #87132a;">PREÇOS</label>
                        </div>
                        <p
                          style="font-weight:100;"
                        >Por favor, indique o custo, em euros (€), de uma refeição deste tipo para cada tipo de consumidor.</p>
                        <div class="row">
                          <div
                            class="col-3"
                            v-for="(consumidor, index3) in tiposConsumidor"
                            v-bind:key="consumidor.tipoConsumidorId"
                          >
                            <div class="form-group">
                              <label :for="`${index3}${index}`">{{ consumidor.tipoConsumidorNome }}</label>
                              <input
                                type="number"
                                step="0.01"
                                class="form-control"
                                :id="`${index3}${index}`"
                                placeholder="Preço"
                                v-model="tipoRefeicao.precos[consumidor.tipoConsumidorId]"
                              />
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <hr />
                  </div>
                </form>
              </b-card-text>
            </b-card>
          </div>
          <div>
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
                    <button
                      @click="adicionarCantina()"
                      type="button"
                      class="lightredbtn"
                      style="width: 15em; font-size: 1em;"
                    >CONFIRMAR</button>
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
                    <button
                      @click="adicionarCantina()"
                      type="button"
                      class="lightredbtn"
                      style="width: 12em; font-size: 0.8em;"
                    >CONFIRMAR</button>
                  </div>
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
import Header from "@/components/HeaderAdministrador.vue";

export default {
  name: "cantina",
  components: {
    Header
  },
  data: () => ({
    nome: "",
    localizacao: "",
    descricao: "",
    tiposConsumidor: [],
    refeicaoInfo: {
      nome: "",
      horaInicio: "",
      horaFim: "",
      horaLimite: "",
      desconto: "",
      taxaCancelamento: "",
      segunda: false,
      terca: false,
      quarta: false,
      quinta: false,
      sexta: false,
      sabado: false,
      domingo: false
    },
    refeicoesInfo: [],
    componentes: [],
    tipoRefeicao: { nome: "", componentes: [], precos: [] },
    tiposRefeicao: []
  }),
  mounted: async function() {
    const response = await fetch(
      "http://localhost:8080/tickeat_war_exploded/DefinirCantina",
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
        this.tiposConsumidor = json.info.tiposConsumidor;
        this.componentes = json.info.componentes;
      } else {
        window.location.href = "http://localhost:3000/";
      }
    });
  },
  methods: {
    addNewRefeicaoInfo: function() {
      this.refeicoesInfo.push({
        nome: "",
        horaInicio: "",
        horaFim: "",
        horaLimite: "",
        desconto: "",
        taxaCancelamento: "",
        segunda: false,
        terca: false,
        quarta: false,
        quinta: false,
        sexta: false,
        sabado: false,
        domingo: false
      });
    },
    removeRefeicaoInfo: function(index) {
      this.$delete(this.refeicoesInfo, index);
    },
    addNewTipoRefeicao: function() {
      let tipos = { nome: "", componentes: [], precos: [] };
      for (var c in this.tiposConsumidor) {
        tipos.precos[this.tiposConsumidor[c].id] = 0;
      }
      this.tiposRefeicao.push(tipos);
    },
    removeTipoRefeicao: function(index) {
      this.$delete(this.tiposRefeicao, index);
    },
    adicionarCantina: async function() {
      const response = await fetch(
        "http://localhost:8080/tickeat_war_exploded/DefinirCantina",
        {
          headers: {
            "Content-Type": "application/json; charset=utf-8"
          },
          credentials: "include",
          method: "POST",
          body: JSON.stringify({
            nome: this.nome,
            localizacao: this.localizacao,
            descricao: this.descricao,
            tiposRefeicao: this.tiposRefeicao,
            refeicoesInfo: this.refeicoesInfo
          })
        }
      );
      response.json().then(json => {
        if (json.success) {
          window.location.href = "http://localhost:3000/cantinas";
        } else {
          this.erro = "Ocorreu um erro no registo da cantina.";
        }
      });
    }
  }
};
</script>

<style scoped>
label {
  color: black;
}
</style>