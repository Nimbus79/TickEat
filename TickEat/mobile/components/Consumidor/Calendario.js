import React, { Component } from "react";

import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  TouchableOpacity,
  Image,
  TouchableHighlight
} from "react-native";

import { Container, Header, Text, Card } from "native-base";

import Constants from 'expo-constants';
import { Agenda } from "react-native-calendars";



export default class Calendario extends Component {
  state = {
    cantinas: [],
    index: 0,
    ready: false,
    ip: "192.168.1.88"
  };

  

  async componentDidMount() {
    const response = await fetch(
        "http://"+this.state.ip+":8080/tickeat_war_exploded/Calendario",
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
          this.setState({ cantinas: json.cantinas });
          this.setState({ ready: true })
        } else {
          this.props.navigation.navigate("LoginPt");
        }
    });
  }


  moveLeft() {
    var newIndex
    if (this.state.ready) {
        if (this.state.index == 0) {
            newIndex = this.state.cantinas.length-1
            this.setState({index: newIndex})
        }
        else {
            newIndex = this.state.index-1
            this.setState({index: newIndex})
        }
    }
  }

  moveRight() {
    var newIndex
    if (this.state.ready) {
        if (this.state.index == this.state.cantinas.length-1) {
            newIndex = 0
            this.setState({index: newIndex})
        }
        else {
            newIndex = this.state.index+1
            this.setState({index: newIndex})
        }
    }
  }

  renderCantinaNome() {
    if (this.state.ready) {
        return <Text style={{fontSize: 20, marginTop:6, justifyContent: "center", textAlign: "center"}}>
            {this.state.cantinas[this.state.index].nome}
        </Text>
    }
  }

  createItems() {
    var items = {}
    var refeicao = {}
    if (this.state.ready) {
        var ref = this.state.cantinas[this.state.index].refeicoes
        for (i = 0; i < ref.length; i++) {
            refeicao = {}
            var data = ref[i].start
            refeicao["title"] = ref[i].title;
            refeicao["class"] = ref[i].class;
            refeicao["cantinaId"] = ref[i].cantinaId;
            refeicao["refeicaoId"] = ref[i].id;
            
            if (data in items) {
                var tipo1 = {}
                var tipo2 = {}
                var tipo = items[data].length+1
                refeicao["tipo"] = tipo
                tipo1 = items[data][0].tipo1
                tipo2 = refeicao
                items[data][0] = {tipo1, tipo2}
            }
            else {
                var tipo1 = {}
                refeicao["tipo"] = 1
                tipo1 = refeicao
                items[data] = [{tipo1}]
            }
        }
    }
    return items
  }
  

  handleItemTipo1(item) {
    if (item.tipo1.class == "reservada") {
        return (
            <TouchableOpacity
                key={item.tipo1.refeicaoId}
                style={styles.greenbtn}
                onPress={() => {
                    this.props.navigation.navigate("Refeicao", {
                        refeicaoId: item.tipo1.refeicaoId,
                        cantinaId: item.tipo1.cantinaId
                    });
                }}
            >
                <Text style={{fontWeight: "bold", color:"white", fontSize:15}}>
                    {item.tipo1.title}
                </Text>
            </TouchableOpacity>
        )
    }
    else if (item.tipo1.class == "reservada japassou") {
        return (
            <TouchableOpacity
                key={item.tipo1.refeicaoId}
                style={styles.lggreenbtn}
                onPress={() => {
                    this.props.navigation.navigate("Refeicao", {
                        refeicaoId: item.tipo1.refeicaoId,
                        cantinaId: item.tipo1.cantinaId
                    });
                }}
            >
                <Text style={{fontWeight: "bold", color:"white", fontSize:15}}>
                    {item.tipo1.title}
                </Text>
            </TouchableOpacity>
        )
    }
    else if (item.tipo1.class == "naoreservada") {
        return (
            <TouchableOpacity
                key={item.tipo1.refeicaoId}
                style={styles.rdbtn}
                onPress={() => {
                    this.props.navigation.navigate("Refeicao", {
                        refeicaoId: item.tipo1.refeicaoId,
                        cantinaId: item.tipo1.cantinaId
                    });
                }}
            >
                <Text style={{fontWeight: "bold", color:"white", fontSize:15}}>
                    {item.tipo1.title}
                </Text>
            </TouchableOpacity>
        )
    }
    else if (item.tipo1.class == "naoreservada japassou") {
        return (
            <TouchableOpacity
                key={item.tipo1.refeicaoId}
                style={styles.lgrdbtn}
                onPress={() => {
                    this.props.navigation.navigate("Refeicao", {
                        refeicaoId: item.tipo1.refeicaoId,
                        cantinaId: item.tipo1.cantinaId
                    });
                }}
            >
                <Text style={{fontWeight: "bold", color:"white", fontSize:15}}>
                    {item.tipo1.title}
                </Text>
            </TouchableOpacity>
        )
    }
    return null
  }

  handleItemTipo2(item) {
    if (item.tipo2.class == "reservada") {
        return (
            <TouchableOpacity
                key={item.tipo2.refeicaoId}
                style={styles.greenbtn}
                onPress={() => {
                    this.props.navigation.navigate("Refeicao", {
                        refeicaoId: item.tipo2.refeicaoId,
                        cantinaId: item.tipo2.cantinaId
                    });
                }}
            >
                <Text style={{fontWeight: "bold", color:"white", fontSize:15}}>
                    {item.tipo2.title}
                </Text>
            </TouchableOpacity>
        )
    }
    else if (item.tipo2.class == "reservada japassou") {
        return (
            <TouchableOpacity
                key={item.tipo2.refeicaoId}
                style={styles.lggreenbtn}
                onPress={() => {
                    this.props.navigation.navigate("Refeicao", {
                        refeicaoId: item.tipo2.refeicaoId,
                        cantinaId: item.tipo2.cantinaId
                    });
                }}
            >
                <Text style={{fontWeight: "bold", color:"white", fontSize:15}}>
                    {item.tipo2.title}
                </Text>
            </TouchableOpacity>
        )
    }
    else if (item.tipo2.class == "naoreservada") {
        return (
            <TouchableOpacity
                key={item.tipo2.refeicaoId}
                style={styles.rdbtn}
                onPress={() => {
                    this.props.navigation.navigate("Refeicao", {
                        refeicaoId: item.tipo2.refeicaoId,
                        cantinaId: item.tipo2.cantinaId
                    });
                }}
            >
                <Text style={{fontWeight: "bold", color:"white", fontSize:15}}>
                    {item.tipo2.title}
                </Text>
            </TouchableOpacity>
        )
    }
    else if (item.tipo2.class == "naoreservada japassou") {
        return (
            <TouchableOpacity
                key={item.tipo2.refeicaoId}
                style={styles.lgrdbtn}
                onPress={() => {
                    this.props.navigation.navigate("Refeicao", {
                        refeicaoId: item.tipo2.refeicaoId,
                        cantinaId: item.tipo2.cantinaId
                    });
                }}
            >
                <Text style={{fontWeight: "bold", color:"white", fontSize:15}}>
                    {item.tipo2.title}
                </Text>
            </TouchableOpacity>
        )
    }
    return null
  }


  render() {
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
                      CALENDÁRIO
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
            <Header style={{backgroundColor:"white"}}>
                <View style={styles.menu}>
                    <TouchableOpacity
                      onPress={() => this.moveLeft()}
                    >
                      <Image
                        style={{ width: 40, height: 40, justifyContent: "flex-start" }}
                        source={require("./../../images/left.png")}
                      />
                    </TouchableOpacity>
                    <View style={{width:"80%", flexDirection: "row", justifyContent: "center", textAlign: "center"}}>
                        {this.renderCantinaNome()}
                    </View>
                    <View style={{flexDirection: "row", justifyContent: "flex-end", width:"15%"}}>
                      <TouchableOpacity
                        onPress={() => this.moveRight()}
                      >
                        <Image
                          style={{ width: 40, height: 40, marginRight: 25}}
                          source={require("./../../images/right.png")}
                        />
                      </TouchableOpacity>
                    </View>
                  </View>
            </Header>
            <View>
            <ScrollView style={styles.scrollView}>
              <Agenda
                // // The list of items that have to be displayed in agenda. If you want to render item as empty date
                // // the value of date key kas to be an empty array []. If there exists no value for date key it is
                // // considered that the date in question is not yet loaded
                items={this.createItems()}
                // // Callback that gets called when items for a certain month should be loaded (month became visible)
                // loadItemsForMonth={month => {
                //   console.log("trigger items loading");
                // }}
                // // Callback that fires when the calendar is opened or closed
                // onCalendarToggled={calendarOpened => {
                //   console.log(calendarOpened);
                // }}
                // // Callback that gets called on day press
                // onDayPress={day => {
                //   console.log("day pressed");
                // }}
                // // Callback that gets called when day changes while scrolling agenda list
                // onDayChange={day => {
                //   console.log("day changed");
                // }}
                // // Max amount of months allowed to scroll to the past. Default = 50
                // pastScrollRange={50}
                // // Max amount of months allowed to scroll to the future. Default = 50
                // futureScrollRange={50}
                // // Specify how each item should be rendered in agenda
                renderItem={(item, firstItemInDay) => {
                  return (
                    <View style={{flexDirection:"row"}}>
                      {this.handleItemTipo1(item)}
                      {this.handleItemTipo2(item)}
                    </View>
                  )
                }}
                // Specify how each date should be rendered. day can be undefined if the item is not first in that day.
                // renderDay={(day, item) => {
                //   console.log("dia :", day);
                //   console.log("Item : ", item);
                //   return (
                //     <View>
                //       <Text>{item.text}</Text>
                //     </View>
                //   );
                // }}
                // // Specify how empty date content with no items should be rendered
                renderEmptyDate={() => {
                   return (
                        <View>
                            <Text style={{textAlign:"center", marginTop:20, marginBottom:20}}>
                                Não existem refeições agendadas.
                            </Text>
                        </View>
                    )
                }}
                // // Specify how agenda knob should look like
                // renderKnob={() => {
                //   return <View />;
                // }}
                // // Specify what should be rendered instead of ActivityIndicator
                renderEmptyData={() => {
                    return (
                        <View>
                            <Text style={{textAlign:"center", marginTop:20, marginBottom:20}}>
                                Não existem refeições agendadas.
                            </Text>
                        </View>
                    )
                }}
                // // Specify your item comparison function for increased performance
                rowHasChanged={(r1, r2) => {
                  return r1.text !== r2.text;
                }}
                // // Hide knob button. Default = false
                // hideKnob={true}
                // // By default, agenda dates are marked if they have at least one item, but you can override this if needed
                // markedDates={{
                //   "2012-05-16": { selected: true, marked: true },
                //   "2012-05-17": { marked: true },
                //   "2012-05-18": { disabled: true }
                // }}
                // // If disabledByDefault={true} dates flagged as not disabled will be enabled. Default = false
                // disabledByDefault={true}
                // // If provided, a standard RefreshControl will be added for "Pull to Refresh" functionality. Make sure to also set the refreshing prop correctly.
                // onRefresh={() => console.log("refreshing...")}
                // // Set this true while waiting for new data from a refresh
                // refreshing={false}
                // // Add a custom RefreshControl component, used to provide pull-to-refresh functionality for the ScrollView.
                // refreshControl={null}
                // // Agenda theme
                // theme={{
                //   backgroundColor: "#ffffff",
                //   calendarBackground: "#ffffff",
                //   textSectionTitleColor: "#b6c1cd",
                //   selectedDayBackgroundColor: "#00adf5",
                //   selectedDayTextColor: "#ffffff",
                //   todayTextColor: "#00adf5",
                //   dayTextColor: "#2d4150",
                //   textDisabledColor: "#d9e1e8",
                //   dotColor: "#00adf5",
                //   selectedDotColor: "#ffffff",
                //   arrowColor: "orange",
                //   disabledArrowColor: "#d9e1e8",
                //   monthTextColor: "blue",
                //   indicatorColor: "blue",
                //   textDayFontFamily: "monospace",
                //   textMonthFontFamily: "monospace",
                //   textDayHeaderFontFamily: "monospace",
                //   textDayFontWeight: "300",
                //   textMonthFontWeight: "bold",
                //   textDayHeaderFontWeight: "300",
                //   textDayFontSize: 16,
                //   textMonthFontSize: 16,
                //   textDayHeaderFontSize: 16,
                //   agendaDayTextColor: "yellow",
                //   agendaDayNumColor: "green",
                //   agendaTodayColor: "red",
                //   agendaKnobColor: "blue"
                // }}
                // // Agenda container style
                style={{ top: 10, height: 500 }}
              />
              </ScrollView>
            </View>
        </ScrollView>
      </SafeAreaView>
    );
  }
}


const styles = StyleSheet.create({
  rdbtn: {
    fontWeight: "500",
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
    paddingTop: 10,
    paddingBottom: 10,
    paddingRight: 40,
    paddingLeft: 40,
    backgroundColor: "#b30000",
    color: "white",
    alignItems: "center",
    width:"45%",
    marginLeft: 5,
    marginRight: 5,
    marginTop: 40 ,
    height: 40
  },
  lgrdbtn: {
    fontWeight: "500",
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
    paddingTop: 10,
    paddingBottom: 10,
    paddingRight: 40,
    paddingLeft: 40,
    backgroundColor: "#b30000",
    color: "white",
    alignItems: "center",
    opacity: 0.6,
    width:"45%",
    marginLeft: 5,
    marginRight: 5,
    marginTop: 40 ,
    height: 40
  },
  greenbtn: {
    fontWeight: "500",
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
    paddingTop: 10,
    paddingBottom: 10,
    paddingRight: 40,
    paddingLeft: 40,
    backgroundColor: "#00b300",
    color: "white",
    alignItems: "center",
    width:"45%",
    marginLeft: 5,
    marginRight: 5,
    marginTop: 40 ,
    height: 40
  },
  lggreenbtn: {
    fontWeight: "500",
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
    paddingTop: 10,
    paddingBottom: 10,
    paddingRight: 40,
    paddingLeft: 40,
    backgroundColor: "#00b300",
    color: "white",
    alignItems: "center",
    opacity: 0.6,
    width:"45%",
    marginLeft: 5,
    marginRight: 5,
    marginTop: 40 ,
    height: 40
  },
  menu: {
    marginTop: 7,
    marginBottom: 10,
    flexDirection: "row",
    width: "100%"
  },
  container: {
    flex: 1,
    marginTop: Constants.statusBarHeight
  },
  scrollView: {
    backgroundColor: 'white',
    marginHorizontal: 0
  }
});
