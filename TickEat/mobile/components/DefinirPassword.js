import React, { Component } from 'react';
import { createStackNavigator, createAppContainer } from 'react-navigation';

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
    TouchableHighlight
} from 'react-native';



export default class Login extends Component {
  render() {
    return (
       <View style={styles.body}>
             <Text> Entrei aqui fardo </Text>
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
       borderBottomColor: '#c4c4c4',
       borderStyle: 'solid',
       paddingLeft: 40,
       //backgroundImage: "url(./images/envelope.png)",
       //backgroundRepeat: no-repeat,
       //backgroundSize: 20 20,
       //backgroundPosition: "left center",
       //-webkit-box-shadow: none,
       elevation: 0,
       borderRadius: 0,
  },
   flags: {
      margin: 10,
      flexDirection: 'row',
      justifyContent: "flex-end",
      flex: 1

    }
});





