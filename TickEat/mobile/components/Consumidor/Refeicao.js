import React, { Component } from "react";

import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  TouchableOpacity,
  Image,
  TouchableHighlight,
  Alert
} from "react-native";

import { Container, Header, Text, Card } from "native-base";

import Constants from 'expo-constants';
import Accordian from '../Accordian';


export default class Refeicao extends Component {
  state = {
    refeicaoId: 0, //14,
    cantinaId: 0, //2,
    refeicao: {},
    ready: false,
    erro: "",
    ip: "192.168.1.88"
  };


  async componentDidMount() {
    this.state.refeicaoId = this.props.navigation.state.params.refeicaoId
    this.setState({refeicaoId: this.state.refeicaoId})
    this.state.cantinaId = this.props.navigation.state.params.cantinaId
    this.setState({cantinaId: this.state.cantinaId})
    const response = await fetch(
      "http://"+this.state.ip+":8080/tickeat_war_exploded/Refeicao?ref="+this.state.refeicaoId+"&cant="+this.state.cantinaId,
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
        this.setState({ refeicao: json.refeicao });
        this.setState({ ready: true })
      } else {
        this.props.navigation.navigate("LoginPt");
      }
    });
  }


  async cancelar() {
    const response = await fetch(
      "http://"+this.state.ip+":8080/tickeat_war_exploded/Cancelar?ref="+this.state.refeicaoId,
      {
        headers: {
          "Content-Type": "application/json; charset=utf-8"
        },
        credentials: "include",
        method: "POST"
      }
    );
    response.json().then(json => {
      if (json.success) {
        this.setState({ready: false})
        this.componentDidMount()
      } 
      else {
        this.state.erro = "Não foi possível cancelar a reserva."
        this.setState({erro: this.state.erro})
        return Alert.alert(this.state.erro)
      }
    });
  }


  handleEmenta() {
    if (this.state.ready) {
      var e = []
      e = this.state.refeicao.ementa
      var view = []
      for (let i = 0; i < e.length; i++) {
        if (e[i].ementas.length > 0) {
          view.push(
            <Text key={"ementa"+i} style={{fontWeight:"bold", color:"#87132a", textTransform:"uppercase",marginLeft:10, marginTop:20}}>
              {e[i].componenteNome}
            </Text>
          )
          var em = []
          em = e[i].ementas
          for (let j = 0; j < em.length; j++) {
            if (em[j].energia) {
              view.push(
                <Card style={{marginLeft:10, marginRight:10}} key={em[j].ementaId}>
                  <Accordian 
                    title = {em[j].comida}
                    energia = {em[j].energia + " Kcal"}
                    lipidos = {em[j].lipidos + " g"}
                    saturados = {em[j].saturados + " g"}
                    hidratos = {em[j].hidratos + " g"}
                    acucar = {em[j].acucar + " g"}
                    fibra = {em[j].fibra + " g"}
                    proteinas = {em[j].proteinas + " g"}
                    sal = {em[j].sal + " g"}
                  />
                </Card>
              )
            }
            else {
              view.push(
                <Card style={{marginLeft:10, marginRight:10}} key={em[j].ementaId}>
                  <Accordian 
                    title = {em[j].comida}
                    energia = {""}
                    lipidos = {""}
                    saturados = {""}
                    hidratos = {""}
                    acucar = {""}
                    fibra = {""}
                    proteinas = {""}
                    sal = {""}
                  />
                </Card>
              )
            }
          }
        }
      }
      return view
    }
  }


  handlePrevisoes() {
    if (this.state.ready) {
      if (this.state.refeicao.aDecorrer) {
        return <Text style={{color:"#87132a", textAlign:"center", fontSize:19}}>
          {this.state.refeicao.contagemValidados + " / " + this.state.refeicao.previsaoGeral}
        </Text>
      }
      else {
        return <Text style={{color:"#87132a", textAlign:"center", fontSize:19}}>
          {this.state.refeicao.previsaoGeral}
        </Text>
      }
    }
  }


  handleEmentaSelecionada() {
    if (this.state.ready) {
      var e = []
      e = this.state.refeicao.ementaSelecionada
      var ementa = []
      for (let i = 0; i < e.length-1; i++) {
        ementa.push(
          <Text key={i} style={{color:"#87132a"}}>
            {e[i].comida + ", "}
          </Text>
        )
      }
      ementa.push(
        <Text key={e.length-1} style={{color:"#87132a"}}>
          {e[e.length-1].comida}
        </Text>
      )
      return ementa
    }
  }


  handleInfoRefeicaoReservada() {
    return <View style={{marginTop:20}}>
      <Text style={{fontSize:16, color:"#87132a", fontWeight:"100", justifyContent:"flex-start", textTransform:"uppercase", marginLeft:10, textAlign:"left"}}>
        <Text style={{fontWeight:"bold", color:"#87132a"}}>
          Ementa Selecionada: {" "}
        </Text>
        {this.handleEmentaSelecionada()}
      </Text>
      <Text style={{fontSize:16, color:"#666666", fontWeight:"100", justifyContent:"flex-start", marginLeft:10, marginTop:10, textAlign:"left"}}>
        {this.state.refeicao.preco + "€"}
      </Text>
      <View style={{flexDirection:"row", justifyContent:"space-between", marginBottom:20}}>
        <TouchableOpacity
          style={styles.editar_rdbtn}
          onPress={() => {
            
          }}
        >
          <Text align="center" style={{fontWeight: "bold", color:"white"}}>EDITAR</Text>
        </TouchableOpacity>
        <TouchableOpacity
          style={styles.cancelar_rdbtn}
          onPress={() => {
            this.cancelar()
          }}
        >
          <Text align="center" style={{fontWeight: "bold", color:"white"}}>CANCELAR</Text>
        </TouchableOpacity>
      </View>
    </View>
  }


  handleInfoRefeicaoValidadaAvaliada() {
    return <View style={{marginTop:20, marginBottom:20}}>
      <Text style={{fontSize:16, color:"#87132a", fontWeight:"100", justifyContent:"flex-start", textTransform:"uppercase", marginLeft:10, textAlign:"left"}}>
        <Text style={{fontWeight:"bold", color:"#87132a"}}>
          Ementa Selecionada: {" "}
        </Text>
        {this.handleEmentaSelecionada()}
      </Text>
      <Text style={{fontSize:16, color:"#666666", fontWeight:"100", justifyContent:"flex-start", marginLeft:10, marginTop:10, textAlign:"left"}}>
        {this.state.refeicao.preco + "€"}
      </Text>
    </View>
  }


  handleInfoRefeicaoValidada() {
    return <View style={{marginTop:20}}>
      <Text style={{fontSize:16, color:"#87132a", fontWeight:"100", justifyContent:"flex-start", textTransform:"uppercase", marginLeft:10, textAlign:"left"}}>
        <Text style={{fontWeight:"bold", color:"#87132a"}}>
          Ementa Selecionada: {" "}
        </Text>
        {this.handleEmentaSelecionada()}
      </Text>
      <Text style={{fontSize:16, color:"#666666", fontWeight:"100", justifyContent:"flex-start", marginLeft:10, marginTop:10, textAlign:"left"}}>
        {this.state.refeicao.preco + "€"}
      </Text>
      <View style={{flexDirection:"row", justifyContent:"center", marginBottom:20}}>
        <TouchableOpacity
          style={styles.rdbtn}
          onPress={() => {
            
          }}
        >
          <Text align="center" style={{fontWeight: "bold", color:"white"}}>AVALIAR</Text>
        </TouchableOpacity>
      </View>
    </View>
  }


  handleInfoRefeicaoNaoReservada() {
    return <View style={{flexDirection:"row", justifyContent:"center", marginBottom:20}}>
      <TouchableOpacity
        style={styles.rdbtn}
        onPress={() => {
          
        }}
      >
        <Text align="center" style={{fontWeight: "bold", color:"white"}}>RESERVAR</Text>
      </TouchableOpacity>
    </View>
  }


  handleInfoRefeicaoNaoReservadaPassada() {
    return <View style={{marginBottom:15}}></View>
  }


  handleInfoRefeicao() {
    if (this.state.ready) {
      if (this.state.refeicao.reservada && !this.state.refeicao.passou) {
        return this.handleInfoRefeicaoReservada()
      }
      else if (this.state.refeicao.reservada && this.state.refeicao.passou && this.state.refeicao.avaliada) {
        return this.handleInfoRefeicaoValidadaAvaliada()
      }
      else if (this.state.refeicao.reservada && this.state.refeicao.passou && !this.state.refeicao.avaliada) {
        return this.handleInfoRefeicaoValidada()
      }
      else if (!this.state.refeicao.reservada && !this.state.refeicao.passou) {
        return this.handleInfoRefeicaoNaoReservada()
      }
      else {
        return this.handleInfoRefeicaoNaoReservadaPassada()
      }
    }
  }


  render() {
    if (this.state.ready && (this.state.refeicaoId != this.props.navigation.state.params.refeicaoId)) {
      this.componentDidMount()
    }
    return (
      <SafeAreaView style={styles.container}>
        <ScrollView style={styles.scrollView}>
            <Container style={{height:"37%"}}>
                <Header style={{backgroundColor: "#87132a"}}>
                  <View style={styles.menu}>
                    <TouchableHighlight
                      onPress={() => this.props.navigation.openDrawer()}
                    >
                      <Image
                        style={{ width: 40, height: 40, justifyContent: "flex-start" }}
                        source={require("./../../images/menu.png")}
                      />
                    </TouchableHighlight>
                    <View style={{width:"80%", flexDirection: "row", justifyContent: "center", textAlign: "center"}}>
                    <Text style={{fontWeight: "bold", fontSize: 20, color:"white", marginTop:6, justifyContent: "center", textAlign: "center"}}>
                      REFEIÇÃO
                    </Text>
                    </View>
                    <View style={{flexDirection: "row", justifyContent: "flex-end", width:"15%"}}>
                      <TouchableHighlight
                        onPress={() => this.props.navigation.navigate("Refeicao")}
                      >
                        <Image
                          style={{ width: 30, height: 30, marginRight: 5, marginTop:5 }}
                          source={require("./../../images/pt.png")}
                        />
                      </TouchableHighlight>
                      <TouchableHighlight
                        onPress={() => this.props.navigation.navigate("RefeicaoEn")}
                      >
                        <Image
                          style={{ width: 30, height: 30, marginRight: 20, marginTop:5 }}
                          source={require("./../../images/en.png")}
                        />
                      </TouchableHighlight>
                    </View>
                  </View>
                </Header>
              </Container>
                <Card style={{marginTop:20, marginLeft:5, marginRight:5}}>
                  <View style={{flexDirection:"row", justifyContent:"space-between", marginTop:10}}>
                    <Text style={{fontSize:19, fontWeight:"400", textTransform:"uppercase", marginLeft:10}}>{this.state.refeicao.cantinaNome}</Text>
                    <Text style={{fontSize:19, textTransform:"uppercase", textAlign:"right", marginRight:10}}>{this.state.refeicao.diaDaSemana}</Text>
                  </View>
                  <View style={{flexDirection:"row", justifyContent:"space-between", marginTop:2}}>
                    <Text style={{fontSize:16, color:"#666666", fontWeight:"100", textTransform:"uppercase", marginLeft:10}}>{this.state.refeicao.refeicaoNome}</Text>
                    <Text style={{fontSize:16, color:"#666666", fontWeight:"100", textTransform:"uppercase", textAlign:"right", marginRight:10}}>{this.state.refeicao.data}</Text>
                  </View>
                  <View>{this.handleInfoRefeicao()}</View>
                </Card>
                <Card style={{marginLeft:5, marginRight:5}}>
                  <Text style={{textAlign:"center", fontSize:19, marginTop:10}}>PESSOAS ESPERADAS</Text>
                  <View style={{marginTop:20, marginBottom:30}}>{this.handlePrevisoes()}</View>
                </Card>
                <Card style={{marginLeft:5, marginRight:5, marginBottom:25}}>
                  <Text style={{textAlign:"center", fontSize:19, marginTop:10}}>EMENTA</Text>
                  <View>{this.handleEmenta()}</View>
                  <View style={{marginBottom:20}}></View>
                </Card>
        </ScrollView>
      </SafeAreaView>
    );
  }
}


const styles = StyleSheet.create({
  rdbtn: {
    borderWidth: 0,
    borderRadius: 45,
    shadowColor: "rgba(0, 0, 0, 0.1)",
    shadowOffset: { width: 0, height: 8 },
    shadowOpacity: 0.8,
    shadowRadius: 15,
    fontSize: 1.2,
    textAlign: "center",
    width: "45%",
    paddingTop: 10,
    paddingBottom: 10,
    backgroundColor: "#87132a",
    color: "#fff",
    alignItems: "center",
    marginTop: 30,
  },
  editar_rdbtn: {
    borderWidth: 0,
    borderRadius: 45,
    shadowColor: "rgba(0, 0, 0, 0.1)",
    shadowOffset: { width: 0, height: 8 },
    shadowOpacity: 0.8,
    shadowRadius: 15,
    fontSize: 1.2,
    textAlign: "center",
    width: "45%",
    paddingTop: 10,
    paddingBottom: 10,
    backgroundColor: "#87132a",
    color: "#fff",
    alignItems: "center",
    marginTop: 30,
    marginLeft: 12
  },
  cancelar_rdbtn: {
    borderWidth: 0,
    borderRadius: 45,
    shadowColor: "rgba(0, 0, 0, 0.1)",
    shadowOffset: { width: 0, height: 8 },
    shadowOpacity: 0.8,
    shadowRadius: 15,
    fontSize: 1.2,
    textAlign: "center",
    width: "45%",
    paddingTop: 10,
    paddingBottom: 10,
    backgroundColor: "#87132a",
    color: "#fff",
    alignItems: "center",
    marginTop: 30,
    marginRight: 12
  },
  menu: {
    marginTop: 7,
    marginBottom: 10,
    flexDirection: "row",
    width: "100%"
  },
  container: {
    flex: 1,
    marginTop: Constants.statusBarHeight,
  },
  scrollView: {
    backgroundColor: 'white',
    marginHorizontal: 0,
  },
});
