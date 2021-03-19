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
  Picker
} from "react-native";


export default class Registar extends Component {
  state = {
    nome: "",
    email: "",
    tipoConsumidorId: "",
    tiposConsumidor: [],
    msg: "",
    erro: "",
    ip: "192.168.1.103"
  };


  async registo() {
    this.state.msg = ""
    this.state.erro = ""
    if (this.state.email == "" || this.state.nome == "" || this.state.tipoConsumidorId == 0) {
      this.state.erro = "Por favor, preencha todos os campos."
      this.setState({erro: "Por favor, preencha todos os campos."});
    } 
    else { 
      const response = await fetch(
        "http://"+this.state.ip+":8080/tickeat_war_exploded/Registar",
        {
          headers: {
            "Content-Type": "application/json; charset=utf-8"
          },
          method: "POST",
          body: JSON.stringify({
            nome: this.state.nome,
            utilizadorEmail: this.state.email,
            tipoConsumidorId: this.state.tipoConsumidorId + ""
          })
        }
      );
      response.json().then(json => {
        if (json.success) {
          this.state.msg = "Registo efetuado com sucesso.";
          this.setState({msg: "Registo efetuado com sucesso."});
        } 
        else {
          this.state.erro = "Ocorreu um erro no seu registo.";
          this.setState({erro: "Ocorreu um erro no seu registo."});
        }
      });
    }
  }


  async componentDidMount() {
    const response = await fetch(
      "http://"+this.state.ip+":8080/tickeat_war_exploded/Registar",
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
        this.setState({ tiposConsumidor: JSON.parse(json.tiposConsumidor) });
      } 
      else {
        this.props.navigation.navigate("LoginPt");
      }
    });
  }


  renderMsgError() {
    if (this.state.erro != "") {
      return <View style={styles.error_msg}>
              <Image
              style={{ width: 26, height: 26, alignSelf: "center", marginLeft: 5 }}
              source={require("./../../images/exclamation-circle.png")}
              />
              <Text style={{color: '#800000', width: "83%", textAlignVertical:"center", marginLeft: 5}}>
                {this.state.erro}
              </Text>
            </View>
    }
    else if (this.state.msg != "") {
      return <View style={styles.success_msg}>
                <Image
                style={{ width: 26, height: 26, alignSelf: "center", marginLeft: 5 }}
                source={require("./../../images/checked-circle.png")}
                />
                <Text style={{color: '#014101', width: "83%", textAlignVertical:"center", marginLeft: 5}}>
                  <Text >
                    {this.state.msg + " "}
                  </Text>
                  <Text onPress={() => this.props.navigation.navigate("LoginPt")} style={{fontWeight: "bold", textDecorationLine: "underline", color:"#014101", textDecorationColor: "#014101"}}>
                    Login
                  </Text>
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
                  style={{ width: 30, height: 30, marginRight: 5 }}
                  source={require("./../../images/pt.png")}
                />
              </TouchableHighlight>
              <TouchableHighlight
                onPress={() => this.props.navigation.navigate("LoginEn")}
              >
                <Image
                  style={{ width: 30, height: 30 }}
                  source={require("./../../images/en.png")}
                />
              </TouchableHighlight>
            </View>
            <View style={styles.sectionContainer}>
              <Image
                source={require("./../../images/logo_tijolo.png")}
                style={{ width: 300, height: 150 }}
                resizeMode="contain"
              />
            </View>
            <View style={styles.sectionContainer}>
              <Text
                style={{ textAlign: "center", fontWeight: "bold", fontSize: 40 }}
              >
                {" "}NOVA CONTA{" "}
              </Text>
            </View>
            <View style={{flexDirection: "row", justifyContent: "center", paddingHorizontal: 24, marginTop: 5}}>
              <Text style={{ textAlign: "center", fontSize: 10, color: "#c4c4c4" }}>
                {" "}
                Por favor, introduza o seu endereço de e-mail institucional. Irá
                receber um e-mail onde deverá definir a sua palavra-passe.
              </Text>
            </View>
            <Text style={{ color: "#c4c4c4", left: 30, marginTop: 10 }}>
              Nome
            </Text>
            <View style={{ flexDirection: "row", marginTop: 3 }}>
              <Image
                source={require("./../../images/user.png")}
                style={{ width: 20, height: 20, marginLeft: 30, marginTop: 5 }}
                resizeMode="contain"
              />
              <TextInput
                placeholder=""
                style={styles.emailinput}
                onChangeText={text => this.setState({ nome: text })}
              />
            </View>
            <Text style={{ color: "#c4c4c4", left: 30, marginTop: 25 }}>
              E-mail
            </Text>
            <View style={{ flexDirection: "row", marginTop: 3 }}>
              <Image
                source={require("./../../images/envelope.png")}
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
              Tipo de Utilizador
            </Text>
            <View style={{left: 30}}>
              <Picker
                style={{width:"88%"}}
                mode="dropdown"
                selectedValue={this.state.tipoConsumidorId}
                onValueChange={selecionado => {
                  this.setState({ tipoConsumidorId: selecionado });
                }}
              >
                <Picker.Item label="" key="0" value="0" />
                {this.state.tiposConsumidor.map(tipoConsumidor => (
                  <Picker.Item 
                    key={tipoConsumidor.id} 
                    value={tipoConsumidor.id} 
                    label={tipoConsumidor.nome} />
                ))}
              </Picker>
              <View
                style={{
                  marginLeft: 2,
                  width: "82.5%",
                  borderBottomColor: "#c4c4c4",
                  borderBottomWidth: 1,
                }}
              />
            </View>
            <View style={{marginLeft: 5}}>
              {this.renderMsgError()}
            </View>
            <View style={{flexDirection: "row", justifyContent: "center", marginBottom: 40}}>
              <TouchableOpacity
                style={styles.rdbtn}
                onPress={() => {
                  this.registo();
                }}
              >
                <Text align="center" style={{fontWeight: "bold", color:"white"}}>
                  REGISTAR
                </Text>
              </TouchableOpacity>
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
    marginTop: 30
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
    marginTop: 20
  },
  success_msg: {
    borderWidth: 0,
    borderRadius: 5,
    shadowColor: "rgba(0, 0, 0, 0.1)",
    shadowOffset: { width: 0, height: 8 },
    shadowOpacity: 0.8,
    shadowRadius: 15,
    flexDirection: "row", 
    width: "83%", 
    height: 50, 
    backgroundColor: "#b4e4b4", 
    marginLeft: 28, 
    marginTop: 20
  }
});
