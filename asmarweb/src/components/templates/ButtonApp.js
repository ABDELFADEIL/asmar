import React from 'react';
import {Row} from "react-bootstrap";


const ButtonApp = ({title, setStep, disable})=> {
    const continuer = ()=> {
        setStep(3);
    }
    console.log(disable)
    return (
                <Row className={"row-btn m-auto text-center"}>
                    <button onClick={continuer} className={"order checkout activated"} disabled={disable} >
                        {title}
                    </button>
                </Row>

        );
}

export default ButtonApp;