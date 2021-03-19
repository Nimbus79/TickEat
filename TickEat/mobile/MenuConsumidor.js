import React from "react";
import { Dimensions } from "react-native";
import { createDrawerNavigator } from "react-navigation-drawer";
import SideBar from "./components/Consumidor/SideBar";
import Calendario from "./components/Consumidor/Calendario";
import Refeicao from "./components/Consumidor/Refeicao";

const WIDTH = Dimensions.get('window').width;
const Menu = createDrawerNavigator(
    {
        Calendario: {screen: Calendario},
        Refeicao: {screen: Refeicao}
    },
    {
        initialRouteName: "Calendario",
        drawerWidth:WIDTH*0.80,
        drawerPosition:'left',
        contentOptions: {
            activeTintColor: "#e91e63"
        },
        contentComponent: props => <SideBar {...props} />,
        drawerOpenRoute: 'LeftSideMenu',
        drawerCloseRoute: 'LeftSideMenuClose',
        drawerToggleRoute: 'LeftSideMenuToggle',
    }
);

export default Menu;