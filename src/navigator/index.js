import React, {useState, useEffect} from 'react';
import {View, ActivityIndicator} from 'react-native'
import AppTab from './AppTab';
import Login from '../screens/Login'
import {connect} from 'react-redux';
import AsyncStorage from '@react-native-community/async-storage';
import {GoogleSignin} from '@react-native-community/google-signin';

const Navigation = ({users}) => {
  const [info, setInfo] = useState(null);
  const [loading, setLoading] = useState(true);

  const getUser = async () => {
    try {
      const jsonValue = await AsyncStorage.getItem('user');
      if (jsonValue != null) {
        setInfo(JSON.parse(jsonValue));
        GoogleSignin.configure({
          webClientId:
            '202766130146-hir8v2igp1pasribup82slm0j08tnmlq.apps.googleusercontent.com',
        });
        console.log('users: ', jsonValue);
      }
      else {
        setInfo(users);
        console.log('users: ', users);
      }
      setLoading(false);
    } catch(e) {
      // error reading value
    }
  }

  useEffect(() => {
    getUser()
  }, [users]);

  if(loading) {
    return (
      <View style={{justifyContent: 'center', alignItems: 'center', flex: 1}}>
        <ActivityIndicator size={50} color="deepskyblue"/>
      </View>
    )
  }
  return info && Object.keys(info).length > 0 ? <AppTab /> : <Login />;
};

const mapStateToProps = (state) => state;
const NavigationConnected = connect(mapStateToProps, null)(Navigation);
export default NavigationConnected;
