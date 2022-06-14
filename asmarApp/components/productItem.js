import React from 'react';
import { Avatar ,Card, Title, Paragraph } from 'react-native-paper';
import { Text, Pressable } from 'react-native';

export const ProductItem = ({ navigation,product}) => {
    const LeftContent = props => <Avatar.Icon {...props} icon="folder" />

    let onPressFunction =(id) => {
        console.log(navigation);
        navigation.navigate("ProductDetailsScreen",{idProduct: id})
    };



    return (
        <Pressable
            onPress={() =>onPressFunction(product.id)}>
            <Card>
                <Card.Title title={product.label}  left={LeftContent} />
                <Card.Content>
                    <Title>{product.label}</Title>
                    <Paragraph>{product.description}</Paragraph>
                </Card.Content>
                <Card.Cover source={{
                    uri:

                        product.urlImages[0] != null ? product.urlImages[0].url : "https://m.media-amazon.com/images/I/51XgqzfXiiL._AC_.jpg",
                }} />
                <Card.Actions>
                    <Text>{product.price}</Text>
                </Card.Actions>
            </Card>
        </Pressable>

    )
}

