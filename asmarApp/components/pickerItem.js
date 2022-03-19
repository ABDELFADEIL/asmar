import React ,{useState }from 'react';
import { Picker } from "@react-native-community/picker";
import {View, Text, StyleSheet} from 'react-native';
import theme from '../../asmarApp/utils/theme'

export const PickerItem =({setSelectedQty,quantity})=> {

    const [selectedValue, setSelectedValue ] = useState(1);

    const array = Array.from({length:20}, (x, i) => i);
    const getQuantity =()=> {

        if(quantity > 20) {
            return array;
        } else{
            return  Array.from({length:quantity}, (x, i) => i);
        }
    }
    return(
        <View   style={styles.pickerContainer}>
            <Picker
                selectedValue={selectedValue}
                onValueChange={(itemValue, itemIndex) => {setSelectedValue(itemValue);
                    setSelectedQty(itemValue)
                    console.log(selectedValue)}}
                    mode="dropdown"
                    style={styles.pickerText}

               /* style={{ height: 18, width: 80,marginLeft:30,marginTop:-15,borderWidth:1,borderColor:theme.COLORS.DARK_GREEN}}*/
                itemStyle={{ backgroundColor:'transparent', color: theme.COLORS.DARK_GREEN,  fontSize:17 ,marginTop:-70,height:50

                    }}

            >
                {
                    getQuantity().map((x, index) => (

                         <Picker.Item  key={x+1} value={x+1}  label={(x+1).toString()}> {x+1}</Picker.Item>

                    ))}
            </Picker>
        </View>
    )

}
const styles = StyleSheet.create({

    pickerContainer:{
        marginTop: -50,
        position: 'absolute', left:0, bottom:0, zIndex:10,
        flex: 1,

    },
    pickerText:{
        color:theme.COLORS.DARK_GREEN,
     /*   height: 20,*/
        textAlign: 'left',
        padding:0,
        marginTop: -15,
        marginLeft: 80,
        backgroundColor:'transparent',

        borderColor:theme.COLORS.DARK_GREEN,
        width: 80
    },
});
