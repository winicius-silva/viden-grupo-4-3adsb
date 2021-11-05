import React from "react";

function Inputs(props) {
    return (
        <>
            <div className="label_input">
                <img src={props.img} id="img" />
                <input type={props.type} placeholder={props.placeholder} class="fonte" id="input" />
            </div>
        </>
    );
}

export default Inputs;