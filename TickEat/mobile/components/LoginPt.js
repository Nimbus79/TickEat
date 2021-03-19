import React, { Component } from "react";

import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Text,
  TextInput,
  TouchableOpacity,
  Image,
  TouchableHighlight,
  CheckBox,
} from "react-native";


export default class Loginpt extends Component {
  state = {
    checked: false,
    email: "",
    password: "",
    erro: "",
    sessao: false,
    ip: "192.168.1.88"
  };


  handleCheckboxChange = () => {
    var checked =  !this.state.checked
    this.state.checked = checked
    this.state.sessao = checked
    this.setState({ checked: this.state.checked })
    this.setState({ sessao: this.state.sessao })
  }


  async login() {
    this.state.erro = ""
    if (this.state.email == "" && this.state.password == "") {
      this.state.erro = "Por favor, introduza o endereço de e-mail e a palavra-passe."
    } else if (this.state.email == "" && this.state.password != "") {
      this.state.erro = "Por favor, introduza o endereço de e-mail."
    } else if (this.state.email != "" && this.state.password == "") {
      this.state.erro = "Por favor, introduza a palavra-passe."
    } else { 
      const response = await fetch(
        "http://"+this.state.ip+":8080/tickeat_war_exploded/",
        {
          headers: {
            "Content-Type": "application/json; charset=utf-8"
          },
          credentials: "include",
          method: "POST",
          body: JSON.stringify({
            email: this.state.email,
            password: this.state.password,
            sessao: this.state.sessao + ""
          })
        }
      );
      response.json().then(json => {
        if (json.success) {
          if (json.tipo == "Consumidor") {
            this.props.navigation.navigate("MenuConsumidor");
          }
          /*if (json.tipo == "Administrador") {
            this.props.navigation.navigate("Pedidos");
          }
          if (json.tipo == "Cozinheiro") {
            this.props.navigation.navigate("InicioCozinheiro");
          }*/
        } else {
          this.state.erro = "Endereço de e-mail ou palavra-passe inválidos."
        }
      });
    }
    this.setState({erro: this.state.erro})
  }


  renderError() {
    if (this.state.erro != "") {
      return <View style={styles.error_msg}>
              <Image
              style={{ width: 26, height: 26, alignSelf: "center", marginLeft: 5 }}
              source={require("./../images/exclamation-circle.png")}
              />
              <Text style={{color: '#800000', width: "83%", textAlignVertical:"center", marginLeft: 5}}>
                {this.state.erro}
              </Text>
            </View>
    }
    return null
  }


  render() {
    return (
      <SafeAreaView style={styles.container}>
        <ScrollView style={styles.scrollView}>
          <View style={styles.body}>
            <View style={styles.flags}>
              <TouchableHighlight
                onPress={() => this.props.navigation.navigate("LoginPt")}
              >
                <Image
                  style={{ width: 30, height: 30, marginRight: 5}}
                  source={require("./../images/pt.png")}
                />
              </TouchableHighlight>
              <TouchableHighlight
                onPress={() => this.props.navigation.navigate("LoginEn")}
              >
                <Image
                  style={{ width: 30, height: 30 }}
                  source={require("./../images/en.png")}
                />
              </TouchableHighlight>
            </View>
            <View style={styles.sectionContainer}>
              <Image
                source={require("./../images/logo_tijolo.png")}
                style={{ width: 300, height: 150 }}
                resizeMode="contain"
              />
            </View>
            <View style={styles.sectionContainer}>
              <Text
                style={{ textAlign: "center", fontWeight: "bold", fontSize: 40 }}
              >
                {" "}BEM-VINDO!{" "}
              </Text>
            </View>
            <Text style={{ color: "#c4c4c4", left: 30, marginTop: 10 }}>
              E-mail
            </Text>
            <View style={{ flexDirection: "row", marginTop: 3 }}>
              <Image
                source={require("./../images/envelope.png")}
                style={{ width: 20, height: 20, marginLeft: 30, marginTop: 5 }}
                resizeMode="contain"
              />
              <TextInput
                placeholder=""
                style={styles.emailinput}
                onChangeText={text => this.setState({ email: text })}
              />
            </View>
            <Text style={{ color: "#c4c4c4", left: 30, marginTop: 25 }}>
              Palavra-Passe
            </Text>
            <View style={{ flexDirection: "row", marginTop: 3 }}>
              <Image
                source={require("./../images/cadeado.png")}
                style={{ width: 20, height: 20, marginLeft: 30, marginTop: 5 }}
                resizeMode="contain"
              />
              <TextInput
                placeholder=""
                style={styles.emailinput}
                secureTextEntry={true}
                onChangeText={text => this.setState({ password: text })}
              />
            </View>
            <View style={{ flexDirection: "row", marginTop: 10, marginLeft: 25 }}>
              <CheckBox
                value={this.state.checked}
                onChange={this.handleCheckboxChange}
              />
              <Text style={{ marginTop: 5 }}>
                Manter sessão iniciada
              </Text>
            </View>
            <View style={{marginLeft: 5}}>
              {this.renderError()}
            </View>
            <View style={{flexDirection: "row", justifyContent: "center"}}>
              <TouchableOpacity
                style={styles.rdbtn}
                onPress={() => {
                  this.login();
                }}
              >
                <Text align="center" style={{fontWeight: "bold", color:"white"}}>
                  ENTRAR
                </Text>
              </TouchableOpacity>
            </View>
            <View style={{flexDirection: "row", justifyContent: "center", marginTop: 10}}>
              <Text onPress={() => this.props.navigation.navigate("DefinirPassword")} style={{textDecorationLine: "underline"}}>
                Esqueceste-te da tua palavra-passe?
              </Text>
            </View>
            <View style={{flexDirection: "row", justifyContent: "center", marginTop: 40, marginBottom: 40}}>
              <Text>
                <Text>
                  AINDA NÃO TEM UMA CONTA?{" "}
                </Text>
                <Text onPress={() => this.props.navigation.navigate("Registo")} style={{fontWeight: "bold", textDecorationLine: "underline"}}>
                  REGISTE-SE!
                </Text>
              </Text>
            </View>
          </View>
        </ScrollView>
      </SafeAreaView>
    );
  }
}


const styles = StyleSheet.create({
  body: {
    backgroundColor: "#ffffff"
  },
  sectionContainer: {
    flexDirection: "row",
    justifyContent: "center",
    marginTop: 32,
    paddingHorizontal: 24
  },
  rdbtn: {
    borderWidth: 0,
    borderRadius: 45,
    shadowColor: "rgba(0, 0, 0, 0.1)",
    shadowOffset: { width: 0, height: 8 },
    shadowOpacity: 0.8,
    shadowRadius: 15,
    fontSize: 1.2,
    textAlign: "center",
    width: "50%",
    paddingTop: 10,
    paddingBottom: 10,
    paddingRight: 40,
    paddingLeft: 40,
    backgroundColor: "#87132a",
    color: "#fff",
    alignItems: "center",
    marginTop: 20
  },
  emailinput: {
    borderWidth: 0,
    borderBottomWidth: 1,
    width: "76%",
    left: 5,
    marginRight: 10,
    borderBottomColor: "#c4c4c4",
    borderStyle: "solid",
    paddingLeft: 10,
    elevation: 0,
    borderRadius: 0
  },
  flags: {
    marginTop: 30,
    marginBottom: 10,
    marginLeft: 10,
    marginRight: 10,
    flexDirection: "row",
    justifyContent: "flex-end"
  },
  error_msg: {
    borderWidth: 0,
    borderRadius: 5,
    shadowColor: "rgba(0, 0, 0, 0.1)",
    shadowOffset: { width: 0, height: 8 },
    shadowOpacity: 0.8,
    shadowRadius: 15,
    flexDirection: "row", 
    width: "83%", 
    height: 50, 
    backgroundColor: "#ffcccc", 
    marginLeft: 28, 
    marginTop: 10
  }
});
