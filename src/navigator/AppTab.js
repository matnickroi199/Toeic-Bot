import React from 'react';
import PropTypes from 'prop-types';
import {createMaterialTopTabNavigator} from '@react-navigation/material-top-tabs';
import Profile from '../screens/Profile';
import TabIcon from '../components/common/TabIcon';
import Home from '../screens/Home';
import Chat from '../screens/Chat/Chatbot';

const Tab = createMaterialTopTabNavigator();

function AppTab() {
  return (
    <Tab.Navigator
      screenOptions={({route}) => ({
        tabBarIcon: ({focused, color}) => (
          <TabIcon color={color} focused={focused} name={route.name} />
        ),
      })}
      tabBarOptions={{
        activeTintColor: 'deepskyblue',
        inactiveTintColor: 'gainsboro',
        showIcon: true,
        showLabel: false,
      }}>
      <Tab.Screen name="Home" component={Home} />
      <Tab.Screen name="Chatbot" component={Chat} />
      <Tab.Screen name="Profile" component={Profile} />
    </Tab.Navigator>
  );
}

TabIcon.propTypes = {
  name: PropTypes.string.isRequired,
  color: PropTypes.string.isRequired,
};

export default AppTab;
