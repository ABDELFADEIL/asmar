import React from 'react';
import {Button} from 'react-native-paper';
import theme from '../../asmarApp/utils/theme'

const DefaultButton = ({title, action,height}) => (
    <Button
        mode="contained"
        uppercase={false}
        onPress={action}
        color={theme.COLORS.BASIC_GREEN}
        labelStyle={{fontSize: 15, paddingVertical: height || 5}}>
        {title}
    </Button>
);


export default DefaultButton;
