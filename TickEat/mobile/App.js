import React from "react";

import LoginPt from "./components/LoginPt";
import Registo from "./components/Consumidor/Registo";
import Calendario from "./components/Consumidor/Calendario";
import Refeicao from "./components/Consumidor/Refeicao";
import MenuConsumidor from "./MenuConsumidor"

import { createAppContainer } from "react-navigation";
import { createStackNavigator } from "react-navigation-stack";


export default class App extends React.Component {
  render() {
    return <AppContainer />;
  }
}

const MainNavigator = createStackNavigator(
  {
    LoginPt: {screen: LoginPt},
    Registo: {screen: Registo},
    Calendario: {screen: Calendario},
    Refeicao: {screen: Refeicao},
    MenuConsumidor: {screen: MenuConsumidor}
  },
  {
    initialRouteName: "LoginPt",
    headerMode: "none",
    swipeEnabled: false
  }
);
const AppContainer = createAppContainer(MainNavigator);
