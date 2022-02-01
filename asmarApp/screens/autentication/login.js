import React from "react";
import { Animated, View, Text, Pressable, Button, StyleSheet, Image, TextInput, TouchableOpacity, AsyncStorage } from 'react-native';
import {Link, useTheme} from '@react-navigation/native';
import { useCardAnimation } from '@react-navigation/stack';
import {useEffect, useState} from 'react';
import {productService} from '../../services/productService';
import {ScreenContainer} from "react-native-screens";
import Logo from "../../assets/asmar_logo.png"
import {GET_JWT_TOKEN, Login, SET_JWT_TOKEN} from "../../services/userService";
import { emailValidator } from '../helpers/emailValidator'
import { passwordValidator } from '../helpers/passwordValidator'
import Icon from 'react-native-vector-icons/FontAwesome';
export default function LoginScreen({route, navigation}) {
    const { colors } = useTheme();
    const { current } = useCardAnimation();
    let [ token, setToken ] = useState(GET_JWT_TOKEN());
    const [email, setEmail] = useState({ value: '', error: '' })
    const [password, setPassword] = useState({ value: '', error: '' })

    const onSubmitForm = async () => {
        const emailError = emailValidator(email.value)
        const passwordError = passwordValidator(password.value)
        if (emailError || passwordError) {
            setEmail({ ...email, error: emailError })
            setPassword({ ...password, error: passwordError })
            return
        }
        const user = {'email': email.value, 'password': password.value};
        const response = await Login(user);
        try {
            const headers = response.headers;
            SET_JWT_TOKEN(headers.authorization);
            console.log(GET_JWT_TOKEN("jwtToken"));
            if (response.status === 200) {
                console.log(navigation)
                navigation.navigate(route.params.name);
            }
        } catch (e) {
            console.log(e);
        }
    }

    return (
        <View style={styles.container}>
            <Pressable style={[
                    StyleSheet.absoluteFill,
                    { backgroundColor: 'rgba(0, 0, 0, 0.5)' },
                ]}
                onPress={navigation.goBack}/>
            <Animated.View
                style={{
                    padding: 16,
                    width: '90%',
                    maxWidth: 400,
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
                    margin: '20px auto',
                    textAlign: 'center',
                    minHeight: '630px',
                    /* box-shadow: 10px 10px 40px rgba(0, 59, 73, 0.38); */
                    boxShadow: '0 4px 6px 2px rgba(0, 59, 73, 0.2), 0 4px 4px 2px rgba(0, 59, 73, 0.14), 0 5px 4px -4px rgba(0, 59, 73, 0.12)'

                }}
            >
                        <View style={{alignItems: 'center',
                            justifyContent: 'center',}}>
                            <Image source={Logo}
                                     style={{ width: 80, height: 50, textAlign: 'center', marginTop: 10}}
                                      alt="asmar logo"/></View>
                        <View style={styles.connHead}><Text style={styles.connHeadH5}>Se connecter</Text></View>
                        <View style={styles.loginInput}>
                            <View style={styles.loginEmail}>
                                <View style={{ display: "flex", flexDirection: "row", justifyContent: 'flex-start', alignContent: 'flex-end'}}>
                                    <Icon name="envelope" size={20} color="#003B49" style={{marginBottom: -10}}/>
                                    <TextInput
                                               style={styles.loginPageCartInput}
                                               returnKeyType="next"
                                               value={email.value}
                                               error={!!email.error}
                                               errorText={email.error}
                                               onChangeText={(text) => setEmail({ value: text, error: '' })}
                                               autoCapitalize="none"
                                               autoCompleteType="email"
                                               textContentType="emailAddress"
                                               keyboardType="email-address"
                                               placeholder="Email adresse" />
                                </View>
                                <View style={styles.loginPageCartHr}/>
                            </View>
                            <View style={styles.loginEmail}>
                                <View style={{ display: "flex", flexDirection: "row", justifyContent: 'flex-start'}}>
                                    <Icon name="lock" size={24} color="#003B49" style={{marginBottom: -10}}/>
                                    <TextInput
                                        style={styles.loginPageCartInput}
                                        type="password"
                                        name="password"
                                        value={password.value}
                                        onChangeText={(text) => setPassword({ value: text, error: '' })}
                                        placeholder="Mot de passe"/>
                                </View>

                                <View style={styles.loginPageCartHr}/>
                            </View>
                            <View style={styles.pwdForget}>
                                <Link to="/">Mot de passe oublié</Link>
                            </View>
                        </View>
                        <View style={styles.btnConn}>
                            <TouchableOpacity onPress={() =>{
                                navigation.goBack();
                                navigation.navigate('Créer un compte')}
                            }
                                >
                                <View style={styles.btnSignup}><Text style={{ fontSize: '0.8rem'}} to="/signup">Créer un compte</Text></View>
                            </TouchableOpacity>
                            <TouchableOpacity>
                                <View onClick={onSubmitForm} style={styles.btnSignin}><Text>se connecter</Text></View>
                            </TouchableOpacity>
                        </View>


            </Animated.View>
        </View>
    );
}

const styles = StyleSheet.create({

    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
    },
   loginPageCart: {
    margin: '20px auto',
       backgroundColor: 'white',
    textAlign: 'center',
    width: '500PX',
    minHeight: '630px',
    borderRadius: '10px',
    /* box-shadow: 10px 10px 40px rgba(0, 59, 73, 0.38); */
    boxShadow: '0 4px 6px 2px rgba(0, 59, 73, 0.2), 0 4px 4px 2px rgba(0, 59, 73, 0.14), 0 5px 4px -4px rgba(0, 59, 73, 0.12)'
},
 loginLogo: {
    paddingTop: '10px',

},
 loginLogoImg: {
    margin: 'auto'
},
 connHead: {
    height: '30px',
    padding: '5px',
    margin: '0'
},
 connHeadH5: {
    padding: '10px',
    margin: '10px',
     fontSize: '1.5rem',
     color: '#003B49'
},
  loginInput: {
    display: 'flex',
    flexFlow: 'column nowrap',
    justifyContent: 'center',
    marginTop: '100px',
    outlineStyle: 'none'
},
 loginEmail: {
    padding: '10px',
    margin: '10px',
     },
    loginPageCartHr: {
        color: '#F4D19E',
        textAlign: 'center',
        margin: 'auto',
        marginTop: 0,
        width: '85%',
        borderBottomColor: '#F4D19E',
        borderBottomWidth: 1.5,
    },
    loginPageCartInput: {
        border: 'none',
        outlineStyle: 'none',
        lineHeight: 'initial',
        alignSelf: 'end',
        fontSize: 'medium',
        marginLeft: 10
},
loginPageCartSvg: {
        height: '1.5rem',
        color: '#003B49',
        marginBottom: '5px',
        width: '10%',
},
pwdForget: {
        display: 'flex',
        width: '80%',
        marginLeft: '70px',
        padding: '0px',
        height: '40px',
        marginTop: '0px',
},

  btnConn: {
      display: 'grid',
      gridTemplateColumns: '1fr 1fr',
      justifyContent: 'center',
      margin: 'auto',
      width: '80%',
      gridColumnGap: '10px',
      marginTop: '0px',
      cursor: 'pointer',
      border: 'none',
      borderRadius: '15px',
      color: '#003B49',
},
btnConnDiv: {
    borderRadius: '10px',
        height: '40px',
        textAlign: 'center',
        padding: '8px',

},
 btnSignin: {
    backgroundImage: 'linear-gradient(#F3BD6E, #7A5F37)',
     borderRadius: 15,
     height: 30,
     textAlign: 'center',
     paddingTop: 4
},
btnSignup: {
    backgroundColor: 'rgba(0, 59, 73, 0.5)',
    borderRadius: 15,
    height: 30,
    textAlign: 'center',
    paddingTop: 4,
    fontSize: '.8rem'

},

/*btnSignin:hover: {
    backgroundImage: 'linear-gradient(#F3BD6E, rgb(101, 78, 46))',
        border: '1px solid #F3BD6E',
},
btnSignup:hover: {
    backgroundColor: 'rgba(0, 59, 73, 0.81)',
        border: '1px solid #003B49',
},
 */
btnConnA: {
    color: '#003B49',
},


});
