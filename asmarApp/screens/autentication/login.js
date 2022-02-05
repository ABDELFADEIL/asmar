import 'react-native-gesture-handler';
import React, {useState} from "react";
import { Animated, View, Text, Pressable, StyleSheet, Image, TextInput, TouchableOpacity, AsyncStorage } from 'react-native';
import {Link, useTheme} from '@react-navigation/native';
import { useCardAnimation } from '@react-navigation/stack';
import Logo from "../../assets/asmar_logo.png"
import {GET_JWT_TOKEN, Login, SET_JWT_TOKEN} from "../../services/userService";
import { emailValidator } from '../helpers/emailValidator'
import { passwordValidator } from '../helpers/passwordValidator'
import Icon from 'react-native-vector-icons/FontAwesome';
import { LinearGradient } from 'expo-linear-gradient';

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
        const response = await Login({'email': email.value, 'password': password.value});
        try {
            const headers = response.headers;
            SET_JWT_TOKEN(headers.authorization);
            if (response.status === 200) {
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
                    margin: '20 auto',
                    textAlign: 'center',
                    minHeight: 630,

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
                                <View style={styles.btnSignup}><Text style={{ fontSize: 0.8}} to="/signup">Créer un compte</Text></View>
                            </TouchableOpacity>
                            <TouchableOpacity>
                                <LinearGradient colors={['#F3BD6E', '#7A5F37']}>
                                    <View onClick={onSubmitForm} style={styles.btnSignin}><Text>se connecter</Text></View>
                                </LinearGradient>
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
    margin: '20 auto',
       backgroundColor: 'white',
    textAlign: 'center',
    width: 500,
    minHeight: 630,
    borderRadius: 10,
},
 loginLogo: {
    paddingTop: 10,

},
 loginLogoImg: {
    margin: 'auto'
},
 connHead: {
    height: 30,
    padding: 30,
    margin: '0'
},
 connHeadH5: {
    padding: 10,
    margin: 10,
     fontSize: 1.5,
     color: '#003B49'
},
  loginInput: {
     flexDirection: 'column',
    flexWrap: 'nowrap',
    justifyContent: 'center',
    marginTop: 100,
},
 loginEmail: {
    padding: 10,
    margin: 10,
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
        marginLeft: 10
},
loginPageCartSvg: {
        height: 1.5,
        color: '#003B49',
        marginBottom: 5,
        width: '10%',
},
pwdForget: {
        width: '80%',
        marginLeft: 70,
        padding: 0,
        height: 40,
        marginTop: 0,
},

  btnConn: {
      justifyContent: 'center',
      margin: 'auto',
      width: '80%',
      marginTop: 0,
      borderRadius: 15,
      color: '#003B49',
},
btnConnDiv: {
    borderRadius: 10,
        height: 40,
        textAlign: 'center',
        padding: 8,

},
 btnSignin: {
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
    fontSize: 0.8

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
