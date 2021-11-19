import React from "react";

function Inputs({ type, placeholder, img, ...opts }) {
    return (
        <>
            <div className="label_input">
                <img src={img} id="img" />
                <div className="input_conf">
                    <input type={type} placeholder={placeholder} class="input" id={placeholder} {...opts} />
                    <label htmlFor={placeholder} className="fonte" id="placeholder_label" >{placeholder}</label>
                </div>
            </div>
        </>
    );
}

export default Inputs;