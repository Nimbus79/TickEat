import React, { Component } from 'react';
// import { createStackNavigator, createAppContainer } from 'react-navigation';



import {
    SafeAreaView,
    StyleSheet,
    ScrollView,
    View,
    Text,
    StatusBar,
    Button,
    TextInput,
    TouchableOpacity,
    Image,
    TouchableHighlight,
    CheckBox
} from 'react-native';

import axios from 'axios'

import {Icon , Header , Left  , Container, Card , CardItem} from 'native-base';
import Axios from 'axios';


export default class Paginainicial extends Component {
state={
    cantinas: [],
    model1: 0,
    model2: 0,
    showArrows: true,
    hideDelimiters: true,
    cycle: false,
    saldoDisponivel: "",
    saldoContabilistico: ""
    }


    async componentDidMount(){
      const response = await axios.get(
        "http://10.0.2.2:8080/tickeat_war_exploded/InicioConsumidor",
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
          this.cantinas = json.paginaInicial;
          /* eslint-disable no-console */
          // console.log(this.cantinas);
          /* eslint-enable no-console */
        } else {
          window.location.href = "http://localhost:3000/";
        }
      });
      const response2 = await axios.get(
        "http://10.0.2.2:8080/tickeat_war_exploded/Saldos",
        {
          headers: {
            "Content-Type": "application/json; charset=utf-8"
          },
          credentials: "include",
          method: "GET"
        }
      );
      response2.json().then(json => {
        if (json.success) {
          this.saldoDisponivel = json.carteira.saldoDisponivel;
          this.saldoContabilistico = json.carteira.saldoContabilistico;
        } else {
          window.location.href = "http://localhost:3000/";
        }
      });
      console.log(this.state.cantinas)
      console.log(this.state.saldoDisponivel)
      console.log(this.state.saldoContabilistico)
      
    }

  render() {
    return (
      
      <View style={styles.body}>
        <View style={styles.flags}  >
          {/* <Text style={{fontSize: 25 , right: 70, top:14}}>Página Inícial</Text> */}
          <TouchableOpacity style={{ right: 260 , margin: 15}} onPress={() => {this.props.navigation.openDrawer() } }>
            <Image
                style= {{width: 20 , height: 20 ,top:6  }}
                source={require('./../../images/sidemenu.png')}/>
          </TouchableOpacity>
          <TouchableHighlight  style={{top: 10, right: 12,bottom: 10}} onPress={() => this.props.navigation.navigate('LoginPt')} >
                <Image
                    style= {{width: 40 , height: 40   }}
                    source={require('./../../images/pt.png')}
                />
            </TouchableHighlight>
            <TouchableHighlight  style={{top:10 ,right: 10, bottom: 10}} onPress={() => this.props.navigation.navigate('DefinirPassword')}   >
                  <Image
                    style= {{width: 40 , height: 40  }}
                    source={require('./../../images/en.png')}
                  />
            </TouchableHighlight>
        </View>
      <View style={styles.sectionContainer}>
        <Card style={styles.card} >
          <CardItem >
            <Text style={{fontWeight: 'bold'}}> Saldo </Text>
          </CardItem>
          <CardItem >
            <Text > Disponivel </Text>
          </CardItem>
          <CardItem >
            <Text > Contabílistico </Text>
          </CardItem>
        </Card>
        <Card style={styles.card} >
          <CardItem >
            <Text > Previsão da Próxima Refeição </Text>
          </CardItem>
        </Card>
        <Card style={styles.card} >
          <CardItem >
            <Text > Estado da fila</Text>
          </CardItem>
        </Card>
        <Card style={styles.card} >
          <CardItem >
            <Text > Previsõe </Text>
          </CardItem>
        </Card>
      </View>
      </View>




                       )
  }
  }


//investigar o que faz a scollview!
//uso no body e no scrollview o import das Colors
const styles = StyleSheet.create({
  engine: {
    position: 'absolute',
    right: 0,
  },
  body: {
    backgroundColor: "#ffffff",
  },
  sectionContainer: {
    marginTop: 32,
    paddingHorizontal: 24,
  },
  buttonStyleContainer: {
         flex: 1,
         flexDirection: 'row',
         marginHorizontal: 20,
          marginTop: 5,
   },
  sectionTitle: {
    fontSize: 24,
    fontWeight: '600',
    color: "#111111",
  },
  sectionDescription: {
    marginTop: 8,
    fontSize: 18,
    fontWeight: '400',
    color: "#111111",
  },
  highlight: {
    fontWeight: '700',
  },
  rdbtn: {
        fontWeight: '500',
        borderWidth: 0,
        borderRadius: 45,
        //boxShadow: 0 8 15 rgba(0, 0, 0, 0.1),
        shadowColor: "rgba(0, 0, 0, 0.1)",
        shadowOffset: { width: 0, height: 8 },
        shadowOpacity: 0.8,
        shadowRadius: 15,
        //outline: 0,
        fontSize: 1.2,
        textAlign: "center",
        marginLeft: 2,
        paddingTop: 10,
        paddingBottom: 10,
        paddingRight: 40,
        paddingLeft: 40,
        backgroundColor: "#87132a",
        color: "#fff",
        alignItems: 'center',
        marginTop: 30

      },
  footer: {
    color: "#111111",
    fontSize: 12,
    fontWeight: '600',
    padding: 4,
    paddingRight: 12,
    textAlign: 'right',
  },
  emailinput: {
       borderWidth: 0,
       borderBottomWidth: 1,
       width: '80%',
       left: 5,
       borderBottomColor: '#c4c4c4',
       borderStyle: 'solid',
       paddingLeft: 40,
       //backgroundRepeat: no-repeat,
       //backgroundSize: 20 20,
       //backgroundPosition: "left center",
       //-webkit-box-shadow: none,
       elevation: 0,
       borderRadius: 0,
  },
   flags: {
      flexDirection: 'row',
      justifyContent: "flex-end",
      top: 20,
      bottom: 50,
      backgroundColor: "#87132a",

    },
    card: {
      backgroundColor: "#ffffff",
      borderRadius: 8 ,
      shadowColor: 'rgba(80, 81, 82, 0.705)',
      justifyContent: 'center',
      shadowOpacity: 0.75,
      shadowRadius: 5,
      shadowOffset: { height: 0, width: 0 },
      borderWidth: 0,

    },
    card2: {
      backgroundColor: "#ffffff",
      borderRadius: 8 ,
      shadowColor: 'rgba(80, 81, 82, 0.705)',
      width: '80%',
      justifyContent: 'center',
      shadowOpacity: 0.75,
      shadowRadius: 5,
      shadowOffset: { height: 0, width: 0 },

    }
});











