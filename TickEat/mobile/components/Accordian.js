
import React, {Component} from 'react';
import { View, TouchableOpacity, Text, StyleSheet, Image} from "react-native";


export default class Accordian extends Component{

    constructor(props) {
        super(props);
        this.state = { 
            energia: props.energia,
            lipidos: props.lipidos,
            saturados: props.saturados,
            hidratos: props.hidratos,
            acucar: props.acucar,
            fibra: props.fibra,
            proteinas: props.proteinas,
            sal: props.sal,
            expanded : false,
        }
    }

    handleIcon() {
        if (this.state.expanded) {
            return <Image
                style={{ width: 26, height: 26, justifyContent: "flex-start" }}
                source={require("./../images/up.png")}
            />
        }
        else {
            return <Image
                style={{ width: 26, height: 26, justifyContent: "flex-start" }}
                source={require("./../images/down.png")}
            />
        }
    }
  
  render() {
    return (
       <View>
            <TouchableOpacity style={styles.row} onPress={()=>this.toggleExpand()}>
                <Text style={{width:"80%"}}>{this.props.title}</Text>
                <View>{this.handleIcon()}</View>
            </TouchableOpacity>
            <View style={styles.parentHr}/>
            {
                this.state.expanded &&
                <View style={styles.child}>
                    <Text style={{marginBottom:5}}>
                        <Text style={{fontWeight:"bold"}}>{"Energia: "}</Text>
                        <Text>{this.props.energia}</Text>
                    </Text>
                    <Text style={{marginBottom:5}}>
                        <Text style={{fontWeight:"bold"}}>{"Lípidos: "}</Text>
                        <Text>{this.props.lipidos}</Text>
                    </Text>
                    <Text style={{marginBottom:5}}>
                        <Text style={{fontWeight:"bold"}}>{"Lípidos, dos quais saturados: "}</Text>
                        <Text>{this.props.saturados}</Text>
                    </Text>
                    <Text style={{marginBottom:5}}>
                        <Text style={{fontWeight:"bold"}}>{"Hidratos de carbono: "}</Text>
                        <Text>{this.props.hidratos}</Text>
                    </Text>
                    <Text style={{marginBottom:5}}>
                        <Text style={{fontWeight:"bold"}}>{"Hidratos de carbono, dos quais açúcares: "}</Text>
                        <Text>{this.props.acucar}</Text>
                    </Text>
                    <Text style={{marginBottom:5}}>
                        <Text style={{fontWeight:"bold"}}>{"Fibra: "}</Text>
                        <Text>{this.props.fibra}</Text>
                    </Text>
                    <Text style={{marginBottom:5}}>
                        <Text style={{fontWeight:"bold"}}>{"Proteínas: "}</Text>
                        <Text>{this.props.proteinas}</Text>
                    </Text>
                    <Text style={{marginBottom:5}}>
                        <Text style={{fontWeight:"bold"}}>{"Sal: "}</Text>
                        <Text>{this.props.sal}</Text>
                    </Text>  
                </View>
            }
       </View>
    )
  }

  toggleExpand=()=>{
    this.setState({expanded : !this.state.expanded})
  }

}

const styles = StyleSheet.create({
    row:{
        flexDirection: 'row',
        justifyContent:'space-between',
        height:56,
        paddingLeft:10,
        paddingRight:10,
        alignItems:'center',
        backgroundColor: "white",
    },
    parentHr:{
        height:1,
        color: "white",
        width:'100%'
    },
    child:{
        margin:10,
        backgroundColor: "lightgray",
        padding:16,
    }
    
});