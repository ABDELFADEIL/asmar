import React from "react";
import {
    Animated, View, Text, Pressable,
    StyleSheet, Image, TextInput, TouchableOpacity, ScrollView, Platform
} from 'react-native';
import {AsyncStorage,} from '@react-native-async-storage/async-storage';
import {Link, useTheme} from '@react-navigation/native';
import { useCardAnimation } from '@react-navigation/stack';
import {useEffect, useState} from 'react';
import Logo from "../../assets/asmar_logo.png";
import * as Animatable from 'react-native-animatable';
import {GET_JWT_TOKEN, Login, SET_JWT_TOKEN, Signup} from "../../services/userService";
import { emailValidator } from '../helpers/emailValidator'
import { passwordValidator } from '../helpers/passwordValidator'
import Icon from 'react-native-vector-icons/FontAwesome';
import {LinearGradient} from "expo-linear-gradient";
import FontAwesome from "react-native-vector-icons/FontAwesome";
import Feather from "react-native-vector-icons/Feather";
import {KeyboardAwareScrollView} from "react-native-keyboard-aware-scroll-view";
export default function SignUpScreen({route, navigation}) {
    const { colors } = useTheme();
    const { current } = useCardAnimation();
    const [ token, setToken ] = useState(GET_JWT_TOKEN());
    const [data, setData] = useState(
        {
            email: '',
            password: '',
            confirm_password: '',
            lastName: '',
            firstName: '',
            telephone: '',
            username: '',
            birthDate: '',
            street: '',
            city: '',
            state: '',
            postalCode: '',
            country: '',
            addInfos: '',
            active: true,
                  })


    const onSubmitForm = async () => {
        const response = await Signup(user);
        try {
            const headers = response.headers;
            console.log(GET_JWT_TOKEN("jwtToken"));
            if (response.status === 200) {
                console.log(navigation)
                navigation.navigate(route.params.name);
            }
        } catch (e) {
            console.log(e);
        }
    }
    const textInputChange = (val) => {
        if( val.length !== 0 ) {
            setData({
                ...data,
                username: val,
                check_textInputChange: true
            });
        } else {
            setData({
                ...data,
                username: val,
                check_textInputChange: false
            });
        }
    }
    return (
        <View
            style={[styles.container, {}]}>
            <Pressable style={[
                StyleSheet.absoluteFill,
                { backgroundColor: 'rgba(0, 0, 0, 0.5)' },
            ]}
                       onPress={navigation.goBack}/>

            <Animated.View
                style={{
                    padding: 16,
                    width: '90%',
                    borderRadius: 10,
                    backgroundColor: colors.card,
                    transform: [
                        {
                            scale: current.progress.interpolate({
                                inputRange: [0, 1],
                                outputRange: [0.9, 1],
                                extrapolate: 'clamp',
                            }),
                        },
                    ],

                    textAlign: 'center',
                    height: 560,
                    justifyContent: 'center'

                }}
            >
                <ScrollView>
                <View style={{
                    flex: 1,
                    justifyContent: 'space-between'
                }}>
                <View style={{alignSelf: 'center', marginBottom: 0, marginTop: 0}}>
                    <Image source={Logo}
                           style={{ width: 100, height: 60}}
                           alt="asmar logo"/>
                    <View style={styles.connHead}><Text style={styles.connHeadH5}>Créer un compte</Text></View>
                </View>
                <View style={styles.loginFrom}>
                    <View style={{width: '100%'}}>
                        <Text style={styles.text_label}>Nom</Text>
                        <View style={styles.action}>
                            <TextInput
                                placeholder=""
                                style={styles.textInput}
                                autoCapitalize="none"
                                onChangeText={(val) => textInputChange(val)}
                            />
                        </View>
                    </View>
                    <View style={{width: '100%', marginTop: 10}}>
                        <Text style={styles.text_label}>Prénom</Text>
                        <View style={styles.action}>
                            <TextInput
                                placeholder=""
                                style={styles.textInput}
                                autoCapitalize="none"
                                onChangeText={(val) => textInputChange(val)}
                            />
                        </View>
                    </View>
                    <View style={{width: '100%', marginTop: 10}}>
                        <Text style={styles.text_label}>Email</Text>
                        <View style={styles.action}>
                            <TextInput
                                placeholder=""
                                style={styles.textInput}
                                autoCapitalize="none"
                                onChangeText={(val) => textInputChange(val)}
                            />
                        </View>
                    </View>
                    <View style={{width: '100%', marginTop: 10}}>
                        <Text style={styles.text_label}>Password</Text>
                        <View style={styles.action}>
                            <TextInput
                                placeholder=""
                                style={styles.textInput}
                                autoCapitalize="none"
                                onChangeText={(val) => textInputChange(val)}
                            />
                        </View>
                    </View>
                    <View style={{width: '100%', marginTop: 10}}>
                        <Text style={styles.text_label}>Confirme mot de passe</Text>
                        <View style={styles.action}>
                            <TextInput
                                placeholder=""
                                style={styles.textInput}
                                autoCapitalize="none"
                                onChangeText={(val) => textInputChange(val)}
                            />
                        </View>
                    </View>
                    <View style={{width: '100%', marginTop: 10}}>
                        <Text style={styles.text_label}>N° + Voie</Text>
                        <View style={styles.action}>
                            <TextInput
                                placeholder=""
                                style={styles.textInput}
                                autoCapitalize="none"
                                onChangeText={(val) => textInputChange(val)}
                            />
                        </View>
                    </View>
                    <View style={{width: '100%', marginTop: 10}}>
                        <Text style={styles.text_label}>Ville</Text>
                        <View style={styles.action}>
                            <TextInput
                                placeholder=""
                                style={styles.textInput}
                                autoCapitalize="none"
                                onChangeText={(val) => textInputChange(val)}
                            />
                        </View>
                    </View>
                    <View style={{width: '100%', marginTop: 10}}>
                        <Text style={styles.text_label}>Code postale</Text>
                        <View style={styles.action}>
                            <TextInput
                                placeholder=""
                                style={styles.textInput}
                                autoCapitalize="none"
                                onChangeText={(val) => textInputChange(val)}
                            />
                        </View>
                    </View>
                    <View style={{width: '100%', marginTop: 10}}>
                        <Text style={styles.text_label}>Pays</Text>
                        <View style={styles.action}>
                            <TextInput
                                placeholder=""
                                style={styles.textInput}
                                autoCapitalize="none"
                                onChangeText={(val) => textInputChange(val)}
                            />
                        </View>
                    </View>
                </View>
                <View style={styles.btnConn}>
                    <TouchableOpacity style={styles.btn} onPress={onSubmitForm}>
                        <LinearGradient style={styles.button} colors={['#F3BD6E', '#7A5F37']}>
                            <View onClick={onSubmitForm} style={styles.btnSignin}><Text>Envoyer</Text></View>
                        </LinearGradient>
                    </TouchableOpacity>
                    <TouchableOpacity style={styles.btn} onPress={() =>{
                        navigation.goBack();
                        navigation.navigate('Créer un compte')
                    }
                    }
                    >
                        <View style={styles.btnSignup}><Text style={{ fontSize: 14, marginLeft: 'auto', marginRight: 'auto'}} >Se connecter</Text></View>
                    </TouchableOpacity>

                </View>

                </View>
                    </ScrollView>
            </Animated.View>
        </View>
    );
}


const styles = StyleSheet.create({

    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
        alignContent: 'center',
        paddingTop: 80,


    },

    loginLogoImg: {
    },
    connHead: {
     marginTop: 10
    },
    connHeadH5: {
        textAlign: 'center',
        fontSize: 18,
        color: '#003B49'
    },
    loginFrom: {
        flexDirection: 'column',
        flexWrap: 'wrap',
        justifyContent: 'center',
        marginTop: 20,

    },

    signupInput: {
        width: '80%',
        color: 'red'
    },
    loginPageCartSvg: {
        height: 20,
        color: '#003B49',
        marginBottom: 5,
        width: '10%',
    },
    pwdForget: {
        width: '90%',
        height: 20,
        marginTop: -20,
        color: '#0017aa'
    },

    btnConn: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        marginTop: 10,
        borderRadius: 15,
        color: '#003B49',
    },
    btn: {
        width: '48%'
    },
    button: {
        borderRadius: 15,
        marginBottom: 15,
        height: 35,
    },
    btnConnDiv: {
        borderRadius: 10,
        height: 40,
        textAlign: 'center',
        padding: 8,

    },
    btnSignin: {
        height: 30,
        textAlign: 'center',
        paddingTop: 5,
        marginLeft: 'auto',
        marginRight: 'auto'
    },
    btnSignup: {
        backgroundColor: 'rgba(0, 59, 73, 0.5)',
        borderRadius: 15,
        height: 35,
        textAlign: 'center',
        paddingTop: 5,
        fontSize: 14,
        width: '100%',



    },

    btnConnA: {
        color: '#003B49',
    },
    action: {
        flexDirection: 'row',
        marginTop: 10,
        borderBottomWidth: 1,
        borderBottomColor: '#F4D19E',
        paddingBottom: 0
    },
    textInput: {
        flex: 1,
        marginTop: Platform.OS === 'ios' ? 0 : -12,
        paddingLeft: 0,
        color: '#05375a',
    },
    text_label: {
        marginLeft: 0,
        fontSize: 16,
        textTransform: 'capitalize',
        color: '#003B49'
    }


});
