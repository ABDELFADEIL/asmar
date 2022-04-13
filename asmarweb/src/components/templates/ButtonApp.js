import React from 'react';
import {Row} from "react-bootstrap";


const ButtonApp = ({title, func})=> {
    const continuer = ()=> {
        func(3);
    }

    return (
                <Row className={"row-btn m-auto text-center"}>
                    <button onClick={continuer} className={"order checkout activated"}>
                        {title}
                    </button>
                </Row>

        );
}

export default ButtonApp;