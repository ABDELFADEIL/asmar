import React, {useState} from "react";
import { Dimensions, Animated, View, Text, Pressable, StyleSheet, Image, TextInput, TouchableOpacity } from 'react-native';
import {Link, useTheme} from '@react-navigation/native';
import { useCardAnimation } from '@react-navigation/stack';
import Logo from "../../assets/asmar_logo.png"
import {GET_JWT_TOKEN, Login, REMOVE_JWT_TOKEN, SET_JWT_TOKEN} from "../../services/userService";
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
        Login({'email': email.value, 'password': password.value})
            .then(response=> {
                //console.log(response);
                console.log(response.headers.authorization);
                if (response.status === 200) {
                    REMOVE_JWT_TOKEN();
                    SET_JWT_TOKEN(response.headers.authorization);
                    const path = route.params.name;
                    if (path == null || path === 'undefined'){
                        navigation.navigate('home');
                    }
                    navigation.navigate(path);
                }
            })
            .catch(error=> console.log(error));
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
                    flex: 1,
                    maxHeight: 480,
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
                    minHeight: 480,
                    justifyContent: 'center'

                }}
            >
                <View style={{
                    flex: 1
                }}>
                        <View style={{alignSelf: 'center', marginBottom: 20, marginTop: 0}}>
                            <Image source={Logo}
                                     style={{ width: 70, height: 40}}
                                      alt="asmar logo"/>
                            <View style={styles.connHead}><Text style={styles.connHeadH5}>Se connecter</Text></View>
                        </View>
                        <View style={styles.loginFrom}>
                            <View style={styles.loginInput}>
                                <View style={{ flexDirection: "row", justifyContent: 'flex-start', alignContent: 'flex-end'}}>
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
                            <View style={styles.loginInput}>
                                <View style={{ display: "flex", flexDirection: "row", justifyContent: 'flex-start'}}>
                                    <Icon name="lock" size={24} color="#003B49" style={{marginBottom: -10}}/>
                                    <TextInput
                                        style={styles.loginPageCartInput}
                                        secureTextEntry={true}
                                        name="password"
                                        value={password.value}
                                        onChangeText={(text) => setPassword({ value: text, error: '' })}
                                        placeholder="Mot de passe"/>
                                </View>

                                <View style={styles.loginPageCartHr}/>
                            </View>
                            <View style={styles.pwdForget}>
                                <TouchableOpacity onPress={() =>{
                                    navigation.goBack();
                                    navigation.navigate('Créer un compte ')}
                                }>
                                    <Text >Mot de passe oublié</Text>
                                </TouchableOpacity>
                            </View>
                        </View>
                        <View style={styles.btnConn}>
                            <TouchableOpacity onPress={onSubmitForm}>
                                <LinearGradient style={styles.button} colors={['#F3BD6E', '#7A5F37']}>
                                    <View onClick={onSubmitForm} style={styles.btnSignin}><Text>se connecter</Text></View>
                                </LinearGradient>
                            </TouchableOpacity>
                            <TouchableOpacity onPress={() =>{
                                navigation.goBack();
                                navigation.navigate('Créer un compte')
                                }
                            }
                                >
                                <View style={styles.btnSignup}><Text style={{ fontSize: 14, marginLeft: 'auto', marginRight: 'auto'}} to="/signup">Créer un compte</Text></View>
                            </TouchableOpacity>

                        </View>
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
        alignContent: 'center',
        paddingTop: 80,


    },
   loginPageCart: {
    backgroundColor: 'white',
    textAlign: 'center',
    borderRadius: 10,
},
 loginLogo: {
    paddingTop: 0,

},
 loginLogoImg: {
},
 connHead: {

},
 connHeadH5: {
    padding: 10,
     fontSize: 16,
     color: '#003B49'
},
    loginFrom: {
     flexDirection: 'column',
    flexWrap: 'wrap',
    justifyContent: 'center',
    marginTop: 20,

},
    loginInput: {
     height: 80,

     },
    loginPageCartHr: {
        marginTop: 0,
        width: '100%',
        borderBottomColor: '#F4D19E',
        borderBottomWidth: 1.5,
    },
    loginPageCartInput: {
        marginLeft: 10,
        width: '80%'
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
      justifyContent: 'center',
      marginTop: 10,
      borderRadius: 15,
      color: '#003B49',
},
    button: {
        borderRadius: 15,
        marginBottom: 15,
        height: 35
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
