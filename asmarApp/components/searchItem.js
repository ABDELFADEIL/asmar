import React, {useEffect, useState} from 'react';
import { Searchbar } from 'react-native-paper';
import DefaultButton from './defaultButton';
import {View ,SafeAreaView, ScrollView,} from 'react-native';


export const SearchItem = ({setKeyword}) => {

    const [input, setInput] = useState('');


    const handleChange = (e) => {
        console.log(e)
        setInput(e);
        console.log(e);
        setKeyword(e);
    }

    const search = (e) => {
        e.preventDefault();
    };

    function clear(){
        setInput('');
        setKeyword('');

    };

    return (
        <SafeAreaView>
            <ScrollView>
                <View onSubmit={search}>
                    <Searchbar
                        placeholder="Search"
                        onChangeText={handleChange}
                        value={input}
                    />
                    <DefaultButton
                        title="Reset"
                        action={clear}/>
                </View>
            </ScrollView>
        </SafeAreaView>

    );
}
