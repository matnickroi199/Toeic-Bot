import React from 'react';
import {StyleSheet, TouchableOpacity, Image, Text, Linking} from 'react-native';

function Card({url, image, title}) {
  const styles = StyleSheet.create({
    container: {
      borderTopWidth: 1,
      borderTopColor: 'gainsboro',
      marginBottom: 20,
    },
    image: {
      height: 150,
    },
    title: {
      padding: 20,
      backgroundColor: 'gainsboro',
      color: 'gray',
    },
  });

  const onPress = () => {
    Linking.canOpenURL(url).then((supported) => {
      if (supported) {
        Linking.openURL(url);
      } else {
        console.log(`Don't know how to open URL: ${url}`);
      }
    });
  };
  return (
    <TouchableOpacity
      style={styles.container}
      onPress={() => onPress()}>
      <Image source={{uri: image}} style={styles.image} resizeMode="cover" />
      <Text style={styles.title}>{title}</Text>
    </TouchableOpacity>
  );
}

export default Card;
