import React, { useCallback } from 'react';
import { View, StyleSheet, image } from "react-native";
import { Text, Card, Button, Icon } from 'react-native-elements';



export default function ArticleMini({ navigation, article }) {
  const styles = StyleSheet.create({
    cardCss: {
      backgroundColor: "#718e95",
    },
    btnAfficher: {
      color: "#003B49",
      paddingLeft: 20,
      paddingRight: 20,
      backgroundColor: "#F4D19E",
      borderColor: "#F4D19E"
    }
  });
  let goToProduct =(id) => {
    console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    console.log(id)
    navigation.navigate("ProductDetailsScreen",{idProduct: id})
  };
  return (
    <Card containerStyle={styles.cardCss} >
      <View style={{ height: 400 }}>
        <Card.Title>{article.label}</Card.Title>
        <Card.Divider />
        <View style={{ height: "60%" }}>
          <Card.Image
            style={{ minWidth: "100%", height: "100%" }}
            source={{
              uri:
                // 'https://awildgeographer.files.wordpress.com/2015/02/john_muir_glacier.jpg',
                article.urlImages[0] != null ? article.urlImages[0].url : "https://m.media-amazon.com/images/I/51XgqzfXiiL._AC_.jpg",
            }}
          />
        </View>
        <Text style={{ marginBottom: 10, height: "15%" }}>
          {article.description}
        </Text>
        <View style={{ display: "flex", flexDirection: "row", justifyContent: "center", alignItems: "center" }}>
          <Text style={{ paddingLeft: 10, width: "40%" }}>
            {article.price} €
          </Text>
          <Button
            buttonStyle={styles.btnAfficher}
            title="Afficher"
            onPress={() =>goToProduct(article.id)}
          />
        </View>
      </View>
    </Card>
  );

}
