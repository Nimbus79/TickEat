import React from "react"
import { Image, View, Alert } from "react-native"
import { Content,List, Header, ListItem, Container, Text} from "native-base";
import { ScrollView } from "react-native-gesture-handler";
import { NavigationActions } from 'react-navigation';

export default class SideBar extends React.Component {
    
    constructor(props) {
        super(props)
        this.state = {
            ip: "192.168.1.88"
        }
    }

    navigateToScreen = (route) => () => {
        const navigate = NavigationActions.navigate({
            routeName: route
        });
        this.props.navigation.dispatch(navigate);
    }


    async logout() {
        const response = await fetch(
            "http://"+this.state.ip+":8080/tickeat_war_exploded/Terminar",
            {
              headers: {
                "Content-Type": "application/json; charset=utf-8"
              },
              credentials: "include",
              method: "GET"
            }
        );
        this.props.navigation.navigate("LoginPt")
    }


    render() {
        return (
            <ScrollView>
                <Container>
                    <Header style={{height:"48.5%", backgroundColor:"white"}}>
                        <Image
                            source={require("./../../images/logo_tijolo.png")}
                            style={{ width: 250, height: 125, alignSelf: "flex-end" }}
                            resizeMode="contain"
                        />
                    </Header>
                    <Content style={{ marginTop: -150 }}>
                        <List>
                            <ListItem onPress={() => this.props.navigation.navigate("InicioConsumidor")}>
                                <View style={{flexDirection: "row", justifyContent: "flex-start"}}>
                                    <Image
                                        style={{ width: 26, height: 26, alignSelf: "center" }}
                                        source={require("./../../images/dashboard.png")}
                                    />
                                    <Text style={{textAlignVertical:"center", marginLeft: 25}}>Página Inicial</Text>
                                </View>
                            </ListItem>
                            <ListItem onPress={() => this.props.navigation.navigate("Perfil")}>
                                <View style={{flexDirection: "row", justifyContent: "flex-start"}}>
                                    <Image
                                        style={{ width: 26, height: 26, alignSelf: "center" }}
                                        source={require("./../../images/userm.png")}
                                    />
                                    <Text style={{textAlignVertical:"center", marginLeft: 25}}>Perfil</Text>
                                </View>
                            </ListItem>
                            <ListItem onPress={() => this.props.navigation.navigate("Saldo")}>
                                <View style={{flexDirection: "row", justifyContent: "flex-start"}}>
                                    <Image
                                        style={{ width: 26, height: 26, alignSelf: "center" }}
                                        source={require("./../../images/money.png")}
                                    />
                                    <Text style={{textAlignVertical:"center", marginLeft: 25}}>Saldo</Text>
                                </View>
                            </ListItem>
                            <ListItem onPress={() => this.props.navigation.navigate("Calendario")}>
                                <View style={{flexDirection: "row", justifyContent: "flex-start"}}>
                                    <Image
                                        style={{ width: 26, height: 26, alignSelf: "center" }}
                                        source={require("./../../images/meal.png")}
                                    />
                                    <Text style={{textAlignVertical:"center", marginLeft: 25}}>Refeições</Text>
                                </View>
                            </ListItem>
                            <ListItem onPress={() => this.props.navigation.navigate("Informacoes")}>
                                <View style={{flexDirection: "row", justifyContent: "flex-start"}}>
                                    <Image
                                        style={{ width: 26, height: 26, alignSelf: "center" }}
                                        source={require("./../../images/info.png")}
                                    />
                                    <Text style={{textAlignVertical:"center", marginLeft: 25}}>Informações</Text>
                                </View>
                            </ListItem>
                            <ListItem onPress={() => this.props.navigation.navigate("Notificacoes")}>
                                <View style={{flexDirection: "row", justifyContent: "flex-start"}}>
                                    <Image
                                        style={{ width: 26, height: 26, alignSelf: "center" }}
                                        source={require("./../../images/bell.png")}
                                    />
                                    <Text style={{textAlignVertical:"center", marginLeft: 25}}>Notificações</Text>
                                </View>
                            </ListItem>
                            <ListItem onPress={() => this.logout()}>
                                <View style={{flexDirection: "row", justifyContent: "flex-start"}}>
                                    <Image
                                        style={{ width: 26, height: 26, alignSelf: "center" }}
                                        source={require("./../../images/logout.png")}
                                    />
                                    <Text style={{textAlignVertical:"center", marginLeft: 25}}>Logout</Text>
                                </View>
                            </ListItem>
                        </List>
                    </Content>
                </Container>
            </ScrollView>
        )
    }
}
