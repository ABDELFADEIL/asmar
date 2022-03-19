import React ,{useState } from 'react';
import {  Picker } from "@react-native-community/picker";
import { View, StyleSheet } from "react-native";


export const PickerItem = ({setSelectedQty,quantity}) => {
    const [selectedValue, setSelectedValue] = useState(1);

    const array = Array.from({length: 20}, (x, i) => i+1);
    const getQuantity = () => {
        console.log("quantity : ", quantity);
        console.log("array : ", array);
        if (quantity > 20) {
            return array;
        } else {
            console.log("array qunatity : ", Array.from({length: quantity}, (x, i) => i+1));
            return Array.from({length: quantity}, (x, i) => i+1);
        }
    }
    return (
            <Picker
                selectedValue={selectedValue}
                style={styles.picker}
                onValueChange={(itemValue, itemIndex) => {setSelectedValue(itemValue);
                    setSelectedQty(itemValue)}}
            >
                {getQuantity().map((x, index) => (
                        /*<Picker.Item label={x + ''} value={x} />*/
                        <Picker.Item key={x} value={x} label={x + ''}> {x}</Picker.Item>
                    ))}
            </Picker>

    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        paddingTop: 20,
        alignItems: "center"
    },
    picker: {
        marginVertical: 30,
        width: 90,
        padding: 10,
        borderWidth: 1,
        borderColor: "#666",
        marginTop: 5, marginLeft: 5
    },
});