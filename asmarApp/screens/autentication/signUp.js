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
import {GET_JWT_TOKEN, Login, SET_JWT_TOKEN, Signup} from "../../services/userService";
import {LinearGradient} from "expo-linear-gradient";
import Feather from "react-native-vector-icons/Feather";
export default function SignUpScreen({route, navigation}) {
    const { colors } = useTheme();
    const { current } = useCardAnimation();
    const [ token, setToken ] = useState(GET_JWT_TOKEN());
    const [ userDTO, setUserDTO ] = useState({});
    const [ secure, setSecure] = useState({
        secureTextEntry: true,
        confirm_secureTextEntry: true
    })
    const [ code , setCode ] = useState('');
    const [user, setUser] = useState(
        {
            email: '', password: '', confirmPassword: '', lastName: '',
            firstName: '', telephone: '', username: null, birthDate: ''
                  });
    const [address, setAddress] = useState(
        { street: '', city: '', state: '', postalCode: '',
            country: '', addInfos: '', active: true
        });

    const onInputchange = (value, name) => {
        console.log(name);

        if( value.length !== 0 ) {
            if (name === 'code'){
                setCode(value)
            }else if (name === 'telephone'){
                setUser(user => ({...user, [name]: code + value}))
            }else if(name === 'birthDate'){
                // convertDate
                setUser(user => ({...user, [name]: convertDate(value)}))
            }
            else {
                setUser(user => ({...user, [name]: value}))
            }
        } else {

        }
        console.log(user);
    }

    const onSubmitForm = async () => {
        console.log(user);
        const response = await Signup(user);

        try {
            console.log(response);
            const userAddress = await response.data;
            setUserDTO(userAddress);
            if (response.status === 201) {
                console.log('201 response');
                console.log('userDTO');
                console.log(userDTO);
                //navigation.goBack();
                //navigation.navigate('Connexion ');
            }
        } catch (e) {
            console.log(e);
        }

    }
    const textInputChange = (val) => {
        console.log(val);
        if( val.length !== 0 ) {
            setUser({
                ...user,
                username: val,
                check_textInputChange: true
            });
        } else {
            setUser({
                ...user,
                username: val,
                check_textInputChange: false
            });
        }
    }
    const convertDate = (dateStr) => {
      let arrayDate = dateStr.split('/');
      return arrayDate[2] + '-' + arrayDate[1] + '-' + arrayDate[0];
    }
    const updateSecureTextEntry = () => {
        setSecure({
            ...secure,
            secureTextEntry: !secure.secureTextEntry
        });
    }
    const updateConfirmSecureTextEntry = () => {
        setSecure({
            ...secure,
            confirm_secureTextEntry: !secure.confirm_secureTextEntry
        });
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
                    padding: 15,
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
                    height: 580,
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
                           style={{ width: 60, height: 40}}
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
                                onChangeText={(val) => onInputchange(val, 'lastName')}
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
                                onChangeText={(val) => onInputchange(val, 'firstName')}
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
                                onChangeText={(val) => onInputchange(val, 'email')}
                            />
                        </View>
                    </View>
                    <View style={{width: '100%', marginTop: 10}}>
                        <Text style={styles.text_label}>Date de naissance</Text>
                        <View style={styles.action}>
                            <TextInput
                                placeholder="Exp: 01/01/1990"
                                style={styles.textInput}
                                autoCapitalize="none"
                                type="date"
                                onChangeText={(val) => onInputchange(val, 'birthDate')}
                            />
                        </View>

                    </View>
                   <View style={{width: '100%', marginTop: 10, flex: 1, flexDirection: 'row', justifyContent: 'space-between'}}>
                       <View style={{width: '48%', marginTop: 10}}>
                           <Text style={styles.text_label}>Mot de passe</Text>
                           <View style={styles.action}>
                               <TextInput
                                   placeholder=""
                                   secureTextEntry={secure.secureTextEntry ? true : false}
                                   style={styles.textInput}
                                   autoCapitalize="none"
                                   onChangeText={(val) => onInputchange(val, 'password')}
                               />
                               <TouchableOpacity
                                   style={{paddingBottom: 5}}
                                   onPress={updateSecureTextEntry}
                               >
                                   {secure.secureTextEntry ?
                                       <Feather
                                           name="eye-off"
                                           color="#003B49"
                                           size={16}
                                       />
                                       :
                                       <Feather
                                           name="eye"
                                           color="#003B49"
                                           size={16}
                                       />
                                   }
                               </TouchableOpacity>
                           </View>

                       </View>
                       <View style={{width: '48%', marginTop: 10}}>
                           <Text style={styles.text_label}>Confirmer</Text>
                           <View style={styles.action}>
                               <TextInput
                                   placeholder=""
                                   secureTextEntry={secure.confirm_secureTextEntry ? true : false}
                                   style={styles.textInput}
                                   autoCapitalize="none"
                                   onChangeText={(val) => onInputchange(val, 'confirmPassword')}
                               />
                               <TouchableOpacity
                                   style={{paddingBottom: 5}}
                                   onPress={updateConfirmSecureTextEntry}
                               >
                                   {secure.confirm_secureTextEntry ?
                                       <Feather
                                           name="eye-off"
                                           color="#003B49"
                                           size={16}
                                       />
                                       :
                                       <Feather
                                           name="eye"
                                           color="#003B49"
                                           size={16}
                                       />
                                   }
                               </TouchableOpacity>
                           </View>

                       </View>
                   </View>
                    <View style={{width: '100%', marginTop: 10, flex: 1, flexDirection: 'row', justifyContent: 'space-between'}}>
                        <View style={{width: '20%', marginTop: 10}}>
                            <Text style={styles.text_label}>Pays</Text>
                            <View style={styles.action}>
                                <TextInput
                                    placeholder="+33"
                                    style={styles.textInput}
                                    autoCapitalize="none"
                                    onChangeText={(val) => onInputchange(val, 'code')}
                                />
                            </View>
                        </View>
                        <View style={{width: '75%', marginTop: 10}}>
                            <Text style={styles.text_label}>Téléphone</Text>
                            <View style={styles.action}>
                                <TextInput
                                    placeholder="066223322"
                                    style={styles.textInput}
                                    autoCapitalize="none"
                                    onChangeText={(val) => onInputchange(val, 'telephone')}
                                />
                            </View>
                        </View>

                    </View>
                </View>
                    <View style={styles.btnConn}>
                        <TouchableOpacity style={styles.btn} onPress={onSubmitForm}>
                            <LinearGradient style={styles.button} colors={['#F3BD6E', '#7A5F37']}>
                                <View onClick={onSubmitForm} style={styles.btnSignin}><Text>Créer mon compte</Text></View>
                            </LinearGradient>
                        </TouchableOpacity>
                    </View>
                    <View>
                        <TouchableOpacity style={styles.btn} onPress={() =>{
                            navigation.goBack();
                            navigation.navigate('Connexion ')
                        }
                        }
                        >
                            <View style={{flexDirection: 'row'}}>
                                <Text style={{width: '48%', marginTop: 5}}>Si vous avez un compte</Text>
                                <Text style={[styles.btnSignup]} >se connecter</Text></View>
                        </TouchableOpacity>
                    </View>
                </View>

                    {/*<View style={{width: '100%', marginTop: 10}}>
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
                    </View>*/}


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
        fontSize: 16,
        color: '#003B49'
    },
    loginFrom: {
        flexDirection: 'column',
        flexWrap: 'wrap',
        justifyContent: 'center',
        marginTop: 10,

    },

    signupInput: {
        width: '80%',
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
        marginTop: 20,
        borderRadius: 15,
        color: '#003B49',
    },
    btn: {
        width: '100%'
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
        width: '50%',



    },

    btnConnA: {
        color: '#003B49',
    },
    action: {
        flexDirection: 'row',
        marginTop: 5,
        borderBottomWidth: 1,
        borderBottomColor: '#F4D19E',
        paddingBottom: 0
    },
    textInput: {
        flex: 1,
        marginTop: Platform.OS === 'ios' ? 0 : -12,
        paddingLeft: 0,
        color: '#05375a',
        paddingTop: 5
    },
    text_label: {
        marginLeft: 0,
        fontSize: 16,
        textTransform: 'capitalize',
        color: '#003B49'
    }

});