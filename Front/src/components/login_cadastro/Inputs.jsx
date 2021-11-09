import React from "react";

function Inputs(props) {
    return (
        <>
            <div className="label_input">
                <img src={props.img} id="img" />
                <div className="input_conf">
                    <input type={props.type} placeholder={props.placeholder} class="fonte" id="input" />
                    <label htmlFor="" className="fonte" id="placeholder_label" >{props.placeholder}</label>
                </div>
            </div>
        </>
    );
}

export default Inputs;